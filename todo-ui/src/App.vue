<template>
  <div class="full-width-container">
    <Bar/>
    <ToDoList :data="data" @item-deleted="loadItems" @item-updated="loadItems"/>
    <CreateTodo @item-added="loadItems" />
  </div>
</template>

<script setup lang="ts">
import Bar from "@/components/ToDoBar.vue";
import ToDoList from "@/components/ToDoList.vue";
import CreateTodo from "@/components/CreateTodo.vue";
import type {TodoResource} from "@/api/TodoService";
import {ref} from "vue";
import {Api} from "@/api/TodoService";

const api = new Api({baseUrl: import.meta.env.VITE_BE_URL});
let data = ref<TodoResource[]>([]);

const loadItems = async () => {
  const response = await api.todos.todosList();
  if (response.data) {
    data.value = response.data;
    console.log(response.data)
  }
};

loadItems();
</script>

<style scoped>
.full-width-container {
  width: 100vw;
  max-width: 100%;
  margin: 0 auto;
  padding: 20px;
  box-sizing: border-box;
  left: 0px;
  position: absolute;
  top: 80px;
}

/* Optional: zusätzliche Stil-Anpassungen für die einzelnen Komponenten */
/* Beispiel:
.Bar, .ToDoList, .CreateTodo {
  margin-bottom: 20px;
}
*/
</style>
