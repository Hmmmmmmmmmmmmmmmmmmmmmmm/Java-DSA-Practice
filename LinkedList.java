package com.LL;

public class LinkedList {
    private int size;
    private Node head;
    private Node tail;
    public LinkedList(){
        this.size=0;
    }
    //insertFirst
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast1(int val){
        if(tail==null){
            insertFirst(val);
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insertLast(int val){
        if(head==null){
            insertFirst(val);
            return;
        }
        Node temp = head;
        while (temp!=null){
            if(temp.next==null){
                Node node = new Node(val);
                temp.next=node;
                tail=node;
                size++;
                return;
            }
            temp=temp.next;
        }
    }

    //display
    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public void insertAnywhere(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Invalid Index");
            return;
        }
        Node node = new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public void deleteFirst(){
        int val = head.val;

        head=head.next;

        if(head==null){
            tail=null;
        }size--;
        System.out.println(val);
    }


    public void deleteLast(){
        if(head==null){
            return;
        }
        if(head.next==null){
            deleteFirst();
            return;
        }
        int val;
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        val=temp.next.val;
        tail=temp;
        temp.next=null;
        System.out.println(val);
    }



    public class Node{
        int val;
        Node next;
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
        public Node(int val){
            this.val=val;
        }
    }
}
