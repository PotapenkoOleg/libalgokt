package com.libalgokt.stacks.arraystack

import com.libalgokt.common.interfaces.Bag
import com.libalgokt.common.interfaces.Stack


class ArrayStack<E>(private var capacity: Int = DEFAULT_CAPACITY) : Stack<E>, Bag<E> {
    private var size = 0

    @Suppress("UNCHECKED_CAST")
    private var array = arrayOfNulls<Any>(capacity) as Array<E?>

    override fun push(item: E) {
        if (size == capacity) {
            resize(2 * capacity)
        }
        array[size++] = item
    }

    override fun pop(): E? {
        if (size == 0) {
            return null
        }
        val result = array[--size]
        array[size] = null // make sure we don't copy garbage during array resize

        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2)
        }
        return result
    }

    override fun peek(): E? = if (size == 0) null else array[size - 1]

    override fun clear() {
        size = 0
        capacity = DEFAULT_CAPACITY
        @Suppress("UNCHECKED_CAST")
        array = arrayOfNulls<Any>(DEFAULT_CAPACITY) as Array<E?>
    }

    override fun add(item: E) = push(item)

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = size == 0

    fun getCapacity(): Int = capacity

    override fun iterator(): Iterator<E> {
        return object : Iterator<E> {
            private var current = size
            override fun hasNext(): Boolean {
                return current > 0
            }

            override fun next(): E {
                if (hasNext()) {
                    return array[--current]!!
                }
                throw NoSuchElementException()
            }
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        this.forEach { item ->
            stringBuilder.append(item)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    private fun resize(capacity: Int) {
        this.capacity = capacity
        @Suppress("UNCHECKED_CAST")
        val copy = arrayOfNulls<Any>(capacity) as Array<E?>
        System.arraycopy(array, 0, copy, 0, size)
        array = copy
    }

    companion object {
        const val DEFAULT_CAPACITY = 2 // should be power of two
    }
}