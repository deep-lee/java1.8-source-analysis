package leetcode;


import java.util.HashMap;
import java.util.Map;

class Node {
  int value;
  int key;
  Node prev;
  Node next;

  public Node() {
  }

  public Node(int key, int value) {
    this.value = value;
    this.key = key;
  }

  public Node(int key, int value, Node prev, Node next) {
    this.value = value;
    this.key = key;
    this.prev = prev;
    this.next = next;
  }
}

public class LRUCache {
  int size;
  int capacity;
  Map<Integer, Node> map;
  Node head, tail;

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      moveToHead(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      moveToHead(node);
    } else {
      // new node
      Node node = new Node(key, value);
      addToHead(node);
      map.put(key, node);
      size++;
      if (size > capacity) {
        // remove last node
        removeTail();
      }
    }
  }

  private void removeTail() {
    Node node = tail.prev;
    node.prev.next = tail;
    tail.prev = node.prev;
    node.prev = null;
    node.next = null;
    map.remove(node.key);
  }

  private void addToHead(Node node) {
    head.next.prev = node;
    node.next = head.next;
    node.prev = head;
    head.next = node;
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.next = null;
    node.prev = null;
  }
}
