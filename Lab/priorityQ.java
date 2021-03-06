import java.io.*;
import java.util.*;

//link
class Link {
    public int data;
    public Link next;

    public Link(int d) {
        data = d;
        this.next = null;
    }

    public void displayLink() {
        System.out.println(data);
    }

}

class LinkList //Linkedlist
{   
    private Link first;
    public LinkList()
    {
        first=null;
    }
public boolean isEmpty()
{
    return(first==null);
}



//insert at lASt position

public void insertLast(int d)
{
    
    Link cur=first;
    Link nl =new Link(d);
    if(isEmpty())
    {
        first=nl;

    }
    else
    {
    while(cur.next!=null)
    {
        cur=cur.next;
    }
    cur.next=nl;
    nl.next=null;
}
}



//To delete the first element 
public int deleteFirst()
{
     
    sort();
   
    int temp=first.data;
    first=first.next;
    return temp;
   
}

     // SWAP
    public void swap(int pos) {
        Link cur = first;
        Link prev = first;

        int i = 0;
        while (pos != i) {

            prev = cur;
            cur = cur.next;
            i++;
        }
        if(cur.data>prev.data){
        int temp = cur.data;
        cur.data = prev.data;
        prev.data = temp;
        }

    }

    // SORT
    public void sort() {
        int n = 1;
        Link cur = first;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }

        int p;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 1; j <= n - i - 1; j++) 
            {

                p = j;
                swap(p);
            }

        }
        
    }

}



class priorityQ
 {
    public static void main(String args[]) throws IOException {
        int choice, value;
        LinkList obj;
        obj = new LinkList();

        Scanner sc = new Scanner(System.in);
        do {
        
           
            System.out.println("1.INSERT");
            
            System.out.println("2.DELETE");
        
            choice = sc.nextInt();

            switch (choice)

            {

            case 1:
            System.out.println("Enter the data to be inserted");
            value = sc.nextInt();
            obj.insertLast(value);
            break;
               
            case 2:
            if(obj.isEmpty())
            System.out.println("THE LIST IS EMPTY");
            int d = obj.deleteFirst();
            System.out.println(d + " is  deleted");
            break;
            

            default:
                System.out.println("INVALID INPUT");
            }

        } while (choice == 1 || choice == 2 );
    }
}
