package fr.antyss77.simplifier;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static String methodName;
    private static final ArrayList<Double> nbAll = new ArrayList<>();

    public static void average() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print(ANSI_RED + "Please enter the number of notes you want to calculate : ");
            double nb = scanner.nextInt();

            for (int i = 0; i < nb; i++) {
                double temp = scanner.nextDouble();
                nbAll.add(temp);
            }

            double temp = nbAll.stream().mapToInt(Double::intValue).sum();

            double result = temp / nb;

            System.out.println(ANSI_GREEN + "Result : " + result);
            retry();


        }
    }

    public static void air() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_RED + "Give me a shape : ");
            String shape = scanner.next();
            if (shape.equalsIgnoreCase("rectangle")) {
                System.out.print(ANSI_RED + "Please enter the width : ");
                double width = scanner.nextDouble();
                System.out.print(ANSI_RED + "Please enter the height : ");
                double height = scanner.nextDouble();

                double res = width * height;

                System.out.println(ANSI_GREEN + "The air is : " + res + "²");
                retry();

            } else if (shape.equalsIgnoreCase("circle")) {
                double pi = Math.PI;

                System.out.print(ANSI_RED + "Enter the radius : ");
                double rad = scanner.nextDouble();
                double res = pi * rad * rad;
                System.out.println(ANSI_GREEN + "The air in the circle is " + res + "²");
                retry();
            } else {
                System.out.println(ANSI_RED + "It is not a shape!");
                quit();
            }

        }
    }

    public static void reduction() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_BLUE + "Hello, would you like to calculate a reduction ? ( y/n ) : ");
            String reply = scanner.next();

            System.out.print(ANSI_RED + "What is the price of the discounted item ? ");
            float price = scanner.nextFloat();
            System.out.print(ANSI_RED + "What is the amount of the reduction ? ");
            float amountReduction = scanner.nextFloat();
            float finalPrice = price * amountReduction / 100;
            finalPrice = price - finalPrice;
            System.out.println(ANSI_GREEN + "Result : " + finalPrice);
            retry();


        }

    }

    public static void volume() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_BLUE + "Do you want to calculate the air of a : rectangle or sphere  ");
            String shape = scanner.next();
            if (shape.equalsIgnoreCase("rectangle")) {
                System.out.print(ANSI_RED + "What is the width ? ");
                float width = scanner.nextFloat();
                System.out.print(ANSI_RED + "What is the length ? ");
                float length = scanner.nextFloat();
                System.out.print(ANSI_RED + "What is the height ? ");
                float height = scanner.nextFloat();
                float result = width * height * length;
                System.out.println(ANSI_GREEN + "Result : " + result + "^3");
                retry();

            } else if (shape.equalsIgnoreCase("sphere")) {
                double pi = Math.PI;

                System.out.print(ANSI_RED + "Enter radius : ");
                double radius = scanner.nextDouble();

                double result = (4 * pi * (radius * radius * radius)) / 3;

                System.out.println(ANSI_GREEN + "The volume is : " + result + "^3");

                retry();
            } else {
                System.out.println(ANSI_RED + "It's not a shape!");
                quit();
            }
        }
    }

    public static void calculator() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_RED + "Give me a first number : ");
            float firstNumber = scanner.nextFloat();
            System.out.print(ANSI_RED + "Give me a second number : ");
            float secondNumber = scanner.nextFloat();
            System.out.print(ANSI_RED + "What do you want as an operator ? : ");
            String operator = scanner.next();
            switch (operator) {
                case "+":
                    float resultAddition = firstNumber + secondNumber;
                    System.out.println(ANSI_GREEN + "Result : " + resultAddition);
                    break;
                case "-":
                    float resultSubtraction = firstNumber - secondNumber;
                    System.out.println(ANSI_GREEN + "Result : " + resultSubtraction);
                    break;
                case "*":
                    float resultMultiplication = firstNumber * secondNumber;
                    System.out.println(ANSI_GREEN + "Result : " + resultMultiplication);
                    break;
                case "/":
                    float resultDivision = firstNumber / secondNumber;
                    System.out.println(ANSI_GREEN + "Result : " + resultDivision);
                    break;
            }
            retry();
        }
    }

    public static void retry() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(ANSI_BLUE + "Do you want to do something else ? ( y/n ) : ");
            String rep = scanner.nextLine();

            if (rep.equalsIgnoreCase("y")) {
                welcome();
            } else {
                quit();
                return;
            }
        }
    }

    public static void welcome() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(ANSI_BLUE + "Hello, what do you want to do ? " + ANSI_GREEN + "Air - Average - Reduction - Volume - Calculator");
            methodName = scanner.nextLine();

            if (methodName.equalsIgnoreCase("air")) Methods.air();
            if (methodName.equalsIgnoreCase("average")) Methods.average();
            if (methodName.equalsIgnoreCase("reduction")) Methods.reduction();
            if (methodName.equalsIgnoreCase("volume")) Methods.volume();
            if (methodName.equalsIgnoreCase("calculator")) Methods.calculator();
            if (methodName.equalsIgnoreCase("quit")) Methods.quit();
        }
    }

    public static void quit() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(ANSI_RED + "The program will close down...");
            for (int i = 5; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println(i);
            }
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

