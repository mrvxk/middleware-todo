<template>
  <div class="todo-list">
    <v-list lines="one">
      <v-list-item
          v-for="todo in data.values()"
          :key="todo.id"
          class="todo-item"
      >
        <div class="todo-content">
          <input
              v-model="todo.name"
              @blur="updateTodo(todo)"
              class="todo-input"
          />
          <p class="todo-subtitle">Lorem ipsum dolor sit amet consectetur adipisicing elit</p>
        </div>
        <button @click="deleteTodo(todo.id)">Delete</button>
      </v-list-item>
    </v-list>
  </div>
</template>

<style>
.todo-list {
  width: 100vw;
  padding: 20px;
}

.todo-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.todo-content {
  flex-grow: 1;
}

.todo-input {
  width: 100%;
  margin-right: 20px;
}

.todo-subtitle {
  margin-top: 5px;
}
</style>

<script setup lang="ts">
import {ref, onMounted} from 'vue';
import {Api, TodoResource} from "@/api/TodoService";

const api = new Api({baseUrl: 'http://localhost:8080'});
let data = ref<TodoResource[]>([]);

onMounted(async () => {
  const response = await api.todos.todosList();
  data.value = response.data;
});

const updateTodo = async (todo: TodoResource) => {
  if (todo.id) {
    await api.todos.todosUpdate(todo);
  }
};

const deleteTodo = async (id: string) => {
  await api.todos.deleteDelete(id);
  data.value = data.value.filter(todo => todo.id !== id);
};
</script>
