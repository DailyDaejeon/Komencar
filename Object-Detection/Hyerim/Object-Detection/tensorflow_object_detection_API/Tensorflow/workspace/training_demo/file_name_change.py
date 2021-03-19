import os
import xml.etree.ElementTree as ET

# 주어진 디렉토리에 있는 항목들의 이름을 담고 있는 리스트를 반환합니다.
# 리스트는 임의의 순서대로 나열됩니다.
file_path = './images/grandeur-origin' #변경하고 싶은 파일이 저장된 경로

# 변경하고 싶은 경로
change_path = "C:/Users/multicampus/git/SSAFY_PJT2/Object-Detection/tensorflow_object_detection_API/Tensorflow/workspace/training_demo/images"
file_names = os.listdir(file_path) #file_path에 저장되어있는 모든 파일명 리스트

img_list=[]
# xml_list=[]
for file in file_names:
   
    if '.jpg' in file or '.jpeg' in file:
        print(file)
        img_list.append(file)
    """
    # elif '.xml' in file:
    if '.xml' in file:
        print(file)
        # print("\n")
        xml_list.append(file)
     """
print(len(img_list))
# print(len(xml_list))

# img 파일명 수정
i = 83
for img in img_list:
    src = os.path.join(file_path, img)
    #print(src)
    img_extension = "." + src.split(".")[-1]
    #print(img_extension)
    dst = 'grandeur_' + str(i) + img_extension
    #print(dst)
    dst = os.path.join(file_path, dst)
    os.rename(src, dst)
    i += 1

"""

# filename 태그, path 태그 변경하기
j = 1
for xml in xml_list:
    target_path = file_path+"\\"+xml
    targetXML = open(target_path, 'rt', encoding='UTF8')
    
    tree = ET.parse(targetXML)
    root = tree.getroot()
    
    # xml filename 태그 수정
    target_tag = root.find("filename")
    origin_tag = target_tag.text
    print("origin filename tag ==> "+origin_tag)
    
    #img_extension = "." + origin_tag.split(".")[-1]
    #print("xml filename tag extension ==> " + img_extension)
    
    #modi_tag = origin_tag.replace(origin_tag, 'avante_' + str(j) + img_extension)
    #print(modi_tag)

    # xml path 태그 수정
    target_path_tag = root.find("path")
    origin_path_tag = target_path_tag.text
    print("origin path tag ==> " + origin_path_tag)
    
    modi_path_tag = change_path + "/" + origin_tag
    modi_path_tag = modi_path_tag.replace("/","\\")
    print("modify path tag ==> " + modi_path_tag)

    # 수정한 내용 적용하기
    #target_tag.text = modi_tag
    target_path_tag.text = modi_path_tag
    tree.write(target_path)
    
    print("\n")
   
    j += 1

"""
"""
# xml 파일명 수정하기
k = 1
for xml in xml_list:
    src = os.path.join(file_path, xml)
    print("origin xml file name ==> "+src)
    
    modi_file_name = 'sonata_' + str(k) + '.xml'
    dst = os.path.join(file_path, modi_file_name)
    print(dst)
    
    os.rename(src, dst)
    
    k += 1
"""