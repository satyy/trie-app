package com.satyy.trie.datastructure;

import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public interface TrieOperation {
    void insert(String word);
    void delete(String word);
    boolean contains(String word);
    boolean isEmpty();
    List<String> getSuggestions(String prefix);
    List<String> getAllElements();
}
