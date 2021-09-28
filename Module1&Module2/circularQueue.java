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

    public void insert(int d) {
        if (isFull()) {
            System.out.println("QUEUE IS FULL");
        } else {
            rear = (rear + 1) % max;
            arr[rear] = d;
        }

    }

    public int delete() {
        int item = 0;
        if (isEmpty()) {
            System.out.println("QUEUE IS EMPTY");
            System.exit(0);

        } else {
            item = arr[front];
            front = (front + 1) % max;
        }
        return item;
    }

    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return ((rear + 1) % max == front);
    }

    public boolean isFull() {
        return ((rear + 2) % max == front);
    }

    public int size() {
        if (rear >= front)
            return (rear - front + 1);
        else
            return ((max - front) + (rear + 1));
    }
}

class circularQueue {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size, choice, data;

        System.out.println("CIRCULAR QUEUE");
        System.out.println("Enter the maximum size of the queue");
        size = sc.nextInt();

        Queue obj = new Queue(size);
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DELETE");
            System.out.println("3.TOTAL");

            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the data to be inserted");
                    data = sc.nextInt();
                    obj.insert(data);
                    break;
                }
                case 2: {

                    data = obj.delete();
                    System.out.println(data + " is the deleted element");
                    break;
                }
                case 3: {
                    data = obj.size();
                    System.out.println("The total number of element is " + data);
                    break;

                }
                default:
                    System.out.println("INVALID CHOICE");

            }
        } while (choice == 1 || choice == 2 || choice == 3);

    }
}
