public class Chapter2 {

    /*
    This is the first line of a comment.
    This is the second line of a comment.
     */
    public static void main(String[] args) {
        // This is a stand alone comment.
	    System.out.println("Hello World One"); // This is a comment.
        System.out.println("Hello World Two");
        System.out.println("Hello World Three");
    }
}

class Example2 {
    public static void main(String args[]) {
        int num; // this declares a variable called num
        num = 100; // this assigns num the value 100
        System.out.println("This is a num: " + num);
        num = num * 2;
        System.out.println("The value of num * 2 is ");
        System.out.println(num);
    }
}

// Rule: if(condition) statement
class IfSample {
    public static void main(String args[]) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y) System.out.println("x is less than y");
        x = x * 2;
        if (x == y) System.out.println("x is now equal to y");
        x = x * 2;
        if (x > y) System.out.println("x is now greater than y");
    }
}

// Rule: for(initialization; condition; iteration) statement;
class ForTest {
    public static void main(String args[]) {
        int x; // The loop control variable
        for (x = 0; x < 10; x++)
            System.out.println("This is x: " + x);
    }
}

class BlockTest {
    public static void main(String args[]) {
        int x, y;
        y = 20;
        // the target of this loop is a block
        for(x = 0; x < 10; x++) {
            System.out.println("This is x: " + x);
            System.out.println("This is y: " + y);
            y = y - 2;
        }
    }
}
