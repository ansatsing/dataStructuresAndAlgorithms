package cn.antsing.linkedlist.singly;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList.createSinglyLinkedList(Arrays.asList(1)).print();
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.createSinglyLinkedList(Arrays.asList(1,2,3,4,5));
        singlyLinkedList.print();
        SinglyLinkedList.reverseSinglyLinkedList(singlyLinkedList).print();
    }
}
