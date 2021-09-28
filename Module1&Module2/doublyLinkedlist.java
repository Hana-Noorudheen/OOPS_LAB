import java.io.*;

class Dlink
{
    public int data;
    public Dlink next;
    public Dlink prev;
    
    public Dlink(int d)
    {
        data=d;
        next=null;
    }
    public void displayLink()
    {
        System.out.println(data);
    }
}


class DLL 
{
    private Dlink first;
    private Dlink last;
    public DLL()
    {
        first=null;
        last=null;
        
    }

    public boolean isEmpty()
    {
        return(first==null);
    }

//display all elements in forward direction
    public void displayForward()
{
    Dlink current = first;
     //if list is Empty
    if(isEmpty())
    {
        System.out.println("THE LIST IS EMPTY");
    }
    while(current!=null)
    {
        current.displayLink();
        current=current.next;
    }
}
//display all in the backward direction
public void displayBackward()
{
    Dlink current = last;
     //if list is Empty
    if(isEmpty())
    {
        System.out.println("THE LIST IS EMPTY");
    }
    while(current!=null)
    {
        current.displayLink();
        current=current.prev;
    }
}

//insert at first position
public void insertFirst(int d)
{
Dlink nl= new Dlink(d);
if(isEmpty())
{
    first=nl;
    last =nl;
}
else
{

 nl.next= first;
 first.prev=nl;
 first=nl;
}
}
//insert at last position
public void insertLast(int d)
{
Dlink nl= new Dlink(d);
if(isEmpty())
{
    first=nl;
    last =nl;
}
else
{

 nl.prev= last;
 last.next=nl;
 last=nl;

}
}
// Inserts the new element following an element with a specified key.

public void insertAfter(int d,int key)
{
    Dlink cur=first;
    Dlink nl =new Dlink(d);

    while(cur.data!=key)
    {
        if(cur.next==null)
        
           System.out.println("Key not found");
        
        else
        {
    
        cur=cur.next;
        }

     }

        if(cur.next==null)
        {
            last.next=nl;
            nl.prev=last;
            last=nl;  
        }
        
     else
        {
            nl.next=cur.next;
            cur.next.prev=nl;
            cur.next =nl;
            nl.prev=cur;
        }

      }

        public int deleteFirst()
        {
            int temp =first.data;
          if(isEmpty())
          {
              System.out.println("The doublylinkedlist is Empty");
          }
          else if(first.next==null)
          {
           first =null;
           last= null; 
          }
          else
          {

            first.next.prev=null;
              first=first.next;
            
          }
          return temp;
        
        }

     public int deleteLast()
{
    int temp =last.data;
  if(isEmpty())
  {
      System.out.println("The doublylinkedlist is Empty");
  }
  
  else
  {
    last.prev.next=null;
        last=last.prev;
	
  }
  return temp;

}

public int deleteKey(int key)
{


    Dlink cur=first;
   
    while(cur.data!=key)
{
    if(cur.next==null)
    System.out.println("The Doublylinkedlist is empty");
    
    else
    {
    
    cur=cur.next;
    }

}
int temp =cur.data;

if (cur==first)
{

first.next.prev=null;
first=first.next;
}
else
cur.prev.next=cur.next;
return temp;

}

}

class doublyLinkedlist
{
//main
public static void main(String args[])throws IOException
{
    int x,value,y;
 DLL obj;
 obj = new DLL(); 
 do{
 System.out.println("1.DISPLAY FORWARD");
 System.out.println("2.DISPLAY BACKWARD");
 System.out.println("3.INSERT FIRST");
 System.out.println("4.INSERT LAST");
 System.out.println("5.INSERT AFTER");
 System.out.println("6.DELETE FIRST");
 System.out.println("7.DELETE LAST");
 System.out.println("8.DELETE KEY");

InputStreamReader read = new InputStreamReader(System.in);
BufferedReader in=new BufferedReader(read);
x=Integer.parseInt(in.readLine());
   
switch(x)
{    
   case 1:
   System.out.println("Display elements in forward direction");
   obj.displayForward();
   break;
   
   case 2:
   System.out.println("Display elements in backward direction");
   obj.displayBackward();
   break;

   case 3:
   System.out.println("Enter the element to be inserted ai first position");
    value=Integer.parseInt(in.readLine());
    obj.insertFirst(value);
    break;

    case 4:
    System.out.println("Enter the element to be inserted at last position");
    value=Integer.parseInt(in.readLine());
    obj.insertLast(value);
    break;

    case 5:
    System.out.println("Enter element to be inserted");
            value=Integer.parseInt(in.readLine());
            System.out.println("Enter the link list value");
            y=Integer.parseInt(in.readLine());
            obj.insertAfter(value,y);
            break;
     case 6:
            value = obj.deleteFirst();
            System.out.println(value +" is Deleted"); 
            break;
            
    case 7:
            value = obj.deleteLast();
            System.out.println(value +" is Deleted"); 
            break;
    case 8:

            System.out.println("Enter the data to be deleted");
            value=Integer.parseInt(in.readLine());
            int v1 =obj.deleteKey(value);
            System.out.println(v1 +" is Deleted"); 
            break;       
            
    default:System.out.println("Invalid Input");
}


}while(x==1||x==2||x==3||x==4||x==5||x==6||x==7||x==8);

}


}