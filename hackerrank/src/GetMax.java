public class GetMax {
    public static void main(String[] args){

        //number of comparisons are 'n'
        //same speed as iterator.

        int[] A = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("method 1: " + getMax(A,0 , A.length - 1));
        System.out.println("method 2: " + getMax2(A,0 , A.length - 1));
    }

    private static int getMax2(int[] A, int low, int high){
        if(low == high){
            //stopping point, one card.
            return A[low];
        }

        int mr = getMax(A,low+1,high);

        return Math.max(mr,A[low]);
    }

    private static int getMax(int[] A, int low, int high){

        if(low == high){
            //stopping point, one card.
            return A[low];
        }

        //divide in half (what if array is odd size)
        int mid = (low+high) / 2; //if 8 / 2 mid = 3
        int left = getMax(A,low,mid);
        int right = getMax(A,mid+1, high);
        return Math.max(left,right);
    }
}
