package com.libalgokt.common.interfaces

import com.libalgokt.common.enums.InsertPosition
import com.libalgokt.common.enums.RemovePosition

public interface List<Key, Value> : Iterable<Value> {
    fun add(key: Key, value: Value, position: InsertPosition)
    fun add(key: Key, value: Value, before: Key)
    fun remove(position: RemovePosition): Value?
    fun remove(key: Key): Value?
    fun get(key: Key): Value?
    fun clear()
    val isEmpty: Boolean
    val size: Int
}