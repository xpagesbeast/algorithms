import java.util.Arrays;

public class FindMaxSum {
    static int maxStartPosition;
    static int maxEndPosition;
    static int maxValue;

    public static void main(String args[]){
        //largest contiguous sum
        final int SIZE =20;
        int[] a = new int[SIZE];
        for(int i=0; i<a.length; i++){
            a[i] = SIZE - (int)(Math.random() * SIZE * 2);
        }

        System.out.println(Arrays.toString((a)));
        System.out.println("largest sum is " + largestSum(a));
        System.out.println("From " + maxStartPosition + " to " + maxEndPosition);
    }

    public static int largestSum(int[] collection){
        int start =0; //start
        int endPos = 0; //end
        int v = 0; //value at position
        int maxVal =collection[0];

        for(start=0; start<collection.length;start++){

            for(endPos=start;endPos<collection.length;endPos++){
                if(start==endPos){
                    v=collection[start];
                }else{
                    v = v + collection[endPos];
                }

                if(v>maxVal){
                    maxVal = v;

                }
            }

        }



        return maxValue;
    }

    public static int ls(int[] A, int s, int e){
        if(s==e){
            return A[s];
        }

        int mid = s+(e-s)/2;
        int vLeft = ls(A,s,mid);
        int vRight = ls(A,mid+1,e);
        int tempLeft = A[mid];
        int sum = A[mid];
        for(int i=mid-1; i>=s; i--){
            if(sum > tempLeft){
                tempLeft = sum;
                sum=sum+A[i];
            }
        }


        int tempRight = A[mid+1];
        for(int i=mid+2; i<=e;i++){

        }
        return sum;
    }

}
