package com.lukaslechner.playground.structuredconcurrency

import kotlinx.coroutines.*

/**
 * 这段代码演示了自定义协程作用域 + 生命周期安全取消：
 * 当组件销毁时，调用scope.cancel()，作用域内所有协程会被自动取消，并能通过 invokeOnCompletion 监听取消事件，彻底避免泄漏。
 */

val scope = CoroutineScope(Dispatchers.Default)

fun main() = runBlocking<Unit> {

    val job = scope.launch {
        delay(100)
        println("Coroutine completed")
    }

    job.invokeOnCompletion { throwable ->
        if (throwable is CancellationException) {
            println("Coroutine was cancelled")
        }
    }

    delay(50)
    onDestroy()
}

fun onDestroy() {
    println("life-time of scope ends")
    scope.cancel()
}