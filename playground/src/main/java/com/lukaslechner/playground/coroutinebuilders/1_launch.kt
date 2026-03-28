package com.lukaslechner.playground.coroutinebuilders

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 协程可以不自动运行，而是由你手动控制：什么时候开始、什么时候执行。
 */
fun main() = runBlocking<Unit> {
    val job = launch(start = CoroutineStart.LAZY) {
        networkRequest()
        println("result received")
    }
    delay(2000)
    job.start()
    println("end of runBlocking")
}

suspend fun networkRequest(): String {
    delay(5000)
    return "Result"
}