package com.juntadeandalucia.ced.domain

import java.io.Serializable

data class ProductEntityView(
    val title: String,
    val subtitle : String,
    val imageList : List<String>
): Serializable