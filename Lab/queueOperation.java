/*Write a menu driven program to implement the following queue operations using array
a.enqueue
b.dequeue
c.display*/



import java.io.*;
import java.util.*;

class Queue {
    private int max;
    private int[] arr;
    private int rear;
    private int front;

    public Queue(int s) {
        max = s;
        arr = new int[max];
        rear = -1;
        front = 0;
    }

    // INSERT
    public void insert(int d) {

        rear = (rear + 1) % max;
        arr[rear] = d;

    }

    // DELETE
    public int delete() {
        int item = 0;

        item = arr[front];
        front = (front + 1) % max;
        return item;
    }

    // DISPLAY
    public void display() {
        int head = front;
        int tail = rear;
        while (true) {
            System.out.println(arr[head]);
            if (head == tail)
                break;
            else
                head = (head + 1) % max;

        }
    }

    public boolean isEmpty() {
        return ((rear + 1) % max == front);
    }

    public boolean isFull() {
        return ((rear + 2) % max == front);
    }

}

class queueOperation {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size, choice, data;

        System.out.println("QUEUE");
        System.out.println("Enter the maximum size of the queue");
        size = sc.nextInt();

        Queue obj = new Queue(size);
        do {
            System.out.println("1.ENQUEUE");
            System.out.println("2.DEQUEUE");
            System.out.println("3.DISPLAY");

            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                if (obj.isFull()) {
                    System.out.println("QUEUE IS FULL");
                } else {
                    System.out.println("Enter the data to be inserted");
                    data = sc.nextInt();
                    obj.insert(data);
                }
                break;
            }
            case 2: {

                if (obj.isEmpty()) {
                    System.out.println("THE LIST IS EMPTY");
                } else

                {
                    data = obj.delete();
                    System.out.println(data + " is the deleted element");
                }
                break;
            }
            case 3: {
                if (obj.isEmpty()) {
                    System.out.println("THE LIST IS EMPTY");
                } else
                    obj.display();
                break;

            }
            default:
                System.out.println("INVALID CHOICE");

            }
        } while (choice == 1 || choice == 2 || choice == 3);

    }
}