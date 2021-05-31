package com.libalgokt.common.interfaces

interface PriorityQueue<E : Comparable<E>> : CollectionBase {
    fun insert(item: E)
    fun delete(): E?
    fun peek(): E?
}