//  4.Write program to implement a DEQUE using Doubly Linked List.
import java.io.*;
import java.util.*;



class Dlink {
    public int data;
    public Dlink next;
    public Dlink prev;

    public Dlink(int d) {
        data = d;
        next = null;
    }

    public void displayLink() {
        System.out.println(data);
    }
}

class Deque {
    private Dlink first;
    private Dlink last;

    public Deque() {
        first = null;
        last = null;

    }

    public boolean isEmpty() {
        return (first == null);
    }

    // display all elements in forward direction
    public void displayForward() {
        Dlink current = first;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE DEQUE IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    // display all in the backward direction
    public void displayBackward() {
        Dlink current = last;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE DEQUE IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.prev;
        }
    }

    // insert at first position
    public void add_front(int d) {
        Dlink nl = new Dlink(d);
        if (isEmpty()) {
            first = nl;
            last = nl;
        } else {

            nl.next = first;
            first.prev = nl;
            first = nl;

        }
    }

    // insert at last position
    public void add_rear(int d) {
        Dlink nl = new Dlink(d);
        if (isEmpty()) {
            first = nl;
            last = nl;
        } else {

            nl.prev = last;
            last.next = nl;
            last = nl;

        }
    }

    // Delete first
    public int remove_front() {
        int temp = first.data;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
            
        }
        return temp;

    }

    // Delete last
    public int remove_rear() {
        
        
        int temp = last.data;
       
            last.prev.next = null;
            last = last.prev;
            return temp;

    }

    public int size() {
        Dlink cur = first;
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        System.out.println("num =" + n);
        return n;
    }
}

class doublylinkdeque {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x,value;
        System.out.println("DEQUE USING DOUBLY LINKED LIST");
        Deque obj = new Deque();
        do{
            System.out.println("1.DISPLAY FORWARD");
            System.out.println("2.DISPLAY BACKWARD");
            System.out.println("3.INSERT FIRST");
            System.out.println("4.INSERT LAST");
            System.out.println("5.DELETE FIRST");
            System.out.println("6.DELETE LAST");
            System.out.println("7.SIZE OF DEQUE");

            x=sc.nextInt();   
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
              System.out.println("Enter the element to be inserted at first position");
               value=sc.nextInt();
               obj.add_front(value);
               break;
           
               case 4:
               System.out.println("Enter the element to be inserted at last position");
               value=sc.nextInt();
               obj.add_rear(value);
               break;
           
               
                case 5: if (obj.isEmpty()) {
                    System.out.println("The Deque is Empty");
                }else  {
                       value = obj.remove_front();
                       System.out.println(value +" is removed from first position."); 
                      
                }
                break;
                       
               case 6: if (obj.isEmpty()) {
                System.out.println("The Deque is Empty");
            } else{
                       value = obj.remove_rear();
                       System.out.println(value +" is removed from last position"); 
            }
                       break;
                 case 7:
                 if (obj.isEmpty()) {
                    System.out.println("The Deque is Empty");
                
                } else {
                        value=obj.size();
                        System.out.println("TOTAL NUMBER OF ELEMENTS ="+value);
                }

               break;   
                       
               default:System.out.println("Invalid Input");
           }
           
           
           }while(x==1||x==2||x==3||x==4||x==5||x==6||x==7);
        }
           

    }


