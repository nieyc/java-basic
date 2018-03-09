package dataStructure.linkList;


/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:16 2018/3/7
 * @Description <E>是泛型的一种，element 的缩写，用于集合中，即不确定集合内容是啥，用<E>来替代
 **/
public class DoubleLinkedList<E> {

    Node head=null;//头节点
    Node temp=null;//临时节点
    Node last=null;//尾节点

   static class  Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E element,Node<E> next,Node<E> prev){
           this.item=element;
           this.next=next;
           this.prev=prev;
        }

    }

    /**
     @Author:nieyc
     @Description:增加节点
     @Date:13:38 2018/3/8
     **/
    public void add(E item){
        Node newNode=new Node(item,null,null);
        if(head==null){
            head=newNode;
            temp=newNode;
            return;
        }
        temp.next = newNode;
        newNode.prev=temp;
        temp=newNode;
        last=temp;
    }

    /**
     @Author:nieyc
     @Description:删除节点
     @Date:13:38 2018/3/8
     **/
    public void remove(int index){
        int length=getLength();
        System.out.println("length is ==>"+length);
        if(index==0||index>length){
            System.out.println("index 越界.链表总长度："+length);
            return;
        }
        Node node=head;
        if(index==1){
            node=node.next;
            node.prev=null;
            head=node;
            return;
        }
        if(index==length){
            getNode(index-1).next=null;
            last=null;
            return;
        }
        int count=1;
        while (node!=null){
            if(count==index){
                getNode(index+1).prev=getNode(index-1);
                getNode(index-1).next=getNode(index+1);
                break;
            }
            count++;
            node=node.next;
        }
    }

    /**
     @Author:nieyc
     @Description:获取链表长度
     @Date:13:41 2018/3/8
     **/
    public int getLength(){
        int count=0;
        if(head==null) {
            return 0;
        }
        Node node=head;
        while (node!=null){
            count++;
            node=node.next;
        }
        return count;
    }

    /**
     @Author:nieyc
     @Description:获取一个链表对象
     @Date:13:41 2018/3/8
     **/
    public Node getNode(int index){
        int length=getLength();
        if(index==0||index>length){
            System.out.println("index:"+index+" 越界,总长度："+length);
            return null;
        }
        Node node=head;
        int count=0;
        while (node!=null){
            count++;
            if(count==index){
                break;
            }
            node=node.next;
        }
        return  node;
    }

    public static void printDoubleLinkList(DoubleLinkedList linkedList){
        //打印整个链表
        int length=linkedList.getLength();
        for (int i = 1; i <=length ; i++) {
            Node<Integer> node = linkedList.getNode(i);
            System.out.print("item:" + node.item);
            if (node.prev == null) {
                System.out.print("prev is null");
            } else {
                System.out.print("prev:" + node.prev.item);
            }
            if (node.next == null) {
                System.out.print("next is null");
            } else {
                System.out.print("next:" + node.next.item);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Object> linkedList=new DoubleLinkedList<Object>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        int length=linkedList.getLength();//获取链表长度
        System.out.println("length:"+length);
        printDoubleLinkList(linkedList);//打印链表内容
        linkedList.remove(1);
        System.out.println("删除操作之后链表数据：");
        printDoubleLinkList(linkedList);

    }

}