from PIL import Image, ImageOps
import numpy as np
import matplotlib.pyplot as plt
from skimage.measure import label, regionprops
from skimage import morphology


image_paths = ['Arborio.jpg', 'Basmati.jpg', 'Ipsala.jpg', 'jasmine.jpg', 'Karacadag.jpg']


def extract_rice_features(image_path):
   
    image = Image.open(image_path)

   
    image_gray = image.convert('L')

   
    image_inverted = ImageOps.invert(image_gray)

   
    image_array = np.array(image_inverted)
    

    
    binary_image = image_array > 128  
    
    labeled_image = label(binary_image)
   
    
    rice_features = []

   
    for region in regionprops(labeled_image):
       
        major_axis = region.major_axis_length
        minor_axis = region.minor_axis_length

       
        perimeter = region.perimeter

       
        rice_features.append({
            'major_axis': major_axis,
            'minor_axis': minor_axis,
            'perimeter': perimeter
        })

    return rice_features


all_rice_features = {}

for image_path in image_paths:
    print(f"Processing {image_path}...")
    features = extract_rice_features(image_path)
    all_rice_features[image_path] = features

    
    for idx, feature in enumerate(features):
        print(f"Image: {image_path}, Rice {idx+1} - Major Axis: {feature['major_axis']}, Minor Axis: {feature['minor_axis']}, Perimeter: {feature['perimeter']}")


