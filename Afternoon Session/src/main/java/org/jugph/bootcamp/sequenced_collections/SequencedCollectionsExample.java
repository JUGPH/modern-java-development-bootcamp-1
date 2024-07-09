package org.jugph.bootcamp.sequenced_collections;

import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.SequencedMap;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class SequencedCollectionsExample {
    public static void main(String[] args) {
        System.out.println("SequencedCollection");
        seqColl();

        System.out.println("\nSequencedSet");
        seqSet();

        System.out.println("\nSequencedMap");
        seqMap();
    }

    static void seqColl() {
        SequencedCollection<Post> seqColl = new ArrayList<>();

        seqColl.addFirst(new Post(1, "First Post")); // First Post
        seqColl.addFirst(new Post(2, "Second Post")); // Second Post, First Post
        seqColl.addLast(new Post(3, "Third Post")); // Second Post, First Post, Third Post
        seqColl.addLast(new Post(4, "Fourth Post")); // Second Post, First Post, Third Post, Fourth Post
        seqColl.addLast(new Post(5, "Fifth Post")); // Second Post, First Post, Third Post, Fourth Post, Fifth Post
        System.out.println(seqColl); // [Second Post, First Post, Third Post, Fourth Post, Fifth Post]
        System.out.println("getFirst() : " + seqColl.getFirst()); // Second Post
        System.out.println("getLast() : " + seqColl.getLast()); // Fifth Post
        System.out.println("removeFirst() : " + seqColl.removeFirst()); // Second Post - [First Post, Third Post, Fourth Post, Fifth Post]
        System.out.println("removeLast() : " + seqColl.removeLast()); // Fifth Post - [First Post, Third Post, Fourth Post]
        System.out.println(seqColl); // [First Post, Third Post, Fourth Post]

        System.out.println("Forwards..."); // Iterate forwards
        for (Post post : seqColl) {
            System.out.println(post); // First Post, Third Post, Fourth Post
        }
        System.out.println("Backwards..."); // Iterate backwards
        for (Post post : seqColl.reversed()) {
            System.out.println(post); // Fourth Post, Third Post, First Post
        }
    }

    static void seqSet() {
        SequencedSet<Post> seqSet = new LinkedHashSet<>();

        seqSet.addFirst(new Post(1, "First Post")); // First Post
        seqSet.addFirst(new Post(2, "Second Post")); // Second Post, First Post
        seqSet.addLast(new Post(3, "Third Post")); // Second Post, First Post, Third Post
        seqSet.addLast(new Post(4, "Fourth Post")); // Second Post, First Post, Third Post, Fourth Post
        seqSet.addLast(new Post(4, "Fourth Post")); // Second Post, First Post, Third Post, Fourth Post
        System.out.println(seqSet); // [Second Post, First Post, Third Post, Fourth Post]
        System.out.println("getFirst() : " + seqSet.getFirst()); // Second Post
        System.out.println("getLast() : " + seqSet.getLast()); // Fourth Post
        System.out.println("removeFirst() : " + seqSet.removeFirst()); // Second Post - [First Post, Third Post, Fourth Post]
        System.out.println("removeLast() : " + seqSet.removeLast()); // Fourth Post - [First Post, Third Post]
        System.out.println(seqSet); // [First Post, Third Post]

        System.out.println("Forwards..."); // Iterate forwards
        for (Post post : seqSet) {
            System.out.println(post); // First Post, Third Post
        }
        System.out.println("Backwards..."); // Iterate backwards
        for (Post post : seqSet.reversed()) {
            System.out.println(post); // Third Post, First Post
        }
    }

    static void seqMap() {
        SequencedMap<Integer, Post> seqMap = new LinkedHashMap<>();

        seqMap.putFirst(1, new Post(1, "First Post")); // 1=First Post
        seqMap.putFirst(2, new Post(2, "Second Post")); // 2=Second Post, 1=First Post
        seqMap.putLast(3, new Post(3, "Third Post")); // 2=Second Post, 1=First Post, 3=Third Post
        seqMap.putLast(4, new Post(4, "Fourth Post")); // 2=Second Post, 1=First Post, 3=Third Post, 4=Fourth Post
        System.out.println(seqMap); // {2=Second Post, 1=First Post, 3=Third Post, 4=Fourth Post}
        System.out.println("firstEntry() : " + seqMap.firstEntry()); // 2=Second Post
        System.out.println("lastEntry() : " + seqMap.lastEntry()); // 4=Fourth Post
        System.out.println("pollFirstEntry() : " + seqMap.pollFirstEntry()); // 2=Second Post - {1=First Post, 3=Third Post, 4=Fourth Post}
        System.out.println("pollLastEntry() :" + seqMap.pollLastEntry()); // 4=Fourth Post - {1=First Post, 3=Third Post}
        System.out.println(seqMap); // {1=First Post, 3=Third Post}

        System.out.println("Forwards..."); // Iterate forwards
        for (Map.Entry<Integer, Post> entry : seqMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()); // 1=First Post, 3=Third Post
        }
        System.out.println("Backwards..."); // Iterate backwards
        for (Map.Entry<Integer, Post> entry : seqMap.reversed().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue()); // 3=Third Post, 1=First Post
        }
    }
}

record Post(int postId, String content) {}
