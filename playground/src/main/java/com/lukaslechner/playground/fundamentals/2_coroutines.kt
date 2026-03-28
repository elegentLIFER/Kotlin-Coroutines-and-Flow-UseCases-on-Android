package com.lukaslechner.playground.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

/**
 * 这段代码直观展示了协程的非阻塞并发执行：两个任务同时启动，各自延时等待但不阻塞线程，总耗时由最长任务决定。
 */
fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { coroutine(1, 5000) },
        async { coroutine(2, 3000) }
    )
    println("main ends")
}

suspend fun coroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work")
    delay(delay)
    println("Coroutine $number has finished")
}