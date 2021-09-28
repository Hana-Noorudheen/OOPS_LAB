
/*Write program to perform the following
a) infix to postfix conversion
b) Infix to prefix conversion*/
import java.io.*;

class postfix {
    private int max;
    private char[] arr;
    private int top;
    private int TOP;
    // Function To check the precedence of operators
    public char[] fstring;

    public int prec(char x) {
        switch (x) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '$':
            return 3;
        }
        return -1;

    }

    // stack implemenation using Array
    public postfix(int s) {
        max = s;
        arr = new char[max];
        fstring = new char[max];
        top = -1;
    }

    public void push(char item) {
        top++;
        arr[top] = item;

    }

    public char pop() {
        char item = arr[top];
        top--;
        return item;

    }

    public char peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }
//for storing the output 
    public void PUSH(char item) {
        TOP++;
        fstring[TOP] = item;

    }

    public char POP() {
        char item = fstring[TOP];
        TOP--;
        return item;

    }

    // Function converts Infix string to Postfix String
    public void conversion(char x) {
        char item;
        // Checking condition for operator
        if (x == '+' || x == '-' || x == '*' || x == '/' || x == '$') {
            if (isEmpty())
                push(x);
            else {
                while (!isEmpty()) {
                    item = pop();
                    if (item == '(')
                        push(item);
                    else {
                        if (prec(item) < prec(x))
                            push(item);
                        if (prec(item) >= prec(x)) {

                            PUSH(item);
                        }

                    }
                    if (prec(item) < x || prec(item) == '(')
                        break;
                }
                push(x);
            }
        } else if (x == '(')// checking condition for '('
            push(x);
        else if (x == ')')// checking conditon for ')'{
        {
            while (!isEmpty()) {
                item = pop();
                if (item == '(')
                    break;
                else {

                    PUSH(item);
                }
            }
        }

        else {

            PUSH(x);
        }
    }

    public static void main(String args[]) throws IOException {
        int l, i, x, ch = 1;
        char item;
        String str;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        do {
            System.out.println("CONVERTER");
            System.out.println("1.INFIX TO POSTFIX CONVERTER");
            System.out.println("2.INFIX TO PREFIX CONVERTER");
            System.out.println("3.PRESS ANY OTHER NUMBER TO EXIT");
            x = Integer.parseInt(in.readLine());

            switch (x) {
            case 1: {
                System.out.println("Enter the Infix String");
                str = in.readLine();
                l = str.length();
                System.out.println("The required Postfix String is");

                postfix obj = new postfix(l);
                for (i = 0; i < l; i++)
                    obj.conversion(str.charAt(i));// repeat
                while (!obj.isEmpty()) {
                    item = obj.pop();

                    obj.PUSH(item);

                } // To print the remaining contents of stack
                for (i = 0; i < l; i++)
                    System.out.println(obj.fstring[i]);

            }
                break;
            case 2: {
                System.out.println("Enter the Infix String");
                str = in.readLine();
                l = str.length();
                char[] arr;
                arr = new char[l];
                System.out.println("The required Prefix String is");
                postfix obj = new postfix(l);
                // STEP 1 Reverse the infix expression
                for (i = 0; i < l; i++)
                    obj.push(str.charAt(i));

                for (i = 0; i < l; i++) {
                    arr[i] = obj.pop();
                    // System.out.println(arr[i]);
                }

                // STEP 2 Make Every '(' as ')' and every ')' as '('
                for (i = 0; i < l; i++) {
                    if (arr[i] == '(') {

                        arr[i] = ')';
                        continue;

                    }

                    if (arr[i] == ')') {

                        arr[i] = '(';
                    }
                }
                // STEP 3 Convert expression to postfix form
                postfix ob = new postfix(l);
                for (i = 0; i < l; i++)
                    ob.conversion(arr[i]);// repeat
                // To print the remaining contents of stack
                while (!ob.isEmpty()) {
                    item = ob.pop();
                    // System.out.println(item);
                    ob.PUSH(item);
                }
                // STEP 4 String reversal of postfix string
                for (i = 0; i < l; i++) {
                    arr[i] = ob.POP();
                    System.out.println(arr[i]);
                }
                break;
            }
            default:
                System.out.println("INVALID INPUT");
            }
        } while (x == 1 || x == 2);
    }

}