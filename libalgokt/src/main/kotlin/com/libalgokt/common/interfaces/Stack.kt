package com.libalgokt.common.interfaces

interface Stack<E> : Iterable<E> {
    fun push(item: E)
    fun pop(): E?
    fun peek(): E?
    fun clear()
    fun isEmpty(): Boolean
    fun getSize(): Int
}