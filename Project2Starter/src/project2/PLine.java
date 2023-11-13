/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 * Implementation of queue. Front is front of list. End is back of list
 *
 * @author Jack Hoeting
 */
public class PLine {

    private int limit;
    private int currentSize;
    private DCircularLL list;

    /**
     * constructor for PLine
     *
     * @param n limit for line size
     */
    public PLine(int n) {
        currentSize = 0;
        limit = n;
        list = new DCircularLL();
    }

    /**
     * Returns number of people in line
     *
     * @return number of people in line
     */
    public int getLineLength() {
        return currentSize;
    }

    /**
     * Tries to add p to queue. Returns true if the person is successfully added
     * to the queue; false otherwise. You can assume p is not null.
     *
     * @return true if added; false otherwise
     */
    public boolean enqueue(Person p) {
        if (currentSize < limit) //check if the line has space available
        {
        list.append(p); //append the person to the end of the queue
        currentSize++; //increment the current size to keep track of the number of ppl in the queue
        
        return true; //the person is added
    }
        else
        {
            return false; //its already at capacity 
        }
    }

    /**
     * returns the Person object that is first in line without removing them.
     * Return null if line is empty
     *
     * @return Person at front of line or null if line empty
     */
    public Person peek() {
        if (list.isEmpty())
        {
            return null;
        }
        return list.getFirst(); //call the getFirst method to get the first
        // person in front of the line
    }

    /**
     * Dequeues the first x people from the line. If there are not x people in
     * line, it removes however many people are in the line. Returns the number
     * of people removed. You should check to make sure x is not negative.
     */
    public int dequeue(int x) {
        if (list.isEmpty())
        {
            return 0;
        }
        int removeCount = 0;
        while (x > 0 && !list.isEmpty())
        {
            list.removeFirst(); //Remove the first person from the line
            removeCount++; //Increment the count of ppl removed
            x--; //Decrement the remaining count of ppl to remove
            currentSize--; //Decrement the current size of the line
        }
        return removeCount; //Return the total number of ppl removed
    }

    /**
     * Removes first person in line and returns. 
     * Returns null if list empty
     * @return first person or null if list is empty
     */
    public Person dequeue() {
       if (list.isEmpty())
       {
           return null;
       }
       currentSize--; //Decrement the current size of the line
       return list.removeFirst(); // Removes the first person from the line
       
    }

    /**
     * Returns true if list is empty; false otherwise
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty() {
       return list.isEmpty();
    }
    
    /**
     * Creates a string representing PLine
     */
    public String toString(){
        return "Front to back "+list+" Length "+ getLineLength();
    }
}
