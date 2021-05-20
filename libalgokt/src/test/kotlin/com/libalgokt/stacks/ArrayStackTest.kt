package com.libalgokt.stacks

import com.libalgokt.common.interfaces.Stack
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
    fun push() {
        val actual = 42
        stack?.push(actual);

        val expected = stack?.pop();
        assertEquals(expected, actual);
    }

    @Test
    fun pop() {
        //fail("Not Implemented")
    }

    @Test
    fun peek() {
        //fail("Not Implemented")
    }

    @Test
    fun clear() {
        //fail("Not Implemented")
    }

    @Test
    fun getSize() {
        //fail("Not Implemented")
    }

    @Test
    fun isEmpty() {
        //fail("Not Implemented")
    }

    @Test
    operator fun iterator() {
        //fail("Not Implemented")
    }

    @Test
    fun add() {
        //fail("Not Implemented")
    }
}