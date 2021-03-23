<template>
    <div>
      <input 
      type="file" 
      accept="image/*" 
      ref="imageInput" @change="onChangeImages">
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
  data() {
    return {
      imageUrl: null,
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
    }
  }
    
})
</script>
