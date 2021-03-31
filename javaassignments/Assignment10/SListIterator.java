package javaassignments;

public class SListIterator {
     SList list;
    public SListIterator(SList head)
    {
        list=head;
    }

    public  void insert( int data)
    {

        Node new_node = new Node(data);
        new_node.next = null;
         if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public  void deleteByKey(int key)
    {
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
           System.out.println(key + " found and deleted");
            return;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }
        if (currNode == null) {
            System.out.println(key + " not found");
        }
       return ;
    }
}
