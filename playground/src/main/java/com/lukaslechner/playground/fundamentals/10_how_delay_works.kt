package com.lukaslechner.playground.fundamentals

// import android.os.Handler
// import android.os.Looper
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

/**
 * 核心想表达：协程的非阻塞延时，在纯 Kotlin 环境用 delay，在 Android 环境用 Handler 实现主线程延时。
 */
fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { delayDemonstration(1, 5000) },
        async { delayDemonstration(2, 3000) }
    )
    println("main ends")
}

suspend fun delayDemonstration(number: Int, delay: Long) {
    println("Coroutine $number starts work")

    // delay(delay)

    // Unfortunately, this doesn't work anymore when I needed to move the playground into its own
    // module when Android Otter came out. I haven't yet found a solution about how to access
    // the Android looper in this module ...

    // Handler(Looper.getMainLooper())
    //    .postDelayed({
    //        println("Coroutine $number has finished")
    //     }, 500)
}