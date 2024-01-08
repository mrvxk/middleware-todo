<template>
  <div class="todo-list">
    <v-list lines="one">
      <v-list-item
          v-for="todo in data.values()"
          :key="todo.id"
          class="todo-item"
      >
        <div class="todo-content">
          <div v-if="isEditing(todo.id)" class="todo-edit-fields">
            <input
                v-model="todo.name"
                class="todo-input"
                @keyup.enter="updateTodo(todo)"
                @blur="stopEditing(todo.id)"
            />
            <textarea
                v-model="todo.notes"
                class="todo-textarea"
                @keyup.enter="updateTodo(todo)"
                @blur="stopEditing(todo.id)"
            ></textarea>
          </div>
          <div v-else class="todo-display-fields" @click="startEditing(todo.id)">
            <h3 class="todo-title">{{ todo.name }}</h3>
            <p class="todo-subtitle">{{ todo.notes }}</p>
          </div>
        </div>
        <button @click="deleteTodo(todo.id)" class="delete-btn">Delete</button>
      </v-list-item>
    </v-list>
  </div>
</template>


<script setup lang="ts">
import {ref, reactive, onMounted} from 'vue';
import {Api, TodoResource} from "@/api/TodoService";

const api = new Api({ baseUrl: 'http://82.165.178.16:8020' });
let data = ref<TodoResource[]>([]);
let editingStatus = reactive(new Map<string, boolean>());

onMounted(async () => {
  const response = await api.todos.todosList();
  data.value = response.data;
  console.log(response.data)
  data.value.forEach(todo => editingStatus.set(todo.id!, false));
});

const isEditing = (id: string) => editingStatus.get(id);

const startEditing = (id: string) => {
  editingStatus.set(id, true);
};

const stopEditing = (id: string) => {
  editingStatus.set(id, false);
};

const updateTodo = async (todo: TodoResource) => {
  if (todo.id) {
    await api.todos.todosUpdate(todo);
    stopEditing(todo.id);
  }
};

const deleteTodo = async (id: string) => {
  await api.todos.deleteDelete(id);
  data.value = data.value.filter(todo => todo.id !== id);
};
</script>


<style>
.todo-list {
  max-width: 80vw;
  margin: auto;
  padding: 20px;
}

.todo-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 1px solid #eee;
  padding: 10px 0;
}

.todo-content {
  flex-grow: 1;
  display: flex;
}

.todo-edit-fields, .todo-display-fields {
  flex-grow: 1;
}

.todo-title {
  width: 100px;
  margin: 0;
  font-weight: bold;
  margin-right: 10px;
}

.todo-subtitle {
  width: 100px;
  margin: 0;
}

.delete-btn {
  background-color: #ff4d4d;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
}

.delete-btn:hover {
  background-color: #ff3333;
}

.todo-edit-fields {
  display: flex;
  gap: 10px; /* Fügt einen Abstand zwischen den Feldern hinzu */
}

.todo-input, .todo-textarea {
  width: 100px;
  margin-right: 20px;
  box-sizing: border-box;
  border: 1px solid transparent;
  padding: 8px;
}

/* Stile für die Eingabefelder im Bearbeitungsmodus */
.todo-input:focus, .todo-textarea:focus {
  border: 1px solid black;
}
</style>
