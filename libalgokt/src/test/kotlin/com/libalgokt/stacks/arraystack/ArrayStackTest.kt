package com.libalgokt.stacks.arraystack

import com.libalgokt.common.interfaces.Stack
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.fail

internal class ArrayStackTest {

    private var stack: Stack<Int>? = null

    @BeforeEach
    fun setUp() {
        stack = ArrayStack()
    }

    @AfterEach
    fun tearDown() {
        stack = null
    }

    @Test
    fun pop() {
        assertNull(stack?.pop())

        val expected = 42
        stack?.push(expected + 2)
        stack?.push(expected + 1)
        stack?.push(expected)

        var actual = stack?.pop()
        assertEquals(expected, actual)

        actual = stack?.pop()
        assertEquals(expected + 1, actual)

        actual = stack?.pop()
        assertEquals(expected + 2, actual)
    }

    @Test
    fun push() {
        val actual = 42
        stack?.push(actual)

        val expected = stack?.pop()
        assertEquals(expected, actual)
    }

    @Test
    fun peek() {
        assertNull(stack!!.peek())

        val expected = 42
        stack!!.push(expected + 2)
        stack!!.push(expected + 1)
        stack!!.push(expected)

        assertEquals(3, stack!!.getSize())

        var actual = stack!!.peek()!!
        assertEquals(expected, actual)

        assertEquals(3, stack!!.getSize())

        actual = stack!!.pop()!!
        assertEquals(expected, actual)
    }

    @Test
    fun clear() {
        assertTrue(stack?.isEmpty() ?: false)

        val expected = 42
        stack?.push(expected + 2)
        stack?.push(expected + 1)
        stack?.push(expected)

        assertFalse(stack?.isEmpty() ?: false)
        assertEquals(3, stack?.getSize())

        stack?.clear()

        assertTrue(stack?.isEmpty() ?: false)
        assertEquals(0, stack?.getSize())
        assertNull(stack?.pop())
    }

    @Test
    fun isEmpty() {
        var expected = stack?.isEmpty() ?: false
        assertTrue(expected)

        stack?.push(42)
        expected = stack?.isEmpty() ?: false
        assertFalse(expected)
    }

    @Test
    fun getSize() {
        var expected = 0
        var actual = stack?.getSize()
        assertEquals(expected, actual)

        stack?.push(42)
        stack?.push(42)
        stack?.push(42)
        stack?.pop()

        expected = 2
        actual = stack?.getSize()
        assertEquals(expected, actual)
    }

    @Test
    fun toStringTest() {
        val item = 42
        stack?.push(item)
        stack?.push(item + 1)
        stack?.push(item + 2)
        val actual = stack?.toString()
        val expected = "44\n43\n42\n"
        assertEquals(expected, actual)
    }

    @Test
    fun iteratorTest() {
        val expected = 42
        stack?.push(expected)
        stack?.push(expected + 1)
        val iterator = stack?.iterator()

        assertTrue(iterator?.hasNext() ?: false)
        var actual = iterator?.next()
        assertEquals(expected + 1, actual)

        assertTrue(iterator?.hasNext() ?: false)
        actual = iterator?.next()
        assertEquals(expected, actual)

        assertFalse(iterator?.hasNext() ?: false)
    }

    @Test
    fun forEachTest() {
        val stringBuilder = StringBuilder()
        val item = 42
        stack?.push(item)
        stack?.push(item + 1)
        stack?.push(item + 2)
        stack?.forEach(stringBuilder::append)
        val actual = stringBuilder.toString()
        val expected = "444342"
        assertEquals(expected, actual)
    }

    @Test
    fun dynamicSizeIncreaseTest() {
        if (stack !is ArrayStack<Int>) {
            fail("Invalid stack type")
        }
        val currentStack = stack as? ArrayStack<Int>
        var expected = 2
        var actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
        stack?.push(42)
        stack?.push(42)
        stack?.push(42)
        expected = 4
        actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
        stack?.push(44)
        stack?.push(44)
        expected = 8
        actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
    }

    @Test
    fun dynamicSizeDecreaseTest() {
        if (stack !is ArrayStack) {
            fail<Any>("Invalid stack type")
        }
        val currentStack = stack as? ArrayStack<Int>
        var expected = 2
        var actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
        for (i in 0..7) {
            stack?.push(42)
        }
        expected = 8
        actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
        for (i in 0..5) {
            stack?.pop()
        }
        expected = 4
        actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
        stack?.pop()
        stack?.pop()
        expected = 2
        actual = currentStack?.getCapacity()
        assertEquals(expected, actual)
    }
}