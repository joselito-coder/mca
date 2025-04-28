import os 
import pandas as pd
from PIL import Image, ImageOps
import numpy
import threading
from skimage.feature import graycomatrix,graycoprops
from skimage.measure import regionprops, label





folder_path = './images'


rice_types = [ folder for folder in os.listdir(folder_path) if os.path.isdir(os.path.join(folder_path,folder)) ]

data = []

for rice_type in rice_types:

    rice_folder_path = os.path.join(folder_path,rice_type)


    for filename in os.listdir(rice_folder_path):
        if filename.endswith('.jpg') or filename.endswith(".png"):
            file_path = os.path.join(rice_folder_path,filename)


            file = Image.open(file_path)
            grey = file.convert('L')
            invert = ImageOps.invert(grey)
            arr = numpy.array(invert)
            binary = arr > 128
            labelled = label(binary)
            regions = regionprops(labelled,intensity_image=arr)

            for region in regions:
                major_axis_length = region.axis_major_length
                minor_axis_length = region.axis_minor_length
                eccentricity = region.eccentricity

                glcm = graycomatrix(region.image_intensity, distances=[1], angles=[0] , levels=256, symmetric=True,normed=True)

                contrast = graycoprops(glcm,'contrast')[0,0]
                correlation = graycoprops(glcm,'correlation')[0,0]
                energy = graycoprops(glcm,'energy')[0,0]


                data.append([ major_axis_length,minor_axis_length,eccentricity,contrast,correlation,energy,rice_type ])
                


columns = ['Major Axis Length', 'Minor Axis Length',"Eccentricity","Contrast","Correlation","Energy","Rice Type"]
df = pd.DataFrame(data,columns=columns)

df.to_csv("test.csv");


print(df)


# print(data)
