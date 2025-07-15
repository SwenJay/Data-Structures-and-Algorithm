/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codings;
import codings.Trees;
/**
 *
 * @author RCS
 */
public class TreesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //root node
        Trees root = new Trees(1); //constructor with int data parameter value
        
        //creating the child node of root node
        root.left = new Trees(2);
        root.right = new Trees(3);
        
        //creating the child node of subtree 2
        root.left.left = new Trees(4);
        root.left.right = new Trees(5);
        
        //method to display
        root.printTree("", false);
        
        // manual representation
        System.out.println("Root: " + root.data);
        System.out.println("Left child of root: " + root.left.data);
        System.out.println("Right child of root: " + root.right.data);
        System.out.println("Children of node 2: " + root.left.left.data + ", " + root.left.right.data);
    }
    
}
