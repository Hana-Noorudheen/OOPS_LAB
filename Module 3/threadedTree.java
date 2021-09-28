import java.io.*;
import java.util.*;



class Nodes {
    int data;
    Nodes lchild;
    Nodes rchild;
    boolean rthread;

    public Nodes(int d) {
        data = d;
        rchild = lchild = null;
        rthread=true;
    }

    public void displayNode() {
        System.out.println(data);
    }
}

class Ttree {
    private Nodes root;

    public Ttree() {
        root = null;
    }

    // inorder non-recursive along with thread
    public void inorderThreaded(Nodes lroot) {
        Nodes q, p = lroot;
        do {
            q = null;
            while (p != null) {
                q = p;
                p = p.lchild;
            }
            if (q != null) {
                q.displayNode();
                p = q.rchild;
                while (q.rthread && p != null) {
                    p.displayNode();
                    q = p;
                    p = p.rchild;
                }
            }
        } while (q != null);

    }

    // making left child
    public void setleft(Nodes p, int x) {

    
        if (p == null)
            System.out.println("Void insertion");
        else if (p.lchild != null)
            System.out.println("invalid insertion");
        else {
            Nodes q = new Nodes(x);
            p.lchild = q;
            q.lchild = null;
            q.rchild = p;
            q.rthread = true;
        }

    }
    //making right child
    public void setright(Nodes p,int x)
    {
        Nodes q,r;
        if(p==null)
        {
            System.out.println("Void insertion");
            
        }
        else if(!p.rthread)
        {
            System.out.println("Invalid insertion");
            
        }
        else{
            q=new Nodes(x);
            r=p.rchild;
            p.rchild=q;
            p.rthread=false;
            q.rchild=null;
            q.rchild=r;
            q.rthread=true;

        }
    }
}


class threadedTree {

    public static void main(String[] args) {
        int x, data;
        Ttree obj = new Ttree();
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
                    obj.inorderThreaded(data);
                    break;
                case 2:
                    obj.();
                    break;

                 default:
                    System.out.println("Invalid Input");
            }

        } while (x == 1 || x == 2);
    }

}

