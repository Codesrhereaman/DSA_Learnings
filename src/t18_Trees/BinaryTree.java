package t18_Trees;
import java.util.Scanner;


public class BinaryTree{
    BinaryTree bt;
    static Scanner sc = new Scanner(System.in);
    public static Node root = null;
    public static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public BinaryTree(int root){
        this.root = new Node(root);
    }



    static void main(String[] args) {
//        insertRootNode();
//        Node node = root;
//        insert(node);
//        System.out.println("Inorder traversal: ");
//        inOrderTraversal(node);
//        System.out.println("pre Order traversal: ");
//        preOrderTraversal(node);
//        System.out.println("post Order traversal: ");
//        postOrderTraversal(node);
    }

    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }


    static boolean insertLeft(Node node){
        System.out.printf("do you want to insert in left node of %d ?(i.e. 0/1): ",node.data);
        int num = sc.nextInt();
        return num == 1;
    }
    static boolean insertRight(Node node){
        System.out.printf("do you want to insert in right node of %d ?(i.e. 0/1): ",node.data);
        int num = sc.nextInt();
        return num == 1;
    }


    public static void insert(Node root){
        int data;
        if(insertLeft(root)){
            System.out.println("enter the value: ");
            data = sc.nextInt();
            root.left = new Node(data);
            insert(root.left);
        }

        if(insertRight(root)){
            System.out.println("enter the value: ");
            data = sc.nextInt();
            root.right = new Node(data);
            insert(root.right);
        }
    }


    public static void insertRootNode(){
        System.out.println("enter the root node data: ");
        int data = sc.nextInt();
        root = new Node(data);
    }
}
