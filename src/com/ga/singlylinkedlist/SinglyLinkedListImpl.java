package com.ga.singlylinkedlist;

public class SinglyLinkedListImpl<T> {
    
    private Node<T> head;
    private Node<T> tail;

    public void add(T element) {

        // Append an element into the SinglyLinkedList
        Node<T> node = new Node<T>();
        node.setValue(element);
        System.out.println("Adding: " + element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextRef(node);
            tail = node;
        }
    }

    public void deleteAfter(T after) {

        // Remove all element in the SinglyLinkedList that is great than a target value
        Node<T> tmp = head;
        Node<T> refNode = null;
        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.compareTo(after) == 0) {
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if (refNode != null) {

            while (true) {

                tmp = refNode.getNextRef();

                if (tmp != null) {
                    refNode.setNextRef(tmp.getNextRef());

                    if (refNode.getNextRef() == null) {
                        tail = refNode;
                    }
                    System.out.println("Deleted: " + tmp.getValue());
                } else {
                    System.out.println("Deleted All Alements after :" + refNode.getValue());
                    break;
                }
            }
        }
    }

    public void removeLast() {

        // Remove the tail element from a SinglyLinkedList
        Node<T> tmp = head;
        Node<T> previoushead = null;
        if (tail == null && head == null) {
            System.out.println("No element found");
        } else {

            while (true) {

                if (tmp == tail) {
                    tail = previoushead;
                    System.out.println("Deleted: " + tmp.getValue());
                    break;
                }
                previoushead = tmp;
                tmp = tmp.getNextRef();
            }
        }
    }

    public void traverse() {

        int node = 1;
        Node<T> tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.println("Node" + node + ":- " + tmp.getValue());
            tmp = tmp.getNextRef();
            node++;
        }
    }

    public static void main(String a[]) {

        // Node Operations
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.removeLast();
        sl.add(6);
        sl.add(7);
        sl.deleteAfter(4);
        sl.add(10);
        sl.add(11);
        sl.traverse();
    }
    
    class Node<T> implements Comparable<T> {
        
        private T value;
        private Node<T> nextRef;
         
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getNextRef() {
            return nextRef;
        }
        public void setNextRef(Node<T> ref) {
            this.nextRef = ref;
        }
        @Override
        public int compareTo(T arg) {
            if(arg == this.value){
                return 0;
            } else {
                return 1;
            }
        }
    }
}
