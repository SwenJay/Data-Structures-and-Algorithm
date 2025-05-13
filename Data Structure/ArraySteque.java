/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codings;

/**
 *
 * @author RCS
 */
public class ArraySteque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // making an objec from the Steque  generic class to access it's constructor
        Steque<Integer> steque = new Steque<>();
        
        System.out.println("Initial Steque: " + steque);
        steque.push(10); //first in from front (LIFO)
        steque.push(5); //last in from front (LIFO)
        System.out.println("After pushes: " + steque);
        steque.enqueue(20); //in from back (FIFO)
        System.out.println("After enqueue: " + steque);
        steque.pop(); //first out from front (LIFO) and 5 is been popped
        System.out.println("After pop: " + steque);
    }
    
}
