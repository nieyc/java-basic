package dataStructure.linkList;

import java.util.List;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:53 2018/3/5
 * @Description
 **/
public class LinkedList  {
    Node head=null;//头节点
    Node temp=null;
    int count=0;

    class Node{
         public int data;
         public Node next;

         public Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    /**
     @Author:nieyc
     @Description: 添加数据(测试发现自己实现的LInkedList添加10万条数据需要25000ms,而jdk 的util.LinkedList
                     添加10万条数据需要13ms，效率相差2000倍)
                     此方法有问题，每次新增，指针都要遍历一次链表，数据量越大，效率越低，10万次新增，10000次增加的时候
                     指针要移动9999次，新增10001，指针要移动10000次，
     @Date:13:06 2018/3/7
     **/
    @Deprecated
    public void addNode(int d){
         Node newNode=new Node(d);
         if(head==null){
             head=newNode;
             return;
         }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }


    /**
     @Author:nieyc
     @Description:效率比jdk 自带的好，只是简单实现单链表增加，没有考虑其他情况，所以快于jdk linkedList
     @Date:12:36 2018/3/8
     **/
    public void add(int d){
        Node newNode=new Node(d);
        if(head==null){
            head=newNode;
            temp=newNode;
            return;
        }
        temp.next=newNode;
        temp=newNode;


    }

    /**
     @Author:nieyc
     @Description: 获取链表长度
     @Date:13:06 2018/3/7
     **/
    public int getNodeLength(){
        int length=0;
        if(head==null){
            return length;
        }
        Node node=head;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }

    /**
     @Author:nieyc
     @Description:打印链表中所有数据
     @Date:17:01 2018/3/6
     **/
    public void printList(){
        Node node=head;
        while (node!=null){
            System.out.print("=>"+node.data);
            node=node.next;
        }
        System.out.println("");
    }

    /**
     @Author:nieyc
     @Description: 根据数据下标获取Node对象
     @Date:13:06 2018/3/7
     **/
    public Node getNode(int index){
        if(index==0||index>getNodeLength()){
            System.out.println("index 越界");
            return null;
        }
         Node node=head;
         int count=0;
         while (node!=null){
             count++;
             if(count==index){
                // System.out.println("链表第"+index+ "项值为："+node.data);
                 break;
             }
             node=node.next;
         }
        return  node;
    }
    /**
     @Author:nieyc
     @Description:根据下标删除链表数据
     @Date:13:07 2018/3/7
     **/
    public void remove(int index){
        if(index==0||index>getNodeLength()){
            System.out.println("index 越界");
            return;
        }
        Node node=head;
        if(index==1){
            node=node.next;
            head=node;
            return;
        }
        if(index==getNodeLength()){
            getNode(index-1).next=null;
            return;
         }
        int count=0;
        while (node!=null){
            count++;
            if(count==index){
                getNode(index-1).next=getNode(index+1);
                break;
            }
            node=node.next;
        }
    }




    /**
     @Author:nieyc
     @Description:删除所有数据
     @Date:13:50 2018/3/7
     **/
    public  void removeAll(){
        head=null;
    }

    public static void printNode(LinkedList list){
        for (int i = 1; i <=list.getNodeLength() ; i++) {
            Node node=(Node)list.getNode(i);
            System.out.println(node.data);
        }
    }


    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
/*        list.add(1);
        list.add(2);
        list.add(3);
        list.add(55);
        list.add(56);
        list.add(57);
        System.out.println("链表长度："+list.getNodeLength());
        list.printList();
        Node node=list.getNode(3);
        System.out.println("node.data:"+node.data+"   node.next:"+node.next);
        list.remove(5);
        //list.removeAll();
        System.out.println("链表长度："+list.getNodeLength());
        list.printList();*/
        long startTime1=System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            list.add(i);
            //System.out.println("i:"+i);
        }
        long endTime1=System.currentTimeMillis();
        System.out.println("totalTime1:"+(endTime1-startTime1));
        //printNode(list);

        long startTime=System.currentTimeMillis();
        List linkedList=new java.util.LinkedList<Integer>();
        for (int i = 0; i <1000000 ; i++) {
            linkedList.add(i);
           // System.out.println("i:"+i);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("totalTime:"+(endTime-startTime));



    }
}
