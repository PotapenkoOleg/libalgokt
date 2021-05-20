package com.libalgokt.common.interfaces

public interface Bag<E> : Iterable<E> {
    fun add(item: E)
    val isEmpty: Boolean
    val size: Int
}
