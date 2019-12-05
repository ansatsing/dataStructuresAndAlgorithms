package cn.antsing.linearlist.linkedlist.singly;

import java.util.List;

/**
 * 单向链表
 */
public class SinglyLinkedList<T> {
    private Node head;
    private Node tail;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    //    private class Node<T>{
//        private final T value;
//        private Node next;
//
//        public Node(T value, Node next) {
//            this.value = value;
//            this.next = next;
//        }
//
//        public Node(T value) {
//            this.value = value;
//        }
//
//        public T getValue() {
//            return value;
//        }
//
//        public Node getNext() {
//            return next;
//        }
//
//        public void setNext(Node next) {
//            this.next = next;
//        }
//    }

    public static <T> SinglyLinkedList<T> createSinglyLinkedList(List<T> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(doCreateSinglyLinkedList(data));

        return singlyLinkedList;
    }

    /**
     * this method expresses mathematics induction very well
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Node<T> doCreateSinglyLinkedList(List<T> data) {
        //specific flow
        if (data == null || data.isEmpty()) {
            return null;
        }

        //normal flow
        Node head = new Node(data.get(0));
        Node next = doCreateSinglyLinkedList(data.subList(1, data.size()));
        head.setNext(next);
        return head;
    }

    public void print() {
        Node currentNode = head;
        do {
            System.out.print(currentNode.getValue() + "\t");
        } while ((currentNode = currentNode.getNext()) != null);
        System.out.println();
    }

    public  static <T> SinglyLinkedList<T> reverseSinglyLinkedList(SinglyLinkedList<T> singlyLinkedList){
//        SinglyLinkedList SinglyLinkedList = new SinglyLinkedList(doReverse(singlyLinkedList.head));
//        return SinglyLinkedList;
        singlyLinkedList.setHead(doReverse(singlyLinkedList.head));
        return singlyLinkedList;
    }

    /**
     * inversion process
     *      1   >   2   >   3   >   4   >   5   > null
     *      1   >[2   >   3   >   4   >   5   >    null]
     *      1   >[5   >   4   >   3   >    2  >   null]
     *      [5   >   4   >   3   >    2  >   1   >   null]
     * @param node
     * @param <T>
     * @return
     */
    private static <T> Node<T> doReverse(Node<T> node){
        if(node == null){
            return null;
        }
        if(node.getNext() == null){
            return node;
        }
        Node head = doReverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return head;
    }
    public  static <T> SinglyLinkedList<T> reverseSinglyLinkedListByLoop(SinglyLinkedList<T> singlyLinkedList){
//        SinglyLinkedList SinglyLinkedList = new SinglyLinkedList(doReverseByLoop(singlyLinkedList.head));
//        return SinglyLinkedList;
        singlyLinkedList.setHead(doReverse(singlyLinkedList.head));
        return singlyLinkedList;

    }
    private static <T> Node<T> doReverseByLoop(Node<T> node){
        if(node == null){
            return null;
        }
        Node result =new Node(node.getValue());
        while (node.getNext()!=null){
            Node temp = new Node(node.getNext().getValue());
            temp.setNext(result);
            result = temp;
            node = node.getNext();
        }
        return result;
    }
}
