package t21_HashMaps;

import java.util.*;

class TreeNode {
   int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left =left;
        this.right = right;
   }
}

public class l_987 {
    static void main() {

    }

    public List<List<Integer>> verticalTraversal(TreeNode node) {

        List<List<Integer>> sol = new LinkedList<>();
        if (node == null) return sol;

        Map<Integer, ArrayList<int[]>> map = new HashMap<>();

        Queue<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{node, 0, 0});

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            Object[] removed = queue.poll();

            node = (TreeNode) removed[0];
            int row = (int) removed[1];
            int col = (int) removed[2];

            map.computeIfAbsent(col, k -> new ArrayList<>())
                    .add(new int[]{row, node.val});

            minIndex = Math.min(col, minIndex);
            maxIndex = Math.max(col, maxIndex);

            if (node.left != null)
                queue.offer(new Object[]{node.left, row + 1, col - 1});

            if (node.right != null)
                queue.offer(new Object[]{node.right, row + 1, col + 1});
        }

        for (int i = minIndex; i <= maxIndex; i++) {

            ArrayList<int[]> list = map.get(i);

            // First sort by row, then by value
            list.sort((a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);
            });

            ArrayList<Integer> column = new ArrayList<>();

            for (int[] pair : list) {
                column.add(pair[1]);
            }

            sol.add(column);
        }

        return sol;
    }


//    public List<List<Integer>> verticalTraversal(TreeNode node) {
//        List<List<Integer>> sol = new LinkedList<>();
//        if (node==null){
//            return sol;
//        }
//        int col = 0;
//
//        Queue<Map.Entry<TreeNode,Integer>> queue = new ArrayDeque<>();
//        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
//
//        queue.offer(new AbstractMap.SimpleEntry<>(node,0));
//        int minIndex = Integer.MAX_VALUE;
//        int maxIndex = Integer.MIN_VALUE;
//
//        while (!queue.isEmpty()){
//            Map.Entry<TreeNode,Integer> removed = queue.poll();
//            node = removed.getKey();
//            col = removed.getValue();
//
//            if(node != null){
//                if(!map.containsKey(col)){
//                    map.put(col,new ArrayList<Integer>());
//                }
//                map.get(col).add(node.val);
//            }
//            minIndex = Math.min(col,minIndex);
//            maxIndex = Math.max(col,maxIndex);
//            if(node.left!=null)queue.offer(new AbstractMap.SimpleEntry<>(node.left,col-1));
//            if(node.right!=null)queue.offer(new AbstractMap.SimpleEntry<>(node.right,col+1));
//
//        }
//
//        for (int i = minIndex; i <= maxIndex ; i++) {
//            sol.add(map.get(i).sort((a,b) -> ));
//        }
//
//        return sol;
//    }
}
