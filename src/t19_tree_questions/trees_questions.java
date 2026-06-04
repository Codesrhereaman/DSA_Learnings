package t19_tree_questions;

import t18_Trees.BinaryTree;

import java.util.*;

public class trees_questions {
    BinaryTree bt = new BinaryTree(6);


    static void main() {
        trees_questions tt = new trees_questions();
        BinaryTree.Node root = BinaryTree.root;
        BinaryTree.insert(root);
        BinaryTree.preOrderTraversal(root);
        System.out.println(tt.maxDepth(root));
//        System.out.println(tt.countPaths2(root, 4).toString());
//        System.out.println(tt.maxPathSum(root));
//        System.out.println(tt.hasPathSum(root,22));
//        System.out.println(tt.sumNumbers3(root));
//        BinaryTree.preOrderTraversal(tt.deserialize(tt.serialize(root)));
//        System.out.println(levelOrderSuccessor(node,11));
//        System.out.println(zigzagLevelOrder(root).toString());
//        zigzagLevelOrder2(root);
    }

    //question 104
    public int maxDepth(BinaryTree.Node root) {
        return helper104(root,0);
    }

    private int helper104(BinaryTree.Node node, int h) {
        if(node==null) return 0;
        int leftHeight = helper104(node.left,h+1);
        int rightHeight = helper104(node.right,h+1);
        return 1+Math.max(leftHeight,rightHeight);
    }

    //question 2476
    public List<List<Integer>> closestNodes(BinaryTree.Node root, List<Integer> queries) {
        List<List<Integer>> l = new ArrayList<>(queries.size());
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root,list);
        for (int i = 0; i < queries.size(); i++) {
            int [] array = floor_ceiling_element(list,queries.get(i));
            List<Integer> temp = new ArrayList<>();
            temp.add(array[0]);
            temp.add(array[1]);
            l.add(temp);
        }
        return l;
    }
    static int[] floor_ceiling_element(List<Integer> arr,int target) {
        int start = 0;
        int end = arr.size() - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target) {
                return new int[]{arr.get(mid),arr.get(mid)};
            }
            if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int ceiling = (start < arr.size() ? arr.get(start) : -1);
        int floor = (-1 < end ? arr.get(end) : -1 );
        return new int[]{floor, ceiling};
    }

    private void inOrderTraversal(BinaryTree.Node node,List<Integer> list){
        if(node==null){
            return ;
        }
        inOrderTraversal(node.left,list);
        list.add(node.data);
        inOrderTraversal(node.right,list);
    }

    //question 687
    int maxUnivalue = 0;
    public int longestUnivaluePath(BinaryTree.Node root) {
        return maxUnivalue;
    }
    private int helper687_2(BinaryTree.Node node) {
        if(node==null){
            return 0;
        }
        if(node.left ==null && node.right==null){
            return 1;
        }
        int left = helper687_2(node.left);
        int right  = helper687_2(node.right);
        if(node.left ==null || node.left.data ==node.data && node.right==null || node.right.data ==node.data){
            maxUnivalue = Math.max(maxUnivalue,left+right);
            return 1+Math.max(left,right);
        }
        else if(node.right==null || node.right.data ==node.data){
            maxUnivalue = Math.max(maxUnivalue,left);
            return 1+right;
        }
        else if(node.left==null || node.left.data==node.data){
            maxUnivalue = Math.max(maxUnivalue,left+right);
            return 1+left;
        }

        return 1;
    }

    private int helper687(BinaryTree.Node node) {
        if(node==null){
            return 0;
        }
        int left = helper687(node.left);
        int right  = helper687(node.right);
        int leftPath = 0;
        int rightPath = 0;
        if(node.left!=null && node.left.data ==node.data){
            leftPath = left+1;
        }if(node.right!=null && node.right.data ==node.data){
            rightPath = left+1;
        }
        maxUnivalue = Math.max(maxUnivalue,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }

    //863
    public List<Integer> distanceK(BinaryTree.Node root, BinaryTree.Node target, int k) {
        List<Integer> list = new LinkedList<>();
        findUp(root,target,k,list);
        return list;
    }

    private int findUp(BinaryTree.Node node, BinaryTree.Node target, int k, List<Integer> list) {
        if(node==null){
            return -1;
        }
        if(node==target) {
            findDown(node, k, list, 0);
            return 0;
        }
        int leftCount = findUp(node.left,target,k,list);
        if(leftCount!=-1){
            if(leftCount+1==k){
                list.add(node.data);
            }
            else{
                findDown(node.right,k,list,leftCount+2);
            }
            return leftCount+1;
        }
        int rightCount = findUp(node.right,target,k,list);
        if(rightCount!=-1){
            if(rightCount+1==k){
                list.add(node.data);
            }
            else{
                findDown(node.left,k,list,rightCount+2);
            }
            return rightCount+1;
        }
        return -1;
    }

    private void findDown(BinaryTree.Node node, int k, List<Integer> list,int downIndex) {
        if(node==null){
            return;
        }
        if(downIndex==k){
            list.add(node.data);
            return;
        }
        findDown(node.left,k,list,downIndex+1);
        findDown(node.right,k,list,downIndex+1);
    }

    //get the count of all possible path anywhere having a targetSum in a tree
    
    List<String> countPaths2(BinaryTree.Node root, int sum) {
        List<Integer> path = new LinkedList<>();
        List<String> pathsList = new LinkedList<>();
        helper(root, sum, path, pathsList);
        return pathsList;
    }

    //return ALL POSSIBLE PATHS
    private void helper(BinaryTree.Node node, int sum, List<Integer> path, List<String> pathsList) {
        if (node == null) {
            return;
        }
        path.add(node.data);

        String paths = "";
        int s = 0;
        //how to check if path is present or not
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            int val = itr.previous();
            paths = val + " " + paths;
            s += val;
            if (s == sum) {
                pathsList.add(paths);
            }
        }
        helper(node.left, sum, path, pathsList);
        helper(node.right, sum, path, pathsList);
        //backtrack
        path.removeLast();

    }


    int countPaths(BinaryTree.Node root, int sum) {
        List<Integer> path = new LinkedList<>();
        return helper(root, sum, path);
    }

    private int helper(BinaryTree.Node node, int sum, List<Integer> path) {
        if(node==null){
            return 0;
        }
        path.add(node.data);

        int count = 0 ;
        int s = 0;
        //how to check if path is present or not
        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()){
            s+=itr.previous();
            if(s==sum){
                count++;
            }
        }
        count += helper(node.left,sum,path) + helper(node.right,sum,path);

        //backtrack
        path.removeLast();
        return count;

    }


    //question 124
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(BinaryTree.Node root) {
        findPossibleMaxSum(root);
        return maxSum;
    }

    private int findPossibleMaxSum(BinaryTree.Node node) {
        if (node == null) return 0;
        int leftSum = Math.max(0, findPossibleMaxSum(node.left));
        int rightSum = Math.max(0, findPossibleMaxSum(node.right));

        maxSum = Math.max(maxSum, node.data + leftSum + rightSum);
        return node.data + Math.max(leftSum, rightSum);
    }

    //question 112
    public boolean hasPathSum(BinaryTree.Node root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(BinaryTree.Node node, int targetSum, int currSum) {
        if (node == null) return false;
        currSum += node.data;
        if (node.left == null && node.right == null) {
            return targetSum == currSum;
        }
        return hasPathSum(node.left, targetSum, currSum) || hasPathSum(node.right, targetSum, currSum);
    }

    //question 129

    //OPTIMUM
    int totalSum;

    public int sumNumbers3(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }
        totalSum = 0;
        helper(root, 0);

        return totalSum;
    }

    private void helper(BinaryTree.Node node, int currSum) {
        if (node == null) {
            return;
        }
        currSum = currSum * 10 + node.data;
        if (node.left == null && node.right == null) {
            totalSum += currSum;
            return;
        }
        helper(node.left, currSum);
        helper(node.right, currSum);
    }

//    this is having a problem of shifting the bit instead of value
//    private void helper(BinaryTree.Node node,int currSum,int currDigit) {
//        if (node == null) {
//            return ;
//        }
//        currSum = (currSum<<currDigit-1) + node.data;
//        if (node.left == null && node.right == null) {
//            totalSum += currSum;
//            return;
//        }
//        helper(node.left, currSum,currDigit+1);
//        helper(node.right,currSum,currDigit+1);
//    }


    public int sumNumbers(BinaryTree.Node root) {
        StringBuilder sb = new StringBuilder("");
        ArrayList<StringBuilder> list = new ArrayList<>(10);
        sumNumbers(root, sb, list);
        int sum = 0;
        for (StringBuilder j : list) {
            sum += Integer.parseInt(j.toString());
        }
        return sum;
    }

    private ArrayList sumNumbers(BinaryTree.Node node, StringBuilder sb, ArrayList<StringBuilder> list) {
        if (node == null) {
            return list;
        }
        sb.append(node.data);
        if (node.left == null && node.right == null) {
            list.add(sb);
        } else {
            if (node.left != null) {
                sumNumbers(node.left, sb, list);
            }
            if (node.right != null) {
                sumNumbers(node.right, sb, list);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return list;
    }

    public int sumNumbers2(BinaryTree.Node root) {
        String sb = ("");
        ArrayList<String> list = new ArrayList<>(10);
        sumNumbers2(root, sb, list);
        int sum = 0;
        for (String j : list) {
            sum += Integer.parseInt(j);
        }
        return sum;
    }

    private void sumNumbers2(BinaryTree.Node node, String sb, ArrayList<String> list) {
        if (node == null) {
            return;
        }
        sb = sb + node.data;
        if (node.left == null && node.right == null) {
            list.add(sb);
            return;
        }
        sumNumbers2(node.left, sb, list);
        sumNumbers2(node.right, sb, list);
    }

    //question 297
    public String serialize(BinaryTree.Node root) {
        StringBuilder sb = new StringBuilder("");
        return ser(root, sb).toString();
    }


    private StringBuilder ser(BinaryTree.Node node, StringBuilder sb) {
        if (node == null) {
            return sb.append("0,");
        }
        sb.append(node.data).append(",");
        ser(node.left, sb);
        ser(node.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public BinaryTree.Node deserialize(String string) {
        StringBuilder sb = new StringBuilder(string);
        return deser(sb);
    }

    private BinaryTree.Node deser(StringBuilder sb) {
        int idx = sb.indexOf(",");
        String s = (sb.substring(0, idx));
        sb.delete(0, idx + 1);
        BinaryTree.Node node = new BinaryTree.Node(Integer.parseInt(s));
        if (node.data == 0) {
            return null;
        }
        node.left = deser(sb);
        node.right = deser(sb);
        return node;
    }

    //question 105
    int index = 0;

    public BinaryTree.Node buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);

    }

    private BinaryTree.Node helper(int[] preorder, int[] inorder, int s, int e) {
        if (s > e) {
            return null;
        }
        BinaryTree.Node node = new BinaryTree.Node(preorder[index]);
        int partition = find(inorder, preorder[index++], s, e);
        node.left = helper(preorder, inorder, s, partition - 1);
        node.right = helper(preorder, inorder, partition + 1, e);
        return node;
    }

    private int find(int[] inorder, int ele, int s, int e) {
        for (int j = s; j <= e; j++) {
            if (inorder[j] == ele) {
                return j;
            }
        }
        return -1;
    }

    //question 230
    int count = 0;

    public int kthSmallest1(BinaryTree.Node node, int k) {
        return kthSmallest(node, k).data;
    }

    private BinaryTree.Node kthSmallest(BinaryTree.Node node, int k) {
        if (node == null) {
            return node;
        }
        BinaryTree.Node left = kthSmallest(node.left, k);
        if (left != null) return left;
        count++;
        if (k == count) {
            return node;
        }
        return kthSmallest(node.right, k);
    }

    //question 236
    static BinaryTree.Node lowestCommonAncestor(BinaryTree.Node node, BinaryTree.Node p, BinaryTree.Node q) {
        if (node == null) {
            return node;
        }
        BinaryTree.Node left = lowestCommonAncestor(node.left, p, q);
        BinaryTree.Node right = lowestCommonAncestor(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }

    }

    //question 114
    static BinaryTree.Node flattenBT(BinaryTree.Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            rightMostNode(node.left).right = node.right;
            node.right = node.left;
            node.left = null;
        }

        flattenBT(node.right);
        return node;

    }

    static BinaryTree.Node rightMostNode(BinaryTree.Node node) {
        if (node.right == null) return node;
        return rightMostNode(node.right);
    }


    //question 226
    static BinaryTree.Node invertBinaryTree(BinaryTree.Node node) {
        if (node == null) {
            return node;
        }
        node.left = invertBinaryTree(node.left);
        node.right = invertBinaryTree(node.right);
        BinaryTree.Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }


    static int calDiameter(BinaryTree.Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = calHeight(node.left);
        int rHeight = calHeight(node.right);
        int lDiameter = calDiameter(node.left);
        int rDiameter = calDiameter(node.right);
        return Math.max(lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    static int calHeight(BinaryTree.Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calHeight(node.left), calHeight(node.right));
    }

    //DFS

    //question 101
    public boolean isSymmetric(BinaryTree.Node root) {
        if (root == null) {
            return false;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            BinaryTree.Node left = q.poll();
            BinaryTree.Node right = q.poll();
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.data != right.data) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    //question 103
    //using queue

    public static List<List<Integer>> zigzagLevelOrder2(BinaryTree.Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();
        boolean leftToRight = true;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                BinaryTree.Node node = q.poll();
                if (leftToRight) {
                    l.add(node.data);
                } else {
                    l.addFirst(node.data);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            list.add(l);
        }
        return list;
    }

    //using deque
    public static List<List<Integer>> zigzagLevelOrder(BinaryTree.Node root) {
        List<List<Integer>> list = new LinkedList<>();
        Deque<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            if (leftToRight) {
                //for even
                for (int i = 0; i < size; i++) {
                    BinaryTree.Node n = q.pollFirst();
                    l.add(n.data);
                    if (n.left != null) {
                        q.addLast(n.left);
                    }
                    if (n.right != null) {
                        q.addLast(n.right);
                    }
                }
                leftToRight = !leftToRight;
            }
            //for odd
            else {
                for (int i = size; i > 0; i++) {
                    BinaryTree.Node n = q.pollLast();
                    l.add(n.data);
                    if (n.right != null) {
                        q.addFirst(n.right);
                    }
                    if (n.left != null) {
                        q.addFirst(n.left);
                    }
                }
                leftToRight = !leftToRight;
            }
            list.add(l);
        }
        return list;
    }


    public static int levelOrderSuccessor(BinaryTree.Node node, int target) {
        if (node == null) {
            return -1;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            BinaryTree.Node n = q.poll();
            if (n.data == target) {
                if (!q.isEmpty()) {
                    return q.peek().data;
                } else {
                    System.out.println("no successor exist");
                    return -1;
                }
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return -1;
    }

    public List<Double> averageOfLevels(BinaryTree.Node root) {
        List<Double> lst = new LinkedList<>();
        if (root == null) return lst;
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                BinaryTree.Node temp = q.poll();
                sum += temp.data;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            lst.add(sum / size);

        }
        return lst;
    }

}
