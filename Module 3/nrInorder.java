import java.io.*;
import java.util.*;

class Node {
    int data;
    Node lchild;
    Node rchild;

    public Node(int d) {
        data = d;
        lchild = rchild = null;
    }

    public void displayNode() {
        System.out.println(data);
    }
}

// stack
class Stack {
    private int max;
    private Node[] arr;
    private int top;

    public Stack(int s) {
        max = s;
        arr = new Node[max];
        top = -1;
    }

    public void push(Node item) {
        top++;
        arr[top] = item;
        // arr[++top];
    }

    public Node pop() {
        Node item = arr[top];
        top--;
        return item;
        // return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}

// Tree
class Tree {
    public Node root;

    public Tree() {
        root = null;
    }

    // insert
  public void insert(int d)
   {
    Node newNode = new Node(d);
    if (root == null)
     {
      root = newNode;
    } else {
      Node cur = root;
      Node parent;
      while (true) {
        parent = cur;
        if (d < cur.data) {
          cur = cur.lchild;
          if (cur == null) {
            parent.lchild = newNode;
            return;
          }
        } else {
          cur = cur.rchild;
          if (cur == null) {
            parent.rchild = newNode;
            return;
          }
        }
      

    

  }
}
   }

    public void traversal() {
        System.out.println("INORDER TRAVERSAL");
        iInOrder(root);
        System.out.println("PREORDER TRAVERSAL");
        iPreOrder(root);
        System.out.println("POSTORDER TRAVERSAL");
        iPostOrder(root);

    }

    // Inorder traversal non recursively(LDR)
  public void iInOrder(Node IRoot) {
    Node p=IRoot;
    Stack s =new Stack(20);
    
    do{
      while(p!=null)
            {
                
                s.push(p);
                p=p.lchild;// L
            }
            if(!s.isEmpty())
            {
                
             p=s.pop();
             p.displayNode();// D
             p=p.rchild;// R

            }

    }while(p!=null||!s.isEmpty());

   
    }

      // Preorder traversal non recursively(DLR)
  public void iPreOrder(Node IRoot) {
    Node p=IRoot;
    Stack s =new Stack(20);
    
    do{
      while(p!=null)
            {
                p.displayNode();// D 
                s.push(p);
                p=p.lchild;// L
            }
            if(!s.isEmpty())
            {
                
             p=s.pop();
             p=p.rchild;// R
            }

    }while(p!=null||!s.isEmpty());

   
    }

    // Postorder traversal non recursively(LRD)
  public void iPostOrder(Node IRoot) {
    Node p=IRoot;
    Stack s =new Stack(20);
    
    do{
      while(p!=null)
            {
               
                s.push(p);
                p=p.lchild;// L
               
                
            }
            if(!s.isEmpty())
            {
                p=s.peek(); 
               
                p=p.rchild;
                if(p==null)
                 {
                  p.displayNode();// D 
                 }
                 else{
                    
                    p=p.rchild;
                 }
                
             }
            
            
            }while(p!=null||!s.isEmpty());

    }

   
    }



class nrInorder {

    public static void main(String[] args) {
        int x, data;
        Tree obj = new Tree();
        Scanner sc = new Scanner(System.in);
        System.out.println("TREE");

        do {
            System.out.println("1.INSERT");
            System.out.println("2.TREE TRAVERSAL");
           

            x = sc.nextInt();
            switch (x)

            {
                case 1:
                    System.out.println("Enter element to be inserted");
                    data = sc.nextInt();
                    obj.insert(data);
                    break;
                case 2:
                    obj.traversal();
                    break;

                 default:
                    System.out.println("Invalid Input");
            }

        } while (x == 1 || x == 2);
    }

}
