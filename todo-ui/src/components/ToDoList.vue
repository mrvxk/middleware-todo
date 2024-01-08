<template>
  <v-container class="todo-list">
    <v-list lines="one">
      <v-list-item
          v-for="todo in data.values()"
          :key="todo.id"
          class="todo-item"
      >
        <div class="todo-content border pa-4">
          <div v-if="isEditing(todo.id)" class="todo-edit-fields d-flex flex-row ma-2 flex-grow-1">
            <v-text-field
                v-model="todo.name"
                class="todo-input"
                @keyup.enter="updateTodo(todo)"
            />
            <v-text-field
                v-model="todo.notes"
                class="todo-textarea"
                @keyup.enter="updateTodo(todo)"
            ></v-text-field>
            <button @click="updateTodo(todo)" class="save-btn">Save</button>
          </div>
          <div v-else class="todo-display-fields d-flex flex-row ma-2 flex-grow-1" @click="startEditing(todo.id)">
            <h3 class="text-center w-50 ma-0 todo-title">{{ todo.name }}</h3>
            <p class="w-50 ma-0 text-center">{{ todo.notes }}</p>
          </div>
          <button @click="deleteTodo(todo.id)" class="delete-btn">Delete</button>
        </div>
      </v-list-item>
    </v-list>
  </v-container>
</template>


<script setup lang="ts">
import {reactive} from 'vue';
import {Api, TodoResource} from "@/api/TodoService";

const api = new Api({baseUrl: import.meta.env.VITE_BE_URL});
let editingStatus = reactive(new Map<string, boolean>());
const emit = defineEmits(['item-deleted', 'item-updated']);

defineProps({data: {type: Array as () => TodoResource[], required: true}})


const isEditing = (id: string) => editingStatus.get(id);

const startEditing = (id: string) => {
  editingStatus.set(id, true);
};

const stopEditing = (id: string) => {
  editingStatus.set(id, false);
};

const updateTodo = async (todo: TodoResource) => {
  console.log(todo)
  if (todo.id) {
    await api.todos.todosUpdate(todo);
    stopEditing(todo.id);
    emit('item-updated');
  }
};

const deleteTodo = async (id: string) => {
  await api.todos.deleteDelete(id);
  emit('item-deleted');
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

}

.todo-title {
  width: 100px;
  margin: 0;
  font-weight: bold;
  margin-right: 10px;
}

.delete-btn {
  background-color: #ff4d4d;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
  height: 60px;
  margin-top: 8px;
}

.save-btn {
  background-color: green;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
  height: 60px;
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
