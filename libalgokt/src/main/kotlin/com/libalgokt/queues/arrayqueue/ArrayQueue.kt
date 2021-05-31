package com.libalgokt.queues.arrayqueue;

import com.libalgokt.common.interfaces.Bag
import com.libalgokt.common.interfaces.Queue
import java.util.function.Consumer


class ArrayQueue<E>(private var capacity: Int = DEFAULT_CAPACITY) : Queue<E>, Bag<E> {
    private var size = 0

    @Suppress("UNCHECKED_CAST")
    private var array = arrayOfNulls<Any>(capacity) as Array<E?>

    override fun enqueue(item: E) {
        if (size == capacity) {
            resize(2 * capacity)
        }
        // TODO: add at capacity minus size position
        ++size
        for (i in size - 1 downTo 1) {
            array[i] = array[i - 1]
        }
        array[0] = item
    }

    override fun dequeue(): E? {
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

    override fun peek(): E? {
        return if (size == 0) null else array[size - 1]
    }

    override fun clear() {
        capacity = DEFAULT_CAPACITY
        size = 0
        @Suppress("UNCHECKED_CAST")
        array = arrayOfNulls<Any>(capacity) as Array<E?>
    }

    override fun isEmpty(): Boolean = size == 0

    override fun getSize(): Int = size

    override fun add(item: E) = enqueue(item)

    fun getCapacity(): Int = capacity

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        this.forEach(Consumer { item: E ->
            stringBuilder.append(item)
            stringBuilder.append("\n")
        })
        return stringBuilder.toString()
    }

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

    private fun resize(capacity: Int) {
        this.capacity = capacity
        @Suppress("UNCHECKED_CAST")
        val copy = arrayOfNulls<Any>(capacity) as Array<E?>
        System.arraycopy(array, 0, copy, 0, size)
        array = copy
    }

    companion object {
        private const val DEFAULT_CAPACITY = 2 // should be power of two
    }
}
