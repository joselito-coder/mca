import Augmentor

import os


# Define input and output folders
input_folder = "./input"  # Folder containing the original image
output_folder = "./output"  # Folder to save augmented images
output_count = 3000  # Number of images to generate

# Ensure output folder exists
os.makedirs(output_folder, exist_ok=True)

# Create an Augmentor pipeline (it saves images in input_folder/output/)
p = Augmentor.Pipeline(input_folder)

# Add transformations (without cropping or zooming)
p.rotate(probability=1.0, max_left_rotation=25, max_right_rotation=25)  # Rotation in both directions  # Additional 30-degree rotation
p.flip_left_right(probability=0.5)  # Random horizontal flip
p.flip_top_bottom(probability=0.5)  # Random vertical flip
p.shear(probability=0.7, max_shear_left=10, max_shear_right=10)  # Shearing effect

# Generate augmented images
p.sample(output_count)

# Correct Augmentor's default output folder
augmentor_output_folder = os.path.join(input_folder, "output")

# Move generated images to the correct output folder
if os.path.exists(augmentor_output_folder):  # Ensure folder exists
    for filename in os.listdir(augmentor_output_folder):
        src = os.path.join(augmentor_output_folder, filename)
        dst = os.path.join(output_folder, filename)
        os.rename(src, dst)
    print(f"✅ Augmentation complete! {output_count} images saved in '{output_folder}/'.")
else:
    print("hello world")