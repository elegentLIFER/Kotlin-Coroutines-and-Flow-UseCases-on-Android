package com.lukaslechner.playground.fundamentals

/**
 * 这段代码演示普通同步函数会阻塞执行，必须等前一个任务完全结束，后一个任务才会开始，和协程的非阻塞并发形成鲜明对比。
 */
fun main() {
    println("main starts")
    routine(1, 5000)
    routine(2, 3000)
    println("main ends")
}

fun routine(number: Int, delay: Long) {
    println("Routine $number starts work")
    Thread.sleep(delay)
    println("Routine $number has finished")
}