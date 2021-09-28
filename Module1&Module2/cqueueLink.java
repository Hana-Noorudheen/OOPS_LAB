//  4.Write program to implement a DEQUE using Doubly Linked List.

import java.io.*;

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

class DLL {
    private Dlink first;
    private Dlink last;

    public DLL() {
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
            System.out.println("THE LIST IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    // insert at last position
    public void enque(int d) {
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

    // delete from first position

    public int deque() {
        int temp = first.data;
        if (isEmpty()) {
            System.out.println("The doublylinkedlist is Empty");
        } else if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.next.prev = null;
        }
        return temp;

    }

}

class cqueueLink {
    // main
    public static void main(String args[]) throws IOException {
        int x, value;
        DLL obj;
        obj = new DLL();
        do {
            System.out.println("1.DISPLAY ");
            System.out.println("2.ENQUEUE");
            System.out.println("3.DEQUEUE");

            InputStreamReader read = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(read);
            x = Integer.parseInt(in.readLine());

            switch (x)
            
            {
            case 1:
                System.out.println("Display All");
                obj.displayForward();
                break;

            case 2:
                System.out.println("Enter element to be inserted");
                value = Integer.parseInt(in.readLine());
                obj.enque(value);
                break;

            case 3:
                value = obj.deque();
                System.out.println(value + " is deleted");
                break;

            default:
                System.out.println("Invalid Input");
            }

        } while (x == 1 || x == 2 || x == 3);

    }

}
