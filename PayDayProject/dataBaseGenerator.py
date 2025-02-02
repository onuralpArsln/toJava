import cv2
import os
import numpy as np
import random

size=2
imageSource = 'd'
windowSizeWidth=(45*2)+135
windowSizeHeight=50*2
imageCounterTrain=0
imageCounterValid=0

# Load image
image = cv2.imread(f'source\\{imageSource}.jpg')
image=cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
image = cv2.resize(image, (45*size, 45*size))
_,image = cv2.threshold(image, 60, 255, cv2.THRESH_BINARY)


def rotateImg(img: cv2.typing.MatLike, angle:int,scale:int=1.0)->cv2.typing.MatLike:
    
    (h, w) = image.shape[:2]
    center = (w // 2, h // 2)
    matrix = cv2.getRotationMatrix2D(center, angle, scale)
    rotated = cv2.warpAffine(image, matrix, (w, h))
    return rotated

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

def sinusoidalWarp(img: cv2.typing.MatLike, x_warp:int=45,y_warp:int=45 )->cv2.typing.MatLike:

    x, y = np.meshgrid(np.arange(45*size), np.arange(45*size))
    # Apply a custom warp (e.g., sinusoidal warp) (change 45 to create )
    x_warped = x + 1 * np.sin(2 * np.pi * y // x_warp)
    y_warped = y + 1 * np.sin(2 * np.pi * x // y_warp)
    # Create the map for remapping
    map_x = x_warped.astype(np.float32)
    map_y = y_warped.astype(np.float32)

    # Apply the custom warp
    warped = cv2.remap(image, map_x, map_y, interpolation=cv2.INTER_LINEAR)
    return warped

def saveImgToTrain(frame):
    global imageSource
    global imageCounterTrain
    target="dataset\\train\\"+imageSource
    os.makedirs(target, exist_ok=True)
    output_path = os.path.join(target, f"image_{imageCounterTrain}.png")
    cv2.imwrite(output_path, frame)
    imageCounterTrain+=1
    
def saveImgToValid(frame):
    global imageSource
    global imageCounterValid
    target="dataset\\validation\\"+imageSource
    os.makedirs(target, exist_ok=True)
    output_path = os.path.join(target, f"image_{imageCounterValid}.png")
    cv2.imwrite(output_path, frame)
    imageCounterValid+=1





for i in range(400):
    rotateParam=random.randint(1,45)
    warpBias=random.randint(1,25)
    sinusoidalWarpParamX=random.randint(1,60)
    sinusoidalWarpParamY=random.randint(1,60)
    currentFrame=image

    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=rotateImg(img=currentFrame, angle=rotateParam)
   
    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=warpImagePerspective(img=currentFrame, warpBias=warpBias)
        if randomSelector<5:
            currentFrame = cv2.flip(currentFrame, 1)

    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=sinusoidalWarp(img=currentFrame, x_warp=sinusoidalWarpParamX,y_warp=sinusoidalWarpParamY)
    
    saveImgToTrain(currentFrame)


for i in range(100):
    rotateParam=random.randint(1,45)
    warpBias=random.randint(1,25)
    sinusoidalWarpParamX=random.randint(1,60)
    sinusoidalWarpParamY=random.randint(1,60)
    currentFrame=image

    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=rotateImg(img=currentFrame, angle=rotateParam)
   
    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=warpImagePerspective(img=currentFrame, warpBias=warpBias)
        if randomSelector<5:
            currentFrame = cv2.flip(currentFrame, 1)

    randomSelector=random.randint(0,12)
    if randomSelector<10:
        currentFrame=sinusoidalWarp(img=currentFrame, x_warp=sinusoidalWarpParamX,y_warp=sinusoidalWarpParamY)
    
    saveImgToValid(currentFrame)


