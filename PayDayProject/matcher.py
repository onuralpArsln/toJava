import cv2
import numpy as np

# Load the main image and the template
image = cv2.imread('PayDayProject\\tablets\\tabletZoom.jpg', cv2.IMREAD_GRAYSCALE)
template = cv2.imread('PayDayProject\\source\\a.jpg', cv2.IMREAD_GRAYSCALE)

cv2.imshow('template',template)

# Perform template matching
result = cv2.matchTemplate(image, template, cv2.TM_CCOEFF_NORMED)

# Define a matching threshold
threshold = 0.3  # Adjust based on your needs
locations = np.where(result >= threshold)

# Draw rectangles around matches
for pt in zip(*locations[::-1]):
    cv2.rectangle(image, pt, (pt[0] + template.shape[1], pt[1] + template.shape[0]), (255, 0, 0), 2)

# Display the result
cv2.imshow('Detected Template', image)
cv2.waitKey(0)
cv2.destroyAllWindows()
