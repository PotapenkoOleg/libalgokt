package com.libalgokt.common.interfaces

interface SymbolTable<E> {
    fun add(key: String, value: E)
    fun remove(key: String): E?
    fun get(key: String): E?
    fun contains(key: String): Boolean
    fun clear()
    fun getKeysWithPrefix(prefix: String): Iterable<String>?
    fun longestPrefixOf(prefix: String): String?
    val isEmpty: Boolean
    val size: Int
    val allKeys: Iterable<String>?
}