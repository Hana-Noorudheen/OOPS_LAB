import java.io.*;


//link
class Link 
{
    public int data;
    public Link next;
    public Link(int d)
    {
        data=d;
        this.next=null;
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
public void insertFirst(int d)
{
   Link nl=new Link(d);
  /* if(isEmpty()) //if list is empty
   {
     first=nl;
     nl.next=null;  
   }*/
  
   nl.next=first;
   first=nl;
}
//To delete the first element 
public Link deleteFirst()
{
    if(isEmpty())
    {
        System.out.println("THE LIST IS EMPTY");
    }
    Link temp=first;
    first=first.next;
    return temp;
}
//to display all elements of the list 
public void displayList()
{
    Link current=first;
    if(isEmpty())
    System.out.println("THE LIST IS EMPTY");
    
    while(current!=null)
    {
        current.displayLink();
        current=current.next;
    }

}
//find a specific Link
public int find(int key)
{
    Link current = first;
    /*
    while(current!=null)
    {
        if(current.data==key)
        {
            return current;
            break;
        }
        else if(current.data==null)
         return null;             
        else 
        current=current.next;

    }*/
    int pos=1;
while(current.data!=key)
{
   
    if(current.next==null)
    {
       return 0;
    }
    else
    current=current.next;
    pos++;
}
return pos;

}
// delete the link cotaining a key
public Link delete(int key)
{

    Link cur=first;
    Link prev=first;
    while(cur.data!=key)
{
    if(cur.next==null)
    return null;
    
    else
    {
    prev=cur;
    cur=cur.next;
    }

}


if (cur==first)
first=first.next;
else
prev.next=cur.next;
return cur;

}
//insert at posn of given
public void insert(int d,int key)
{
    Link cur=first;
    Link prev=first;
    Link newLink =new Link(d);
    while(cur.data!=key)
    {
        if(cur.next==null)
        
           System.out.println("Key not found");
        
        else
        {
        prev=cur;
        cur=cur.next;
        }

      newLink.next=prev.next;
      prev.next=newLink;
     
}
}

//insert at laat position

public void insertLast(int d)
{

    Link cur=first;
    Link nl =new Link(d);

    while(cur.next!=null)
    {
        cur=cur.next;
    }
    cur.next=nl;
    nl.next=null;

}

}
class singleLinkedlist
{
    public static void main(String args[])throws IOException
     {   
         int x,value,z;
         LinkList obj;
         obj = new LinkList();
         do{
       System.out.println("SINGLE LINKED LIST");
       System.out.println("1.INSERT FIRST");
       System.out.println("2.DELETE FIRST");
       System.out.println("3.DISPLAY ALL");
       System.out.println("4.FIND THE LINK");
       System.out.println("5.DELETE LINK");
       System.out.println("6.INSERT LINK");
       System.out.println("7.INSERT Last");
       InputStreamReader read=new InputStreamReader(System.in);
       BufferedReader in=new BufferedReader(read);
       x=Integer.parseInt(in.readLine());
       
        switch(x)
       
        {
            
            case 1:

            
            System.out.println("Enter the data to be insreted");
            value=Integer.parseInt(in.readLine());
            obj.insertFirst(value);
            break;
            case 2:
            obj.deleteFirst();

            System.out.println("The element id deleted");
            break;
            case 3:
            System.out.println("Display all elements in the Link");
            obj.displayList();
            break;
            case 4:
            System.out.println("Enter the element to be searched");
          value=Integer.parseInt(in.readLine());
            int y=obj.find(value);
            if(y==0)
            {
              System.out.println("Key not found");

            }
            else
            System.out.println("The element  is found at the position"+y);
            break;
            case 5:
            System.out.println("Enter the data to be deleted");
          value=Integer.parseInt(in.readLine());
            obj.delete(value);
            System.out.println("Deleted");
            break;
            case 6:
           
            System.out.println("Enter element to be inserted");
            value=Integer.parseInt(in.readLine());
            System.out.println("Enter the link list value");
            z=Integer.parseInt(in.readLine());
            obj.insert(value,z);
            break;

            case 7:
            System.out.println("Enter the data to be inserted");
            value=Integer.parseInt(in.readLine());
            obj.insertLast(value);
            break;
            
         default:System.out.println("INVALID INPUT");  
   }
       

    }while(x==1||x==2||x==3||x==4||x==5||x==6||x==7);
}
}  