package com.example.dictionaryapp.data.model

data class UrbanResponse(
    val list: List<UrbanDefinition>
)

data class UrbanDefinition(
    val definition: String,
    val example: String
)
