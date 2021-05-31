package com.libalgokt.tries.ternarytrie

import com.libalgokt.common.interfaces.SymbolTable

class TernaryTrie<E> : SymbolTable<E> {
    private var size = 0
    private var root: TernaryTrieNode<E>? = null

    private class TernaryTrieNode<Item>(val character: Char) {
        var value: Item? = null
        var left: TernaryTrieNode<Item>? = null
        var middle: TernaryTrieNode<Item>? = null
        var right: TernaryTrieNode<Item>? = null
    }

    override fun add(key: String, value: E) {
        TODO("Not yet implemented")
    }

    override fun get(key: String): E? {
        TODO("Not yet implemented")
    }

    override fun remove(key: String): E? {
        TODO("Not yet implemented")
    }

    override fun contains(key: String): Boolean {
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

    override fun getAllKeys(): Iterable<String>? {
        TODO("Not yet implemented")
    }

    override fun getKeysWithPrefix(prefix: String): Iterable<String>? {
        TODO("Not yet implemented")
    }

    override fun longestPrefixOf(prefix: String): String? {
        TODO("Not yet implemented")
    }
}
