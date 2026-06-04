package t15_GFG_Questions;
import java.util.*;
public class EasyQuestions {

    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
//        sumTriangle(arr);
        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(increasingNumbers(2));
//        Stack<Integer> st  = new Stack<>();
//        st.push(5);
//        st.push(56);
//        st.push(2);
//        st.push(65);
//        st.push(23);
//        st.push(32);
////        sortStackUsingRecursion(st);
//        reverseStackUsingRecursion(st);
//        while(!st.isEmpty()){
//            System.out.println(st.pop());
//        }
//        ArrayList<Integer> eList = new ArrayList<>();
//        System.out.println(getSubset(getAllPrimes(2,list, 24),eList,0,24,0).toString());
//        int [][]mat = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};
//        System.out.println(totalCount(0,0,1,7,mat));
//        if(subset(arr,0,10,0,eList)){
//            System.out.println(eList.toString());
//        }
//        System.out.println(partitionArrays(arr));
        int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(ratInMaze(mat,"",0,0));

    }
    static void sumTriangle(int [] arr){
        if(arr.length<1){
            return;
        }
        int [] temp = new int[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            temp[i] = arr[i] + arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
        sumTriangle(temp);
    }
    //not a good or efficient solution
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int min_num = (int)Math.pow(10,n-1);

        if(n==1){
            for(int i=0;i<10;i++){
                list.add(i);
            }
            return list;
        }
        list.addAll(getNumber(min_num,n,list));
        return list;
    }
    static ArrayList<Integer> getNumber(int n ,int digits,ArrayList<Integer> list){
        int cur_dig = (int)((Math.log10(n))+1);
        if( cur_dig !=digits){
            return list;
        }
        int s = n;
        while(s>9){
            int d = s%10;
            s = s/10;
            int td = s%10;
            if(td<d){
                continue;
            }else{
                getNumber(n+1,digits,list);
            }
        }
        System.out.println(n);
        list.add(n);
        getNumber(n+1,digits,list);
        return list;
    }

    static void sortStackUsingRecursion(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        sortStackUsingRecursion(st);
        sortedInsert(st,top);
    }
    private static void sortedInsert(Stack<Integer> st,int x){
        if(st.isEmpty() ||x>=st.peek()){
            st.push(x);
            return;
        }
        int top = st.pop();
        sortedInsert(st,x);
        st.push(top);
    }

    static void reverseStackUsingRecursion(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStackUsingRecursion(st);
        reverseInsert(st,top);
    }
    private static void reverseInsert(Stack<Integer> st,int x){
            if(st.isEmpty()){
                st.push(x);
                return;
            }
            int top = st.pop();
            reverseInsert(st,x);
            st.push(top);
    }

    static List<Integer> getAllPrimes(int n,List<Integer> list,int sum){
        if(n>=sum){
            return list;
        }

        if((n&1)==0) {
            return getAllPrimes(n+1,list,sum);
        }
        if(n==2){
            list.add(2);
            return getAllPrimes(n+1,list,sum);
        }
        int sq = (int)Math.sqrt(n) ;
        boolean isPrime = true;
        for (int i = 3; i<=sq; i=i+2) {
            if(n%i==0 ){
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            list.add(n);
        }
        return getAllPrimes(n+1,list,sum);
    }
    static List<List<Integer>> getSubset(List<Integer> exist,List<Integer> sub,int cumSum,int sum,int index){
        List<List<Integer>> list = new ArrayList<>();
        if(cumSum==sum){
            list.add(new ArrayList<>(sub));
            return list;
        }

        if(index==exist.size() || cumSum>sum){
            return list;
        }

        sub.add(exist.get(index));
        list.addAll(getSubset(exist,sub,cumSum+ exist.get(index),sum,index+1));
        sub.remove(sub.size() -1);
        list.addAll(getSubset(exist,sub,cumSum,sum,index+1));

        return list;
    }

    static int longestRoute(int i,int j,int[] [] arr,int xd,int yd){
        if(i==xd&&j==yd){
            return 0;
        }
        if(i<0||j<0||j>=arr[0].length||i>=arr.length){
            return Integer.MIN_VALUE;
        }
        if(arr[i][j]!=1){
            return Integer.MIN_VALUE;
        }
        arr[i][j] =0;
        int left = 1+longestRoute(i,j-1,arr,xd,yd);
        int right = 1+longestRoute(i,j+1,arr,xd,yd);
        int up = 1+longestRoute(i-1,j,arr,xd,yd);
        int down = 1+longestRoute(i+1,j,arr,xd,yd);
        arr[i][j] = 1;
        int max = Math.max(left,right);
         max = Math.max(max,up);
         max = Math.max(max,down);
        return max;
    }
    private static int totalCount(int xs,int ys,int xd,int yd,int[][] arr){
        if(arr[xs][ys]==0&&arr[yd][yd]==0){
            return -1;
        }
        return longestRoute(0,0,arr,xd,yd);
    }

    //handshakes problem you can do when you complete dp

    static ArrayList<ArrayList<Integer>> partitionArrays(int [] arr){
        int n = arr.length;
        int total = 0;
        for(int ele:arr) total+=ele;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        if(subset(arr,0,total,0,result)){
            int listIndex=0;
            for (int i = 0; i < n; i++) {
                if(result.get(listIndex)==i){
                    list.get(0).add(arr[i]);
                    listIndex ++;
                }else{
                    list.get(1).add(arr[i]);
                }
            }
        }
        return list;
    }
    static boolean subset(int[] arr,int index,int sum,int currentSum,ArrayList<Integer> result){
        int n = arr.length;
        if(currentSum==sum/2 && (n%2 ==0 &&result.size()==n/2)||(n%2!=0 && (result.size()==n/2 || result.size()==n/2+1))){
            return true;
        }
        if(index>=n||currentSum>sum/2){
            return false;
        }
        result.add(index);
        if(subset(arr,index+1,sum,currentSum+arr[index],result)) return true;
        result.remove(result.size()-1);
        if(subset(arr,index+1,sum,currentSum,result)) return true;
        return false;
    }
    static ArrayList<Integer> subsetArrayList(int[] arr,int index,int sum,int currentSum,ArrayList<Integer> result){
        int n = arr.length;
        if(currentSum==sum/2 && (n%2 ==0 &&result.size()==n/2)||(n%2!=0 && (result.size()==n/2 || result.size()==n/2+1))){
            return new ArrayList<>(result);
        }
        if(index>=n||currentSum>sum/2){
            return null;
        }
        result.add(index);
         ArrayList<Integer>left = subsetArrayList(arr,index+1,sum,currentSum+arr[index],result);
         if(left!=null) return left;
        result.remove(result.size()-1);
        return subsetArrayList(arr,index+1,sum,currentSum,result);

    }


    static List<String> ratInMaze(int[][] arr,String sub,int i,int j){
        List<String> list = new ArrayList<>();
        if(i==arr.length -1&& j==arr[0].length-1){
            list.add(sub);
            return list;
        }
        if(i<0||j<0||i>=arr.length||j>=arr[0].length){
            return list;
        }
        if(arr[i][j]!=1){
            return list;
        }
        arr[i][j] = 0;
        list.addAll(ratInMaze(arr,sub+"D",i+1,j));
        list.addAll(ratInMaze(arr,sub+"U",i-1,j));
        list.addAll(ratInMaze(arr,sub+"R",i,j+1));
        list.addAll(ratInMaze(arr,sub+"L",i,j-1));
        arr[i][j] = 1;

        return list;
    }
//leetcode 79


}