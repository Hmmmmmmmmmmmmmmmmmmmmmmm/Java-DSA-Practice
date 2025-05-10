package com.LL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision {

    static void max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Max is: "+max);
    }
    
    static int[] reverse(int[] arr){
        int len = arr.length;
        int[] rev = new int[len];
        for(int i = len-1; i>=0 ; i--) {
            System.out.println("Length: " +len +
                                " len - 1 "+(len-1) +
                                "len -1 -i: "+(len- 1 -i)+
                                " i: "+i);
            System.out.println("rev["+(len-1-i)+"]="+"arr["+i+"]");
            rev[len-i-1]=arr[i];
        }
        return rev;
    }

    static int linearSearch(int[] arr, int key){
        if(arr.length==0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key){
                return i;
            }
        }return -1;
    }

    static int stringSearch(String str,char key){
        if(str.isEmpty()){
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==key) {
                return i;
            }
        }return -1;
    }
    
    static int min(int[] arr){
        if(arr.length==0){
            return -1;
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    static int[] linearSearch2D(int[][] matrix, int key){
        if(matrix.length==0){
            return new int[]{-1,-1};
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==key){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    static int binarySearch(int[] arr, int key){
        if(arr.length==0) return -1;
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]==key) return m;
            if(arr[m]>key) e=m-1;
            else s=m+1;
        }
        return -1;
    }

    static int binarySearchCelling(int[] arr, int key){
        if(key>arr[arr.length-1]) return -1;
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]==key) return m;
            if(arr[m]>key) e=m-1;
            else s=m+1;
        }
        if(e<arr.length-1){
            System.out.println("pew "+arr[s]+" i.e., "+s+"th index");
            return s;
        }else{
            return -1;
        }
    }

    static int[] fal(int[] arr, int target){
        int[] ans = {-1,-1};
        int start = binSearch(arr, target, true);
        int end = binSearch(arr, target, false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }

    private static int binSearch(int[] arr, int target, boolean findS) {
        int s = 0;
        int e = arr.length-1;
        int ans = -1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]>target){
                e=m-1;
            }else if(arr[m]<target){
                s=m+1;
            }else{
                ans = m;
                if(findS) e=m-1;
                else s=m+1;
            }
        }
        return ans;
    }

    static int peak(int[] arr){
        int s = 0;
        int e = arr.length-1;
        int peak = 0;
        while (s<e){
            int m = s+(e-s)/2;
            if(arr[m]>arr[m+1]){
                e=m;
            } else{
                s=m+1;
            }
        }
        return s;
    }

    static int MountainPeak(int[] arr){
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            int m = s+(e-s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }

    static int binSearchMountain(int[] arr, int target){
        int peak = MountainPeak(arr);
        int asc =0;
        int dec =0;
        if(peak!=arr.length-1){
            asc = binSearchSE(arr, target,0,peak);
            dec = binSearchSE(arr, target,peak,arr.length-1);
        }else{
            return binSearchSE(arr, target,0,arr.length-1);
        }
        return Math.min(asc,dec);
    }

    private static int binSearchSE(int[] arr, int target, int s, int e) {
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]>target){
                e=m-1;
            }else if(arr[m]<target){
                s=m+1;
            }else{
                return m;
            }
        }
        return -1;
    }

    static int rotatedBinSearch(int[] arr,int target){
        int pivot = pivot(arr);
        if(pivot==-1){
            return binSearchSE(arr,target,0,arr.length-1);
        }else{
            if(arr[pivot]==target) return pivot;
            else if(arr[0]<=target) return binSearchSE(arr, target, 0, pivot);
            else return binSearchSE(arr, target,pivot+1,arr.length-1);
        }
    }
    static int pivot(int[] arr){int s = 0;
        int e = arr.length-1;
        while(s<e){
            int m = s+(e-s)/2;
            if(m<e && arr[m]>arr[m+1]) return m;
            if(m>s && arr[m-1]>arr[m]) return m-1;
            if(arr[s]>arr[m]) e=m-1;
            else if(arr[s]<arr[m]) s=m+1;
        }
        return -1;
    }
    //IMP as in tough
    static int pivotDup(int[] arr){int s = 0;
        int e = arr.length-1;
        while(s<e){
            int m = s+(e-s)/2;
            if(m<e && arr[m]>arr[m+1]) return m;
            if(m>s && arr[m-1]>arr[m]) return m-1;
            if(arr[s]==arr[m] && arr[e]==arr[m]){//mid start end all equal
                while(arr[s]==arr[e]){
                    if(arr[s]>arr[s+1]){
                        return s;
                    }
                    s++;
                    if(arr[e]<arr[e-1]){
                        return e-1;
                    }
                    e--;
                }
            }
            else if(arr[s]<arr[m]||(arr[m]==arr[s] && arr[m]>arr[e])){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return -1;
    }

    public int splitArray(int[] arr, int k) {
        int s = arr[0];
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>s){
                s = arr[i];
            }
            e = e +arr[i];
        }
        //we got start and end
        while(s<e){
            int m = s + (e-s)/2;
            int sum=0;
            int pieces = 1;
            for (int i = 0; i < arr.length; i++) {
                if(sum+arr[i]>m){
                    pieces++;
                    sum = arr[i];
                }else{
                    sum+=arr[i];
                }
            }
            if(k>=pieces){
                e=m;
            }else{
                s=m+1;
            }
        }
        return e;
    }

    static void print2DA(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    static int[] binSearch2D(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length-1;
        while (r< matrix.length && c>=0){
            if(matrix[r][c]==target) return new int[]{r,c};
            if(matrix[r][c]>target) c--;
            else r++;
        }
        return new int[]{-1,-1};
    }

    static int[] binSearch2DSorted(int[][] matrix, int target){
       int s = 0;
       int e = matrix.length-1;
       int temp = 0;
       while(s<=e){
           int m = s+(e-s)/2;
           if(matrix[m][temp]==target){
               return new int[]{m,temp};
           }
           if(matrix[m][temp]>target){
               e=m-1;
           }else{
               s=m+1;
           }
       }
       //we got floor number for out matrix
        //i.e., row in which it could be
        //now we put BS on that fuckin row!
        int rowNumber = e;//end pointer at floor
        int startOfTheRow = 0;
        int endOfTheRow = matrix[rowNumber].length-1;
        while(startOfTheRow<=endOfTheRow){
            int m = startOfTheRow+(endOfTheRow-startOfTheRow)/2;
            if(matrix[rowNumber][m]==target){
                return new int[]{rowNumber,m};
            }if(matrix[rowNumber][m]>target){
                endOfTheRow=m-1;
            }else{
                startOfTheRow=m+1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] binSearch2DFlattened(int[][] matrix, int target) {
        // Step 1: Get number of rows and columns
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 2: Set up binary search on the "virtual" 1D version of the matrix
        int start = 0;
        int end = rows * cols - 1;  // Total number of elements - 1

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Step 3: Map the 1D index back to 2D indices
            int row = mid / cols;       // Row number in 2D
            int col = mid % cols;       // Column number in 2D

            int midValue = matrix[row][col];  // Actual value at that position

            // Step 4: Standard binary search comparison
            if (midValue == target) {
                return new int[]{row, col};  // Found target
            } else if (midValue < target) {
                start = mid + 1;  // Move right
            } else {
                end = mid - 1;    // Move left
            }
        }

        // Step 5: Target not found
        return new int[]{-1, -1};
    }

   public static int mySqrt(int x) {
//        int e = x/2;
//        int s = x/1000;
//        while(e >= s){
//            System.out.println("Lower: "+ s);
//            System.out.println("Upper: "+ e);
//            int mid = s + (e - s)/2;
//            System.out.println("Mid: "+mid);
//            System.out.println("Mid*Mid: "+mid*mid);
//            if((mid*mid)==x){
//                return mid;
//            }if((mid*mid)>x){
//               e=mid-1;
//            }else{
//                s=mid+1;
//            }
//        }
       int ans=1;
       while(ans*ans!=x){
           System.out.println(ans + "ans*ans"+ ans*ans + "x" +x);
           if(ans*ans>x){
               return ans-1;
           }
           else{
               ans++;
           }
       }
       return (x<2)?x:ans;
    }


    public static int mySqrt2(int x) {
        if(x<100){
            int ans=1;
            while(ans*ans!=x){
                System.out.println(ans + "ans*ans"+ ans*ans + "x" +x);
                if(ans*ans>x){
                    return ans-1;
                }
                else{
                    ans++;
                }
            }
            return (x<2)?x:ans;
        }
        else{
            double e = x/2;
            double s = 0;
            while(e >= s){
                double mid = s + (e - s)/2;
                if((mid*mid)==x){
                    return (int)mid;
                }if((mid*mid)>x){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
            return (int)s;
        }
    }

    public static double mySqrt3(int x) {
        if(x<100){
            int ans=1;
            while(ans*ans!=x){
                System.out.println(ans + "ans*ans"+ ans*ans + "x" +x);
                if(ans*ans>x){
                    return ans-1;
                }
                else{
                    ans++;
                }
            }
            return (x<2)?x:ans;
        }
        else{
            double e = (double) x /2;
            double s =  1;
            while(e >= s){
                double mid = (double)( s +  (double)(e - s)/2);
                if((mid*mid)==x){
                    return mid;
                }if((mid*mid)>x){
                    e= (double)mid-1;
                }else{
                    s= (double)mid+1;
                }
            }
            return (double)s;
        }
    }

    //167
    public static int[] twoSum(int[] arr, int target) {
        int[] ans = {-1,-1};
        for (int i = 0; i < arr.length; i++) {
            int sec = target - arr[i];
            int there = binarySearch(arr,sec);
            if(there!=-1&&there!=i){
                return ((i+1)>(there+1))?new int[]{there+1,i+1}:new int[]{i+1,there+1};
            }
        }
        return ans;
    }
    static int sum(int n){
        return (int)n*(n+1)/2;
    }
    public static int arrange(int n){
        if(n<=1){
            return n;
        }
        int max_step_size;//
        if(n%2==0){
            max_step_size = n/2;
        }
        else{
            max_step_size = (int) (double) (n / 2);
        }
        if(n==sum(max_step_size)) return max_step_size;
        int total_coins = sum(max_step_size);//to fill the stairs completely
        int s = 1;
        int e = max_step_size;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(n==sum(mid)) return mid;
            if((n<sum(mid))&&(mid>1&&total_coins>=sum(mid-1))){
                return mid-1;
            }
            if(n>sum(mid)){
                //row filled we check ahead\
                s = mid+1;
            }else{
                e=mid-1;
            }
        }
        return e;
    }

    public int singleNonDuplicate(int[] arr) {
        int s = 0;
        int e =arr.length;
        while(s<=e){
            int m = s+(e-s)/2;
            if(m%2==0&&arr[m-1]==arr[m]) e=m-1;
            else if(m%2!=0&&arr[m-1]==arr[m]) s=m+1;
            else if(m%2==0&&arr[m-1]!=arr[m]) e=m-1;
            else if(m%2!=0&&arr[m-1]!=arr[m]) s=m+1;
        }
        return arr[s];
    }
    //sorting
    static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void bubbleSort(int arr[]){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    static void selectionSort(int arr[]){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int lastElement = arr.length-i-1;
            max = maxElement(arr,lastElement);
            swap(arr,lastElement,max);
        }
    }
    static int maxElement(int[] arr,int end){
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }


    //insertion sort
    static void insertionSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    //cyclic sort
    static void cyclicSort(int[] arr){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
    }


    static int missingNo268(int arr[]){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=i&&arr[i]<arr.length){
                swap(arr,i,arr[i]);
            }else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j){
                return j;
            }
        }
        return -1;
    }

    static ArrayList<Integer> findAllMissingNo448(int[] arr){
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<arr.length){
            if(arr[i]!=i+1&&arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j+1){
               ans.add(j+1);
            }
        }
        return ans;
    }
    static int duplicateNum287(int[] arr){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=i+1&&arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
        return arr[arr.length-1];
    }

    static int duplicateNum287re(int[] arr){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                if(arr[i]==arr[arr[i]-1]){
                    return arr[i];
                }
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
        return arr[arr.length-1];
    }

    static ArrayList<Integer> duplicateNumArray442(int[] arr){
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<arr.length){
            if(arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j+1) ans.add(arr[j]);
        }
        return ans;
    }

    static int[] setMismatch645(int[] arr){
        int i = 0;
        while(i<arr.length){
            if(arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j+1){
                return new int[]{arr[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }


    //recursion
    static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    static int binSearch(int[] arr, int target,int s,int e){
        int mid = s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }if(arr[mid]>target) return binSearch(arr,target,s,mid-1);
        else return binSearch(arr, target, mid+1,e);
    }

    static int fact(int n){
        if(n<=1){
            return 1;
        }return n*fact(n-1);
    }

    static int prodDigits(int n){
        if(n%10==n){
            return n;
        }return n%10 * prodDigits(n/10);
    }

    static int revNumber(int n,int rev){
        if(n==0){
            return rev;
        }return revNumber(n/10,(n%10)+rev*10);
    }

    static int rev(int n){
        int tDig = (int)(Math.log10(n))+1;
        return revNumber2(n,tDig);
    }

    static int revNumber2(int n,int tDig){
        if(n%10==n){
            return n;
        }return (n%10) * (int)Math.pow(10,tDig-1) + revNumber2(n/10,tDig-1);
    }

    static int countZero(int n){
        int count=0;
        return helperCountZero(n,count);
    }

    private static int helperCountZero(int n, int count) {
        if(n==0){
            return count;
        }if(n%10==0) return helperCountZero(n/10,++count);
        return helperCountZero(n/10,count);
    }

    static boolean isSorted(int[] arr){
        return helperIsSorted(arr, 0);
    }

    private static boolean helperIsSorted(int[] arr, int i) {
        if(arr[i]>arr[i+1]) return false;
        return i >= (arr.length - 2) || helperIsSorted(arr, ++i);
    }
    //kk:
    private static boolean helperIsSorted2(int[] arr, int i) {
        if(i > (arr.length - 1) ) return false;
        return arr[i]<arr[i+1] && helperIsSorted2(arr, ++i);
    }

    static int LinSearchRec(int[] arr, int target){
        return helperLinearSearch(arr,target,0);
    }

    private static int helperLinearSearch(int[] arr, int target, int i) {
        if(i==arr.length) return -1;
        if(arr[i]==target) return i;
        return helperLinearSearch(arr,target,++i);
    }

    static ArrayList<Integer> LinSearchRec2(int[] arr, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        return helperLinearSearch2(arr,target,0,ans);
    }
    private static ArrayList<Integer> helperLinearSearch2(int[] arr, int target, int i,ArrayList<Integer> ans){
        if(i==arr.length) return ans;
        if(arr[i]==target) ans.add(i);
        return helperLinearSearch2(arr,target,++i,ans);
    }

    static int rotatedBinSearch(int[] arr, int target, int s, int e){
        if(s>e) return -1;
        int m = s+(e-s)/2;
        if(arr[m]==target)return m;
        //checking left side sorted or not?
        if(arr[m]>arr[s]){
            if(target>=arr[s]&&target<=arr[m]) return rotatedBinSearch(arr, target,s,m-1);
            else return rotatedBinSearch(arr, target, m+1,e);
        }if(target>=arr[m]&&target<=arr[e]){
            return rotatedBinSearch(arr, target, m+1,e);
        }return rotatedBinSearch(arr, target, s,m-1);
    }

    //patter + recursion

    static void triangle(int r, int c){
        if(r==0){
            return;
        }if(r>c){
            triangle(r,++c);
            System.out.print('*');
        }else{
            triangle(--r,0);
            System.out.println();
        }
    }
    static void triangleInverted(int r, int c){
        if(r==0){
            return;
        }if(r>c){
            System.out.print('*');
            triangleInverted(r,++c);
        }else{
            System.out.println();
            triangleInverted(--r,0);
        }
    }

    //bubble sort
    static void bubble(int[] arr, int r, int c){
        if(r==0){
            return;
        }if(r>c){
            //swap
            if(arr[c]>arr[c+1]) swap(arr,c,c+1);
            bubble(arr,r,++c);
        }else{
            System.out.println();
            bubble(arr,--r,0);
        }
    }


    //Merge Sort
    //original array remains same:
    static int[] MergeSort(int[] arr){
        //base condition
        if(arr.length==1) return arr;
        int mid = arr.length/2;
        //dividing in 2
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mergedArray = new int[left.length+right.length];

        while(i<left.length&&j< right.length){
            if(left[i]<right[j]) mergedArray[k++]=left[i++];
            else mergedArray[k++]=right[j++];
        }
        while (i<left.length&&j== right.length) mergedArray[k++]=left[i++];
        while (j<right.length&& i == left.length) mergedArray[k++]=right[j++];

        return mergedArray;
    }

    //quick Sort
    static void quickSort(int[] arr){
        helperQuickSort(arr,0,arr.length-1);
    }

    private static void helperQuickSort(int[] arr, int lower, int higher) {
        //lower is smaller side of pivot pointer aka left of pivot
        //higher is larger side of pivot pointer aka right of pivot
        if(lower>=higher) return;
        int s = lower;
        int e = higher;
        int m = s+(e-s)/2;
        int pivot = arr[m];

        while(s<=e){
            //we move pointers ahead if elements at right place
            while(arr[s]<pivot) s++;
            while(arr[e]>pivot) e--;
            if(s<=e){
                //swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        //now pivot at right place
        //sort 2 halves:
        helperQuickSort(arr,lower,e);
        helperQuickSort(arr,s,higher);
    }

    //recursion + string/subset/subsequence

    static String removeChar(String str, char ch){
        StringBuilder sb = new StringBuilder();
        if(str.isEmpty()) return sb.toString();
        if(str.charAt(0)!=ch) sb.append(str.charAt(0));
        return sb + removeChar(str.substring(1),ch);
    }
    static String removeChar2(String str, char ch, StringBuilder ans){
        if(str.isEmpty()) return ans.toString();
        if(str.charAt(0)!=ch) ans.append(str.charAt(0));
        return removeChar2(str.substring(1),ch,ans);
    }

    //subsets:
    static void subsets(String sub, String str){
        if(str.isEmpty()){
            System.out.println(sub);
            return;
        };
        subsets(sub+str.charAt(0),str.substring(1));
        subsets(sub,str.substring(1));
    }

    static ArrayList<String> subsets2(String p, String up, ArrayList<String> ans){
        if(up.isEmpty()){
            System.out.println(p);
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
//        ArrayList<String> left = subsets2(p+ch,up.substring(1),ans);
//        ArrayList<String> right = subsets2(p,up.substring(1),ans);
//        left.addAll(right);
//        return left;
        subsets2(p+ch,up.substring(1),ans);
        subsets2(p,up.substring(1),ans);

        return ans;
    }



    //fucking recurrsion to iteration move biacthahsfkjhlcngqwqwqwqwqws
    //tetoetoeoteotoet
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }


    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int n = p.length();
        char ch = up.charAt(0);
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutation(f+ch+s,up.substring(1));
        }
    }

    static ArrayList<String> permutation2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            System.out.println(p);
            return ans;
        }
        int n = p.length();
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutation2(f+ch+s,up.substring(1)));
        }
        return ans;
    }

    static int permutation2Count(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int n = p.length();
        char ch = up.charAt(0);
        int c = 0;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            c = c + permutation2Count(f+ch+s,up.substring(1));
        }
        return c;
    }

    static void diePlease(String p,int up){
        if(up==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6&&i<=up; i++) {
            diePlease(p+i,up-i);
        }

    }

    static ArrayList<String> diePleasePlease(String p,int up){
        if(up==0){
            ArrayList<String> ans = new ArrayList<>();
            System.out.println(p);
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6&&i<=up; i++) {
            ans.addAll(diePleasePlease(p+i,up-i));
        }
        return ans;
    }

    static int MazeSolCount(int r, int c){
        if(r==1||c==1){
            return 1;
        }
        int right = MazeSolCount(r-1,c);
        int down = MazeSolCount(r,c-1);
        return right + down;
    }

    static void MazeSolPath(String p, int r, int c){
        if(r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r>1)MazeSolPath(p+'D',r-1,c);
        if(c>1)MazeSolPath(p+'R',r,c-1);
    }
    static ArrayList<String> Path(String p, int r, int c){
        if(r==1&&c==1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1){
            ans.addAll(Path(p+'D',r-1,c));
        }
        if(c>1){
            ans.addAll(Path(p+'R',r,c-1));
        }
        return ans;
    }
    static ArrayList<String> Path2(String p, int r, int c){
        if(r==1&&c==1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1){
            ans.addAll(Path2(p+'D',r-1,c));
        }
        if(c>1){
            ans.addAll(Path2(p+'R',r,c-1));
        }
        if(c>1&&r>1){
            ans.addAll(Path2(p+'d',r-1,c-1));
        }
        return ans;
    }


    static ArrayList<String> PathObstructions(boolean[][] maze, String p, int r, int c){
        if(r== maze.length-1&&c==maze[0].length-1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[r][c]) return ans;
        if(r < maze.length-1){
            ans.addAll(PathObstructions(maze,p+'D',r+1,c));
        }
        if(c < maze[0].length-1){
            ans.addAll(PathObstructions(maze,p+'R',r,c+1));
        }
        if(c < maze[0].length-1&&r < maze.length-1){
            ans.addAll(PathObstructions(maze,p+'d',r+1,c+1));
        }
        return ans;
    }
    static ArrayList<String> AllPaths(boolean[][] maze, String p, int r, int c){
        if(r== maze.length-1&&c==maze[0].length-1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[r][c]) return ans;

        //now we are setting/marking this block as marked!
        maze[r][c]=false;
        if(r < maze.length-1){
            ans.addAll(AllPaths(maze,p+'D',r+1,c));
        }
        if(r > 0){
            ans.addAll(AllPaths(maze,p+'D',r-1,c));
        }
        if(c < maze[0].length-1){
            ans.addAll(AllPaths(maze,p+'R',r,c+1));
        }
        if(c > 0){
            ans.addAll(AllPaths(maze,p+'L',r,c-1));
        }
        //now we done with our stuff we turn it back to as it was:
        //since here the function will be over
        //we make it correct
        maze[r][c]=true;

        //diagonal
//        if(c < maze[0].length-1&&r < maze.length-1){
//            ans.addAll(AllPaths(maze,p+'d',r+1,c+1));
//        }
        return ans;
    }





    public static void main(String[] args) {
        System.out.println("Pew");
        int[] mew = {1,2,3,4};
        System.out.println(mew);
        max(mew);
        System.out.println(Arrays.toString(reverse(mew)));
        System.out.println(linearSearch(mew, 1));
        System.out.println(stringSearch("HelloNigga",'a'));
        System.out.println(min(mew));
        int[][] matrix = {{1,2,3},{4,5,6,100},{7,8,9}};
        System.out.println(Arrays.toString(linearSearch2D(matrix,5)));
        System.out.println("Binary search: "+binarySearch(mew,111));
        System.out.println((int)'a');
        char[] arr1 = {'c','d','e'};

        int[] arr = {2,3,5,9,14,16};
        System.out.println(Arrays.toString(arr));
        System.out.println("Celling: "+binarySearchCelling(arr,150));
        int[] arr3 = {1,2,3,4,5,3,1};
        System.out.println("ma "+binSearchMountain(arr3,3));
        int[] arr4 = {4,5,6,7,0,1,2};
        System.out.println("rbs "+rotatedBinSearch(arr4,0));
        System.out.println("rbs "+pivotDup(arr4));
        int[][] matrix1 = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49,},
                {33,34,38,50}};
        print2DA(matrix1);
        System.out.println(Arrays.toString(binSearch2D(matrix1,15)));
        int[][] matrixSorted = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println("mew "+Arrays.toString(binSearch2DSorted(matrixSorted,12)));


        System.out.println("LeetCode69: "+mySqrt3(2147483647));

        System.out.println(Arrays.toString(twoSum(new int[]{0,0,3,4},0)));


            System.out.println(Math.pow(100,0.5)==(int)Math.pow(100,0.5));
            System.out.println(Math.ceil(2.5));
            System.out.println(arrange(8));
            int max_step_size = (int) Math.ceil((double) 3 / 2);

        System.out.println(max_step_size);


        int[] arr2 = {5,2,3,4,1};
        System.out.println("Bubble Sort");
        System.out.println("Unsorted array: "+Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("Sorted array: "+Arrays.toString(arr2));

        int[] arr5 = {5,2,3,4,1};
        System.out.println("Selection Sort");
        System.out.println("Unsorted array: "+Arrays.toString(arr5));
        selectionSort(arr5);
        System.out.println("Sorted array: "+Arrays.toString(arr5));

        int[] arr6 = {5,2,3,4,1};
        System.out.println("Insertion Sort");
        System.out.println("Unsorted array: "+Arrays.toString(arr6));
        insertionSort(arr6);
        System.out.println("Sorted array: "+Arrays.toString(arr6));

        int[] arr7 = {5,2,3,4,1};
        System.out.println("Cyclic Sort");
        System.out.println("Unsorted array: "+Arrays.toString(arr7));
        cyclicSort(arr7);
        System.out.println("Sorted array: "+Arrays.toString(arr7));

        int[] arr8 = {9,6,4,2,3,5,7,0,1};
        System.out.println("268: "+missingNo268(arr8));

        int[] arr9 = {4,3,2,7,8,2,3,1};
        System.out.println("448: "+findAllMissingNo448(arr9));

        int[] arr10 = {1,2,3,4,2,5};
        System.out.println("448: "+duplicateNum287(arr10));

        int[] arr11 = {4,3,2,7,8,2,3,1};
        System.out.println("448: "+duplicateNumArray442(arr11));

        int[] arr12 = {1,1};
        System.out.println("645: "+ Arrays.toString(setMismatch645(arr12)));

        System.out.println(fib(10));
        System.out.println("Recursion BS: "+binSearch(new int[]{1,2,3,4,5}, 2,0,arr.length-1));
        System.out.println("Fact: "+fact(5));
        System.out.println("prod: "+prodDigits(522));
        System.out.println("rev: "+revNumber(123213,0));
        System.out.println("rev: "+rev(123213));
        System.out.println("Zero's: "+countZero(102020));

        int[] arr13 = {9,1,1,2,3};
        System.out.println(Arrays.toString(arr13)+" is sorted?: "+isSorted(arr13));
        System.out.println("Lin Search: "+LinSearchRec(arr13,1));
        System.out.println("Lin Search: "+(LinSearchRec2(arr13,1)));

        triangle(4,0);
        System.out.println();
        triangleInverted(4,0);

        bubble(arr13,arr13.length-1,0);
        System.out.println(Arrays.toString(arr13));
        int[] arr14 = {6,5,4,3,87,1,23,0};
        System.out.println("Unsorted Array: "+Arrays.toString(arr14));
//        System.out.println(Arrays.toString(MergeSort(arr14)));
        //correct way:
        arr14=MergeSort(arr14);
        System.out.println("Sorted Array: "+Arrays.toString(arr14));
        System.out.println("Now");
        int[] arr15 = {6,5,4,3,87,1,23,0};
        quickSort(arr15);
        System.out.println(Arrays.toString(arr15));

        System.out.println(removeChar("baccab",'a'));
        System.out.println(removeChar2("baccab",'a',new StringBuilder()));

        subsets("","abc");
        ArrayList<String> ans = new ArrayList<>();
        System.out.println(subsets2("","abc",ans));
        ArrayList<String> result = subsets2("", "abc", new ArrayList<>());
        String[] sorted = result.toArray(new String[0]);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println("PewPew");
        System.out.print("[");
        List<List<Integer>> ans2 = subset(new int[]{1,2,3});
        for (List<Integer> list: ans2) {
            System.out.print(list+",");
        }
        System.out.print("]");

        System.out.println("Permutation");
        permutation("","abc");
        System.out.println(permutation2("","abc"));
        System.out.println(permutation2Count("","abc"));
        int digit = "1".charAt(0)-'0';
        System.out.println(digit);
        System.out.println();
        diePlease("",4);
        System.out.println(diePleasePlease("",4));

        System.out.println(MazeSolCount(3,3));
        MazeSolPath("",3,3);
        System.out.println(Path("",3,3));



        System.out.println(Path2("",3,3));
        boolean[][] maze1 = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        System.out.println(PathObstructions(maze1,"",0,0));

        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(PathObstructions(maze,"",0,0));

        System.out.println(AllPaths(maze1,"",0,0));

    }
}
