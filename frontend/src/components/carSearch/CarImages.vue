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
        >
        <!-- :capture="imageMethod" -->
        <button 
        type="button"
        @click="onClickImageUpload"
        class="imageupload-btn"
        >
          <template v-if="imageMethod==='camera'">
            <i class="fas fa-camera-retro"></i>
          </template>
          <template v-else>
            <i class="fas fa-image"></i>
          </template>
          {{ imageMethod }}
        </button>
      </div>
    <img 
    v-if="imageUrl"
    :src="imageUrl"
    width="100%" 
    alt="이미지">
  </div>
    
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  props :{
    imageMethod :{
      type : String,
      required : true,
      default:"camera"
    }
  },
  data() {
    return {
      imageUrl: null,
      carImagePic:String,
    }
  },
  methods: {
    onClickImageUpload() {
    this.$refs.imageInput.click();
    },
    onChangeImages(e) {
        console.log(e.target.files)
        const file = e.target.files[0]; // Get first index in files
        this.imageUrl = URL.createObjectURL(file); // Create File URL
        console.log('이미지 URL : ',this.imageUrl)
        // this.sendImages();
    },
    // sendImages() {
    //   if(this.imageUrl) {
    //       let imagePic = new FormData();
    //       let pic = "보낼 이미지 이름";
    //       let picDB = String(pic + '.jpg');
    //       this.carImagePic = picDB;
    //       imagePic.append("profile", this.imageUrl, String(pic+'.jpg'))
    //       await API보내기(imagePic)
    //       .then(() => {
    //       })
    //       .catch(() => {
    //         this.$swal({
    //           text: "프로필 사진을 업로드 하던 중 오류가 발생했습니다.",
    //           customClass: {
    //             container: 'swal2-container'
    //           },
    //           icon: 'warning',
    //           timer: 1300,
    //           showConfirmButton: false,
    //         })
    //         return false;
    //       });
    //     }
//     }
  }
    
})
</script>
