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
        public Node parent;


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
                        p.parent=q;
                        break;
                    }else{
                        q=q.rightChild;
                    }

                }else {  //要插入的值比当前节点值要大，插入当前节点的右孩子
                     if(q.leftChild==null){
                         q.leftChild=p;
                         p.parent=q;
                         break;
                     }else{
                         q=q.leftChild;
                     }

                }
            }
    }

     /**
       @Author:nieyc
       @Description: 查找一个数，返回所在节点
       @Date:15:21 2018/4/14
      **/
    public Node find(int value){
        Node currentNode=root;
        while (currentNode!=null&&currentNode.value!=value){
            if(value<currentNode.value){
                currentNode=currentNode.leftChild;
            }else{
                currentNode=currentNode.rightChild;
            }
        }
        return  currentNode;

    }

     /**
       @Author:nieyc
       @Description:删除一个节点
       @Date:16:54 2018/4/18
      **/
    public  Node delete(int value){
        Node currentNode=root;
        Node node=find(value);
        //如果要删除的对象没有叶子节点，则直接置为null
        if(node.leftChild==null&&node.rightChild==null){
            if(node.parent.rightChild!=null){
                if(node.parent.rightChild.value==value){
                    node.parent.rightChild=null;
                }
            }else  if(node.parent.leftChild!=null){
                if(node.parent.leftChild.value==value){
                    node.parent.leftChild=null;
                }

            }
        }else if(node.leftChild==null||node.rightChild==null){ //如果要删除的对象只有一个叶子节点
            if(node.rightChild==null){
                node.parent.leftChild=node.leftChild;
            }else if(node.leftChild==null){
                    node.parent.leftChild=node.rightChild;
            }
        }else if(node.leftChild!=null&&node.rightChild!=null){//删除对象有2个叶子节点
            Node successor=getSuccessor(node);
            if(node==root){
                root=successor;
            }else  if(node==node.parent.leftChild){
                node.parent.leftChild=successor;
            }else if(node==node.parent.rightChild){
                node.parent.rightChild=successor;
            }
            successor.leftChild=node.leftChild;
        }

        return currentNode;
    }


     /**
       @Author:nieyc
       @Description: 找到被删除节点的中序后继节点：在树中找出所有比
       被删除节点的值大的所有数，并在这些数中找出一个最小的数来。
       听起来很拗，如果把它用图形来描述的话，就是，从被删除的节点出发
       经过它的右节点，然后右节点最左边的叶子节点就是我们要找的，
       它有一个专业名词叫中序后继节点。
       @Date:16:46 2018/4/18
      **/
     public Node getSuccessor(Node delNode){  //参数为被删除的节点
         //定义一个当前节点的引用，直接让往下走一步，走到被删除节点的右节点
         Node curr=delNode.rightChild;
         Node successor=curr;  //用来指向中级后续节点
         Node sucParent=null; //用来指向中级后续节点的父节点
         while(curr!=null){
             sucParent=successor;
             successor=curr;
             curr=curr.leftChild;
         }
         //循环停止，中级后续节点被找出
         if(successor!=delNode.rightChild){
             //将后继节点的子节点（只可能有右节点）替补到后继节点的位置上
             sucParent.leftChild=successor.rightChild;
             //将被删除的右孩子连接到后继节点的右节点上
             successor.rightChild=delNode.rightChild;
             //将被删除的左孩子连接到后继节点的右节点上（就是用后继节点替换掉被删除的节点）
         }
         return successor;
     }


      /**
        @Author:nieyc
        @Description:前序遍历： 跟--左--右
        @Date:17:29 2018/4/18
       **/
     public  void preOrder(Node n){
         System.out.println(n.value);
         if(n.leftChild!=null){
             preOrder(n.leftChild);
         }
         if(n.rightChild!=null){
             preOrder(n.rightChild);
         }
         System.out.println("====================="+n.value);
         if(n.leftChild==null&&n.rightChild==null){
             System.out.println("game over");
         }
     }


      /**
        @Author:nieyc
        @Description:中序遍历：左--跟--右
        @Date:17:28 2018/4/18
       **/
     public void midOrder(Node n) {
         if (n.leftChild != null){
             midOrder(n.leftChild);
         }
         System.out.println(n.value);
         if (n.rightChild != null){
             midOrder(n.rightChild);
         }

     }

      /**
        @Author:nieyc
        @Description:后序遍历： 左--右--跟
        @Date:11:20 2018/4/19
       **/
     public void postOrder(Node n){
         if (n.leftChild != null){
             postOrder(n.leftChild);
         }
         if (n.rightChild != null){
             postOrder(n.rightChild);
         }
         System.out.println(n.value);
     }


    public static void main(String[] args) {
        BsTree tree=new BsTree();
        Integer[] data={3,2,1,5,4,8,6,7,9};
        for (int i = 0; i <data.length ; i++) {
            tree.insert(data[i]);
        }
        System.out.println("this.root:"+tree.root);
        tree.postOrder(tree.root);
        //Node node= tree.find(7);
        //System.out.println(node.value);
        //Node node1=tree.delete(8);
        //System.out.println("node:"+node1);

    }
}
