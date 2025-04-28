import os
from PIL import Image,ImageOps
import numpy
from skimage.measure import label,regionprops
from skimage.feature import graycomatrix,graycoprops
import pandas as pd

path = "./images";

data = []

rice_types = [folder for folder in os.listdir(path) if( os.path.isdir( os.path.join(path,folder)))]

# print(rice_types)

for rice_type in rice_types:

    current_rice_path = os.path.join(path,rice_type)

    for images in os.listdir(current_rice_path):

        img_path = os.path.join(current_rice_path,images)

        if(images.endswith(".jpg")):

            # print(img_path)
            file = Image.open(img_path)
            grey = file.convert('L')
            invert = ImageOps.invert(grey)
            arr = numpy.array(invert)
            binary = arr > 128;
            labelled = label(binary)
            print(labelled)
            regions = regionprops(labelled,intensity_image=arr)
            
            # exit();

            for region in regions:

                majorAxisLength = region.axis_major_length;
                minorAxisLength = region.axis_minor_length;
                eccentricity = region.eccentricity
                
                # print(majorAxisLength,minorAxisLength,eccentricity)

                glcm  = graycomatrix(region.image_intensity, distances=[1], angles=[0],levels=256,symmetric=True, normed=True )

                contrast = graycoprops(glcm,'contrast')[0,0];
                corelation = graycoprops(glcm,'correlation')[0,0];
                energy = graycoprops(glcm,'energy')[0,0];


                data.append([majorAxisLength,minorAxisLength,eccentricity,contrast,corelation,energy,rice_type])

                # print(data)

        


columns=["Major_Axis_Length","Minor_Axis_Length","Eccentricity","Contrast","Correlation","Energy","Rice_Type"]

df = pd.DataFrame(data,columns=columns);

df.to_csv("output.csv");






