package com.LL;

class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }

    public int getSize() {
        return size;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
        System.out.println("head = " + head.value);
        System.out.println("tail = " + tail.value);
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        tail=node;
        size++;
        System.out.println("head = " + head.value);
        System.out.println("tail = " + tail.value);
    }

    public void insertLastWithTail(int value) {
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail=node;
        size++;
        System.out.println("head = " + head.value);
        System.out.println("tail = " + tail.value);
    }

    public void insertInRandomIndex(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }else if(index==size){
            insertLastWithTail(value);
            return;
        }
        Node node = new Node(value);
        int ctr = 0;
        Node temp = head;
        while(ctr<index-1){
            temp=temp.next;
            ctr++;
        }node.next=temp.next;
        temp.next=node;
        size++;

    }

    public void insertInRandomIndex2(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }else if(index==size){
            insertLastWithTail(value);
            return;
        } else if (index>size) {
            try{
                System.out.println("Index given exceeded size\ninserted at the end");
                insertInRandomIndex2(value,size);
            }  catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
            return;
        }
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next=node;
        size++;

    }


    public void deleteFirst() {
        Node temp = head.next;
        head.next=null;
        head=temp;
        if(head==null){
            tail=null;
        }size--;
    }
    public int deleteFirst2() {
        Node temp = head.next;
        int val = head.value;
        head.next=null;
        head=temp;
        if(head==null){
            tail=null;
        }size--;
        return val;
    }
    //better much better:
    public int deleteFirst3() {
        int val = head.value;
        head = head.next;
        if(head==null){
            tail=null;
        }size--;
        return val;
    }

    public int deleteLast(){
        int val = tail.value;
        Node temp=head;
        for (int i = 0; i < size-2; i++) {
            temp = temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }

    public int deleteAny(int index){
        if(index==0){
            return deleteFirst3();
        }
        if(index==size-1){
            deleteLast2();
        }
        Node beforeIndex = get(index-1);
        int val = (beforeIndex.next).value;
        beforeIndex.next=beforeIndex.next.next;
        size--;
        return val;
    }

    //del2:
    public Node get(int index) {
        Node node= head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
    public int deleteLast2(){
        if(size<=1){
            deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }

    //find:
    public Node find(int val){
        Node target = head;
        while(target!=null){
            if(target.value==val){
                return target;
            }
            target=target.next;
        }return null;
    }

    public

    void display() {
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " -> ");
//            System.out.print(temp.next + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }

        public Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }
}

