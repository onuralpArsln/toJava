import cv2
import os
import numpy as np

size=2
imageSource = 'a'
windowSizeWidth=(45*2)+135
windowSizeHeight=50*2
imageCounter=0

# Load image
image = cv2.imread(f'source\\{imageSource}.jpg')
image=cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
image = cv2.resize(image, (45*size, 45*size))
cv2.imshow("Source",image)
cv2.resizeWindow("Source", windowSizeWidth, windowSizeHeight) 

def rotateImg(img: cv2.typing.MatLike, angle:int,scale:int=1.0)->cv2.typing.MatLike:
    
    (h, w) = image.shape[:2]
    center = (w // 2, h // 2)
    matrix = cv2.getRotationMatrix2D(center, angle, scale)
    rotated = cv2.warpAffine(image, matrix, (w, h))
    return rotated

rotated=rotateImg(image, 45)
cv2.imshow("Rotate",rotated)
cv2.resizeWindow("Rotate", windowSizeWidth, windowSizeHeight) 


def warpImagePerspective(img: cv2.typing.MatLike, warpBias:int=5)->cv2.typing.MatLike:
    # Define the source points (corners of the original image)
    src_points = np.float32([[0, 0], [44*size, 0], [0, 44*size], [44*size, 44*size]])

    # Define the destination points (where you want to warp the corners)
    dst_points = np.float32([
        [warpBias, warpBias],  # Move top-left inward
        [44*size - warpBias*2, warpBias],  # Move top-right inward
        [warpBias*2, 44*size - warpBias],  # Move bottom-left inward
        [44*size - warpBias, 44*size - warpBias*2]  # Move bottom-right inward
    ])
    # Compute the perspective transformation matrix
    M = cv2.getPerspectiveTransform(src_points, dst_points)

    # Apply the perspective transformation
    perspect = cv2.warpPerspective(image, M, (45*size, 45*size))
    return perspect

perspect = warpImagePerspective(image)
# Save or display the result
cv2.imshow('Perspective', perspect)
cv2.resizeWindow("Perspective", windowSizeWidth, windowSizeHeight)


def sinusoidalWarp(img: cv2.typing.MatLike, x_warp:int=45,y_warp:int=45 )->cv2.typing.MatLike:

    x, y = np.meshgrid(np.arange(45*size), np.arange(45*size))
    # Apply a custom warp (e.g., sinusoidal warp) (change 45 to create )
    x_warped = x + 1 * np.sin(2 * np.pi * y / x_warp)
    y_warped = y + 1 * np.sin(2 * np.pi * x / y_warp)
    # Create the map for remapping
    map_x = x_warped.astype(np.float32)
    map_y = y_warped.astype(np.float32)

    # Apply the custom warp
    warped = cv2.remap(image, map_x, map_y, interpolation=cv2.INTER_LINEAR)
    return warped

war3= sinusoidalWarp(image)
cv2.imshow('Warper', war3)
cv2.resizeWindow("Warper", windowSizeWidth, windowSizeHeight)


def saveImg(frame):
    global imageSource
    global imageCounter
    os.makedirs(imageSource, exist_ok=True)
    output_path = os.path.join(imageSource, f"image_{imageCounter}.png")  # Save as PNG
    cv2.imwrite(output_path, frame)
    imageCounter+=1

saveImg(war3)

cv2.waitKey(0)
cv2.destroyAllWindows()

"""
# Destination folder
output_folder = "output_images"
os.makedirs(output_folder, exist_ok=True)

# Save each image
for idx, img in enumerate(augmented_images):
    output_path = os.path.join(output_folder, f"image_{idx}.png")  # Save as PNG
    cv2.imwrite(output_path, img)
    print(f"Saved: {output_path}")

    """

