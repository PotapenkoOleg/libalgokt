package com.libalgokt.lists.singlelinkedlist

import com.libalgokt.common.enums.InsertPosition
import com.libalgokt.common.enums.RemovePosition
import com.libalgokt.common.interfaces.BagKeyValue
import com.libalgokt.common.interfaces.List

class SingleLinkedList<Key, Value> : List<Key, Value>, BagKeyValue<Key, Value> {

    override fun add(key: Key, value: Value, position: InsertPosition) {
        TODO("Not yet implemented")
    }

    override fun add(key: Key, value: Value, before: Key) {
        TODO("Not yet implemented")
    }

    override fun add(key: Key, value: Value) {
        TODO("Not yet implemented")
    }

    override fun remove(position: RemovePosition): Value? {
        TODO("Not yet implemented")
    }

    override fun remove(key: Key): Value? {
        TODO("Not yet implemented")
    }

    override fun get(key: Key): Value? {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSize(): Int {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Value> {
        TODO("Not yet implemented")
    }
}