<template>
  <div class="full-width-container">
    <Bar/>
    <ToDoList/>
    <CreateTodo/>
  </div>
</template>

<script setup lang="ts">
import Bar from "@/components/ToDoBar.vue";
import ToDoList from "@/components/ToDoList.vue";
import CreateTodo from "@/components/CreateTodo.vue";
</script>

<style scoped>
.full-width-container {
  width: 100vw;
  max-width: 100%;
  margin: 0 auto;
  padding: 20px;
  box-sizing: border-box;
}

/* Optional: zusätzliche Stil-Anpassungen für die einzelnen Komponenten */
/* Beispiel:
.Bar, .ToDoList, .CreateTodo {
  margin-bottom: 20px;
}
*/
</style>
