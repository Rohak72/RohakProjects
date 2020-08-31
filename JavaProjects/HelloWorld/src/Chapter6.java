import java.util.Stack;

public class Chapter6 {
    public static void main(String args[]) {

        System.out.println("This chapter is an introduction to classes.");
    }
}

// Objects are instances of a class.
// Variables within a class are called instance variables.
// Data and code specification is key to creating a class.
// A rudimentary class involves variables, parameters, and methods.

class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    double volume() {

        return width * height * depth;
    }
}

class BoxDemo {
    public static void main(String args[]) {
        Box myBox = new Box(3, 5, 10);
       double vol;
       vol = myBox.volume();
       System.out.println("The volume of the box is " + vol);
    }
}

// Stack - defines data items and methods
// Uses first-in, last-out ordering system - values come back reversed
// Uses push and pop methods to store and output information.
// Used as a reversal method to show most recent inputs instead of the earliest inputs.

class TestStack {
    public static void main(String args[]) {
        Stack myStack1 = new Stack();
        Stack myStack2 = new Stack();

        // push some numbers into each stack
        for(int i=0; i<10; i++) {
            myStack1.push(i);
        }
        for(int i=0; i<20; i++) {
            myStack2.push(i);
        }

        // popping numbers out of the stack
        System.out.println("Stack in myStack1:");
        for(int i=0; i<10; i++) {
            System.out.println(myStack1.pop());
        }
        System.out.println("Stack in myStack2");
        for(int i=0; i<20; i++) {
            System.out.println(myStack2.pop());
        }
    }
}
