<template>
  <div class="add-todo-form">
    <input
        v-model="newTodo.name"
        type="text"
        placeholder="Todo-Name"
        class="todo-input"
    />
    <textarea
        v-model="newTodo.notes"
        placeholder="Notizen"
        class="todo-textarea"
    ></textarea>
    <button @click="addTodo" class="add-btn">Todo hinzufügen</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { Api, TodoResource } from "@/api/TodoService";

const api = new Api({ baseUrl: 'http://82.165.178.16:8020' });
const newTodo = ref({ name: '', notes: '' });

const addTodo = async () => {
  if (newTodo.value.name) {
    await api.todos.todosCreate(newTodo.value);
    newTodo.value = { name: '', notes: '' }; // Zurücksetzen des Formulars
    // Emit an event or update a global state here if needed
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
