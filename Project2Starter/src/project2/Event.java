/**
 * CSCI 220 - Project 2
 * Simulation.
 * 
 * This class holds details about an event object.
 * Events should be compared by the time that the events occur.
 * 
 */
package project2;

/**
 * @author Jack Hoeting
 * @version 2023.02
 * Built the project from scratch.
 */


// Define the event types
enum EventType {
    START_RIDE,
    END_RIDE,
    ARRIVE_AT_CARNIVAL
}

public class Event {

    private EventType eventType;
    private double eventTime;
    private Object eventTarget;

    public Event(EventType eventType, double eventTime, Object eventTarget) {
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.eventTarget = eventTarget;
    }

    /**
     * @return the eventTarget
     */
    public Object getEventTarget() {
        return eventTarget;
    }

    /**
     * @return the eventTime
     */
    public double getEventTime() {
        return eventTime;
    }

    /**
     * @return the eventType
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * @param eventTarget the eventTarget to set
     */
    public void setEventTarget(Object eventTarget) {
        this.eventTarget = eventTarget;
    }

    /**
     * @param eventTime the eventTime to set
     */
    public void setEventTime(double eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    
    /**
     * Create a string representing event
     * @return string for event
     */
    public String toString(){
        String result=eventTarget+ " ";
        switch (eventType){
            case START_RIDE:
                result+="Start Ride: ";
                break;
            case END_RIDE:
                result+="End Ride: ";
                break;
            case ARRIVE_AT_CARNIVAL:
                result+="Arrive: ";
                break;
            default:
                result+="Error: ";
        }
        result += " at "+eventTime;  
        return result;
    }

}
