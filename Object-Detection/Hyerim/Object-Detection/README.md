# Object-Detection 학습

## ⭐GITHUB⭐

[5taku/custom_object_detection](https://github.com/5taku/custom_object_detection/tree/a5921b3c020dddb542412e8c0f38a42e594b34ba#summary)

## Object Detection API 사용해서 따라하기

### 0. Tutorial

```
Object-Detection Folder
	└─ google-images-download //구글 이미지 크롤링
	└─ images //크롤링한 이미지 저장
	└─ labelImg //이미지 라벨링
	└─ models //tensorflow (아마도)2.0 models Folder
	└─ tensorflow_object_detection_helper_tool //object_detection model api
	└─ xml //라벨링 결과 저장
anaconda - Object-Detection
- python 3.7.10

lib
	- cudnn 7.6.5
	- Cython 0.29.22
	- jupyter 1.0.0
	- lxml 4.6.1
	- matplotlib 3.3.4
	- numpy 1.19.2
	- pandas 1.2.3
	- pillow 8.1.2
	- pyqt 5.9.2
	- scikit-learn 0.24.1
	- scipy 1.6.1
	- tensorflow 1.5.0	//2.x 버전 안됨(tensorflow.contrib.slim 문제)
	- tqdm 4.56.0
	- etc.
```

### 1. 데이터 수집

- Object-Detection / google-images-download 를 이용해서 데이터 수집하기

  (avante2020 정/측/후면 이미지 각각 100장씩 크롤링)

```powershell
...\\google-images-download> googleimagesdownload --keywords "avante2020 frontal" --size medium --output_directory ./images/
```

- 사진 확장자는 .jpg만 사용 가능(.png/.webp 파일 삭제)

- 적절한 이미지가 아닌 사진들 정제(아반떼 사진이 아닌 것, 측면 폴더에 있는 후면 사진 등)

### 2. 데이터 라벨링

- labelImg 이용하여 이미지에 라벨링 처리

```powershell
...\\labelImg> pyrcc5 -o libs/resources.py resources.qrc
...\\labelImg> python labelImg.py -i "../images/이미지 저장된 폴더명"
```

- Change Save dir ⇒ xml 파일 저장할 폴더 지정(보통 원본 이미지 파일하고 같은 폴더에 저장)

- Open Dir ⇒ 원본 이미지가 저장된 폴더 선택

- 원하는 영역을 선택한 뒤, 라벨링 처리

- 단축키

  - W : 영역 지정

  - A : 이전 이미지

  - D : 다음 이미지

### 3. label_map.pdtxt 파일 수정

- 본인이 지정한 라벨링에 맞춰서 파일 수정

**(PATH : ...\tensorflow_object_detection_helper_tool\label_map.pdtxt)**

```
item {
  id: 1
  name: 'avante2020 frontal'
}
item {
  id: 2
  name: 'avante2020 rear'
}
item {
  id: 3
  name: 'avante2020 side'
}
```

### 4. TF RECORD 파일 생성

- tensorflow_object_detection_helper_tool 이용해서 TF RECORD 파일을 생성

```powershell
...\\tensorflow_object_detection_helper_tool> python tfgenerator.py -i "../images/tfRecord"
```

### 5. Treansfer Learning & exporting

- import 경로 맞춰주기(이유는 모르겠는데 경로가 아주 그냥 엉망진창이야🤬)

- Raster_Rcnn_Inception_v2_coco 모델을 통해서 50000번 학습시키기

  (3000번 주기로 evaluate 값 확인)

**❗오류 이슈❗**

1. from deployment import model_deploy 가 어디 있는데....!!!!!!

   ⇒ tf_slim 따로 설치해서 해결!

   ```
   //cmd 켤 때마다 이거 두 줄 추가(걍 고정하는 법 없나...)
   set PYTHONPATH=C:\\Users\\multicampus\\git\\SSAFY_PJT2\\Object-Detection\\tensorflow\\models;C:\\Users\\multicampus\\git\\SSAFY_PJT2\\Object-Detection\\tensorflow\\models\\research;C:\\Users\\multicampus\\git\\SSAFY_PJT2\\Object-Detection\\tensorflow\\models\\research\\slim

   ...\\tensorflow\\models\\research>>protoc --python_out=. .\\object_detection\\protos\\anchor_generator.proto .\\object_detection\\protos\\argmax_matcher.proto .\\object_detection\\protos\\bipartite_matcher.proto .\\object_detection\\protos\\box_coder.proto .\\object_detection\\protos\\box_predictor.proto .\\object_detection\\protos\\eval.proto .\\object_detection\\protos\\faster_rcnn.proto .\\object_detection\\protos\\faster_rcnn_box_coder.proto .\\object_detection\\protos\\grid_anchor_generator.proto .\\object_detection\\protos\\hyperparams.proto .\\object_detection\\protos\\image_resizer.proto .\\object_detection\\protos\\input_reader.proto .\\object_detection\\protos\\losses.proto .\\object_detection\\protos\\matcher.proto .\\object_detection\\protos\\mean_stddev_box_coder.proto .\\object_detection\\protos\\model.proto .\\object_detection\\protos\\optimizer.proto .\\object_detection\\protos\\pipeline.proto .\\object_detection\\protos\\post_processing.proto .\\object_detection\\protos\\preprocessor.proto .\\object_detection\\protos\\region_similarity_calculator.proto .\\object_detection\\protos\\square_box_coder.proto .\\object_detection\\protos\\ssd.proto .\\object_detection\\protos\\ssd_anchor_generator.proto .\\object_detection\\protos\\string_int_label_map.proto .\\object_detection\\protos\\train.proto .\\object_detection\\protos\\keypoint_box_coder.proto .\\object_detection\\protos\\multiscale_anchor_generator.proto .\\object_detection\\protos\\graph_rewriter.proto
   ```

   [참고]

   - 내일 시도해보기

   [Tensorflow2 Object Detection API 설치 및 환경 구성](https://like-edp.tistory.com/10)

   https://deeplearning.home.blog/2018/11/13/python-tensorflow-object-detection-api%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EA%B0%9D%EC%B2%B4-%ED%83%90%EC%A7%80-%EB%B0%A9%EB%B2%95-1/

   [Tf Slim :: Anaconda.org](https://anaconda.org/conda-forge/tf_slim)

   +) train.py / trainer.py 파일을 둘 다 tensorflow/models/research 폴더에 복사해줌

## ⭐참고자료⭐

[13. Object Detection - two stage method(R-CNN, fast R-CNN, faster R-CNN)](https://nittaku.tistory.com/273)

[[Object Detection\] 1. Object Detection 논문 흐름 및 리뷰](https://nuggy875.tistory.com/20)

[[Object Detection\] 2. R-CNN : 딥러닝을 이용한 첫 2-stage Detector](https://nuggy875.tistory.com/21)
