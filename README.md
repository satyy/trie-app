# Trie Datastructure

- Implemention of Trie datastructure in Java.
- Use of implemented Trie to create an application to store strings and get suggestion list for any prefix string.
- Swagger-ui for the API's.

## About Trie
Trie is a tree-like data structure whose nodes store the letters of an alphabet. It is a very powerful and efficient datastructure when comes to getting suggestions for a prefix string, out of a set of words. The word Trie comes from the word re`Trie`val, which basically the main purpose of this datastructure i.e, retrieving suggestions. Because of its efficiency and fast retreival, Trie has been used in many search box widget on search engines where auto-suggetion is needed for the user input text.
Every node of Trie consists of multiple branches. Each branch represents a possible character of keys and word can be retreived by traversing down the branch path of the tree.

## Performance
Trie is very efficient as compared to other data structres when it comes to retrieving strings which starts with a given prefix.
Time complexity for 
```
  Search: O(k)   
  Insert/Delete: O(k)
  Suggestion for prefix key: O(p)   
        
      where, p is size of prefix.
             k is size of search key.
 ````
                

## Build and Run

## Verify Trie

## Implementation Class File
