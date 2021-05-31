package com.libalgokt.common.interfaces

interface HashTable<Key, Value> : CollectionBase {
    fun add(key: Key, value: Value)
    fun remove(key: Key): Value?
    fun get(key: Key): Value?
}

