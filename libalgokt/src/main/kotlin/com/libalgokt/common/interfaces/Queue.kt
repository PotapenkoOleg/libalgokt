package com.libalgokt.common.interfaces

interface Queue<E> : Iterable<E>, CollectionBase {
    fun enqueue(item: E)
    fun dequeue(): E?
    fun peek(): E?
}