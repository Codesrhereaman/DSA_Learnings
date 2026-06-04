package t18_Trees;

public class AVL_Tree {
    private static Node root ;
    private static class Node{
        public int getData() {
            return data;
        }
        private final int data;
        private Node left;
        private Node right;
        private int height = 0;
        public Node(int data){
            this.data = data;
        }
    }
    public static int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    static void main() {

        // Bigger Test Arrays
        int[] llTree = {50, 40, 30, 20, 10};
        int[] rrTree = {10, 20, 30, 40, 50};
        int[] lrTree = {50, 30, 40, 20, 35};
        int[] rlTree = {10, 50, 30, 60, 25};

// Roots
        Node rootLL = null;
        Node rootRR = null;
        Node rootLR = null;
        Node rootRL = null;

// Insert using loop
        for (int val : llTree) {
            rootLL = insert(val, rootLL);
        }

        for (int val : rrTree) {
            rootRR = insert(val, rootRR);
        }

        for (int val : lrTree) {
            rootLR = insert(val, rootLR);
        }

        for (int val : rlTree) {
            rootRL = insert(val, rootRL);
        }

// Display all
        System.out.println("LL Tree:");
        prettyDisplay(rootLL, 0);
        System.out.println();

        System.out.println("RR Tree:");
        prettyDisplay(rootRR, 0);
        System.out.println();

        System.out.println("LR Tree:");
        prettyDisplay(rootLR, 0);
        System.out.println();

        System.out.println("RL Tree:");
        prettyDisplay(rootRL, 0);
        System.out.println();

        //AVl\\\\\\\\\\\\\\\\\\

        // roots ko firse null karo
        rootLL = null;
        rootRR = null;
        rootLR = null;
        rootRL = null;

// same arrays use ho rahe hain (llTree, rrTree, lrTree, rlTree)

// AVL insertion
        for (int val : llTree) {
            rootLL = insertAvl(val, rootLL);
        }

        for (int val : rrTree) {
            rootRR = insertAvl(val, rootRR);
        }

        for (int val : lrTree) {
            rootLR = insertAvl(val, rootLR);
        }

        for (int val : rlTree) {
            rootRL = insertAvl(val, rootRL);
        }

// display
        System.out.println("LL AVL:");
        prettyDisplay(rootLL, 0);
        System.out.println();

        System.out.println("RR AVL:");
        prettyDisplay(rootRR, 0);
        System.out.println();

        System.out.println("LR AVL:");
        prettyDisplay(rootLR, 0);
        System.out.println();

        System.out.println("RL AVL:");
        prettyDisplay(rootRL, 0);
        System.out.println();


    }
    static void prettyDisplay(Node node,int level){
        if(node==null) return;
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|----->"+node.getData());
        }else{
            System.out.println(node.getData());
        }
        prettyDisplay(node.left,level+1);
    }



    public static void insertRoot(int value){
        root = insertAvl(value,root);
    }

    private static Node insertAvl(int value, Node root){
        if(root==null){
            return new Node(value);
        }
        if(value<root.data){
            root.left = insertAvl(value,root.left);
        }
        if(value> root.data){
            root.right = insertAvl(value,root.right);
        }
        root.height = Math.max(height(root.left),height(root.right)) + 1;
        return rotate(root);
    }

    private static Node insert(int value, Node root){
        if(root==null){
            return new Node(value);
        }
        if(value<root.data){
            root.left = insert(value,root.left);
        }
        if(value> root.data){
            root.right = insert(value,root.right);
        }
        root.height = Math.max(height(root.left),height(root.right)) + 1;
        return root;
    }


    private static Node rightRightRotated(Node node) {
        Node c = node.right;
        node.right = c.left;
        c.left = node;
        return c;
    }

    private static Node leftLeftRotate(Node node) {
        Node c = node.left;
        node.left = c.right;
        c.right = node;
        return c;
    }


    private static Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) >0){
                //LL
                return leftLeftRotate(node);
            }else{
                //LR
                node.left = rightRightRotated(node.left);
                return leftLeftRotate(node);
            }
        }
        if(height(node.right) - height(node.left) > 1){
            //right heavy
            if(height(node.right.right) - height(node.right.left) > 0){
                //RR
                return rightRightRotated(node);
            }else{
                //RL
                node.right = leftLeftRotate(node.right);
                return rightRightRotated(node);
            }
        }
        return node;
    }




    private static boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return (Math.abs(height(node.left) - height(node.right)) <= 1) && balanced(node.left) && balanced(node.right);
    }
}
