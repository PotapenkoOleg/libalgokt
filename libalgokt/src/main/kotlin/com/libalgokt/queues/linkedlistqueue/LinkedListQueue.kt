package com.libalgokt.queues.linkedlistqueue


import com.libalgokt.common.interfaces.Bag
import com.libalgokt.common.interfaces.Queue

class LinkedListQueue<E> : Queue<E>, Bag<E> {
    private var size = 0
    private var first: LinkedListQueueNode<E>? = null

    private class LinkedListQueueNode<Item>(val item: Item?) {
        var next: LinkedListQueueNode<Item>? = null
    }

    override fun enqueue(item: E) {
        val oldFirst = first
        first = LinkedListQueueNode(item)
        first!!.next = oldFirst
        ++size
    }

    override fun dequeue(): E? {
        val result: E
        if (first == null) {
            return null
        }
        if (first!!.next == null) {
            result = first!!.item!!
            first = null
            --size
            return result
        }
        var previous = first
        var current = first!!.next
        while (current!!.next != null) {
            previous = current
            current = current.next
        }
        result = current.item!!
        previous!!.next = null
        --size
        return result
    }

    override fun peek(): E? {
        if (first == null) {
            return null
        }
        if (first!!.next == null) {
            return first!!.item
        }
        var current = first
        while (current!!.next != null) {
            current = current.next
        }
        return current.item
    }

    override fun clear() {
        size = 0
        first = null
    }

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = first == null

    override fun add(item: E) = enqueue(item)

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        this.forEach { item: E ->
            stringBuilder.append(item)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    override fun iterator(): Iterator<E> {
        return object : Iterator<E> {
            private var current: LinkedListQueueNode<E>? = null
            override fun hasNext(): Boolean {
                return current != null && current!!.next != null
            }

            override fun next(): E {
                if (hasNext()) {
                    current = current!!.next
                    return current!!.item!!
                }
                throw NoSuchElementException()
            }

            init {
                current = LinkedListQueueNode(null)
                current!!.next = first
            }
        }
    }
}