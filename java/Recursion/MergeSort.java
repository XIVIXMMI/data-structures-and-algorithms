package Recursion;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 9, -1, 6, 5, 3, 7};
        mergeSort(arr,0, arr.length - 1);
        for( int temp : arr){
            System.out.print(temp + " ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort( arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        //build a temp array to avoid modifying the original array
        int[] tempArr = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        //While both sub-array have value, then try to merge them in sorted order
        while (i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                tempArr[k++] = arr[i++];
            }else {
                tempArr[k++] = arr[j++];
            }
        }

        //Add the rest of the value from the left sub-array into result
        while (i <= mid){
            tempArr[k++] = arr[i++];
        }

        //Add the rest of the value from the right sub-array into result
        while (j <= end){
            tempArr[k++] = arr[j++];
        }

        for( i = start; i <= end; i++){
            arr[i] = tempArr[i -start];
        }

    }
}
