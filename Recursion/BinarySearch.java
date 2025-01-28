package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {-1,0,1,2,3,4,5,6,7,8,};
        int result = binarySearch(A,0,10,7);
        System.out.println(result);
    }
    public static int binarySearch(int[] A,int left, int right, int x){
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(x == A[mid]){
            return mid; //
        }

        if(x < A[mid]){
            return binarySearch(A, left, mid -1, x);
        }

        return binarySearch(A, mid + 1, right, x);

    }
}
