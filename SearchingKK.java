public class SearchingKK {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while (start<=end){
            int mid = (start+(end - start)/2);
            if(target>=letters[mid]){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return letters[start % letters.length];
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0] =search(nums, target,true);
        ans[1]=search(nums, target,false);
        return ans;
    }
    public int search(int[] arr, int target, boolean start){
        int s= 0;
        int ans=-1;
        int e = arr.length-1;
        while (s<=e){
            int mid = (s+(e-s)/2);
            if(arr[mid]>target){
                e = mid-1;
            } else if (arr[mid]<target) {
                s=mid+1;
            } else {
                ans = mid;
                if(start){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }return ans;
    }
    public static void main(String[] args) {
        System.out.println("Mew");
    }
}
