package com.libalgokt.common.interfaces

public interface PriorityQueue<E : Comparable<E>> {
    fun insert(item: E)
    fun delete(): E?
    fun peek(): E?
    fun clear()
    val isEmpty: Boolean
    val size: Int
}