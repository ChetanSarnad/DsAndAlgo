package Hashing.BasicImplementations;

import java.util.LinkedList;
import java.util.List;

/*
Class to demonstrate the working of a hashmap

So the question is how to fit big list of data, uniquely into a limited set of slots.
The technique is hashing, we calculate the hash of the element, then find the right slot/address to fit it into.
If two elements get the same hash, it is called as collision.
Collision can be resolved using multiple techniques like probing or chaining.
Here we will look at chaining, that is, each slot in HashMap holds a list.
All elements with same hash will be added to the list in this slot of hashmap
 */
public class Hashmap {

    // size of hashmap
    int size = 3;

    // This the array backing the hashmap
    // It is an array of list, i.e. at each position of array, there is a list to hold the elements
    // The size is 3, smaller, to demonstrate the collision cases as well.
    List<DummyClassItems>[] backingArray = new LinkedList[size];

    /*
    Method to add an item to hashmap
     */
    public void put(DummyClassItems dummyClassItem) {

        // Firstly calculate the hashcode of the item
        int hashcode = getHashcode(dummyClassItem);

        // Then find the slot it has to fit into
        // Modulus operator helps here, to get the right slot as remainder, when we divide by size
        int slot = hashcode % size;

        // Get the list at the slot and add it
        List<DummyClassItems> listAtSlot = backingArray[slot];

        // If null, then create a list and add it
        if (listAtSlot == null) {
            listAtSlot = new LinkedList<>();
            backingArray[slot] = listAtSlot;
        }

        // Add it to the list at that slot
        listAtSlot.add(dummyClassItem);

    }

    public DummyClassItems get(DummyClassItems dummyClassItem) {

        // Firstly calculate the hashcode of the item
        int hashcode = getHashcode(dummyClassItem);

        // Get the slot
        int slot = hashcode % size;

        // Get the list at that slot
        List<DummyClassItems> list = backingArray[slot];

        // Loot through the slot and find the element using equals method
        for (int i = 0; i < list.size(); i++) {
            DummyClassItems dummyClassItemFromMap = list.get(i);
            if (equals(dummyClassItem, dummyClassItemFromMap)) {
                // return if matches with the asked key
                return dummyClassItemFromMap;
            }
        }
        // Else return null
        return null;
    }

    /*
    Method to generate hashcode
     */
    private int getHashcode(DummyClassItems dummyClassItem) {

        // Just a simple hashcode, real hashcodes are much more sophisticated
        return dummyClassItem.data1 + dummyClassItem.data2;
    }

    /*
    Method to generate equals value
     */
    private boolean equals(DummyClassItems dummyClassItem1, DummyClassItems dummyClassItem2) {
        if ((dummyClassItem1.data1 == dummyClassItem2.data1) && (dummyClassItem1.data2 == dummyClassItem2.data2)) {
            return true;
        }
        return false;
    }

    /*
    Print the map
     */
    public void printMap() {

        for (int i = 0; i < size; i++) {
            System.out.println("Slot " + i);
            List<DummyClassItems> dummyClassItemsList = backingArray[i];
            if (dummyClassItemsList != null) {
                for (int j = 0; j < dummyClassItemsList.size(); j++) {
                    System.out.println("Item " + j);
                    System.out.println(dummyClassItemsList.get(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Hashmap hashmap = new Hashmap();

        DummyClassItems dummyClassItem1 = new DummyClassItems(3, 7);
        DummyClassItems dummyClassItem2 = new DummyClassItems(7, 3);
        DummyClassItems dummyClassItem3 = new DummyClassItems(1, 2);
        DummyClassItems dummyClassItem4 = new DummyClassItems(2, 1);
        DummyClassItems dummyClassItem5 = new DummyClassItems(6, 8);
        DummyClassItems dummyClassItem6 = new DummyClassItems(8, 6);
        DummyClassItems dummyClassItem7 = new DummyClassItems(4, 6);

        hashmap.put(dummyClassItem1);
        hashmap.put(dummyClassItem2);
        hashmap.put(dummyClassItem3);
        hashmap.put(dummyClassItem4);
        hashmap.put(dummyClassItem5);
        hashmap.put(dummyClassItem6);
        hashmap.put(dummyClassItem7);

        hashmap.printMap();

        System.out.println("Try to fetch an item present");
        DummyClassItems receivedDC = hashmap.get(dummyClassItem1);
        System.out.println("Fetch : " + dummyClassItem1);
        System.out.println("Received : " + receivedDC);

        System.out.println();

        System.out.println("Try to fetch an item NOT present");
        DummyClassItems dummyClassItem8 = new DummyClassItems(10, 10);
        receivedDC = hashmap.get(dummyClassItem8);
        System.out.println("Fetch : " + dummyClassItem8);
        System.out.println("Received : " + receivedDC);

    }

}

class DummyClassItems {

    int data1;

    int data2;

    public DummyClassItems(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return "DummyClassItems{" +
                "data1=" + data1 +
                ", data2=" + data2 +
                '}';
    }
}