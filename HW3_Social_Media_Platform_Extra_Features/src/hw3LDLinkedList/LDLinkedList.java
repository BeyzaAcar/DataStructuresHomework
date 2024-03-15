package hw3LDLinkedList;
//import java.util.Objects;

import java.util.AbstractList;
import java.util.List;

/**
 * Class for the LinkedList created by me
 * @author BeyzaAcar
 */
public class LDLinkedList <Y> extends AbstractList implements List
{
    private class Node <T>
    {
        private T datum;
        private Node<T> next;
        boolean willItBeDeleted;
        public Node()
        {
            willItBeDeleted = false;
            next = null;
        }
        public Node(T datum)
        {
            willItBeDeleted = false;
            next = null;
            this.datum = datum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Node<T> node = (Node<T>) o;
            return datum.equals(node.datum);
        }

        /**
         * Setter for Node
         * @param datum
         */
        public void setDatum(T datum)
        {
            this.datum = datum;
            next = null;
        }
    }
    private Node head;
    private int size;
    private boolean isThisSecondDeletion;
    public LDLinkedList()
    {
        isThisSecondDeletion = false;
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * Inserts the given datum to the last of the list
     * @param datum
     */
    public boolean add(Object datum)
    {
        if(head == null)
        {
            head = new Node<Y>((Y)datum);
            size++;
            return true;
        }
        Node<Y> tempNode = head;
        Node<Y> NodeToAdd = new Node<Y>((Y)datum);
        while(tempNode.next!=null)
        {
            tempNode = tempNode.next;
        }
        size++;
        tempNode.next = NodeToAdd;
        return true;
    }

    /**
     * Insert the given element to the first index
     * @param datum
     */
    public void addFirst(Y datum)
    {
        Node<Y> newHead = new Node<Y>(datum);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * Insert the given element to the given index
     * @param index index at which the specified element is to be inserted
     * @param datum element to be inserted
     */
    public void add(int index, Object datum)
    {
        if(index==0) /*If user call this method to insert an element to the first element, this method calls addFirst method and returns*/
        {
            addFirst((Y) datum);
            return;
        }
        Node<Y> tempNode = head;
        Node<Y> NodeToAdd = new Node<Y>((Y) datum);
        for(int i = 0;i<index-1;i++)
        {
            tempNode = tempNode.next;
        }
        NodeToAdd.next = tempNode.next;
        tempNode.next = NodeToAdd;
        size++;
    }

    /**
     * Reaches the element at the given index
     * @param index
     * @return
     */
    public Y get(int index)
    {
        if(index>size-1) {
            System.out.println("This memory does not belong to this list");
            return null;
        }
        if(head == null) {
            return null;
        }
        Node<Y> tempNode = head;
        if(tempNode.willItBeDeleted == true && tempNode.next == null) return null; /*if the list has just 1 element and this element is removed*/
        if(tempNode.willItBeDeleted==true) tempNode = tempNode.next; /*if the first element marked as deleted*/
        for(int i = 0;i<index;i++)
        {
            if(tempNode.next.willItBeDeleted && tempNode.next.next != null)
            {
                tempNode = tempNode.next;
            }
            tempNode = tempNode.next;
        }
        if(tempNode == null) System.out.println("nullummm");
        return tempNode.datum;
    }

    /**
     * Removes the element given as parameter
     * @param toRemove
     * @return a boolean depending on whether the remove operation is done or not
     */
    public boolean remove(Object toRemove) /*As said in the pdf of this assignment, physical delete is done every 2 elements, otherwise only the value of the boolean variable inside the node is changed */
    {
        if(head == null) return false; /*if there is no element to remove, in other words if list is empty*/
        Node<Y> tempNode = head;

        if(isThisSecondDeletion == false)
        {
            while(tempNode != null)
            {
                if(tempNode.datum.equals((Y)toRemove))
                {
                    tempNode.willItBeDeleted = true;
                }
                tempNode = tempNode.next;
            }
            isThisSecondDeletion = true;
            return true;
        }
        else /*physical deletion is necessary*/
        {
            while(tempNode.next != null)
            {
                if(tempNode.next.datum.equals((Y)toRemove) || tempNode.next.willItBeDeleted == true)
                {
                    tempNode.next = tempNode.next.next;
                    size--;
                }
                tempNode = tempNode.next;
            }
            if(head.datum.equals((Y)toRemove)) /*if the element to be removed is in the head node*/
            {
                head = head.next;
                size--;
            }
            isThisSecondDeletion = false;
            return true;
        }
    }


}
