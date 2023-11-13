/**
 * This is the code for project 2 in CSCI 220. Note that there
 * are multiple files.
 *
 * This class is your DCircularLL. 
 * 
 * REMEMBER: A circular linked list only uses a tail pointer - no head pointer.
 *
 * Methods implemented:
 * public void prepend(Person value)
 * public void append(Person value) 
 * public Person removeLast()
 * public Person removeFirst()
 * public void empty()
 * public boolean isEmpty()
 * public Person getFirst()
 * public Person getLast()
 * public DCircularLL()
 * public String toString() 
 * private static class Node  <-- Inner Node class
 * 
 */
package project2;

/**
 * @version Starter Code
 * @author Liz Johnson
 */
class DCircularLL {

    private Node tail;

    /**
     * creates an empty list
     */
    public DCircularLL() {
        tail = null;
    }

    /**
     * Adds value to the start of the list
     *
     * @param value
     */
    public void prepend(Person value) {
        Node n = new Node(value);
        if (tail==null){
            n.next=n;
            tail=n;
            n.prev=n;
        } else {
            n.next=tail.next;
            tail.next.prev=n;
            n.prev=tail;
            tail.next=n;
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value
     */
    public void append(Person value) {
        Node n = new Node(value);
        if (tail==null){
            n.next=n;
            tail=n;
            n.prev=n;
        } else {
            n.next=tail.next;
            tail.next.prev=n;
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    
    }

    
    /**
     * Removes the first value in the list
     * @return removed item (or null if list was empty)
     */
    public Person removeFirst() {
        if (tail!=null){
            if(tail.next==tail){
                // only 1 node
                Person p = tail.value;
                tail=null;
                return p;
            } else {
                // more than 1 node
                Person p = tail.next.value;
                tail.next=tail.next.next; // second node
                tail.next.prev=tail;
                return p;
            }
        }
        return null;
    }

    /**
     * Removes the last value in the list
     * @return removed item (or null if list was empty)
     */
    public Person removeLast() {
        if (tail!=null){
            if(tail.next==tail){
                // only 1 node
                Person p = tail.value;
                tail=null;
                return p;
            } else {
                // more than 1 node
                Person p = tail.value;
                tail.prev.next=tail.next; 
                tail.next.prev=tail.prev;
                tail=tail.prev;
                return p;
            }
        }
        return null;
    }
    /**
     * Empties the list
     */
    public void empty() {
        tail=null;
    }
    
    /**
     * checks to see if empty
     * @return true if empty; false otherwise
     */
    public boolean isEmpty(){
        return tail==null;
    }
    
    /**
     * Returns first item or null if list empty
     * @return first item or null if list empty
     */
    public Person getFirst(){
        if (tail==null){
            return null;
        } else {
            return tail.next.value;
        }
    }
    /**
     * Returns last item or null if list empty
     * @return last item or null if list empty
     */
 public Person getLast(){
    
        if (tail==null){
            return null;
        } else {
            return tail.value;
        }
    }
 

    /**
     * This is the method called when a DCircularLL is passed to System.out.print It
     * determines what is printed.
     * 
     * For this project I printed the list forward 
     */
    @Override
    public String toString() {
        if (tail == null) {
            return "[]";
        }
        String strRepresentation = "[ ";
        Node cur = tail.next;
        while (cur != tail) {
            strRepresentation += cur.value + " ";
            cur = cur.next;
        }
        strRepresentation += cur.value + "]";
        return strRepresentation;
    }

    void add(Person p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {

        public Node prev;
        public Node next;
        public Person value;

        public Node(Person value) {
            this.prev = null;
            this.value = value;
            this.next = null;
        }

        public Node(Node prev, Person value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}
