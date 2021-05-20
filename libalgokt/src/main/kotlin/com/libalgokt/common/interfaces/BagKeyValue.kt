package com.libalgokt.common.interfaces

public interface BagKeyValue<Key, Value> : Iterable<Value> {
    fun add(key: Key, value: Value)
    val isEmpty: Boolean
    val size: Int
}

