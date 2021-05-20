package com.libalgokt.common.interfaces

interface Queue<E> : Iterable<E> {
    fun enqueue(item: E)
    fun dequeue(): E?
    fun peek(): E?
    fun clear()
    val isEmpty: Boolean
    val size: Int
}