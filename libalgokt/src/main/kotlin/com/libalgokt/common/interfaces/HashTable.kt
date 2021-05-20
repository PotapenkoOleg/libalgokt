package com.libalgokt.common.interfaces

interface HashTable<Key, Value> {
    fun add(key: Key, value: Value)
    fun remove(key: Key): Value?
    fun get(key: Key): Value?
    fun clear()
    val isEmpty: Boolean
    val size: Int
}

