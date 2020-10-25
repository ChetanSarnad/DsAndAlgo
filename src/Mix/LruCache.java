package Mix;

import java.util.HashMap;

/*

1.The key to solve this problem is using a double linked list which enables us to quickly move nodes.

2.The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1).
The list of double linked nodes make the nodes adding/removal operations O(1).

With the above two points mentioned, let me further clarify how to use a linked list and hash map to solve this.

Okay, so what is a LRU cache?
LRU is least recently used cache right, so only the elements are used recently will be made available in the cache.

Suppose the size of cache is 3, it is holding following element

Cache : 1 -> 2 -> 3

Now if I have to insert 4, I have to remove an element right, so we will remove the element which is not used

We can assume that the head always points to most recently used.
Like head -> 1 -> 2 -> 3 -> tail (though I am using single direction arrow, we will be using dual i.e. like a doubly linked)
Which mean the element at the tail is most unused, so we remove it.

i.e remove the tail.previous node, also add 4 at the head, since it is most recently added
head -> 4 -> 1 -> 2 -> tail

Suppose we need to access 1, now 1 becomes most recently used, we have to add it to the head.
So we first remove it from the list and then add at head.
head -> 1 -> 4 -> 2 -> tail

Every time we access or add the same element, it become LRU and we move that element to head.

What is Hash map doing here then?

The LRU cache, needs a constant time get and put right. The hash map is data structure which provides that
Linked list was required, because here we also needed an order of elements right, most used at head and least at tail etc.

The hash map contains the key, which the actual key provided to it. The value will be a linked list node.
The value provided will be wrapped in a linked list node and set as the hash map value for that key.

Every time we do an get on hash map, it certainly gives back the node required, but also removes it from linked list
and adds it back to the head again, to mark it as most recently used.

And when ever we add an element, if it already exists, then just remove and add at head again. To mark as recently used.
If new element, then add at the head. But if the cache is full, remove element at tail and make space, and then add it.

Refer code below for all these operations.

 */

class Node {

    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LruCache {

    HashMap<Integer, Node> map;
    int capicity, count;
    Node head, tail;

    public LruCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}