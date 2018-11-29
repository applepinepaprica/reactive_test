package com.example.test2.str

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

@Document
data class Str(@Id val id: String? = null,
                val title: String)