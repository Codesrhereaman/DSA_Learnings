//class t11_doubly_LinkedList {
//    public Node getHead() {
//        return head;
//    }
//
//    private Node head;
//    private Node tail;
//    private int size;
//
//    public void deletionAtPosition(int position){
//        Node temp=head,prev = null;
//        int count =1;
//        if(temp==null){
//            System.out.println("underflow");
//            return;
//        }if(position==1){
//            deletionAtFirst();
//            return;
//        }
//        while(temp != null && count != position){
//            prev = temp;
//            temp =temp.next;
//            count++;
//        }
//        if(temp!=null){
//            prev.next = temp.next;
//            temp.next=null;
//            if(prev.next==null) tail = prev;
//        }else{
//            System.out.println("invalid postion");
//        }
//    }
//
//    public void deletionAtLast(){
//        if(head == null){
//            System.out.println("underflow") ;
//            return ;
//        }if(head==tail){
//            head =null;
//            tail = null;
//        }
//        Node temp = head,prev=null;
//        while(temp.next != tail){
//            temp = temp.next;
//        }
//        temp.next = null;
//        tail = temp;
//    }
//
//
//    public void deletionAtFirst(){
//        if(head == null){
//            System.out.println("underflow") ;
//            return ;
//        }
//        head = head.next;
//        if(head==null) tail = null;
//    }
//    public void insertionAtPosition(int value,int position){
//        Node node = new Node(value);
//        Node temp = head,prev = null;
//        int count = 1;
//        if(head==null || position==1){
//            insertionAtFirst(value);
//        }
//        else{
//            while(temp != null && count != position){
//                prev = temp;
//                temp = temp.next;
//                count++;
//            }
//            if(count==position){
//                prev.next = node;
//                node.next  = temp;
//                if(temp==null){
//                    tail = node;
//                }
//            }else{
//                System.out.println("invalid position");
//            }
//        }
//    }
//    public void insertionAtLast(int value){
//        Node node = new Node(value);
//        if(tail == null){
//            insertionAtFirst(value);
//        }else{
//            node.next = head;
//            node.prev = tail;
//            tail.next = node;
//            head.prev = node;
//
//            tail = node;
//        }
//    }
//    public void reverse(){
//        if(head==null || head==tail){
//            System.out.println("contains only one node !! can not reverse it");
//            return;
//        }else {
//            Node temp = null,current = head;
//            do{
//                temp = current.next;
//                current.next = current.prev;
//                current.prev = temp;
//                current = temp;
//            }while(current!=head);
//            temp = tail;
//            tail=head;
//            head = temp;
//        }
//    }
//    public void display(Node head){
//        Node temp = this.head;
//        while(temp.next != head){
//            System.out.print(temp.data+ " -> ");
//            temp = temp.next;
//        }
//        System.out.println(temp.data);
//    }
//    public void insertionAtFirst(int value){
//        Node node = new Node(value);
//        if(head==null) {
//            head =node;
//            node.next = node;
//            node.prev = node;
//            tail = node;
//        }else {
//            node.next = head;
//            head.prev = node;
//            head = node;
//            node.prev = tail;
//            tail.next = node;
//        }
//        size += 1;
//    }
//
//    public t11_doubly_LinkedList() {
//        this.size = 0;
//    }
//
//    private class Node{
//        int data;
//        Node next;
//        Node prev;
//        public Node(int data){
//            this.data = data;
//        }
//        public Node(int data,Node next){
//            this.data = data;
//            this.next = next;
//        }
//        public Node(int data,Node next,Node prev){
//            this.data = data;
//            this.next = next;
//            this.prev = prev;
//        }
//    }
//}


class t11_LinkedList {
    public Node getHead() {
        return head;
    }

    private Node head;
    private Node tail;
    private int size;

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
        System.out.println();
    }
    public void insertionAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail==null) tail = node;
        size+=1;
    }

    public t11_LinkedList() {
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
public class t11_Main_Lists{
    public static void main(String[] args) {
//        t11_LinkedList list = new t11_LinkedList();
//        list.insertionAtFirst(1);
//        list.insertionAtFirst(2);
//        list.insertionAtFirst(3);
//        list.insertionAtFirst(6);
//        list.insertionAtFirst(5);
//        list.insertionAtFirst(6);
//        list.insertionAtFirst(7);
//        list.insertionAtLast(8);
//        list.insertionAtLast(89);
//        list.display(list.getHead());
//        list.insertionAtPosition(0,7);
//        list.display(list.getHead());
//        list.deletionAtFirst();
//        list.deletionAtLast();
//        System.out.println("after delete at first and last node");
//        list.display(list.getHead());
//        System.out.println("iterative deletion");
//        for (int i = 8; i >= 0; i--) {
//            list.deletionAtPosition(i);
//            list.display(list.getHead());
//        }
//        t11_doubly_LinkedList dlist = new t11_doubly_LinkedList();
//        dlist.insertionAtFirst(3);
//        dlist.insertionAtFirst(2);
//        dlist.insertionAtFirst(1);
//        dlist.display(dlist.getHead());
//        dlist.reverse();
//        dlist.display(dlist.getHead());
//        dlist.insertionAtLast(4);
//        dlist.display(dlist.getHead());



    }
}
