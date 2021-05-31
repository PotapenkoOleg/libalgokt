package com.libalgokt.common.interfaces

interface Stack<E> : Iterable<E>, CollectionBase {
    fun push(item: E)
    fun pop(): E?
    fun peek(): E?
}