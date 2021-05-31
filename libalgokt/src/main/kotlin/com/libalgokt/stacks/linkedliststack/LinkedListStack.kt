package com.libalgokt.stacks.linkedliststack

import com.libalgokt.common.interfaces.Bag
import com.libalgokt.common.interfaces.Stack
import java.util.function.Consumer

class LinkedListStack<E> : Stack<E>, Bag<E> {
    private var size = 0
    private var first: LinkedListStackNode<E>? = null

    private class LinkedListStackNode<Item>(val item: Item?) {
        var next: LinkedListStackNode<Item>? = null
    }

    override fun pop(): E? {
        if (first == null) {
            return null
        }
        val item = first!!.item
        first = first!!.next
        --size
        return item
    }

    override fun push(item: E) {
        val oldFirst = first
        first = LinkedListStackNode(item)
        first!!.next = oldFirst
        ++size
    }

    override fun peek(): E? {
        return if (first == null) null else first!!.item
    }

    override fun clear() {
        first = null
        size = 0
    }

    override fun isEmpty(): Boolean = first == null

    override fun getSize(): Int = size

    override fun add(item: E) = push(item)

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
            private var current: LinkedListStackNode<E>? = null
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
                current = LinkedListStackNode(null)
                current!!.next = first
            }
        }
    }
}