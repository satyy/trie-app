package com.satyy.trie.datastructure;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
class TrieNode {

    @Getter private final Map<Character, TrieNode> children;

    @Getter @Setter private boolean isWord;

    TrieNode() {
        children = new HashMap<>();
    }
}
