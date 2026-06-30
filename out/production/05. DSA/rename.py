import os

# Specify the base path
base_path = r"C:\Users\DELL\OneDrive\Desktop\JAVA DSA"

def rename_folders(base_path):
    for folder in os.listdir(base_path):
        folder_path = os.path.join(base_path, folder)
        if os.path.isdir(folder_path):
            # Check if folder name starts with digits (e.g., 001 - , 002 -)
            if folder.split(' - ')[0].isdigit():
                folder_number = int(folder.split(' - ')[0])
                new_name = f"{folder_number:04d} - {folder.split(' - ')[1]}"
            # If the folder name contains 'practice', remove it
            elif 'practice' in folder:
                new_name = folder.replace('practice - ', '').strip()
            # If the folder name starts with 'A - ', remove it
            elif folder.startswith('A - '):
                new_name = folder.replace('A - ', '').strip()
            else:
                new_name = folder

            # Rename folder if needed
            new_path = os.path.join(base_path, new_name)
            if folder_path != new_path:  # Avoid renaming to itself
                os.rename(folder_path, new_path)
                print(f"Renamed: {folder} -> {new_name}")
rename_folders(base_path)
