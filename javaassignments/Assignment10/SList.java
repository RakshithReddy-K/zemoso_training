package javaassignments;

public class SList {
        Node head;


    @Override
    public String toString() {
        return "SList{" +
                "head=" + head +
                '}';
    }

    public SListIterator iterator()
    {
        return new SListIterator(this);
    }
}

