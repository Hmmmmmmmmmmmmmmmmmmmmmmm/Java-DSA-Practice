package com.LL;

//import jdk.incubator.vector.VectorOperators;

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        size=0;
    }
    public int getSize(){
        return size;
    }

    public void insert(int value){
        Node node = new Node(value);
        if(head==null){
            head=node;
            tail=node;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size++;
    }

    Node get(int value){
        Node node=head;
        do{
            if(node.value==value){
                return node;
            }
            node=node.next;
        }while(node!=head);
        return null;
    }
    Node getOneBefore(int value){
        Node node=head;
//        Node prev=node;
        do{
            if(node.next.value==value){
//                return prev;
                return node;
            }
//            prev = node;
            node=node.next;

        }while(node!=head);
        return null;
    }
    public Integer delete(int value){
        if(head==null){
            return null;
        }
        if(head.value==value){
            head=head.next;
            tail.next=head;
        }
        Node beforeTarget = getOneBefore(value);
        int val = beforeTarget.next.value;
        beforeTarget.next=beforeTarget.next.next;
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        do{
            System.out.print(temp.value + "->");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next){
            this.value=value;
            this.next= next;
        }
    }
}
