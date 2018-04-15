package dataStructure.tree;

 /**
   @Author:nieyc
   @Description: 实现一个二叉查找树的增删查
   @Date:19:20 2018/4/14
  **/
public class BsTree {

    public BsTree(){
    }
    Node root;

    class Node{
        public Integer value;
        public Node leftChild;
        public Node rightChild;


        public Node(Integer value){
            this.value=value;
        }
    }

     /**
       @Author:nieyc
       @Description: 插入二叉树
       @Date:20:46 2018/4/14
      **/
    public void insert(Integer value){
        Node p=new Node(value);
        //如果根节点是null
        if(root==null){
            root=p;
            return;
        }
        Node q=this.root;
        while(true){
            if(value>q.value){ //要插入的值比当前节点值要大，插入当前节点的右孩子
                    if(q.rightChild==null){
                       q.rightChild=p;
                        break;
                    }else{
                        q=q.rightChild;
                    }
                }else {  //要插入的值比当前节点值要大，插入当前节点的右孩子
                     if(q.leftChild==null){
                         q.leftChild=p;
                         break;
                     }else{
                         q=q.leftChild;
                     }
                }
            }
    }

     /**
       @Author:nieyc
       @Description: 查找一个数
       @Date:15:21 2018/4/14
      **/
    public Node find(int value){
        Node currentNode=root;
        while (currentNode!=null&&currentNode.value!=value){
            if(value<currentNode.value){
                currentNode=currentNode.rightChild;
            }else{
                currentNode=currentNode.leftChild;
            }
        }
        return  currentNode;

    }

    public  void delete(){

    }







    public static void main(String[] args) {
        BsTree tree=new BsTree();
        Integer[] data={3,2,5,4,8,7,9};
        for (int i = 0; i <data.length ; i++) {
            tree.insert(data[i]);
        }
        System.out.println("this.root:"+tree.root);
        Node node= tree.find(8);
        System.out.println(node);

    }
}
