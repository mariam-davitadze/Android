package com.example.recyclerapp.model

import com.example.recyclerapp.model.Data
import com.example.recyclerapp.model.Support

data class UsersListResponse(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)