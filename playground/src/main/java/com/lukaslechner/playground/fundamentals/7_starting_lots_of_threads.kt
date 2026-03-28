package com.lukaslechner.playground.fundamentals

import kotlin.concurrent.thread

/**
 * 这段代码试图开启 100 万个线程，会直接因系统资源耗尽崩溃，以此极端对比凸显协程的轻量性。
 */
fun main() {
    repeat(1_000_000) {
        thread {
            Thread.sleep(5000)
            print(".")
        }
    }
}