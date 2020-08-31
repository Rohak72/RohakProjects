import java.util.Random;
public class Chapter5 {
    public static void main(String args[]) {

        System.out.println("This chapter will be about control statements.");
    }
}

// Program Control Statements can be classified in three types: selection, iteration, and jump.
// Selection: allow program to choose different paths based on the outcome of an expression or variable state.
// Iteration: enable program execution to repeat one or more statements. (loops)
// Jump: allow program to execute in a non-linear fashion.

class ifElse {
    public static void main(String args[]) {
        String days[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        String selected_day = days[3];
        String mood = "Wednesday it is. Stuck in the middle of a long week.";
        if (selected_day == days[0] | selected_day == days[1] | selected_day == days[2]) {
            System.out.println("You are only at the beginning of the week. You still have a long ways to go.");
        }
        else if (selected_day == days[3] | selected_day == days[4] | selected_day == days[5] | selected_day == days[6]) {
            System.out.println(mood);
        }
        else {
            System.out.println("You are trapped in an alternate dimension.");
        }
    }
}

// A simple example of the switch.
class SimpleSwitch {
    public static void main(String args[]) {
        for (int i=0; i<=6; i++)
            switch(i) {
                case 0:
                    System.out.println("i is zero.");
                    break;
                case 1:
                    System.out.println("i is one.");
                    break;
                case 2:
                    System.out.println("i is two.");
                    break;
                default:
                    System.out.println("i is greater than 3");
        }
    }
}
// Execution falls through each case until a break is reached.
// DO-WHILE LOOP DEMO

class doWhile {
    public static void main(String args[]) {
        int a = 10;

        do {
            System.out.println("There are " + a + " books in the store.");
            a--;
        } while (a > 0) ;

    }
}

class ForLoop {
    public static void main(String args[]) {
        String symbols[] = { "!", "@", "#", "$", "%" };
        int i, j;
        for (i=0; i<4; i++) {
            for (j=i; j<4; j++)
                System.out.println(symbols[i] + symbols[i] + symbols[i] + symbols[i]);
            System.out.println();
        }
    }
}

// Three Jump Statements: Break, Continue, and Return

class BreakLoop {
    public static void main(String args[]) {
        for(int i=0; i<3; i++) {
            System.out.println("Pass " + i + ": ");
            for(int j=0; j<100; j++) {
                if (j==10) break;
                System.out.println(j + " ");
            }
            System.out.println();
        }
        System.out.println("Loops complete.");
    }
}

class BreakGoTo {
    public static void main(String args[]) {
        boolean t = true;

        first: {
            second: {
                third: {
                System.out.println("Before the break.");
                if(t) break second;
                System.out.println("This won't execute");
            }
            System.out.println("This will also not execute.");
          }
          System.out.println("This will execute.");
        }
    }
}

class Continue {
    public static void main(String args[]) {
        outer: for(int j=0; j<6; j++) {
                    for(int i=0; i<10; i++) {
                        if (i>j) {
                            System.out.println("i="+i+" j="+j+" continuing");
                            continue;
                        }
                        System.out.println(j + " ");
                    }
                    System.out.println("In the outer loop");
                }
            }
}

class ReturnEasy {
    public static void main(String args[]) {
        boolean t = true;
        System.out.println("Before the return.");
        if(t) return;
        System.out.println("This will not be printed.");
    }
}