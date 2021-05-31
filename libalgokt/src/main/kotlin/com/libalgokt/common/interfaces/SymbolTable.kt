package com.libalgokt.common.interfaces

interface SymbolTable<E> : CollectionBase {
    fun add(key: String, value: E)
    fun remove(key: String): E?
    fun get(key: String): E?
    fun contains(key: String): Boolean
    fun getKeysWithPrefix(prefix: String): Iterable<String>?
    fun longestPrefixOf(prefix: String): String?
    fun getAllKeys(): Iterable<String>?
}