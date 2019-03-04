import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;

public class Sorts
{
   static int[] sizes = {8, 32, 64, 128, 256, 512, 1024, 2*1024, 4*1024, 8*1024,
         16*1024, 32*1024, 64*1024, 128*1024, 256*1024, 512*1024/*, 1024*1024*/};  
   public static void main(String[] args) throws Exception
   {
      int sIdx = 0;
      long startTime;
      long endTime;
      double time;
      String lastName = "Last Name";
      PrintWriter pw = new PrintWriter(new File(lastName + "_sortTimes.csv"));
      pw.println( "Size, BubbleSort, MergeSort, QuickSort, JavaSort" );
      while( sIdx < sizes.length ) 
      {
         int[] A = new int[sizes[sIdx]];
         int[] B = new int[sizes[sIdx]];  
         int[] C = new int[sizes[sIdx]]; 
         int[] D = new int[sizes[sIdx]]; 
         int[] E = new int[sizes[sIdx]]; 
         for( int i=0; i<A.length; i++ ) 
         {
            A[i] = (int)(Math.random()*sizes[sIdx]*2);
            B[i] = A[i];
            C[i] = A[i];
            D[i] = A[i];
            E[i] = A[i];
         }
         System.out.println();
         System.out.println("--------------------------------------------------");
         System.out.println("Initial Values: ");
         printArray(A);
         pw.print(A.length + ", ");

         System.out.println( "Starting bubble sort ---------------- Size = " + B.length);
         startTime = System.nanoTime();
         bubbleSort(B);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Bubble sort finished - time = " + time + " seconds" );
         pw.print(time + ", ");
         printArray(B);
         System.out.println();

         System.out.println( "Starting merge sort ---------------- Size = " + C.length);
         startTime = System.nanoTime();         
         C = mergeSort(C);         
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Merge sort finished - time = " + time + " seconds.");
         pw.print(time + ", ");
         printArray(C);
         System.out.println();

         System.out.println( "Starting quick sort ---------------- Size = " + D.length);
         startTime = System.nanoTime();
         D = quickSort(D);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "quickSort finished - time = " + time  + " seconds." );
         pw.print(time + ", ");
         printArray(D);
         System.out.println();
         
         System.out.println( "Starting java's Array sort ---------------- Size = " + E.length);
         startTime = System.nanoTime();
         E = javaSort(E);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Java's Array sort finished - time = " + time  + " seconds." );
         pw.println(time);
         printArray(E);
         System.out.println();
         sIdx = sIdx + 1;   
      }
      pw.close();
   }  
   public static void printArray(int[] X)
   {
      System.out.print("[ ");
      int i=0;
      for( ; i<15 && i<X.length; i++ )  
      {
         System.out.print( X[i] + " " );
      }
      if( i < X.length ) System.out.print("... ");
      System.out.println("]");
   }
   
   public static void bubbleSort(int[] A)
   {
      int n = A.length;
      boolean swapped = false;
      for(int j=0; j<n;j++) {
         swapped = false;
         for (int i = 0; i < n; i++) {
            /* if this pair is out of order */
            // System.out.println("A[" + i + "]=" + A[i] + ", A[" + (i+1)+"]");
            if (i + 1 < n) {
               if (A[i] > A[i + 1]) {
                  /* swap them and remember something changed */
                  swap(A, i, i + 1);
                  swapped = true;
               }
            }

            //System.out.println(Arrays.toString(A));
         }
      }
   }

   private static void swap(int[] items, int item1, int item2){
      int temp = items[item1];
      items[item1] = items[item2];
      items[item2] = temp;
   }

   public static int[] mergeSort(int[] X)
   {

     // System.out.println(") mergeSort entry " + X.length);

      /* our stopping condition - no recursion */
      if( X.length <= 1 )
      {
         //System.out.println( ") Exit condition returning " + Arrays.toString(X));
         return X;
      }
      /* split X into 2 halves */
      int mid = (X.length/2);
      int[] B = new int[mid];
      int[] C = new int[X.length - mid];
      /* fill array b*/
      for( int i=0; i<mid; i++ )
      {
         B[i] = X[i];
      }
      for(int i=0;i<(X.length-mid);i++){
         C[i] = X[i+mid];
      }
    //  System.out.println( ") Array Left " + B.length + " " + Arrays.toString(B)) ;
    //  System.out.println( ") Array Right " + C.length + " " + Arrays.toString(C));

      B = mergeSort(B);
      C = mergeSort(C);
      /* merge the 2 sorted arrays back together */
      X = merge(B, C);
    //  System.out.println( ") returning " + X.length + " " + Arrays.toString(X));
      return X;
   }
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
   public static int[] javaSort(int[] X)
   {
      Arrays.sort(X);
      return X;
   }
   public static int[] quickSort(int[] X)
   {
      //quicksort doesn't create a new array
      //  so we need additional params for our 
      //  recursive method - this method is what the user sees
      return quickSort(X, 0, X.length-1);   
   }
   public static int[] quickSort(int[] X, int s, int e)
   {
      if(s > e){
         return X;
      }
      int pivot = partition(X,s,e);
      X =quickSort(X, s, pivot-1);
      X= quickSort(X, pivot+1,e);


      return X;
   }
   private static int partition( int[]X, int s, int e )
   {
      int tmp = X[s];
      while (s < e) {
         while (s < e && X[e] >= tmp) {
            e--;
         }
         X[s] = X[e];
         while (s < e && X[s] <= tmp) {
            s++;
         }
         X[e] = X[s];
      }
      X[s] = tmp;
      return s;
   }
}