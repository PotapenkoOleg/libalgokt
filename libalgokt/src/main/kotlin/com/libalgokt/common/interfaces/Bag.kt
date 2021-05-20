package com.libalgokt.common.interfaces

interface Bag<E> : Iterable<E> {
    fun add(item: E)
    fun isEmpty(): Boolean
    fun getSize(): Int
}
