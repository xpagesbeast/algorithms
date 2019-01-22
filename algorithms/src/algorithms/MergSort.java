package algorithms;

import java.util.Arrays;

public class MergSort {
	
	 public static void main(String[] args)
	   {
	      int[] ar = new int[25];
	      for( int i=0; i<ar.length; i++ ) 
	      {
	         ar[i] = (int)(Math.random()*ar.length*10+1);
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
	   }
	   
	 /* WRITE THIS METHOD! */
	   public static boolean isSorted(int[] A)
	   {
	      for(int i=0; i<A.length; i++){
	    	  if(i == A.length-1){
	    		  return true;
	    	  }
	    	  
	    	  if(A[i] > A[i+1]){
	    		  //if A index is greater than next A index
	    		  return false;
	    	  }
	      }
	      return true;  
	   }
	   
	   public static int[] mergeSort(int[] A)
	   {
	      /* our stopping condition - no recursion */
	      if( A.length <= 1 )
	      {
	         return A;
	      }   
	      /* split A into 2 halves */
	      int[] B = new int[A.length/2];
	      int[] C = new int[A.length - B.length];
	      /* fill */
	      for( int i=0; i<A.length; i++ ) 
	      {
	         if( i<B.length ) 
	         {
	            B[i] = A[i];
	         }
	         else
	         {
	            C[i-B.length] = A[i]; // use debugger here
	         }
	      }
	      B = mergeSort(B);
	      C = mergeSort(C);
	      /* merge the 2 sorted arrays back together */      
	      A = merge(B, C);
	      return A;
	   }
	   
	   /* WRITE THIS METHOD!  
	      I erased the code we did in class.. */
	   public static int[] merge(int[] X, int[] Y)
	   {
	      /* New Array is the size of Array X + Array Y */
	      int[] temp = new int[X.length + Y.length];
	      
	      int indexX = 0; //indexes Array X
	      int indexY = 0; //indexes Array Y
	      
	      for(int i=0; i < temp.length; i++){
	    	  //loop through entire temp array elements and populate each one.
	    	  if(indexY < Y.length  && indexX < X.length){
	    		  //if both arrays haven't reached their end (could be different sizes)
	    		  if(X[indexX] < Y[indexY]){
		    		  temp[i]=X[indexX];
		    		  indexX++;
		    	  }else{
		    		  temp[i]=Y[indexY];
		    		  indexY++;
		    	  }
	    	  }else {
	    		  //one arrays is out of bounce
	    		  if(indexY < Y.length){
	    			  temp[i]=Y[indexY];
	    			  indexY++;
	    		  }else if(indexX < X.length){
	    			  temp[i]=X[indexX];
	    			  indexX++;
	    			  
	    		  }
	    	  }
	    	  
	      }
	      
	      return temp; 
	   } 
}
