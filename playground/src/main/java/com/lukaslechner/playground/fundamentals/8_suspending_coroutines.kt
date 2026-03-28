package com.lukaslechner.playground.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

/**
 * 协程可以在一个线程上，高效、非阻塞、并发地执行多个任务，比线程更轻、更快、更简单。
 */
fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { suspendingCoroutine(1, 5000) },
        async { suspendingCoroutine(2, 3000) },
        async {
            repeat(5) {
                println("other tasks is working on ${Thread.currentThread().name}")
                delay(1000)
            }
        }
    )
    println("main ends")
}

suspend fun suspendingCoroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name}")
}