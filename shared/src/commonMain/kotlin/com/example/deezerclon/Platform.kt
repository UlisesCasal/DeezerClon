package com.example.deezerclon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform