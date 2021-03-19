import os
import xml.etree.ElementTree as ET

file_path = './images/grandeur' #변경하고 싶은 파일이 저장된 경로

# 변경하고 싶은 경로
# change_path = "C:/Users/multicampus/git/SSAFY_PJT2/Object-Detection/tensorflow_object_detection_API/Tensorflow/workspace/training_demo/images"
file_names = os.listdir(file_path) #file_path에 저장되어있는 모든 파일명 리스트

xml_list=[]
for file in file_names:
    if '.xml' in file:
        # print(file)
        xml_list.append(file)

print(len(xml_list))

# folder 태그, name 태그 변경하기
j = 1
for xml in xml_list:
    target_path = file_path+"\\"+xml
    targetXML = open(target_path, 'rt', encoding='UTF8')
    
    tree = ET.parse(targetXML)
    root = tree.getroot()
    
    # xml folder 태그 수정
    target_tag = root.find("folder")
    origin_folder_tag = target_tag.text
    print("origin filename tag ==> "+ origin_folder_tag)
    
    modi_folder_tag = origin_folder_tag.replace(origin_folder_tag, "images")
    print("modify filename tag ==> "+ modi_folder_tag)

    # xml name 태그 수정
    object_tag = root.find("object")
    name_tag = object_tag.find("name")
    origin_name_tag = name_tag.text
    print("origin name tag ==> " + origin_name_tag)
    
    
    modi_name_tag = 'grandeur'
    print("modify name tag ==> " + modi_name_tag)
    
    # 수정한 내용 적용하기
    target_tag.text = modi_folder_tag
    name_tag.text = modi_name_tag
    tree.write(target_path)
    
    print("\n")

    j += 1