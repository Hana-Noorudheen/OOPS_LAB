import java.io.*;
import java.util.Scanner;

class queue {
    private int max;
    private int[] arr;
    private int rear;
    private int front;

    public queue(int s) {
        max = s;
        arr = new int[max];
        rear = -1;
        front = 0;
    }

    // INSERTION
    public void insert(int d) {

        if (isFull()) {
            System.out.println("QUEUE IS FULL");
        } else {
            rear++;
            arr[rear] = d;
        }

    }

    // DELETION
    public int delete() {
        int item = 0;

        if (isEmpty()) {
            System.out.println("QUEUE IS EMPTY");
            System.exit(0);

        } else {
            item = arr[front];
            front++;
        }
        return item;
    }

    // QUEUE IS EMPTY
    public boolean isEmpty() {
        return (front == rear + 1);

    }

    // QUEUE IS FULL
    public boolean isFull() {
        return (rear == max - 1);
    }

    public int total() {
        return (rear - front + 1);
    }
}

class linearQueue {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size, choice, data;

        System.out.println("LINEAR QUEUE");
        System.out.println("Enter the maximum size of the queue");
        size = sc.nextInt();

        queue obj = new queue(size);
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
                data = obj.total();
                System.out.println("The total number of element is " + data);
                break;

            }
            default:
                System.out.println("INVALID CHOICE");

            }
        } while (choice == 1 || choice == 2 || choice == 3);

    }
}