import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class t14_Recursion_adv_question {
    public static void main(String[] args) {
//        String s = "dfsapplendkjfnappdsf";
//        System.out.println(skip(s,sub,0));
//        System.out.println(());
//        System.out.println(skipApple(s,""));
//        System.out.println(skipAppNotApple(s));
//        sub("abc","");
//        ArrayList<String> sub = new ArrayList<String>();
//        System.out.println(sub(s,"",sub));
//        System.out.println(sub2(s,""));
//        subAscii("ab","");
//        System.out.println(subAscii2("abc",""));
//        System.out.println("a".charAt(0)-'0');
//        System.out.println(pad("","89"));
        int[] arr = {1,1,1,1,1};
//        List<Integer> list = new ArrayList<>();
//        System.out.println(subset(arr,0,list).toString());
//        System.out.println(subset(arr).toString());
//        System.out.println(subsetDuplicate(arr).toString());
//        permut("abc","");
//        List<List<String>> str = new ArrayList<>();
//        System.out.println(permut2("abcde","",str).toString());
//        List<Integer> ls = new ArrayList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        System.out.println(combinationSum(arr,8,0,ls).toString());
//        System.out.println(rollingDice(arr,4,ls,list,0).toString());
//        rollingDice("",4);
        System.out.println(targetSum(arr,3,0,0));

    }
    //ques 17 in leetcode
//    static ArrayList<String> pad(String p, String up){
//        if(up.isEmpty()){
//            ArrayList<String> s = new ArrayList<>();
//            s.add(p);
//            return s;
//        }
//        ArrayList<String> sub  = new ArrayList<>();
//        int digit = up.charAt(0) - '0';
//        if(digit==7){
//            for (int i = (digit-2)*3; i <=(digit-1)*3 ; i++) {
//                char ch = (char)(i+'a');
//                sub.addAll(pad(p+ch,up.substring(1)));
//            }
//        }
//        else if(digit==8){
//            for (int i = (digit-2)*3+1; i <=(digit-1)*3 ; i++) {
//                char ch = (char)(i+'a');
//                sub.addAll(pad(p+ch,up.substring(1)));
//            }
//        }
//        else if(digit==9){
//            for (int i = (digit-2)*3+1; i <=(digit-1)*3+1 ; i++) {
//                char ch = (char)(i+'a');
//                sub.addAll(pad(p+ch,up.substring(1)));
//            }
//        }else {
//            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
//                char ch = (char) (i + 'a');
//                sub.addAll(pad(p + ch, up.substring(1)));
//            }
//        }
//        return sub;
//    }
//    static void pad(String p,String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        int digit = up.charAt(0) - '0';
//        for (int i = (digit-2)*3; i <(digit-1)*3 ; i++) {
//            char ch = (char)(i+'a');
//            pad(p+ch,up.substring(1));
//        }
//    }
    //returning count for the combination
    static int pad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        for (int i = (digit-2)*3; i <(digit-1)*3 ; i++) {
            char ch = (char)(i+'a');
            count=count+pad(p+ch,up.substring(1));
        }
        return count;
    }
    //skip a char

    static String skip(String s,String sub,int index){
        if(s.length()==index){
            return sub;
        }
        if(s.charAt(index)!='a'){
            sub=sub+s.charAt(index);
        }
        return skip(s,sub,index+1);
    }
    //skip a string("Apple")
    static String skipApple(String s,String sub){
        if(s.isEmpty()){
            return sub;
        }
        if(s.startsWith("apple")){
            return skipApple(s.substring(5),sub);
        }
        return skipApple(s.substring(1),sub+s.charAt(0));
    }
    //skip astring if not the required string
    static String skipAppNotApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("app")){
            if(s.startsWith("apple")){
                return "apple"+skipAppNotApple(s.substring(5));
            }else{
                return skipAppNotApple(s.substring(3));
            }
        }else {
            return s.charAt(0)+skipAppNotApple(s.substring(1));
        }
    }
    //getting subseq
    static void sub(String s,String sub){
        if(s.isEmpty()){
            System.out.println(sub);
            return;
        }
        char c = s.charAt(0);
        sub(s.substring(1),sub+c);
        sub(s.substring(1),sub);
    }
    //return arraylist of subset
    static ArrayList<String> sub(String s,String temp,ArrayList<String> list){
        if(s.isEmpty()){
            list.add(temp);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> left = sub(s.substring(1),temp+c,list);
        ArrayList<String> right = sub(s.substring(1),temp,list);
        left.addAll(right);
        return left;

    }
    static ArrayList<String> sub2(String s,String temp){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(temp);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> left = sub2(s.substring(1),temp+c);
        ArrayList<String> right = sub2(s.substring(1),temp);
        left.addAll(right);
        return left;
    }
    //return sub with ascii
    static void subAscii(String s,String sub){
        if(s.isEmpty()){
            System.out.println(sub);
            return;
        }
        char c = s.charAt(0);
        subAscii(s.substring(1),sub+c);

        subAscii(s.substring(1),sub);
        subAscii(s.substring(1),sub+(c+0));
    }
    static ArrayList<String> subAscii2(String s,String temp){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(temp);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> first = subAscii2(s.substring(1),temp+c);
        ArrayList<String> second = subAscii2(s.substring(1),temp);
        ArrayList<String> third = subAscii2(s.substring(1),temp+(c+0));
        first.addAll(second);
        first.addAll(third);
        return first;
    }

    static List<List<Integer>> subset(int[] arr,int index,List<Integer> list){
        List<List<Integer>> result = new ArrayList<>();
        if(index==arr.length){
            result.add(new ArrayList<>(list));
            return result;
        }
        result.addAll(subset(arr,index+1,list));
        list.add(arr[index]);
        result.addAll(subset(arr,index+1,list));
        list.remove(list.size() -1);

        return result;
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int ele:arr){
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(ele);
                result.add(temp);
            }
        }

        return result;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start =0;
        int end = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            start = 0;
            if(i>0 && arr[i]==arr[i-1]) {
                start = end+1;
            }
            end=result.size();
            for (int j = start; j < end; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(arr[i]);
                result.add(temp);
            }
        }
        return result;
    }
    static void permut(String up,String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
//        permut(up.substring(1),p+up.charAt(0));
        for (int i = 0; i <= p.length(); i++) {
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            permut(up.substring(1),f+ch+l);
        }
    }
    static List<List<String>> permut2(String up,String p,List<List<String>> lst){
        if(up.isEmpty()){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            lst.add(temp);
            return lst;
        }
        char ch = up.charAt(0);
//        permut(up.substring(1),p+up.charAt(0));
        for (int i = 0; i <= p.length(); i++) {
//            List<List<String>> temp = new ArrayList<>();
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            permut2(up.substring(1),f+ch+l,lst);
        }
        return lst;
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target,int index,List<Integer> ls) {
        List<List<Integer>> result = new ArrayList<>();
        if(target==0){
            if(result.contains(ls)){
                return result;
            }
            result.add(new ArrayList<>(ls));
            return result;
        }
        if(index==candidates.length || target<0){
            return result;
        }
        ls.add(candidates[index]);
        List<List<Integer>> single = combinationSum(candidates,target-candidates[index],index+1,ls);
        List<List<Integer>> multi = combinationSum(candidates,target-candidates[index],index,ls);
        ls.remove(ls.size() - 1);
        List<List<Integer>> exclude = combinationSum(candidates,target-candidates[index],index+1,ls);
        result.addAll(single);
        result.addAll(multi);
        result.addAll(exclude);
        return result;
    }

    static List<List<Integer>> rollingDice(int[] arr,int target,List<Integer> ls,List<List<Integer>> list,int index){
        if(target==0){
            list.add(new ArrayList<>(ls));
            return list;
        }
        if(index==arr.length || target<arr[index]){
            return list;
        }

        ls.add(arr[index]);
        rollingDice(arr,target-arr[index],ls,list,index);
        ls.remove(ls.size() -1);
        rollingDice(arr,target,ls,list,index+1);
        return list;
    }
    static void rollingDice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<=target ; i++) {
            rollingDice(p+i,target-i);
        }
    }
    //leetcode probelm 494
    static int targetSum(int[] nums, int target,int sum,int index) {
        int count = 0;
        if(index==nums.length && target==sum){
            return 1;
        }
        if(index==nums.length && target!=sum){
            return 0;
        }
        count = count + targetSum(nums,target,sum+nums[index],index+1);
        count = count + targetSum(nums,target,sum-nums[index],index+1);
        return count;
    }

}
