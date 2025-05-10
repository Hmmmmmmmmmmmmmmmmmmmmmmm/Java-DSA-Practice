import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortingKK {
    public static int findDuplicate(int[] arr) {
        int i = 0;
        while (i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[correctIndex]!=arr[i]){
                swap(arr,i,correctIndex);
            }else {
                return arr[i];
            }
        }return -1;
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    static void sort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]==arr.length){
                i++;
            }else if(arr[i]!=arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }
    int missingElement(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i]<arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]!=index){
                return index;
            }
        }  return arr.length;
    }
    static List<Integer> findDisappearedNumbers(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean unequal=false;
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]!= index+1){
                list.add(index+1);
            }
        }
        return list;
    }
    //official Cyclic sort:
    public static void CyclicSort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap2(arr, i, correct);
            }else{
                i++;
            }
        }
    }
    static void swap2(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    public static void main(String[] args) {
        System.out.println("mew");
        int[] arr = {1,1,2};
        System.out.println(findDuplicate(arr));
//        System.out.println(Arrays.toString(arr));
//        CyclicSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(findDisappearedNumbers(arr));

    }
}
