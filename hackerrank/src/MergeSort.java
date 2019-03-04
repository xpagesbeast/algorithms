import java.util.Arrays;

public class MergeSort
{
   private static int counter = 0;
   private static int arraySize = 2;

   public static void main(String[] args)
   {
      System.out.println("Started...");
      int[] ar = new int[arraySize];
      for( int i=0; i<arraySize; i++ )
      {
         ar[i] = (int)(Math.random()*arraySize*10+1);
      }
      System.out.println( Arrays.toString(ar) );
      if( isSorted(ar) ) 
      {
         System.out.println("Array is sorted!");
      }
      else
      {
         System.out.println("Array is not sorted!");
      }
      ar = mergeSort(ar);
      System.out.println( Arrays.toString(ar) );
      if( isSorted(ar) ) 
      {
         System.out.println("Array is sorted!");
      }
      else
      {
         System.out.println("Array is not sorted!");
      }
      System.out.println("...completed");
   }
   /* WRITE THIS METHOD! */
   public static boolean isSorted(int[] A)
   {

      boolean pass = true;
      /* true if sorted, false otherwise */
      for(int i=0; i<A.length; i++){
         if((i+1) < A.length) {
            if (A[i + 1] < A[i]) {
               pass = false;
            }
         }
      }
      return pass;
   }
   public static int[] mergeSort(int[] A)
   {
      counter ++;
      System.out.println(counter + ") mergeSort entry " + A.length);

      /* our stopping condition - no recursion */
      if( A.length <= 1 )
      {
         System.out.println(counter + ") Exit condition returning " + Arrays.toString(A));
         return A;
      }   
      /* split A into 2 halves */
      int mid = (A.length/2);
      int[] B = new int[mid];
      int[] C = new int[A.length - mid];
      /* fill array b*/
      for( int i=0; i<mid; i++ )
      {
         B[i] = A[i];
      }
      for(int i=0;i<(A.length-mid);i++){
         C[i] = A[i+mid];
      }
      System.out.println(counter + ") Array Left " + B.length + " " + Arrays.toString(B)) ;
      System.out.println(counter + ") Array Right " + C.length + " " + Arrays.toString(C));

      B = mergeSort(B);
      C = mergeSort(C);
      /* merge the 2 sorted arrays back together */      
      A = merge(B, C);
      System.out.println(counter + ") returning " + A.length + " " + Arrays.toString(A));
      return A;
   }
   /* WRITE THIS METHOD!  
      I erased the code we did in class.. */
   public static int[] merge(int[] X, int[] Y)
   {
     // System.out.println(counter + ") merging X (size:'" + X.length + "') "+Arrays.toString(X) + ", Y (size:'" + Y.length + "') " + Arrays.toString(Y));
      int indexX = 0;
      int indexY = 0;

      int[] temp = new int[X.length + Y.length];
      for(int i = 0; i<temp.length; i++){

         if(indexX >= X.length){
            temp[i] = Y[indexY];
            indexY++;
         }else if(indexY >= Y.length){
            temp[i] = X[indexX];
            indexX++;
         }else  if(X[indexX] <= Y[indexY]){
            temp[i] = X[indexX];
            indexX++;
         }else{
            temp[i] = Y[indexY];
            indexY++;
         }
      }
      //System.out.println(counter + ") returning (size:'" + temp.length + "') "+Arrays.toString(temp));
      return temp; 
   } 
}