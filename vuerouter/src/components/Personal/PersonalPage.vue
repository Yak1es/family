<template>
    <div class="PersonalDiv">
        <personal-category/>
        <personal-pie/>
    </div>
</template>

<script>
    import PersonalCategory from "./PersonalComponents/PersonalCategory";
    import PersonalPie from "./PersonalComponents/PersonalPie";
  export default {
    name: "PersonalPage",
    components:{PersonalCategory,PersonalPie}
  }
</script>

<style scoped>
.PersonalDiv{

    position: relative;
    border-radius: 5px;
    margin-top: 30px;
    height: 500px;
    display: flex;


}
</style>