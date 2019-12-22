package com.satyy.trie.facade;

import com.satyy.trie.util.TrieUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Component
public class TrieFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrieFacade.class);

    @Autowired
    private TrieUtil trieUtil;

    public void insertWord(final String word) {
        trieUtil.getTrie().insert(word);
    }

    public void insertWords(final List<String> words) {
        words.forEach(trieUtil.getTrie()::insert);
    }

    public void removeWord(final String word) {
        trieUtil.getTrie().delete(word);
    }

    public boolean contains(final String word) {
        return trieUtil.getTrie().contains(word);
    }

    public boolean isEmpty() {
        return trieUtil.getTrie().isEmpty();
    }

    public List<String> getSuggestions(final String prefix) {
        return trieUtil.getTrie().getSuggestions(prefix);
    }

    public List<String> getAllElements() {
        return trieUtil.getTrie().getAllElements();
    }
}
