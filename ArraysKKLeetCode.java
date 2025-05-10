import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraysKKLeetCode {
    static Scanner sc = new Scanner(System.in);
    public static int Sum(int[] arr){
            int sum=0;
            for(int i = 0; i<arr.length;i++){
                sum+=arr[i];
            }return sum;
        }
    public static int maximumWealth(int[][] accounts) {
            int max = 0;
            for(int acc[]: accounts){
                max=Math.max(Sum(acc),max);
            }return max;
        }
    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int index=0;

//        for (int i = 1; i < len; i++) {
//            int temp = nums[(2*i-1)];
//            nums[len+i]=nums[(2*i-1)];
//            nums[(2*i-1)]=temp;
            for(int i = 0; i<n;i++){
                arr[index++]=nums[i];
                arr[index++]=nums[n+i];
            }
            return arr;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> bool= new ArrayList<>();
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int i=0;i< candies.length;i++) {
            if(candies[i]+extraCandies>=max){
                bool.add(true);
            }else {
                bool.add(false);
            }
        }
        return bool;
    }
    public int numIdenticalPairs(int[] nums) {
        System.out.println("Fuck This Shit");
        int count =0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }return count;
    }
    public int numIdenticalPairsOP(int[] nums) {
        int count = 0;
        int[] frequnecy = new int[102];
        for (int i : nums) {
            frequnecy[i]++;
        }
        for(int n : frequnecy){
            count+= n* (n-1)/2;
        }
        return count;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        {
//            int count = 0;
//            int[] frequency = new int[102];
//            for (int i = 0; i < nums.length; i++) {
//                frequency[nums[i]]++;
//            }
//            for (int i = 0; i < frequency.length; i++) {
//                count += frequency[i] * (frequency[i] - 1) / 2;
//            }
//            return
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int count=0;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[i]>nums[j]){
                        count++;
                    }
                }
                ans[i]=count;
            }return ans;
        }
    }
    public static int[] swap(int[] arr, int position, int piece){
        int temp = arr[position];
        arr[position]=piece;
        if(arr.length>=position+1&&arr[position+1]!=0){
            return swap(arr,position+1,temp);
        }
        return arr;
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> targetList = new ArrayList<Integer>();
//        int len = targetList.length;
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i],nums[i]);
        }int[] arr = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            arr[i] = targetList.get(i);
        }
        return arr;
    }
    public static int min(int[] arr){
        int minInRow =Integer.MAX_VALUE;
        for(int el:arr){
            minInRow =Math.min(minInRow,el);
        }return minInRow;
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int maxx=0, counter=0;
        if(matrix[0].length==1){
            for (int i = 0; i < matrix.length; i++) {
                maxx = Math.max(maxx, matrix[i][0]);
                counter++;
            }
        }else{
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int minInRow = min(row);
            for (int j = 0; j < matrix.length; j++) {
                if(i>=matrix[0].length){
                    continue;
                }
                if(minInRow>matrix[j][i]){
                    maxx = Math.max(maxx, minInRow);
                    counter++;
                }
            }
        }
        }
        if(counter>0) {
            ans.add(maxx);
            return ans;
        }else {
            return ans;
        }
    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int maxx=0, counter=0;
        if(matrix[0].length==1){
            for (int i = 0; i < matrix.length; i++) {
                maxx = Math.max(maxx, matrix[i][0]);
                counter++;
            }
        }
        else{
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                int minInRow =0, minIndex=0;
                for(int j = 0; j < row.length; j++){
                    if (row[j] < minInRow) {
                        minInRow = row[j];
                        minIndex = j;
                    }
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[j][minIndex]>maxx){
                        ans.add(maxx);
                    }
                }
                return ans;
//                for (int j = 0; j < matrix.length; j++) {
//                    if(i>=matrix[0].length){
//                        continue;
//                    }
//                    if(minInRow>matrix[j][i]){
//                        maxx = Math.max(maxx, minInRow);
//                        counter++;
//                    }
//                }
            }
        }return null;
//        if(counter>0) {
//            ans.add(maxx);
//            return ans;
//        }else {
//            return ans;
//        }
    }
    public static void input2D(int n,int m,int[][] matrix){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
    }
    public static void output2D(int n,int m,int[][] matrix){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void output2Dm2(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix));
        }
    }
    public static void Search2D(int[][] matrix, int key){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==key){
                    System.out.println("Requested element"+ key +" at: ("+i+","+j+")");
                    return;
                }
            }
        } System.out.println("No such element here");
    }

    public static void main(String[] args) {
        System.out.println("Mew");
        ArraysKKLeetCode obj = new ArraysKKLeetCode();
//        int[][] test = {{1,2,3},{3,2,1}};
//        System.out.println(maximumWealth(test));
        int[] arr1 = {0,1,2,3,4};
        int[] arr2 = {0,1,2,2,1};
//        System.out.println(Arrays.toString(shuffle(arr,3)));
//        List<Boolean> bool= new ArrayList<>();
//        System.out.println(bool);
        System.out.println(Arrays.toString(createTargetArray(arr1,arr2)));
    }
}
