import java.io.*;

class ourstack {
   private int max;
   private int[] arr;
   private int top;

   public ourstack(int s)
   {
       max=s;
       arr= new int[max];
       top=-1;
   }


public void push(int item) {
    top++;
    arr[top]=item;
    //arr[++top];
}

public int pop() {
    int item = arr[top];
    top--;
    return item;
    //return arr[top--];
}

public int peek() {
     return arr[top];
}

public boolean isFull() {
    if(top==max-1)
    return true;
    else
    return false;
    //return top==max-1;
}

public boolean isEmpty(){
    return top==-1;
}

}

class stack{
    public static void main( String s[]) 
throws IOException
 {
 ourstack st=new ourstack(20);//object creation
 st.push(56); 
 st.push(33);
 int value=st.pop();
 System.out.println(value);
 }
}