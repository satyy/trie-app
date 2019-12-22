package com.satyy.trie.controller;

import com.satyy.trie.facade.TrieFacade;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Api
@RestController
@RequestMapping("/trie")
public class TrieController {

    @Autowired
    private TrieFacade facade;

    @PutMapping("/insert/{word}")
    public ResponseEntity insertWord(@PathVariable("word") final String word) {
        facade.insertWord(word);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/insert/list")
    public ResponseEntity insertWords(@RequestBody final List<String> words) {
        facade.insertWords(words);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{word}")
    public ResponseEntity removeWord(@PathVariable("word") final String word) {
        facade.removeWord(word);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/contain/{word}")
    public boolean contains(@PathVariable("word") final String word) {
        return facade.contains(word);
    }

    @GetMapping("/empty")
    public boolean isEmpty() {
        return facade.isEmpty();
    }

    @GetMapping("/suggestion/{prefix}")
    public List<String> getSuggestions(@PathVariable("prefix") final String prefix) {
        return facade.getSuggestions(prefix);
    }

    @GetMapping("/all")
    public List<String> getAllElements() {
        return facade.getAllElements();
    }

}
