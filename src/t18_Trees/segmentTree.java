package t18_Trees;

public class segmentTree {

    static void main() {
        int [] arr = {1,4,6,8,-4,2,6,38};
        segmentTree st = new segmentTree(arr);
        st.display(st.root);
        System.out.println(st.query(1,6));
        st.update(5,20);
        st.display(st.root);
    }

    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval,int endInterval){
            this.endInterval = endInterval;
            this.startInterval = startInterval;
        }
    }
    Node root;
    public segmentTree(int []arr){
        this.root  = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr, int s, int e) {
        if(s==e){
            Node leaf = new Node(s,e);
            leaf.data = arr[s];
            return leaf;
        }
        int mid = (s+e)/2 ;
        Node node = new Node(s,e);
        node.left = constructTree(arr,s,mid);
        node.right = constructTree(arr,mid+1,e);
        node.data = node.left.data + node.right.data;
        return node;
    }
    private void display(Node node){
        String str = "";
        if(node.left != null) {
            str += "Interval = [" + node.left.startInterval + "," + node.left.endInterval + "] and data: " + node.left.data + "<= ";
        }else{
            str += "no left child";
        }

        str += "Interval = [" + node.startInterval + "," + node.endInterval + "] and data: " + node.data + "<= ";
        if(node.right != null) {
            str += "Interval = [" + node.right.startInterval + "," + node.right.endInterval + "] and data: " + node.right.data + "";
        }else{
            str += "no right child";
        }
        System.out.println(str + "\n");

        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }

    }

    public int query(int si,int ei){
        return this.query(this.root,si,ei);

    }
    private int query(Node node,int qsi,int qei){
        if(node==null){
            return 0;
        }

        if(node.startInterval>=qsi && node.endInterval<=qei){
            return node.data;
        }
        else if(node.startInterval>qei || node.endInterval<qsi){
            return 0;
        }
        else {
            return query(node.left,qsi,qei) + query(node.right,qsi,qei);
        }

    }
    public void update(int index,int value){
        root.data =  this.update(root,index,value);
    }
    private int update(Node node,int index,int value){
        if(index>=node.startInterval && index<=node.endInterval){
            if(index==node.startInterval && index== node.endInterval){
                node.data = value;
                return node.data;
            }else{
                node.data = update(node.left,index,value) + update(node.right,index,value);
                return node.data;
            }
        }
        return node.data;
    }
}
