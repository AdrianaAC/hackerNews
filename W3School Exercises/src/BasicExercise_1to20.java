import java.util.Scanner;

public class BasicExercise_1to20 {

    //1. Write a Java program to print 'Hello' on screen and then print your name on a separate line.
    public static void one() {
        System.out.println("Hello\n" + "Adriana Alves");
    }

    //2. Write a Java program to print the sum of two numbers
    public static void two() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the first number to sum: ");
        int num1 = input.nextInt();
        System.out.print("Input the second number to sum: ");
        int num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum of the two numbers you indicated is: " + sum);
    }

    //3. Write a Java program to divide two numbers and print on the screen.
    public static void three() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number you want to divide: ");
        int num1 = input.nextInt();
        System.out.print("Input the number you want to divide for: ");
        int num2 = input.nextInt();
        int division = num1 / num2;
        System.out.println("The result of the division you just asked is: " + division);

    }

    //4. Write a Java program to print the result of the following operations.
    //a. -5 + 8 * 6 //b. (55+9) % 9 //c. 20 + -3*5 / 8 //d. 5 + 15 / 3 * 2 - 8 % 3
    public static void four() {
        int a = (-5 + 8 * 6);
        int b = (55+9) % 9;
        int c = ((20) + (-3*5) /8);
        int d = 5 + 15 / 3 * 2 - 8 % 3;
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);

    }

    //5. Write a Java program that takes two numbers as input and display the product of two numbers.
    

    //6. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.

    //7. Write a Java program that takes a number as input and prints its multiplication table up to 10.

    //8. Write a Java program to display the following pattern.

    //9. Write a Java program to compute the specified expressions and print the output.

    //10. Write a Java program to compute a specified formula.

    //11. Write a Java program to print the area and perimeter of a circle.

    //12. Write a Java program that takes three numbers as input to calculate and print the average of the numbers.

    //13. Write a Java program to print the area and perimeter of a rectangle.

    //14. Write a Java program to print an American flag on the screen.

    //15. Write a Java program to swap two variables.

    //16. Write a Java program to print a face.

    //17. Write a Java program to add two binary numbers

    //18. Write a Java program to multiply two binary numbers.

    //19. Write a Java program to convert a decimal number to binary number.

    //20. Write a Java program to convert a decimal number to hexadecimal number.


    public static void main(String[] args) {
        //Run the solution here to the the result

        System.out.println("What's the exercise you want the see the result?");
        Scanner exercise = new Scanner(System.in);
        String message = exercise.nextLine();
        System.out.println("\nThe solution for exercise " + message + " is: ");
        String choosenExercise = message + "()";
        //System.out.println(choosenExercise);
        //BasicExercise_1to20.(choosenExercise) ;
        BasicExercise_1to20.four();
        System.out.println("\nCheck the solution to understand how this was done.");


    }
}



