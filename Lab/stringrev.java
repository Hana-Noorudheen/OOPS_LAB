import java.io.*;

class stringrev {
    int n;
    int sp;
    char[] a;

    stringrev(int nn) {
        sp = -1;
        n = nn;
        a = new char[n];
    }

    boolean push(char x) {
        if (sp >= n) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++sp] = x;
            return true;
        }
    }

    char pop() {
        if (sp < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            char x = a[sp--];
            return x;
        }
    }

    public static void main(String args[]) throws IOException {
        int l, i;
        String str;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the String");
        str = in.readLine();
        l = str.length();
        stringrev obj = new stringrev(l);
        for (i = 0; i < l; i++)
            obj.push(str.charAt(i));

        for (i = 0; i < l; i++) {
            char ch = obj.pop();
            System.out.print(ch);
        }
    }
}