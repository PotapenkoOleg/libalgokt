package com.libalgokt.common.interfaces

public interface Stack<E> : Iterable<E> {
    fun push(item: E)
    fun pop(): E?
    fun peek(): E?
    fun clear()
    val isEmpty: Boolean
    val size: Int
}