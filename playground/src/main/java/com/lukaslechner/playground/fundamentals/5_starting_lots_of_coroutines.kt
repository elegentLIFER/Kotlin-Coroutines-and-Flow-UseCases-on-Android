package com.lukaslechner.playground.fundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 这段代码轻松创建并运行 100 万个轻量协程，程序稳定无压力，直接证明协程极轻量、可支撑百万级高并发，而线程完全做不到。
 */
fun main() = runBlocking<Unit> {
    repeat(1_000_000) {
        launch {
            delay(5000)
            print(".")
        }
    }
}