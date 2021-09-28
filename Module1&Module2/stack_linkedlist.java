import java.io.*;

class Link
{

    public int data;
    public Link next;
    public Link(int d)
    {
        data=d;
        
    }
    public void displayLink()
    {
        System.out.println(data);
    }
}
class LinkList //linkedlist
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

//insert link to first
public void push(int d)
{
   Link nl=new Link(d);
  
   nl.next=first;
   first=nl;
}
//To delete the first element 
public int pop()
{
    if(isEmpty())
    {
        System.out.println("THE LIST IS EMPTY");
    }
    int temp=first.data;
    first=first.next;
    return temp;
}

public void peek()
{
    Link cur=first;
    System.out.println("The peeked element is" +cur.data);
}

}
class stack_linkedlist
{
    public static void main(String args[])throws IOException
     {   
         int x,value,z;
         LinkList obj;
         obj = new LinkList();
         do{
       System.out.println("STACK USING LINKED LIST");
       System.out.println("1.PUSH");
       System.out.println("2.POP");
       System.out.println("3.PEEK");
      
       InputStreamReader read=new InputStreamReader(System.in);
       BufferedReader in=new BufferedReader(read);
       x=Integer.parseInt(in.readLine());
       
        switch(x)
       
        {
            
            case 1:

            
            System.out.println("Enter the data to be pushed");
            value=Integer.parseInt(in.readLine());
            obj.push(value);
            break;
            case 2:
             z=obj.pop();

            System.out.println("The element popped is" +z);
            break;
            case 3:
            obj.peek();
            break;
           
            
         default:System.out.println("INVALID INPUT");  
   }
       

    }while(x==1||x==2||x==3);
}
}  