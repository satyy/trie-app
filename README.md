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
1. Checkout repo.
2. run cmd `sh run-app.sh`


## Verify Trie
The application exposed few the api's to add, remove words, get suggestions etc.
1. You can use the `swagger-ui` to make call to the api's or make `curl` request to the api's exposed.
2. To access Swagger-ui, once the application is up and running, go to browser and make a request to below url
```
            http://127.0.0.1:8081/swagger-ui.html
- if running on the same system or else, change the ip addess in the url.
``` 
   This opens the swagger-ui page on the web browser from which you would be able to access all the exposed api's and make call to it. 

### Endpoints exposed
1. `GET`    /trie/empty                         - check if the trie is empty. 
2. `GET`    /trie/contain/{word}                - check if the `word` is present in trie.
3. `GET`    /trie/all                           - get all the words in the trie.
4. `GET`    /trie/suggestion/{prefix}           - get suggestion list for words starting with given `prefix` in trie.
5. `PUT`    /trie/insert/{word}                 - insert the `word` in the trie.
6. `PUT`    /trie/insert/list                   - insert a list of words in trie at once. Expects a list of string in request body.
7. `DELETE` /trie/delete/{word}                 - remove `word` from trie. 

## Implementation Class File
