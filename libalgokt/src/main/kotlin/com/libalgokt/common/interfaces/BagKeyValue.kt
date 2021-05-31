package com.libalgokt.common.interfaces

interface BagKeyValue<Key, Value> : Iterable<Value>, CollectionBase {
    fun add(key: Key, value: Value)
}

