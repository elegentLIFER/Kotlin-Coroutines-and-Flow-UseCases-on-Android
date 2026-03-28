package com.lukaslechner.playground.coroutinebuilders

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 1. async = 启动有返回值的并发协程
 *      launch：无返回值，用于执行任务
 *      async：返回 Deferred，用于获取结果
 * 2. .await() = 等待协程完成并获取结果
 *      调用时才会等待结果
 *      不影响协程已经并发执行
 */
fun main() = runBlocking<Unit> {

    val startTime = System.currentTimeMillis()

    val deferred1 = async {
        val result1 = networkCall(1).also {
            println("result received: $it after ${elapsedMillis(startTime)}ms")
        }
        result1
    }

    val deferred2 = async {
        val result2 = networkCall(2)
        println("result received: $result2 after ${elapsedMillis(startTime)}ms")
        result2
    }

    val resultList = listOf(deferred1.await(), deferred2.await())

    println("Result list: $resultList after ${elapsedMillis(startTime)}ms")
}

suspend fun networkCall(number: Int): String {
    delay(5000)
    return "Result $number"
}

fun elapsedMillis(startTime: Long) = System.currentTimeMillis() - startTime
