package dataStructure.tree;

public class BasicTree {

    public Object data;
    public BasicTree right;
    public BasicTree left;

    public BasicTree(Object d){
        this.data=d;
    }

    public static void main(String[] args) {
        BasicTree a=new BasicTree(1);
        BasicTree b=new BasicTree(2);
        BasicTree c=new BasicTree(3);
        a.left=b;
        a.right=c;
        System.out.println("a:"+a);

    }

}
