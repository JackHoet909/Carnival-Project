/**
 * CSCI 220 - Project 2
 * Simulation.
 * 
 * This class handles the details of a specific ride from ride times, number of people
 * able to ride at once, whether it is running, and a queue for who is waiting on it.
 * 
 */

package project2;

import java.util.ArrayList;

/**
 * @author Kathleen Timmerman
 * @version 2023.02
 * Built the project from scratch.
 */

public class Ride {

    private final double RIDE_TIME; //How long the ride is in minutes.
    private final int CAPACITY; // How many people can ride the ride at once.
    private PLine line; // People waiting on ride
    private boolean running; //Is the ride running. False at start of day and when no line to load
    private ArrayList<Person> onRide = new ArrayList(); //List of persons currently riding ride.

    /**
     * Creates a ride object with a given ride length in minutes and a number of people
     * that can ride the ride at once.
     * @param rideTime
     * @param capacity 
     */
    public Ride(double rideTime, int capacity) {
        this.RIDE_TIME = rideTime;
        this.CAPACITY = capacity;
        this.line = new PLine(capacity);
        running = false;
    }

    /**
     * Adds p to the rides line.
     * @param p
     * @return 
     */
    public boolean addToLine(Person p) {
        return line.enqueue(p);
    }

    /**
     * Returns the length of the ride line.
     * @return 
     */
    public int getLineLength() {
        return line.getLineLength();
    }

    /**
     * Will load and start the ride if people are waiting.
     * @return 
     */
    public boolean startRide() {
        
        if(line.isEmpty()){
            running = false;
            return false;
        }
        
        int count = 0;
        while(count < CAPACITY && !line.isEmpty()){
            onRide.add(line.dequeue());
            count++;
        }
        
        return true;
        
    }

    /**
     * Removes people from the ride. Returns the list of person disembarking.
     * @return 
     */
    public ArrayList<Person> endRide() {
        ArrayList<Person> exiting = onRide;
        onRide = new ArrayList();
        
        return exiting;
    }

    /**
     * @return the CAPACITY
     */
    public int getCapacity() {
        return CAPACITY;
    }

    /**
     * @return the RIDE_TIME
     */
    public double getRideTime() {
        return RIDE_TIME;
    }

   
    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

}
