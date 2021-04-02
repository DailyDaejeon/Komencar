<template>
  <div>
    <div>
      <input
        ref="imageInput"
        type="file"
        hidden
        @change="onChangeImages"
        :v-model="carImagePic"
        accept="image/jpeg,image/jpg"
      />
      <button type="button" @click="onClickImageUpload" class="imageupload">
        <i class="fas fa-camera-retro"></i>
        Camera
      </button>
      <div @click="onClickImageUpload">
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
import { searchModelImg } from "@/api/index";

export default Vue.extend({
  components: {
    CarImageBtn
  },

  data() {
    return {
      imageUrl: null,
      carImagePic: String
    };
  },
  methods: {
    onClickImageUpload() {
      this.$refs.imageInput.click();
    },
    onChangeImages(e) {
      console.log(e.target.files);
      const file = e.target.files[0]; // Get first index in files
      this.imageUrl = URL.createObjectURL(file); // Create File URL
      console.log("이미지 URL : ", this.imageUrl);
      this.sendImages();
    },
    sendImages() {
      if (this.imageUrl) {
        this.$refs.zzUpload.progressClickEvent();
        const imagePic = new FormData();
        const pic = "보낼 이미지 이름";
        const picDB = String(pic + ".jpg");
        this.carImagePic = picDB;
        imagePic.append("profile", this.imageUrl, String(pic + ".jpg"));
        searchModelImg(imagePic)
          .then(res => {
            console.log(res);
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
      this.$router.push({ name: "Main" });
    }
  }
});
</script>
