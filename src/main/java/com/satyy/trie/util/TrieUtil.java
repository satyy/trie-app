package com.satyy.trie.util;

import com.satyy.trie.datastructure.Trie;

import javax.annotation.PostConstruct;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Component
public class TrieUtil {

    @Getter private Trie trie;

    public TrieUtil() {
    }

    @PostConstruct
    private void init() {
        trie = new Trie();
    }

}
