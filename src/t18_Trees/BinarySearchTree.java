package t18_Trees;

import java.util.Scanner;

public class BinarySearchTree {
    static Scanner sc = new Scanner(System.in);
    private static Node root ;
    private static class Node{
        public int getVal() {
            return val;
        }
        private final int val;
        private Node left;
        private Node right;
        private int height = 0;
        public Node(int val){
            this.val = val;
        }
    }
    public static int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }


    static void main() {
//        insert(15);
//        insertRoot(5);
        int[] arr  = {8,2,4,5,6,10,1,9};
        for(int ele:arr){
            insert(ele,root);
        }
//        insertSorted(arr,0,arr.length-1);
//        preOrderTraversal(root," ");
//        System.out.println(balanced(root));
//        System.out.println("pretty tree");
        prettyDisplay(root,0);
    }

    //is valid bst 98 on LeetCode
    private boolean isValidBST(Node root,long max,long min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || min>= root.val) {
                return false;
        }
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max) ;
    }

    static void prettyDisplay(Node node,int level){
        if(node==null) return;
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|----->"+node.getVal());
        }else{
            System.out.println(node.getVal());
        }
        prettyDisplay(node.left,level+1);
    }



    static void preOrderTraversal(Node root,String details){
        if(root==null){
            return;
        }
        System.out.println(details+root.getVal() );
        preOrderTraversal(root.left,"left child of "+root.getVal()+" : ");
        preOrderTraversal(root.right,"right child of "+root.getVal()+" : ");
    }

    public static void insertSorted(int[] arr,int start,int end){
        if(start>end) return;
        int mid = start + (end-start)/2;
        if(root==null) {
            insertRoot(arr[mid]);
        }else{
            insert(arr[mid],root);
        }
        insertSorted(arr,start,mid-1);
        insertSorted(arr,mid+1,end);
    }

    private static Node insert(int value, Node root){
        if(root==null){
            return new Node(value);
        }
        if(value<root.val){
            root.left = insert(value,root.left);
        }
        if(value> root.val){
            root.right = insert(value,root.right);
        }
        root.height = Math.max(height(root.left),height(root.right)) + 1;
        return root;
    }

    public static void insertRoot(int value){
        root = insert(value,root);
    }

    public static boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return (Math.abs(height(node.left) - height(node.right)) <= 1) && balanced(node.left) && balanced(node.right);
    }


}
