/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codings;

/**
 *
 * @author RCS
 */
public class Trees {
    int data;
    Trees left;  // left child
    Trees right; // right child

    // Constructor
    public Trees(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Display method (sideways tree)
    public void printTree(String prefix, boolean isLeft) {
        if (right != null) {
            right.printTree(prefix + (isLeft ? "|   " : "    "), false);
        }
        System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + data);
        if (left != null) {
            left.printTree(prefix + (isLeft ? "|   " : "    "), true);
        }
    }

}

