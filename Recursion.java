package com.LL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recursion {
        static void print(int n){
            if(n>10){
                System.out.println(n);
                return;
            }
            System.out.println(n);
            print(n+1);
        }
        static void funBoth(int n){
            if(n==0) return;
            System.out.println(n);
            funBoth(n-1);
            System.out.println(n);
        }
        static int fact(int n){
            if(n<2){
                return n;
            }
            return n*fact(n-1);
        }
        static int sumDigit(int n){
            if(n==0){
                return n;
            }
            return n%10+sumDigit(n/10);
        }
        static void reverseNum1(int n){
            if(n/10==0){
                System.out.print(n);
                return;
            }
            System.out.print(n%10);
            reverseNum1(n/10);
        }
        static ArrayList<Integer> reverseNum(int n, ArrayList<Integer> list){
            if(n<10){
                list.add(n);
                return list;
            }
            list.add(n%10);
            reverseNum(n/10,list);
            return list;
        }
        static int revNum(int N){
            ArrayList<Integer> list = reverseNum(N,new ArrayList<Integer>());
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num);
            }
            return Integer.parseInt(sb.toString());
        }
        //retry reverse via GPT:
        static int reverseNumberActual(int n, int reversed){
            if(n==0){
                return reversed;
            }
            return reverseNumberActual(n/10,reversed*10+n%10);
        }
        static int countZero(int n,int count){
            if(n==0){
                return count;
            }
            return countZero(n/10,(n%10==0)?++count:count);
        }
        static double fib(int n){
            if(n<2){
                return (double) n;
            }
            return (double)(fib(n-1)+fib(n-2));
        }
        static double fibbonacci(int n){
            return (long)((1/Math.pow(5,0.5))*(Math.pow((1+Math.pow(5,0.5))/2,n)-Math.pow((1-Math.pow(5,0.5))/2,n)));
        }
        static int bin(int[] arr,int key, int s, int e){
            if(s>e){
                return -1;
            }
            int m = s+(e-s)/2;
            if(arr[m]==key){
                return m;
            }
            if(arr[m]>key){
                return bin(arr, key, s, m-1);
            }else{
                return bin(arr, key, m+1, e);
            }
        }
        static int bin(int[] arr, int k){
            int s = 0;
            int e = arr.length-1;
            while (s<e){
                int m = s+(e-s)/2;
                if(arr[m]==k){
                    return m;
                }
                if(arr[m]>k){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }
            return -1;
        }
        static int linS(int[] arr, int k){
            return linSearchHelper(arr, k, 0);
        }
        private static int linSearchHelper(int[] arr, int k, int index) {
            if(index>arr.length-1){
                return -1;
            }
            if(arr[index]==k){
                return index;
            }
            return linSearchHelper(arr, k, ++index);
        }
        static boolean sorted(int[] arr,int index){
            if(index==arr.length-1){
                return true;
            }
            return (arr[index]<arr[index+1]) && sorted(arr,++index);
        }
        static void reverse90Triangle(int n,int c){
            if(c>=n){
                return;
            }
            for (int i = 0; i < n-c; i++) {
                System.out.print("*");
            }
            System.out.println();
            reverse90Triangle(n,++c);
        }
        static void pattern(int r, int c){
            if(r==0){
                return;
            }
            if(r>c){
                System.out.print("*");
                pattern(r,++c);
            }
            else{
                System.out.println();
                pattern(--r,0);
            }
        }
        static void pattern2(int r, int c){
            if(r==0){
                return;
            }
            if(r>c){
                pattern(r,++c);
                System.out.print("*");

            }
            else if(r==c){
                pattern(--r,0);
                System.out.println();

            }
        }
        static void bubble(int[] arr, int r,int c){
            if(r==0){
                return;
            }
            if(c<r){
                if(arr[c]>arr[c+1]){
                    int temp = arr[c];
                    arr[c]=arr[c+1];
                    arr[c+1]=temp;
                }bubble(arr,r,c+1);
            }else{
                bubble(arr,r-1,0);
            }
        }
        static int[] mergeSort(int[] arr){
            if(arr.length==1){
                return arr;
            }
            int mid = arr.length/2;
            int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
            int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

            return merge(left, right);
        }
        static int[] merge(int[] f, int[] s){
            int[] mix = new int[f.length+s.length];
            int i=0;
            int j=0;
            int k=0;
            while (i<f.length&&j<s.length){
                if(f[i]<s[j]){
                    mix[k]=f[i];
                    i++;
                }else{
                    mix[k]=s[j];
                    j++;
                }k++;
            }
            while(i<f.length){
                mix[k]=f[i];
                i++;
                k++;
            }
            while(j<s.length){
                mix[k]=s[j];
                j++;
                k++;
            }
            return mix;
        }
        static String skipChar(String string, StringBuilder sb, char c, int i){
            if(i==string.length()){
                return sb.toString();
            }
            if(string.charAt(i)!=c){
                sb.append(string.charAt(i));
            }return skipChar(string,sb,c,++i);
        }
        static void skip(String s,String g){
            if(g.isEmpty()){
                System.out.println(s);
                return;
            }
            char ch = g.charAt(0);

            if(ch=='a'){
                skip(s,g.substring(1));
            }else {
                skip(s+ch,g.substring(1));
            }
        }
        static String skip1(String s){
            if(s.isEmpty()){
                return "";
            }
            char ch = s.charAt(0);

            if(ch=='a'){
                return skip1(s.substring(1));
            }else {
                return ch + skip1(s.substring(1));
            }
        }
        static String skipApple(String s){
            if(s.isEmpty()){
                return "";
            }
            if(s.startsWith("apple")){
                return skipApple(s.substring(5));
            }else {
                return s.charAt(0) + skipApple(s.substring(1));
            }
        }
        static String skipAppNotApple(String s){
            if(s.isEmpty()){
                return "";
            }
            if(s.startsWith("app")&&!s.startsWith("apple")){
                return skipAppNotApple(s.substring(3));
            }else {
                return s.charAt(0) + skipAppNotApple(s.substring(1));
            }
        }
        static void subSeq(String p, String up){
            if(up.isEmpty()){
                System.out.println(p);
                return;
            }
            char ch = up.charAt(0);
            subSeq(p+ch,up.substring(1));
            subSeq(p,up.substring(1));
        }
        static ArrayList<String> subSeqReturn(String p, String up){
            ArrayList<String> ans=new ArrayList<>();
            if(up.isEmpty()){
                ans.add(p);
                return ans;
            }
            char ch = up.charAt(0);
            ArrayList<String> left = subSeqReturn(p+ch,up.substring(1));
            ArrayList<String> right = subSeqReturn(p,up.substring(1));
            left.addAll(right);
            Collections.sort(left);
            return left;
        }
        static List<List<Integer>> subSeq(int[] arr){
            List<List<Integer>> outer = new ArrayList<>();
            outer.add(new ArrayList<>());
            for(int num: arr){
                int contains = outer.size();
                for (int i = 0; i < contains; i++) {
                    ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                    inner.add(num);
                    outer.add(inner);
                }
            }
            return outer;
        }
        static List<List<Integer>> subSeqDuplicate(int[] arr){
            Arrays.sort(arr);
            List<List<Integer>> outer = new ArrayList<>();
            outer.add(new ArrayList<>());
            int s= 0; int e =0;
            for(int i =0; i<arr.length;i++){
                s=0;
                if(i>0&&arr[i]==arr[i-1]){
                    s=e+1;
                }
                int contains = outer.size();
                e=contains-1;
                for (int j = s; j < contains; j++) {
                    ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                    inner.add(arr[i]);
                    outer.add(inner);
                }
            }
            return outer;
        }
        static int c =0;
        static void permutation(String p, String up){
            if(up.isEmpty()){
                System.out.println(p);
                c++;
                return;
            }
            char ch = up.charAt(0);
            for (int i = 0; i <= p.length(); i++) {
                String f = p.substring(0,i);
                String s = p.substring(i);
                permutation(f+ch+s,up.substring(1));
            }
        }

        static ArrayList<String> permutationRet(String p, String up){
            if(up.isEmpty()){
                ArrayList<String> potato = new ArrayList<>();
                potato.add(p);
                return potato;
            }
            ArrayList<String> ans = new ArrayList<>();
            char ch = up.charAt(0);
            for (int i = 0; i <= p.length(); i++) {
                String f = p.substring(0,i);
                String s = p.substring(i);
                ans.addAll(permutationRet(f+ch+s,up.substring(1)));
            }
            return ans;
        }


        //    public List<String> letterCombinations(String digits) {
////        char[][] arr = {{},{},{'a','b','c'},{'d','e','f'},
////                {'g','h','i'},{'j','k','l'},{'m','n','o'},
////                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
//        ArrayList<String> potato= new ArrayList<>();
//        pcpc("",digits);
//
//    }
        static ArrayList<String> letterCombinationsHelper(String p, String up){
            if(up.isEmpty()){
                ArrayList<String> potato = new ArrayList<>();
                potato.add(p);
                return potato;
            }
            ArrayList<String> ans = new ArrayList<>();
            char ch = up.charAt(0);
            for (int i = 0; i <= p.length(); i++) {
                String f = p.substring(0,i);
                String s = p.substring(i);
                ans.addAll(permutationRet(f+ch+s,up.substring(1)));
            }
            return ans;
        }
        static ArrayList<String> potato12= new ArrayList<>();
        static void pcpc(String p, String up){
            if(up.isEmpty()){
                System.out.print(p+ " ");
                potato12.add(p);
                System.out.println(potato12);
                return;
            }
            int digit = up.charAt(0)-'0';
//        System.out.println(digit);
            if(digit>=2&&digit<7) {
                for (int i = (digit-2) * 3; i < (digit-1) * 3; i++) {
                    char ch = (char) ('a' + i);
                    pcpc(p + ch, up.substring(1));
                }
            }else if(digit==8){
                for (int i = (digit-2) * 3; i < (digit-1) * 3; i++) {
                    char ch = (char) ('a' + i + 1);
                    pcpc(p + ch, up.substring(1));
                }
            }
            //4 words:
            else if(digit==7){
                for(int i = (digit-2) * 3; i <= (digit-1) * 3; i++){
                    char ch = (char) ('a' + i);
                    pcpc(p + ch, up.substring(1));
                }
            }else if(digit==9){
                for(int i = (digit-2) * 3; i <= (digit-1) * 3; i++){
                    char ch = (char) ('a' + i+1);
                    pcpc(p + ch, up.substring(1));
                }
            }

        }
        static ArrayList<String> pcpc1(String p, String up){
            if(up.isEmpty()){
                ArrayList<String> list = new ArrayList<>();
                System.out.print(p+ " ");
                list.add(p);
                System.out.println(list);
                return list;
            }
            int digit = up.charAt(0)-'0';//we get the asci value of the number via string
            //like '1'-0 gives int 1
            ArrayList<String> ans = new ArrayList<>();
//        System.out.println(digit);
            if(digit>=2&&digit<7) {
                for (int i = (digit-2) * 3; i < (digit-1) * 3; i++) {
                    char ch = (char) ('a' + i);
                    ans.addAll(pcpc1(p + ch, up.substring(1)));
                }
            }else if(digit==8){
                for (int i = (digit-2) * 3; i < (digit-1) * 3; i++) {
                    char ch = (char) ('a' + i + 1);
                    ans.addAll(pcpc1(p + ch, up.substring(1)));
                }
            }
            //4 words:
            else if(digit==7){
                for(int i = (digit-2) * 3; i <= (digit-1) * 3; i++){
                    char ch = (char) ('a' + i);
                    ans.addAll(pcpc1(p + ch, up.substring(1)));
                }
            }else if(digit==9){
                for(int i = (digit-2) * 3; i <= (digit-1) * 3; i++){
                    char ch = (char) ('a' + i+1);
                    ans.addAll(pcpc1(p + ch, up.substring(1)));
                }
            }
            return ans;
        }


        static void dieComb(String p, int target){
            if(target==0){
                System.out.println(p);
                return;
            }
            for (int i = 1; i <= 6 && i <= target; i++) {
                dieComb(p+i,target-i);
            }
        }
        static ArrayList<String> dieComb2(String p, int target){
            if(target==0){
                ArrayList<String> pp = new ArrayList<>();
                pp.add(p);
//            System.out.println(p);
                return pp;
            }
            ArrayList<String> muehehe = new ArrayList<>();
            for (int i = 1; i <= 6 && i <= target; i++) {
                muehehe.addAll(dieComb2(p+i,target-i));
            }
            return muehehe;
        }

        static int mazeCount(int r, int c){
            if(r==1||c==1){
                return 1;
            }
            int left = mazeCount(r-1,c);
            int right = mazeCount(r,c-1);
            return left + right;
        }

        static void mazePath(String p, int r, int c){
            if(r==1&&c==1){
                System.out.println(p);
                return;
            }
            if(r!=1){
                mazePath(p+'D',r-1,c);
            } if (c!=1) {
                mazePath(p+'R',r,c-1);
            }
        }
        static ArrayList<String> mazePathRet(String p, int r, int c){
            if(r==1&&c==1){
                ArrayList<String> ans = new ArrayList<>();
                ans.add(p);
                return ans;
            }
            ArrayList<String> list = new ArrayList<>();
            if(r!=1){
                list.addAll(mazePathRet(p+'D',r-1,c));
            } if (c!=1) {
                list.addAll(mazePathRet(p+'R',r,c-1));
            }
            return list;
        }

        static void mazePath2(String p, int r, int c){
            if(r==1&&c==1){
                System.out.println(p);
                return;
            }
            if(r!=1){
                mazePath2(p+'D',r-1,c);
            } if (c!=1) {
                mazePath2(p+'R',r,c-1);
            }if(r>1&&c>1){
                mazePath2(p+'S',r-1,c-1);
            }
        }

        static void pathRes(String p, boolean[][] maze, int r, int c){
            if(r==maze.length-1&&c==maze[0].length-1){
                System.out.println(p);
                return;
            }
            if(!maze[r][c]){
                return;
            }
            if(r<maze.length-1){
                pathRes(p+'D',maze,r+1,c);
            }if(c<maze[0].length-1){
                pathRes(p+'R',maze,r,c+1);
            }
        }

        static void pathUDLR(String p, boolean[][] maze,int r, int c){
            if(r==maze.length-1&&c==maze[0].length-1){
                System.out.println(p);
                return;
            }
            if(!maze[r][c]){return;}//obstacle check
            //marking the block as visited
            maze[r][c]=false;
            if(r<maze.length-1){
                pathUDLR(p+'D',maze,r+1,c);
            }if(c<maze[0].length-1){
                pathUDLR(p+'R',maze,r,c+1);
            }if(r>0){
                pathUDLR(p+'U',maze,r-1,c);
            }if(c>0){
                pathUDLR(p+'L',maze,r,c-1);
            }
            //returning now so reverting the changes
            //in detail in copy
            maze[r][c]=true;
        }

        static void pathUDLRPrint(String p, boolean[][] maze,int r, int c, int[][] path,int step){
            if(r==maze.length-1&&c==maze[0].length-1){
                path[r][c]=step;
                System.out.println(p);
                for(int[] arr: path){
                    System.out.println(Arrays.toString(arr));
                }
                System.out.println();
                return;
            }
            if(!maze[r][c]){return;}//obstacle check
            //marking the block as visited
            maze[r][c]=false;
            path[r][c]=step;
            if(r<maze.length-1){
                pathUDLRPrint(p+'D',maze,r+1,c,path,step+1);
            }if(c<maze[0].length-1){
                pathUDLRPrint(p+'R',maze,r,c+1,path,step+1);
            }if(r>0){
                pathUDLRPrint(p+'U',maze,r-1,c,path,step+1);
            }if(c>0){
                pathUDLRPrint(p+'L',maze,r,c-1,path,step+1);
            }
            //returning now so reverting the changes
            //in detail in copy
            maze[r][c]=true;
            path[r][c]=0;
        }


        //N-Queens
        static int NQueen(boolean[][] board, int row){
            if(row==board.length){
                displayBoard(board);
                System.out.println();
                return 1;
            }
            int count = 0;
            //now going through each block
            for (int col = 0; col < board.length ; col++) {
                if(isSafeBlock(board,row,col)){
                    board[row][col]=true;
                    count+=NQueen(board,row+1);
//                System.out.println(count);
                    board[row][col]=false;
                }
            }
//        System.out.println(count);
            return count;
        }

        private static boolean isSafeBlock(boolean[][] board, int row, int col) {
            //top
            for (int i = 0; i < row ; i++) {
                if(board[i][col]){
                    return false;
                }
            }

            //left
            int maxLeft = Math.min(row,col);
            for (int i = 1; i <= maxLeft; i++) {
                if(board[row-i][col-i]){
                    return false;
                }
            }
            //right
            int maxRight = Math.min(row,board.length-col-1);
            for (int i = 1; i <= maxRight; i++) {
                if(board[row-i][col+i]){
                    return false;
                }
            }
            return true;
        }

        private static void displayBoard(boolean[][] board) {
            for (boolean[] arr: board){
                for(boolean element: arr){
                    if(element){
                        System.out.print("Q ");
                    }else{
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }

        //leetcode 17
        //Sudoku Solver
        static boolean isSafe(int[][] board, int row, int col, int num){
            //row check:
            for (int i = 0; i < board.length; i++) {
                if(board[row][i]==num){
                    return false;
                }
            }
            //col check
            for (int[] arr: board) {
                if(arr[col]==num){
                    return false;
                }
            }

            //block check:
            //sqrt to get the block size say for 9*9 board we have sqrt as 3 thus 3*3 small blocks
            int sqrt = (int)Math.sqrt(board.length);
            int rowStart = row - row % sqrt;
            int colStart = col - col % sqrt;

            for (int r = rowStart ; r < rowStart + sqrt; r++) {
                for (int c = colStart; c < colStart+sqrt; c++) {
                    if(board[r][c]==num){
                        return false;
                    }
                }
            }
            //no match found:
            //we can add the num here
            return true;
        }
        static boolean solve(int[][] board){
            int n = board.length;
            int row = -1;
            int col = -1;
            boolean emptyLeft = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]==0){
                        row = i;
                        col = j;
                        emptyLeft=false;
                        break;
                    }
                }//DOUBT
                if(emptyLeft==false){
                    break;
                }
            }if(emptyLeft==true){
                return true;
                //sudoku solved
            }
            for (int number = 1; number <= 9 ; number++) {
                if(isSafe(board,row,col,number)){
                    board[row][col]=number;
                    // Recursive call - try to solve the rest of the board
                    if(solve(board)){
                        // found a valid configuration, bubble up success
                        return true;
                        //sudoku solved
                    }else{
                        //backtrack
                        board[row][col]=0;
                    }
                }
            }
            return false;
        }
        static void display2D(int[][] matrix){
            for(int[] arr: matrix){
                System.out.println(Arrays.toString(arr));
            }
        }

        public static void main(String[] args) {
            System.out.println("Mew");
            funBoth(3);
            System.out.println("Factorial: "+fact(5));
            System.out.println(sumDigit(1234911234));
            reverseNum1(1234567);
            System.out.println();
            System.out.println(revNum(1234567));
            System.out.println(reverseNumberActual(1234567,0));
            System.out.println(countZero(1005024800,0));
            System.out.println(countZero(1,0));
            System.out.println("fib: "+fib(5));
            System.out.println("fib: "+fibbonacci(50));
            int[] arr = {1,2,3,4,5,6};
            System.out.println("Binary Search arr");
            System.out.println(bin(arr, 5,0, arr.length-1));
            System.out.println(bin(arr, 5));
            System.out.println(linS(arr, 9));
            System.out.println("is sorted?: "+sorted(new int[]{0,5,9,22},0));
//        reverse90Triangle(5,0);
            pattern(5,0 );
            int[] arr2 = {1,2,3,4,6,0};
            System.out.println(Arrays.toString(arr2));
//        bubble(arr2,arr2.length-1,0);
//        System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(mergeSort(arr2)));
            System.out.println(skipChar("", new StringBuilder(""),'t',0));
            skip("","basd");
            System.out.println(skipAppNotApple("appapplemewappleh"));
            subSeq("","abc");
            System.out.println(subSeqReturn("","abc"));
            List<List<Integer>> ans = subSeq(new int[]{1,2,3});
            System.out.println("Pew:");
            for (List list:ans){
                System.out.print(list+" ");
            }
            List<List<Integer>> ans2 = subSeqDuplicate(new int[]{1,2,2,3});
            System.out.println("\nPeww:");
            for (List list:ans){
                System.out.print(list+" ");
            }
            permutation("","12345");
            System.out.println(c);
            System.out.println(permutationRet("","12"));
            String up = "2";
            int dig = up.charAt(0)-'0';
            System.out.println("dig: "+dig);
            System.out.println("Direct int: "+(int)up.charAt(0));
            System.out.println(dig>7);
            for (int i = (dig-2) * 3; i <= (dig-1) * 3; i++) {
                System.out.println((char)(i+'a'+1));
            }
            System.out.println("mew");
            //leetcode 17
//        System.out.println(ans);
            pcpc("","27");
            System.out.println(potato12);
            System.out.println(dig>=2&&dig<7);
            System.out.println("MEW");
            System.out.println(pcpc1("","29"));
            dieComb("",4);
            System.out.println(dieComb2("",4));
            System.out.println("Maze: "+mazeCount(3,3));
            mazePath("",3,3);
            System.out.println(mazePathRet("",3,3));
            System.out.println("Huh:");
            mazePath2("",3,3);
            boolean[][] maze = {
                    {true,true,true},
                    {true,true,true},
                    {true,true,true}
            };
            System.out.println("meow");
            pathRes("",maze,0,0);
            System.out.println("All paths");
            pathUDLR("",maze,0,0);
            int[][] path = new int[maze.length][maze[0].length];
//        int[][] path = {
//                {0,0,0},
//                {0,0,0},
//                {0,0,0}
//        };
            System.out.println();
            pathUDLRPrint("",maze,0,0,path,1);
            int n=4;
            boolean[][] board = new boolean[n][n];
            System.out.println(Arrays.toString(board));
            System.out.println(NQueen(board,0));
            int[][] sudokuBoard = {
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
            System.out.println("The current board:");
            display2D(sudokuBoard);
            solve(sudokuBoard);
            System.out.println("Solved:");
            display2D(sudokuBoard);
        }



}
