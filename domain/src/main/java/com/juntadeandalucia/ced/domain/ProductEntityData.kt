package com.juntadeandalucia.ced.domain


data class ProductEntityData(
    val id: Int,
    val title: String,
    val subtitle : String,
    val imageList : List<String>
)