package com.lukaslechner.coroutineusecasesonandroid.playground.structuredconcurrency

import kotlinx.coroutines.*

// IMPORTANT: The playground functions stopped working with Android Studio Otter,
// that's why I moved them from the "app" gradle module into a standalone Kotlin library
// gradle module called playground.

/**
 * coroutineScope会等待其内部所有子协程执行完成后才会返回，外部协程会等它执行完毕再启动后续子协程，体现了结构化并发的等待特性。
 */
fun main() {

    val scope = CoroutineScope(Job())

    scope.launch {

        doSomeTasks()

        launch {
            println("Starting Task 3")
            delay(3000)
            println("Task 3 completed")
        }
    }

    Thread.sleep(10000)
}

suspend fun doSomeTasks() = coroutineScope {
    launch {
        println("Starting Task 1")
        delay(1000)
        println("Task 1 completed")
    }

    launch {
        println("Starting Task 2")
        delay(2000)
        println("Task 2 completed")
    }
}