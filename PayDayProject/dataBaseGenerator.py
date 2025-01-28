
import cv2
import os
import numpy as np

# Load image
image = cv2.imread('source\\a.jpg')

# Rotate by 45 degrees
(h, w) = image.shape[:2]
center = (w // 2, h // 2)
matrix = cv2.getRotationMatrix2D(center, 45, 1.0)
rotated = cv2.warpAffine(image, matrix, (w, h))
cv2.imshow("rot",rotated)



# Define the source points (corners of the original image)
src_points = np.float32([[0, 0], [44, 0], [0, 44]])

# Define the destination points (where you want to warp the corners)
dst_points = np.float32([[10, 10], [40, 5], [5, 40]])

# Compute the affine transformation matrix
M = cv2.getAffineTransform(src_points, dst_points)

# Apply the affine transformation
warped_image = cv2.warpAffine(image, M, (45, 45))


cv2.imshow('Warped Image', warped_image)




# Define the source points (corners of the original image)
src_points = np.float32([[0, 0], [44, 0], [0, 44], [44, 44]])

# Define the destination points (where you want to warp the corners)
dst_points = np.float32([[10, 10], [40, 5], [5, 40], [35, 35]])

# Compute the perspective transformation matrix
M = cv2.getPerspectiveTransform(src_points, dst_points)

# Apply the perspective transformation
perspect = cv2.warpPerspective(image, M, (45, 45))

# Save or display the result
cv2.imshow('pers', perspect)


x, y = np.meshgrid(np.arange(45), np.arange(45))

# Apply a custom warp (e.g., sinusoidal warp) (change 45 to create )
x_warped = x + 1 * np.sin(2 * np.pi * y / 45)
y_warped = y + 1 * np.sin(2 * np.pi * x / 45)

# Create the map for remapping
map_x = x_warped.astype(np.float32)
map_y = y_warped.astype(np.float32)

# Apply the custom warp
war3 = cv2.remap(image, map_x, map_y, interpolation=cv2.INTER_LINEAR)


cv2.imshow('Wwa', war3)


cv2.waitKey(0)

# Close the window
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

