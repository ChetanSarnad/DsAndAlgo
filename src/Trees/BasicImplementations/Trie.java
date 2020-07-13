package Trees.BasicImplementations;

import java.util.HashMap;
import java.util.Map;

/*

Class to represent and explain Trie(ReTRIEval) data structure

Trie data structure is used for use cases like
1. Check if word begins with a certain prefix
2. Check if a particular word exit

Each Trie Node will have two things
1. Map which holds all the child characters. Key contains character, value the reference to that trie node
2. A flag called isEndOfWord. This helps in determining if it is end of word.


Time complexity:

For creation of trie : O(w * l)
w -> number of words inserted
l -> average length of words

Search : O(l)
l -> length of the word to be searched.

 */
public class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    /*
    Inserting a new word in Trie
    Split into characters and loop for length.
    Check if root contains the first character in its map of children, else add it.
    Then continue down the line among children and check if character, available or we need to add.
    Add one else character to mark end of word as true.
     */
    public void insert(String word) {

        // Start with root as current node
        TrieNode current = root;

        // Iterate over the length of word
        for (int i = 0; i < word.length(); i++) {

            Character ch = word.charAt(i);

            TrieNode node = current.childNodes.get(ch);

            // If node with character does not exist, create and put it in child nodes
            if (node == null) {
                node = new TrieNode();
                current.childNodes.put(ch, node);
            }
            // Set current to this node
            current = node;
        }

        // Set endOfWord after the last character node
        current.isEndOfWord = true;
    }


    /*
    Search for the given word in the trie
    If isPrefix is false, then it has to be a complete word, i.e. last trieNode should have isEndOfWord flag as true
     */
    public boolean search(String word, boolean isPrefix) {

        // Start the search from root
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            Character ch = word.charAt(i);

            TrieNode node = current.childNodes.get(ch);

            // If no node found for character in worder, return as false
            if (node == null) {
                return false;
            }

            // set the node as current node and continue search
            current = node;
        }

        // If not just prefix and we are looking for whole word search then last node should have isEndOfWord flag as true
        if (!isPrefix) {
            if (current.isEndOfWord) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        // Insert cat
        System.out.println("Insert cat");
        trie.insert("cat");

        // Insert can
        System.out.println("Insert can");
        trie.insert("can");

        // Insert win
        System.out.println("Insert win");
        trie.insert("win");

        // Insert wine
        System.out.println("Insert wine");
        trie.insert("wine");

        System.out.println("Search for ca full word : ");
        System.out.println(trie.search("ca", false));

        System.out.println("Search for ca as prefix : ");
        System.out.println(trie.search("ca", true));

        System.out.println("Search for win full word : ");
        System.out.println(trie.search("win", false));

        System.out.println("Search for wine full word : ");
        System.out.println(trie.search("wine", true));


    }

}

/*
TrieNode having childNodes and flag to indicate end of word
 */
class TrieNode {

    Map<Character, TrieNode> childNodes;

    Boolean isEndOfWord;

    TrieNode() {
        childNodes = new HashMap<>();
        isEndOfWord = false;
    }
}
