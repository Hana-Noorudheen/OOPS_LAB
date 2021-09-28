  import java.io.*;
  import java.util.*;

class binarysearch
{
    public static void main(String args[])throws IOException
 {
    int key,max;
    int[] arr;



    Scanner sc  = new Scanner(System.in);
    
    
    System.out.println("Enter the  number of elements");
    max=sc.nextInt();
    arr=new int[max];

    System.out.println("Enter the  elements");
     for(int i=0;i<max;i++)
     {
      arr[i]=sc.nextInt();
     }
     System.out.println("Enter the  key element");
     key=sc.nextInt(); 

      int ans=search(arr , max, key);
      if(ans==-1)
      System.out.println("Element not found!");
      else
      System.out.println("Element found at " + (ans +1) +" Posn");
     

   }

public  static  int search(int[] a,int m,int k)
{   
    int sindex=0;
    int midindex;
    int eindex=a.length-1;

    while(sindex<=eindex)
   {
       midindex=(sindex+eindex)/2;
      if(a[midindex]==k)
      {
       return midindex;
      }
       else if(a[midindex]<k)
       {
           sindex=midindex+1;
       }
      else
      eindex=midindex-1; 


    }
 return -1;
    
}

}