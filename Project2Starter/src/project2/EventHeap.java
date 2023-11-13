/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * This class creates a MINIMUM HEAP built on an array. The size of the heap should
 * only be limited by the hardware of the computer.
 */
package project2;

/**
 * @author Jack Hoeting
 * @version 2023.10 Built the project from scratch.
 */
public class EventHeap {

    private int size;
    private Event[] heap;

    /**
     * Create an empty heap.
     */
    public EventHeap() {
        size = 0;
        heap = new Event[500];
    }

    /**
     * Add an item to the heap.
     *
     * @param event to be added
     * @return true if event is successfully added. False otherwise.
     */
    public boolean add(Event event) {
        // Check if heap is full and resize if needed
    if (size == heap.length)   
    {
        doubleCapacity();
    }

    // Add event at the end of the heap
    heap[size] = event;
    size++;

    // Perform a bubble up operation to maintain the heap property
    bubbleUp(size - 1); //calls the index of the last added element in the heap

    return true; //event is added successfully
    }

    /**
     * Remove and return the minimum value in the heap.
     *
     * @return minimum value or, if empty, return null
     *
     */
    public Event remove() {
        if (isEmpty()) {
        return null;
    }

    // Store root event (the one to be removed)
    Event removedEvent = heap[0];

    // Move the last event in the array to index 0
    heap[0] = heap[size - 1];
    size--;

    if (size > 0) {
        // Percolate down to restore the heap property
        bubbleDown(0);
    }

    return removedEvent;
    }

    /**
     * Returns without removing the minimum value in the heap.
     *
     * @return min value or, if empty, null
     *
     */
    public Event peek() {
        if (isEmpty()) {
        return null;
    }
    
    // Return the event at the top of the heap (index 0)
    return heap[0];
    }

    /**
     * returns the number of items in the heap
     *
     * @return number of heap items
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if heap is empty. False otherwise.
     *
     * @return true if heap is empty. False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Doubles the capacity of the heap. This method should also copy over all
     * elements from the old array to the new array.
     */
    private void doubleCapacity() {
        
        int newCapacity = heap.length * 2; //doubling capacity
        Event [] newHeap = new Event[newCapacity]; //create new array with the doubled capacity
        
        for (int i = 0; i < size; i++)
        {
            newHeap[i] = heap[i]; //copy elements from the old array and paste it on the new array
        }
        
        heap = newHeap; //update heap reference on new array
    }

    /**
     * Once something is added to the bottom of the heap, this method moves it
     * upward until it is in the correct spot.
     *
     * @param index original index of item to bubble
     */
    private void bubbleUp(int index) {
        
        while (index > 0)
        {    //// Compute the parent node's index
            int parentIndex = (index - 1) / 2;
            
             // Get the event associated with the current node and its parent
            Event currentEvent = heap[index];
            Event parentEvent = heap[parentIndex];
            //Check for a violation of the max heap property
            if(currentEvent.getEventTime() >= parentEvent.getEventTime())
            {
            return;
            }
            else
            {
            swap(index, parentIndex); //swap
            index = parentIndex; //// Continue the loop from the parent node
            }
        }
    }

    /**
     * Once something is swapped to the top of the heap, this method will move
     * it downwards until it is the correct spot.
     *
     * @param index original index of item to bubble
     */
    private void bubbleDown(int index) {
         int childIndex = 2 * index + 1; // Calculate the child index
         Event event = heap[index]; //get event at current node
         while(childIndex < size)
         { //// Find the minimum time among the event and all the event's children
        double minTime = event.getEventTime();
        int minIndex = index;
        int i = 0;
        
        while (i < 2 && i + childIndex < size) {
            Event childEvent = heap[i + childIndex];
            double childTime = childEvent.getEventTime(); //find and store the time 
            //associated with a child event.
        
            if (childTime < minTime) 
            {
            minTime = childTime;
            minIndex = i + childIndex;
         }
            i++;
        }
        //// Check for a violation of the min heap property
        if (minIndex == index) {
            return;
        
    }
        else
        {
            swap(index, minIndex);
            
            // Continue loop from the min index node
            index = minIndex;
            childIndex = 2 * index + 1;
        }
    }
    }

    /**
     * Creates a string representation of the tree. Note: size and heap might
     * need to be updated to reflect your variable names.
     *
     * @return string representing heap
     */
    public String toString() {
        String s = "";
        int nodesPerLevel = 0;
        int maxNodesPerLevel = 1;
        for (int i = 0; i < size; i++) {
            s += heap[i] + "  ";
            nodesPerLevel++;
            if (nodesPerLevel >= maxNodesPerLevel) {
                s += "\n"; //New Line 
                maxNodesPerLevel *= 2;
                nodesPerLevel = 0;
            }
        }
        return s;
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param index1 index of first element
     * @param index2 index of second element
     */
    private void swap(int index1, int index2) {
        
    Event temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
        
    }
}
