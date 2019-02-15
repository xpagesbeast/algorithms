import java.util.Arrays;

public class QuickSort {
    static int[] A = {5,7,3,1,6,8,4,9};
    public static void main(String[] args){

        System.out.println(Arrays.toString(A));
        qsort(A);
       System.out.println(Arrays.toString(A));
    }

    public static void qsort(int[] A){
        qsRec(A,0,A.length-1);
    }

    //next tuesday void mergeSort method
    //integer array, use original instead of creating a new one.

    public static void qsRec(int[] A, int low, int high){
        if(low >= high){
            return ;
        }
        int pivot = partition(A,low,high);
        qsRec(A, low, pivot-1);
        qsRec(A, pivot+1,high);

        int temp = A[low];
        A[low] = A[pivot];
        A[pivot] = temp;
    }

    public static int partition(int[] A, int low, int high){
        int pivot = low;
        int start = low;
        int end = high;

        for(int i=start+1; i<=high;i++){
            if(A[low]> A[i]){
                pivot++;
                int temp = A[i];
                A[i] = A[pivot];
                A[pivot] = temp;
            }
        }
        int temp = A[low];
        A[low] = A[pivot];
        A[pivot] = temp;

        return pivot;
    }

    private static void swap(int first, int second, int[] A){
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;
    }
}
