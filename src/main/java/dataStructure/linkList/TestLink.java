package dataStructure.linkList;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:44 2018/3/8
 * @Description
 **/
public class TestLink {
     DoubleLinkedList<Integer> linkedList=new DoubleLinkedList<Integer>();

    public  void testAdd(){
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(11);
        linkedList.add(13);
        linkedList.add(23);
    }
    /**
     @Author:nieyc
     @Description:排序算法
     @Date:16:19 2018/3/8
     **/
    public DoubleLinkedList.Node SortLinkList(){
        DoubleLinkedList.Node nextNode=null;
        DoubleLinkedList.Node curNode=linkedList.head;
        int tmp=0;
        while (curNode.next!=null){
            nextNode=curNode.next;
            while (nextNode!=null){
                if ((Integer)curNode.item > (Integer)nextNode.item) {
                    tmp = (Integer)curNode.item;
                    curNode.item = nextNode.item;
                    nextNode.item = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return linkedList.head;
    }

    public static void main(String[] args) {
        TestLink main=new TestLink();
        main.testAdd();
       // main.linkedList.getNode(3).item=12;//可以直接修改链表节点值
        System.out.println("链表长度："+main.linkedList.getLength());
        main.SortLinkList();
        for (int i = 1; i <=main.linkedList.getLength() ; i++) {
            DoubleLinkedList.Node<Integer> node = main.linkedList.getNode(i);
            System.out.print(node.item+",");
        }
    }
}
