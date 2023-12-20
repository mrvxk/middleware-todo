<template>
    <v-layout>
      <v-app-bar
          color="secondary"
          density="compact"
      >
        <template v-slot:prepend>
          <v-app-bar-nav-icon></v-app-bar-nav-icon>
        </template>

        <v-app-bar-title>ToDos</v-app-bar-title>

        <template v-slot:append>
          <v-btn icon="mdi-dots-vertical"></v-btn>
         </template>
      </v-app-bar>
    </v-layout>
</template>