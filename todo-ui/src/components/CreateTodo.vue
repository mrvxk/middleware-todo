<template>
  <div class="add-todo-form">
    <v-text-field
        v-model="newTodo.name"
        type="text"
        placeholder="Todo-Name"
        class="todo-input ma-1"
    />
    <v-textarea
        v-model="newTodo.notes"
        placeholder="Notes"
        class="todo-textarea"
    ></v-textarea>
    <button @click="addTodo" class="add-btn">Todo hinzufügen</button>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {Api, TodoResource} from "@/api/TodoService";

const api = new Api({baseUrl: import.meta.env.VITE_BE_URL});
let newTodo = ref({name: '', notes: ''} as TodoResource);
const emit = defineEmits(['item-added']);

const addTodo = async () => {
  if (newTodo.value.name ) {
    await api.todos.todosCreate(newTodo.value);
    emit('item-added');
    newTodo = ref({name: '', notes: ''});
  }
};
</script>

<style>
.add-todo-form {
  max-width: 80vw;
  margin: auto;
  padding: 20px;
}

.todo-input, .todo-textarea {
  width: 100%;
  margin-bottom: 10px;
  padding: 8px;
  box-sizing: border-box;
}

.add-btn {
  background-color: #4caf50;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
}

.add-btn:hover {
  background-color: #45a049;
}
</style>
