import java.io.*;
//link
class Link 
{
    public int data;
    public Link next;
    public Link(int d)
    {
        data=d;
        next=null;
    }
    public void displayLink()
    {
        System.out.println(data);
    }

}
//double Ended list
class FirstLastLink
{
private Link first;
private Link last;
public FirstLastLink()
{
    first=null;
    last=null;
}

public boolean isEmpty()
{
    return(first==null);
}
//insert at first position
public void insertFirst(int d)
{
  Link nl=new Link(d);
  if(isEmpty())
  {
      first=nl;
      last=nl;
  }
  else
  {
    nl.next=first;
    first=nl;
  }
}
//insert at last position
public void insertLast(int d)
{
Link nl=new Link(d);
if(isEmpty())
{
    first =nl;
    last  =nl;
}
else
{
 last.next=nl;
 last=nl;   
}

}
//delete at first position1

public int deleteFirst()
{
    int temp =first.data;
  if(isEmpty())
  {
      System.out.println("The double ended list is Empty");
  }
  else if(first.next==null)
  {
   first =null;
   last= null; 
  }
  else
  {
      first=first.next;
  }
  return temp;

}
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
}
 

class doubleEnded//main
{
    public static void main(String args[])throws IOException
    {
        int x,value;
     FirstLastLink obj;
     obj = new FirstLastLink();  
     do{
     System.out.println("1.INSERT FIRST");
     System.out.println("2.INSERT LAST");
     System.out.println("3.DELETE FIRST");
     System.out.println("4.DISPLAY ALL");
 
    InputStreamReader read = new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(read);
    x=Integer.parseInt(in.readLine());
       
    switch(x)
    {
        case 1:
            
        System.out.println("Enter the element to be inserted ai first position");
        value=Integer.parseInt(in.readLine());
        obj.insertFirst(value);
        break;
        case 2:
        System.out.println("Enter the element to be inserted at last position");
        value=Integer.parseInt(in.readLine());
        obj.insertLast(value);
        break;
        case 3:
         value =  obj.deleteFirst();
        System.out.println(value +" is Deleted");
        break;
        case 4:
        System.out.println("Display all elements in the Link");
        obj.displayList();
        break;
        default:System.out.println("Invalid Input");
    }
   
   
    }while(x==1||x==2||x==3||x==4);
    
}
}









