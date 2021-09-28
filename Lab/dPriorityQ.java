import java.io.*;
import java.util.*;

class PriorityQ
{
    private int max;
    private int[] arr;
    private int  count;

    public PriorityQ(int s)
    {
        max = s;
        arr = new int[max];
        count=0;
    }
//insert
    public void insert(int item)
    {
        int i;
        if(count==0)
        {
            arr[count]=item;
            count++;
        }else{
            for(i=count-1;i>=0;i--)
            {
                if(item>arr[i]) // if(item<arr[i]) : will run as ascending priority queue
                arr[i+1]=arr[i];
                else
                break;
            }
            arr[i+1]=item;
            count++;
        }
    }

//remove

    public int remove()
    {
        count--;
        return(arr[count]);
    }

//peek min

    public int peekMin()
    {
        return (arr[count-1]);
    }

//isEmpty

    public boolean isEmpty()
    {
        return(count==0);
    }

//isFull

    public boolean isFull()
    {
        return(count==max);
    }

}

class dPriorityQ
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int size, choice, data; 

        System.out.println("PRIORITY QUEUE");
        System.out.println("Enter the maximum size of the Queue");
        size = sc.nextInt();

        PriorityQ obj = new PriorityQ(size);
        do {
            System.out.println("1.INSERT");
            System.out.println("2.REMOVE");
            System.out.println("3.PEEK MIN");

            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                if (obj.isFull()) {
                    System.out.println("Queue is Full");
                } else {
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    obj.insert(data);
                }
                break;
            }
            case 2: {
                if (obj.isEmpty()) {
                    System.out.println(" Queue is Empty");
                } else {
                    data = obj.remove();
                    System.out.println(data + " is deleted");
                }
                break;
            }
            case 3: {
                if (obj.isEmpty()) {
                    System.out.println(" Queue is Empty");
                } else { 
                    data = obj.peekMin();
                    System.out.println("Data is "+data);
                }
                break;
            }
            default:
                System.out.println("Invalid input");
            }
        } while (choice == 1 || choice == 2 || choice == 3);
    }

}
