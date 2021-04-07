<template>
  <button
    :zz-button-progress="this.progress"
    :class="[
      'zz-button',
      {
        active: active,
        'zz-button-progress-done': done,
        'zz-button-progress-done-active': check
      }
    ]"
    @transitionend="progressTransitionEndEvent"
    @animationend="progressAnimationEndEvent"
  >
    <span> <i class="fas fa-camera-retro"></i> {{ this.text }} </span>
  </button>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    text: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      progress: null,
      active: false,
      done: false,
      check: false
    };
  },
  methods: {
    moveProgress(progress) {
      this.progress = progress;
      // console.log("4 자식 moveProgress", progress);
    },
    resetProgress() {
      this.progress = null;
      this.active = false;
      this.done = false;
      this.check = false;
    },
    progressClickEvent() {
      // console.log("1 progressClickEvent 시작");

      if (this.active === false && this.done === false) {
        this.active = true;
      }
      // this.progressTransitionEndEvent()
    },
    progressTransitionEndEvent() {
      // console.log("2 progressTransitionEndEvent 시작");
      if (this.progress === null && this.active === true) {
        this.progress = 0;

        this.$emit("progress");
      } else if (this.done === true) {
        this.check = true;
      }
    },
    progressAnimationEndEvent(evt) {
      if (evt.animationName == "progress-done-pre") {
        this.done = true;
        this.active = false;
        this.progress = null;
      } else if (evt.animationName == "progress-done-post") {
        this.$emit("progress-finished");
      }
    }
  }
});
</script>

<style></style>
