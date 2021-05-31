package com.libalgokt.common.interfaces


interface Bag<E> : Iterable<E>, CollectionBase {
    fun add(item: E)
}
