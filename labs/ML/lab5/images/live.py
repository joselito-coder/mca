import os
import pandas as pd
from PIL import Image, ImageOps
import numpy
from skimage.feature import graycomatrix, graycoprops
from skimage.measure import regionprops, label

folder_path = '.'  # Replace with the path to the parent folder

# List all rice type folders inside the main folder
rice_types = [folder for folder in os.listdir(folder_path) if os.path.isdir(os.path.join(folder_path, folder))]

# Initialize an empty list to store data
data = []

# Loop through each rice type folder
for rice_type in rice_types:
    rice_folder_path = os.path.join(folder_path, rice_type)

    # Loop through each image in the rice type folder
    for filename in os.listdir(rice_folder_path):
        if filename.endswith('.jpg') or filename.endswith('.png'):  # Add other image formats if necessary
            file_path = os.path.join(rice_folder_path, filename)

            # Open image and process
            file = Image.open(file_path)
            grey = file.convert('L')
            invert = ImageOps.invert(grey)
            arr = numpy.array(invert)
            binary = arr > 128
            labelled = label(binary)
            regions = regionprops(labelled, intensity_image=arr)

            # Extract features for each region and append to data list
            for region in regions:
                major_axis_length = region.major_axis_length
                minor_axis_length = region.minor_axis_length
                eccentricity = region.eccentricity

                glcm = graycomatrix(region.intensity_image, distances=[1], angles=[0], levels=256, symmetric=True, normed=True)
                contrast = graycoprops(glcm, 'contrast')[0, 0]
                correlation = graycoprops(glcm, 'correlation')[0, 0]
                energy = graycoprops(glcm, 'energy')[0, 0]

                # Append the feature data with the target rice type
                data.append([major_axis_length, minor_axis_length, eccentricity, contrast, correlation, energy, rice_type])

# Create a DataFrame from the collected data
columns = ['Major Axis Length', 'Minor Axis Length', 'Eccentricity', 'Contrast', 'Correlation', 'Energy', 'Rice Type']
df = pd.DataFrame(data, columns=columns)

# Save the DataFrame to a CSV file
df.to_csv('rice_features.csv', index=False)

print("Feature extraction complete and CSV file saved.")
