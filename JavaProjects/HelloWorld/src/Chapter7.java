public class Chapter7 {
    public static void main(String args[]) {
        System.out.println("This chapter delves deeper into methods and classes.");
    }
}

/* Method Overloading: An implementation of polymorphism that allows for two methods within a class that share the same
name as long as their parameters are different */

class OverloadDemo {
        void test() {
            System.out.println("No parameters");
        }
        void test(int a) {
            System.out.println("a: " + a);
        }
        void test(int a, int b) {
            System.out.println("a: " + a);
            System.out.println("b: " + b);
        }
        double test(double a) {
            System.out.println("a: " + a);
            return a*a;
        }
}

class Overload {
    public static void main(String args[]) {
        OverloadDemo ob = new OverloadDemo();
        double result;
        ob.test();
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.256);
        System.out.println("Result of test(123.256): " + result);
    }
}

// Constructors can also be overloaded in order to make themselves more compatible and efficient.
/* Overloading is important because it shows flexibility and it combines multiple uses of an original method into one
overarching constructor or method. */

// Using Objects as Parameters
class Test {
    int a, b;
    Test(int i, int j) {
        a = i;
        b = j;
    }
    boolean equals(Test o) {
        if (o.a == a && o.b == b) {
            return true;
        }
        else {
            return false;
        }
    }
}

class PassOb {
    public static void main(String args[]) {
        Test ob1 = new Test(100, 22);
        Test ob2 = new Test(100, 22);
        Test ob3 = new Test(-1, -1);

        System.out.println("ob1 == ob2 " + ob1.equals(ob2));
        System.out.println("ob2 == ob3 " + ob2.equals(ob3));
    }
}

// Arguments can be passed by value or reference.
// Recursion: The process of defining something in terms of itself.

class Factorial {
    int fact(int n) {
        int result;
        if (n==1) return 1;
        result = fact(n-1) * n;
        return result;
    }
}

class Recursion {
    public static void main(String args[]) {
        Factorial rec = new Factorial();
        System.out.println("The factorial of 3 is " + rec.fact(3));
        System.out.println("The factorial of 5 is " + rec.fact(5));
    }
}

class Test1 {
    int a; // default access
    public int b; // public access
    private int c; // private access

    void setC(int i) {
        c = i;
    }
    int getC() {
        return c;
    }
}

class AccessTest {
    public static void main(String args[]) {
        Test1 test = new Test1();
        test.a = 10;
        test.b = 20;

        // test.c = 100 ---> Error!

        test.setC(100); // ---> Must access c through methods
    }
}

// Example of Encapsulation with stack

class Stack {
    /* Both stack and tos are private. This means they cannot be maliciously attacked or altered
    in any form or manner.
     */
    private int stck[] = new int[10];
    private int tos;

    Stack() {
        tos = -1;
    }
    // Push an item into the stack.
    void push(int item) {
        if(tos == 9) {
            System.out.println("Stack is full.");
        }
        else {
            stck[++tos] = item;
        }
    }
    // Pop an item from the stack.
    int pop() {
        if(tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        else return stck[tos--];
    }
}

// Static members are those who can be used independent of any other object within that class.
// Static members can be accessed before any other objects of its class.
// Static methods can only call other static methods, access static data, and cannot refer to this or super in any way.

class UseStatic {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("Static block initialized");
        b = a * 4;
    }

    public static void main(String args[]) {
        meth(42);
    }
}

// classname.method is how static methods can be independently called in classes and used in programs.
// To conclude, the static keyword indicates that the given class, method, or data can be independently used.

// The final keyword prevents contents from being initialized. Must be initalized when declared.
// EG: final int FILE_NEW = 1;

// Arrays are objects which have attributes of length.

class Length {
    public static void main(String args[]) {
        int a1[] = new int[10];
        int a2[] = {1, 2, 3, 4, 5, 6};
        int a3[] = new int[5];

        System.out.println("The length of the first array is " + a1.length);
        System.out.println("The length of the second array is " + a2.length);
        System.out.println("The length of the third array is " + a3.length);
    }
}

// Nested Classes: Classes defined within another class. The scope of a nested classes is bound to the scope of its parent.
// Nested Class has access to members of enclosing class, including private members.
// Enclosing class does not have access to nested class members.
// Two types of nested classes: Static and non-static.
// Static: Has the static modifier applied, can only access enclosing class members through objects; seldom used.
// Inner: Non-static; has access to all members of enclosing class; fully within scope of EC.

// Demonstration of inner class.
class Outer {
    int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // inner class - in scope of outer, can access variable outer_x
    class Inner {
        void display() {
            System.out.println("Display: outer_x = " + outer_x);
        }
    }
}

class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}

// Inner class within a for loop.
class Outer1 {
    int outer_x = 100;
    void test() {
        for(int i=0; i<10; i++) {
            class Inner {
                void display() {
                    System.out.println("display: outer_x = " + outer_x);
                }
            }
            Inner inner = new Inner();
            inner.display();
        }
    }
}

class Tester {
    public static void main(String[] args) {
        Outer1 tester = new Outer1();
        tester.test();
    }
}

// Every string created is an example of the object string.
// Strings are immutable - cannot be changed once created.
// You can always create a new string that contains modifications; StringBuffer.
// The operator "+" is used for the concatenation of strings.
// Three Methods: boolean equals(String object), int length(), char charAt(int index).

class StringMethods {
    public static void main(String args[]) {
        String strOb1 = "First String";
        String strOb2 = "Second String";
        String strOb3 = strOb1;
        System.out.println("The length of str0b1: " + strOb1.length());
        System.out.println("Char at index 3 in strOb1: " + strOb1.charAt(3));
        if(strOb1.equals(strOb3)) {
            System.out.println("strOb1 == strOb3");
        }
        else System.out.println("strOb1 != strOb3");
    }
}

// Command Line Arguments stored in string array passed to main method. All are passed as strings.

class CommandLine {
    public static void main(String args[]) {
        for(int i=0; i<args.length; i++)
            System.out.println("args[" + i + "]: " + args[i]);
    }
}

