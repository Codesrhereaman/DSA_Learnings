package t18_Trees.algos;


import java.util.*;

public class BFS {
    private static Node root;
    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    static void main() {

    }



    public static List<List<Integer>> bfs(Node node){
        List<List<Integer>> list = new LinkedList<>();
        if(node ==null){
            return list;
        }
        Queue<Node> q = new LinkedList<>() ;
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                l.add(n.data);
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            list.add(l);
        }
        return list;
    }
    public static void bfs_Recursive(Node node,Queue<Node> q){
        if(node == null ){
            return ;
        }
        System.out.println(node.data);
        if(node.left!=null){
            q.add(node.left);
        }
        if(node.right!=null){
            q.add(node.right);
        }
        q.poll();
        if(!q.isEmpty()){
            bfs_Recursive(q.peek(),q);
        }
    }
    public static void bfs_Iterative(Node node){
        Queue<Node> q = new LinkedList<>() ;
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.println(n.data);
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
    }
}
