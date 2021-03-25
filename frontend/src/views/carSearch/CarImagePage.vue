<template>
  <div>
      <div class="container" id="scanIdCardPage">
      <div class="scanIdCardDiv">
              <div class="scanCardContainer" v-show="afterTakingPhoto">
                  <video ref="video" id="video"  autoplay></video>
                  <canvas ref="canvas" id="canvas" width="320" height="240" style="display: none;"></canvas>
              </div>
          </div>
      </div>

      <div class="takePhotoBtnDiv">
          <div>
              <button type="button" class="btn btn-info" @click="Camera">Camera</button>
          </div>
      </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  data() {
    return {
      myPreferredCameraDeviceId: "" as any,
      afterTakingPhoto:false as boolean,
      videoLabel: false as any
    }
    },
    methods: {
        Camera() {
            if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
              navigator.mediaDevices.enumerateDevices().then((devices) => {
          devices.forEach((device) => {
            console.log(device.kind + ": " + device.label +
                        " id = " + device.deviceId);
            // console.log('디바이스종류',device.kind, device)
            console.log('???',this.videoLabel)
            if (device.kind === "videoinput" && !this.videoLabel) {
              console.log('디바이스ID?',device.deviceId)
              this.videoLabel = device.label;
              // this.myPreferredCameraDeviceId = device.deviceId;
              navigator.mediaDevices.getUserMedia({ video: { deviceId: device.deviceId } }).then(stream => {
                  // console.log('내디바이스',this.myPreferredCameraDeviceId)
                  console.log("내디바이스",stream)
                  document.querySelector('video').srcObject = stream;
                  const track = stream.getVideoTracks()[0];
                  console.log('트랙',track)
                  // const imagePic = new FormData();
                  // const pic = "보낼 이미지 이름";
                  // imagePic.append("profile", this.imageUrl, String(pic+'.jpg'))
                  this.afterTakingPhoto = true
                });
            }
          });
        })
        .catch(function(err) {
          console.log(err.name + ": " + err.message);
        });
                
            }
        },
        findDeviseInfo() {
          if (!navigator.mediaDevices || !navigator.mediaDevices.enumerateDevices) {
          console.log("enumerateDevices() not supported.");
          return;
        }

        // List cameras and microphones.

        navigator.mediaDevices.enumerateDevices()
        .then(function(devices) {
          devices.forEach(function(device) {
            console.log(device.kind + ": " + device.label +
                        " id = " + device.deviceId);
                        console.log('??',device.kind)
            if (device.kind === "videoinput") {
              this.myPreferredCameraDeviceId = device.deviceId;
              console.log('난 뭘까',typeof this.myPreferredCameraDeviceId,this.myPreferredCameraDeviceId)
            }
          });
        })
        .catch(function(err) {
          console.log(err.name + ": " + err.message);
        });
        }
    },
    mounted() {
      // this.findDeviseInfo();
      // this.Camera();
    }
})
</script>

<style>

</style>