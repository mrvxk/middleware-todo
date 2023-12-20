<template>
  <v-list lines="one">
    <v-list-item
        v-for="todo in data.values()"
        :key="todo.id"
        :title="'Item ' + todo.name"
        subtitle="Lorem ipsum dolor sit amet consectetur adipisicing elit"
    ></v-list-item>
  </v-list>
</template>

<script setup lang="ts">
import {ref, onMounted} from 'vue';
import {Api, TodoResource} from "@/api/TodoService";

const api = new Api({ baseUrl: 'http://localhost:8080' });

let data = ref<TodoResource[]>([]); // Korrekte Initialisierung und Typisierung

onMounted(async () => {
  console.log(`the component is now mounted.`);
  const response = await api.todos.todosList();
  data.value = response.data; // Zuweisung der API-Antwort
});
</script>
