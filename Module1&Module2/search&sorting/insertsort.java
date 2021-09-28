 import java.io.*;
import java.util.*;

class insertsort
{
    public static void main(String args[])throws IOException
 {
    int max,key=0;
    int[] arr;


    Scanner sc = new Scanner(System.in);
    
    
    System.out.println("Enter the  number of elements");
    max=sc.nextInt();
    arr=new int[max];

    System.out.println("Enter the  array elements");
     for(int i=0;i<max;i++)
     {
      arr[i]=sc.nextInt();
     }
     
     isort(arr,max,key);
      }

public static void isort(int[] a,int m,int k)   
{

int j;
for(int i=1;i<m;i++)
{
    k=a[i];
    j=i-1;
while(j>=0 && k<a[j])
{
    a[j+1]=a[j];
    j--;
}
 
a[j+1]=k;

}
System.out.println("THE SORTED ARRAY IS");
for(int i=0;i<m;i++)
{

    System.out.println(a[i]);  

}


}
   
}