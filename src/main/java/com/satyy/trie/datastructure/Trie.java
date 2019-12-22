package com.satyy.trie.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public class Trie implements TrieOperation {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Insert word in the trie.
     * @param word word to be inserted.
     */
    @Override
    public void insert(final String word) {
        TrieNode currentNode = root;

        for ( char c : word.toCharArray()) {
            currentNode = currentNode.getChildren().computeIfAbsent(c, character -> new TrieNode());
        }
        currentNode.setWord(true);
    }

    /**
     * Remove word from the trie
     * @param word word to remove.
     */
    @Override
    public void delete(final String word) {
        delete(root, word, 0);
    }

    private boolean delete(final TrieNode current, final String word, int index) {
        if (index == word.length()) {
            if (!current.isWord()) {
                return false;
            }
            current.setWord(false);
            return current.getChildren().isEmpty();
        }

        final char ch = word.charAt(index);
        final TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }

        final boolean deleteCurrentNode = delete(node, word, index + 1) && !node.isWord();
        if (deleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    /**
     * Verify if the word is present in trie.
     * @param word the word to check its presence in trie
     * @return true if present or else, false
     */
    @Override
    public boolean contains(final String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            final TrieNode charNode = currentNode.getChildren().get(ch);
            if (charNode == null) {
                return false;
            }
            currentNode = charNode;
        }
        return currentNode.isWord();
    }

    /**
     * Verify if the trie is empty.
     * @return true if trie is empty or else, false
     */
    @Override
    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }

    /**
     * Get suggestion list of words starting with the given prefix in the trie.
     * @param prefix prefix to check words starting with this prefix
     * @return list of string with all the suggestions
     */
    @Override
    public List<String> getSuggestions(final String prefix) {
        final List<String> result = new ArrayList<>();
        if (root == null) {
            throw new IllegalStateException("Trie is empty");
        }
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode charNode = currentNode.getChildren().get(ch);
            if (charNode == null) {
                return result;
            }
            currentNode = charNode;
        }
        //at this point currentNode points to the end of the typed word
        //get all the child word from this point and concat with word
        initSuggestionList(result, prefix, currentNode);
        return result;
    }

    @Override
    public List<String> getAllElements() {
        return getSuggestions("");
    }

    private void initSuggestionList(final List<String> suggestionList, final String currentString,
                                    final TrieNode currentNode) {
        if (currentNode.isWord()) {
            suggestionList.add(currentString);
        }
        for (Map.Entry<Character, TrieNode> entry : currentNode.getChildren().entrySet()) {
            initSuggestionList(suggestionList, currentString.concat(entry.getKey().toString()), entry.getValue());
        }
    }

}
