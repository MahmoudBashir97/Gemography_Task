package com.mahmoudbashir.gemographytask.pojo

data class Root(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)