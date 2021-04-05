<template>
  <div>
    <div>
      <!-- <button type="button" @click="onClickImageUpload" class="imageupload">
        <i class="fas fa-camera-retro"></i>
        Camera
      </button> -->
      <div class="camera-button-div" @click="onClickImageUpload">
        <input
          ref="imageInput"
          type="file"
          hidden
          @change="onChangeImages"
          :v-model="carImagePic"
          accept="image/jpeg,image/jpg"
        />
        <CarImageBtn
          text="Camera"
          ref="zzUpload"
          @progress="moveProgress"
          @progress-finished="endProgress"
        />
      </div>
    </div>
    <img v-if="imageUrl" :src="imageUrl" width="100%" alt="이미지" />
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarImageBtn from "@/components/carSearch/CarImageBtn.vue";
import { searchModelImg, findModelId } from "@/api/index";

export default Vue.extend({
  components: {
    CarImageBtn
  },

  data() {
    return {
      imageUrl: null,
      carImagePic: String,
      modelId: Number,
      modelDetailId: Number,
      modelName: String,
      modelDetailName: String,
      imagefile: null
    };
  },
  methods: {
    onClickImageUpload() {
      this.$refs.imageInput.click();
    },
    onChangeImages(e) {
      console.log(e.target.files);
      const file = e.target.files[0]; // Get first index in files
      this.imagefile = file;
      this.imageUrl = URL.createObjectURL(file); // Create File URL
      console.log("이미지 URL : ", this.imageUrl);
      this.sendImages();
    },
    sendImages() {
      if (this.imagefile) {
        // this.$refs.zzUpload.progressClickEvent();
        const imagePic = new FormData();
        imagePic.append("file", this.imagefile, String(".jpg"));
        searchModelImg(imagePic)
          .then(res => {
            console.log("너는 무슨 자동차니 ? ", res.data);
            findModelId(res.data).then(res => {
              console.log("제 정보는용", res.data);
              this.$router.push({
                name: "Main",
                params: { modelInfo: res.data }
              });
            });
          })
          .catch(() => {
            this.$swal({
              text: "사진을 업로드 하던 중 오류가 발생했습니다.",
              customClass: {
                container: "swal2-container"
              },
              icon: "warning",
              timer: 1300,
              showConfirmButton: false
            });
            return false;
          });
      }
    },
    moveProgress(progress = 0) {
      console.log("3 moveProgress시작", progress);
      // 업로드 api로 바꾸기 그만큼 시간흐름
      const progressTimeout = setTimeout(() => {
        clearTimeout(progressTimeout);

        if (progress < 100) {
          const newProgress = progress + 1;
          this.$refs.zzUpload.moveProgress(newProgress);
          this.moveProgress(newProgress);
        }
      }, 10);
    },
    endProgress() {
      const endProgressTimeout = setTimeout(() => {
        clearTimeout(endProgressTimeout);

        this.$refs.zzUpload.resetProgress();
      }, 1000);
      this.$router.push({
        name: "Main",
        params: {
          m_id: this.modelId,
          md_id: this.modelDetailId,
          m_name: this.modelName,
          md_name: this.modelDetailName
        }
      });
    }
  }
});
</script>
