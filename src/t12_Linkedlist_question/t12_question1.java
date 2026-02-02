package t12_Linkedlist_question;

class t12_LinkedList {
    public Node getHead() {
        return head;
    }

    private Node head;
    private Node tail;
    private int size;
    public void insertRec(int data,int pos){
        head = insertRec(data,pos,head);
    }
    private Node insertRec(int data,int pos,Node node){
        if(pos==1 ){
            Node temp = new Node(data,node);
            size++;
            return temp;
        }
        node.next = insertRec(data,pos-1,node.next); //can not use pos-- as it gives same value each of the time cause infinite loop
        return node;
    }

    public void deletionAtPosition(int position){
        Node temp=head,prev = null;
        int count =1;
        if(temp==null){
            System.out.println("underflow");
            return;
        }if(position==1){
            deletionAtFirst();
            return;
        }
        while(temp != null && count != position){
            prev = temp;
            temp =temp.next;
            count++;
        }
        if(temp!=null){
            prev.next = temp.next;
            temp.next=null;
            if(prev.next==null) tail =prev;
        }else{
            System.out.println("invalid postion");
        }
    }

    public void deletionAtLast(){
        if(head == null){
            System.out.println("underflow") ;
            return ;
        }if(head==tail){
            head =null;
            tail = null;
        }else {
            Node temp = head, prev = null;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }


    public void deletionAtFirst(){
        if(head == null){
            System.out.println("underflow") ;
            return ;
        }
        head = head.next;
        if(head==null) tail = null;
    }
    public void insertionAtPosition(int value,int position){
        Node node = new Node(value);
        Node temp = head,prev = null;
        int count = 1;
        if(head==null || position==1){
            insertionAtFirst(value);
        }
        else{
            while(temp != null && count != position){
                prev = temp;
                temp = temp.next;
                count++;
            }
            if(count==position){
                prev.next = node;
                node.next  = temp;
                if(temp==null){
                    tail = node;
                }
            }else{
                System.out.println("invalid position");
            }
        }
    }
    public void insertionAtLast(int value){
        Node node = new Node(value);
        if(tail == null){
            insertionAtFirst(value);
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }
    public void insertionAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail==null) tail = node;
        size+=1;
    }

    public void t12_LinkedList() {
        this.size = 0;
    }

    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
}
public class t12_question1 {
    public static void main(String[] args) {
        t12_LinkedList list = new t12_LinkedList();
        for (int i = 0; i < 4; i++) {
            list.insertionAtPosition(i+1,i+1);
        }
        list.display(list.getHead());
        list.insertRec(7,3);
        list.display(list.getHead());
    }
}

