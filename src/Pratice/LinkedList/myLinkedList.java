package Pratice.LinkedList;

class MyLinkedList {
    MyLinkedList myLinkedList;
    Node head;
    private static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
    public MyLinkedList() {
        head=null;
    }

    public int get(int index) {
        if(head==null || index<0){
            return -1;
        }
        int count = 0;
        Node temp = head;
        while(temp!=null){
            if(index==count){
                return temp.val;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head  = node;
    }

    public void addAtTail(int val) {
        if(head==null){
            head=new Node(val);
            return;
        }
        Node temp = head;
        Node newNode = new Node(val);
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if(index<0){
            return ;
        }
        if(head == null && index > 0)
            return;
        if(index==0){
            addAtHead(val);
            return;
        }
        int count = 0;
        Node temp = head;
        while(temp.next!=null && index!=count+1 ){
            count++;
            temp = temp.next;
        }
        if(index==count+1){
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if(index<0|| head==null){
            return ;
        }
        if(index==0){
            head = head.next;
            return;
        }
        int count = 0;
        Node temp = head;
        while(temp.next!=null && index!=count+1 ){
            count++;
            temp = temp.next;
        }
        if(temp.next!=null){
            Node node = temp.next;
            temp.next = node.next;
            node.next = null;
        }
    }
}
