/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * CSCI 220 - Project 2
 * Simulation.
 * 
 * This class holds the details about an individual.
 * 
 * 
 */
package project2;
/**
 *
 * @author johnsone
 */
public class Person {
    private double arrivalTime; //How many minutes past park opening time that they arrive
    private double timeLeaving; //How many minutes past park opening time that they wish to leave

    public Person(double arrivalTime, double timeLeaving) {
        this.arrivalTime = arrivalTime;
        this.timeLeaving = timeLeaving;
    }

    /**
     * @return the arrivalTime
     */
    public double getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @return the timeLeaving
     */
    public double getTimeLeaving() {
        return timeLeaving;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @param timeLeaving the timeLeaving to set
     */
    public void setTimeLeaving(double timeLeaving) {
        this.timeLeaving = timeLeaving;
    }
    
    /**
     * Returns string representing person
     */
    public String toString(){
        return "[Person "+arrivalTime+":"+timeLeaving+"]";
    }
}
