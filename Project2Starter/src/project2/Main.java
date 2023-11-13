/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * For this project there are 4 major components: Main, PLine, EventHeap, and CarnivalSimulation.
 *
 * Main is where the main method resides. It is also where testing code can go.
 * PLine is an implementation of a queue.
 * EventHeap is an implementation of a minimum Heap
 * Carnival Simulation is a driver class that runs the simulation.  The method start() acts
 * as the main for this simulation.
 *
 * The minor classes include Event, Person, and Ride.  Each of these pieces are an object
 * that mostly holds data about that object.  There are no large quantities of code in
 * these classes.
 *
 * EventType is an enumerated type (enum). You can consider it a data type that has a finite
 * number of options of what it can hold.  The EventType enum is declared in the event class.
 */
package project2;

/**
 * @author Jack Hoeting
 * @version 2023.02 Built the project from scratch.
 */
public class Main {

    /**
     * This is where your code begins. Comment/Uncomment the parts you do/don't
     * want to run.
     *
     * @param args
     */
    public static void main(String[] args) {
        testPLine();
        testEventHeap();
        //CarnivalSimulation.start();
    }

    private static void testPLine() {
        System.out.println();
        System.out.println("PLINE:");
        System.out.println();
        PLine a = new PLine(8);
        
        System.out.println("***LINE LENGTH***");
        int lineLength = a.getLineLength();
        System.out.println("Expected: Return the number of people in line: 0");
        System.out.println("Actual: " + lineLength);
        
        System.out.println("***ENQUEUE***");
        Person person1 = new Person(10.0, 30.0);
        Person person2 = new Person(11.0, 28.0);
        Person person3 = new Person(8.0, 26.0);
        Person person4 = new Person(6.0, 28.0);
        Person person5 = new Person(3.0, 18.0);
        Person person6 = new Person(9.0, 29.0);
        boolean firstresult = a.enqueue(person1);
        boolean secondresult = a.enqueue(person2);
        boolean thirdresult = a.enqueue(person3);
        boolean fourthresult = a.enqueue(person4);
        System.out.println("Expected: Returns true if arrival and leaving time of the 4 people "
         + "are successfully added to the queue");
        System.out.println("Actual: " + firstresult + " and " + secondresult + " and " + thirdresult 
        + " and " + fourthresult);
        
        System.out.println("***PEEK***");
        Person peak = a.peek();
        System.out.println("Expected: Returns the Person object that is first "
           + "in line without removing them: Person 10.0:30.0");
        System.out.println("Actual: " + peak);
        
        System.out.println("***DEQUEUEING THE FIRST X PEOPLE***");
        int removeCount = a.dequeue(2);
        System.out.println("Expected: Returns the 2 removed.");
         System.out.println("Actual: " + removeCount);
         
        System.out.println("***DEQUEUE THE FIRST PERSON***"); 
        Person removefirstNum = a.dequeue();
        System.out.println("Expected: Returns the person removed: Person 8.0:26.0");
        System.out.println("Actual: " + removefirstNum);
        
        System.out.println("***CHECKING IF THE LIST IS EMPTY***");
        boolean isEmpty = a.isEmpty();
        System.out.println("Expected: Returns false");
        System.out.println("Actual: " + isEmpty);
        
        System.out.println("***LINE DESCRIPTION***");
        
        System.out.println("Expected: String representation of the Person object: Front to back [ [Person 6.0:28.0]] Length 4");
        String lineDescription = a.toString();
        System.out.println("Actual: " + lineDescription);
        
        System.out.println("***DEQUEUEING AN ITEM FROM A 1 ITEM PLINE***");
        PLine b = new PLine(1);
        b.enqueue(person1);
        Person removeOneItem = b.dequeue();
        System.out.println("Expected: Returns the item removed: Person 10.0:30.0");
        System.out.println("Actual: " + removeOneItem);
        
        System.out.println("***CHECKING IF THE 1 ITEM LIST IS EMPTY***");
        boolean isOneItemEmpty = b.isEmpty();
        System.out.println("Expected: Returns true");
        System.out.println("Actual: " + isOneItemEmpty);
        
        System.out.println("***EMPTY LINE DESCRIPTION***");
        System.out.println("Expected: Empty string representation of the Person object");
        String emptyLineDescription = b.toString();
        System.out.println("Actual: " + emptyLineDescription);
        
        System.out.println("***ENQUEUEING 6 PEOPLE TO A 5 ITEM LIST***");
        PLine c = new PLine(5);
        boolean p1 = c.enqueue(person1);
        boolean p2 = c.enqueue(person2);
        boolean p3 = c.enqueue(person3);
        boolean p4 = c.enqueue(person4);
        boolean p5 = c.enqueue(person5);
        boolean p6 = c.enqueue(person6);
        System.out.println("Expected: Will only show 5 trues and 1 false");
        System.out.println("Actual: " + p1 + " " + p2 + " " + p3 + " "+ p4 + " " + p5 + " " + p6);

         
         

    }
    private static void testEventHeap() {

        EventHeap e = new EventHeap();
        System.out.println();
        
        System.out.println("EVENT HEAP:");
        System.out.println();
        Event event1 = new Event(EventType.START_RIDE, 10.0, "Teddy Bear Coaster");
        Event event2 = new Event(EventType.END_RIDE, 54.0, "Mini Train");
        Event event3 = new Event(EventType.START_RIDE, 24.0, "Tornado Coaster");
        
        
        
        System.out.println("***ADD***");
        boolean result1 = e.add(event1);
        boolean result2 = e.add(event2);
        boolean result3 = e.add(event3);
        System.out.println("Expected: EventHeap should have 3 events and return true to each one");
        System.out.println("Actual: " + result1 + ", " + result2 + ", " + result3);
        
        System.out.println("***REMOVE***");
        Event removedEvent = e.remove();
        System.out.println("Expected: Returns minimum value removed: Teddy Bear Coaster Start Ride:  at 10.0");
        System.out.println("Actual: " + removedEvent);
        
        System.out.println("***PEEK***");
        Event peekEvent = e.peek();
        System.out.println("Expected: Return min value peeked or, if empty, null");
        System.out.println("Actual: " + peekEvent);
        
        System.out.println("***SIZE***");
        int size = e.size();
        System.out.println("Expected: Return number of heap items");
        System.out.println("Actual: " + size);
        
        System.out.println("***EMPTY***");
        boolean emptyEvent = e.isEmpty();
        System.out.println("Expected: Since the heap is not empty, return false.");
        System.out.println("Actual: " + emptyEvent);
        
        System.out.println("***HEAP STRING***");
        String heapString = e.toString();
        System.out.println("Expected: Return string representing heap:  Tornado Coaster Start Ride:  at 24.0  \n" +
"Mini Train End Ride:  at 54.0");
           System.out.println("Actual: " + heapString);
           
        System.out.println("***REMOVING ONLY ELEMENT ON ONE ITEM HEAP***");
        EventHeap d = new EventHeap();
        d.add(event1);
        Event removedOnlyEvent = d.remove();
        System.out.println("Expected: Removes and returns the 1st event: Teddy Bear Coaster Start Ride:  at 10.0");
        System.out.println("Actual: " + removedOnlyEvent);
        
        System.out.println("***EMPTY ON ONE ITEM HEAP***");
        boolean emptyOneItem = d.isEmpty();
        System.out.println("Expected: Returns true if the heap is empty");
        System.out.println("Actual: " + emptyOneItem);
        
        System.out.println("***REMOVE AGAIN ON THE ONE ITEM HEAP***");
        Event removedSecond = d.remove();
        System.out.println("Expected: Removes and returns null");
        System.out.println("Actual: " + removedSecond);
        
        
        System.out.println("***RESIZING THE HEAP AFTER 501 EVENTS***");
        EventHeap reSize = new EventHeap();
        for (int i = 1; i < 501; i++) {
        Event event4 = new Event(EventType.ARRIVE_AT_CARNIVAL, i, "Pirate Ship");
        boolean sizeHeap = reSize.add(event4);
        System.out.println("Event " + i + " Added: " + sizeHeap);
        }
        
        int heapSize = reSize.size();
        System.out.println("Expected: Should successfully add 500 events, and the size should stay at 500 after adding another event.");
        System.out.println("Also should add the 501st event and return the removed event: Tornado Coaster Start Ride:  at 24.0");
        System.out.println("Actual: Heap Size: " + heapSize);
        
        
        reSize.add(new Event(EventType.ARRIVE_AT_CARNIVAL, 0, "Pirate Ship"));
       
        System.out.println(e.remove());
    }
}


