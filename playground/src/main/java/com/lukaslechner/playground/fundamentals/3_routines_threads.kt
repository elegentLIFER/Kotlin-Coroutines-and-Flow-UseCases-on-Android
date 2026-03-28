package com.lukaslechner.playground.fundamentals

import kotlin.concurrent.thread

/**
 * 这段代码演示了：用原生线程也能实现并发，但线程是重量级的、需要手动等待，和轻量且自动管理的协程形成鲜明对比。
 */
fun main() {
    println("main starts")
    threadRoutine(1, 5000)
    threadRoutine(2, 3000)
    Thread.sleep(8000)
    println("main ends")
}

fun threadRoutine(number: Int, delay: Long) {
    thread {
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("Routine $number has finished")
    }
}