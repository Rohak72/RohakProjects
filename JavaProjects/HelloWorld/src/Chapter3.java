public class Chapter3 {
    public static void main(String args[]) {
        System.out.println("This is Chapter 3. This will cover variables, data types, and arrays.");
    }
}

// Goal: Compute distance light travels using long variables.
class Light {
    public static void main(String args[]) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        // approximate speed of light in miles per second
        lightspeed = 186000;
        days = 1000; // specify number of days
        seconds = days * 24 * 60 * 60; // convert to seconds
        distance = lightspeed * seconds; // compute distance
        System.out.println("In " + days + " light will travel about " + distance + " miles.");
    }
}
// Float: Useful for fractional components, but not adequate for very large or very small values.
// Double: Useful for maintaining accuracy, used for trigonometric functions.

// Goal: Compute the area of a circle.
class Area {
    public static void main(String args[]) {
        double pi, r, a;
        r = 10.8;
        pi = 3.1416; // approximation
        a = pi * r * r;
        System.out.println("The area of the circle is " + a + ".");
    }
}

// Char: pretty straightforward, uses unicode to store characters, 65,536 range, 16 bit.

// Chars behave like integers. Cool, right!

class CharDemo {
    public static void main(String args[]) {
        char ch1;
        ch1 = 'R';
        System.out.println("Ch1 is " + ch1);
        ch1+= 2;
        System.out.println("Ch1 is now " + ch1);
    }
}

class BooleanDemo {
    public static void main(String args[]) {
        boolean b;
        b = true;
        System.out.println("The coronavirus is a major epidemic.");
        System.out.println(b);
        b = false;
        System.out.println("I like being in quarantine.");
        System.out.println(b);
    }
}

// Basic Variable Declaration: type identifier [= value][, identifier [= value] ...];

// Demonstrate dynamic initialization. ----> Objective
class DynamicInit {
    public static void main(String args[]) {
        double a = 3.0, b = 4.0;
        // c is dynamically initialized
        double c = Math.sqrt(a * a + b * b);
        System.out.println("The value of c is " + c);
    }
}

// Demonstrate block scope.

class BlockScope {
    public static void main(String args[]) {
        int x; // known to all code within main
        x = 10;
        if (x == 10) {
            int y = 20; // y is only known here
            // x and y both known here.
            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        }
        // y = 100;
        // This will produce an error, as y was only defined in the block.

        // x is still known.
        System.out.println("x is " + x);
    }
}

// Truncation: The process in which a float loses its fractional component when being casted to an int.
// Demonstration of casts.
class Conversion {
    public static void main(String args[]) {
        byte b;
        int i = 257;
        double d = 323.142;

        System.out.println("\nConversion of int to byte.");
        b = (byte) i;
        System.out.println("i and b " + i + " " + b);

        System.out.println("\nConversion of double to an int.");
        i = (int) d;
        System.out.println("d and i " + d + " " + i);

        System.out.println("\nConversion of double to byte.");
        b = (byte) d;
        System.out.println("d and b " + d + " " + b);
    }
}

class Promote {
    public static void main(String args[]) {
        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 5000;
        float f = 5.67f;
        double d = .1234;
        double result = (f * b) + (i / c) - (d * s);
        System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
        System.out.println("result = " + result);
    }
}

// One Dimensional Array Syntax: type var-name[];, array-var = new type[size];
// e.g. int month_days[]; month_days = new int[12];
class AutoArray {
    public static void main(String args[]) {
        int month_days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        System.out.println("April has " + month_days[3] + " days.");
    }
}

class Average {
    public static void main(String args[]) {
        double num[] = { 1, 2, 3, 4, 5 };
        double result = 0;
        int i;

        for (i=0; i<5; i++) 
            result = result + num[i];
        System.out.println("The average of the numbers 1-5 is " + (result/5) + ".");
    }
}

// Multi-Dimensional Arrays: int twoD [] [] = new int [4] [5]; Left index determines rows and right index determines columns.

class threeDMatrix {
    public static void main(String args[]) {
        int threeD[][][]= new int[3][4][5];
        int i, j, k;
        for (i=0; i<3; i++)
            for (j=0; j<4; j++)
                for (k=0; k<5; k++)
                    threeD[i][j][k] = i * j * k;
        for (i=0; i<3; i++) {
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 5; k++)
                    System.out.println(threeD[i][j][k] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}

