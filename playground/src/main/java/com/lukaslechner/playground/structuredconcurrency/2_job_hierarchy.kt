package com.lukaslechner.playground.structuredconcurrency

import kotlinx.coroutines.*

fun main() {
    val scopeJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + scopeJob)

    val passedJob = Job()
    val coroutineJob = scope.launch(passedJob) {
        println("Starting coroutine")
        delay(1000)
    }

    println("传入的 passedJob 和协程返回的 coroutineJob 是同一个对象：${passedJob === coroutineJob}")

    println("coroutineJob 是不是 scopeJob 的子任务？ => ${scopeJob.children.contains(coroutineJob)}")
}