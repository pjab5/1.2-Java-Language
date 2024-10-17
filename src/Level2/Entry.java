package Level2;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Entry {
    static Scanner read = new Scanner(System.in);



    public static byte readByte(String message) {
        byte input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter a byte value:");
            try {
                input = read.nextByte();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format");
                read.next();
            }
        }
    }

    public static int readInt(String message) {
        int input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter an integer value:");
            try {
                input = read.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format");
                read.next();
            }
        }
    }


    public static float readFloat(String message) {
        float input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter a float value:");
            try {
                input = read.nextFloat();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format.");
                read.next();
            }
        }
    }

    public static double readDouble(String message) {
        double input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter a double value:");
            try {
                input = read.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format.");
                read.next();
            }
        }
    }


    public static char readChar(String message){
        String input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter a character:");
            try {
                input = read.next();
                if(input.length()!=1){
                    throw new NotACharException("Incorrect format.");
                }
                return input.charAt(0);
            } catch (NotACharException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readString(String message){
        String input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter a string:");
            try {
                input = read.next();
                if(input.isEmpty()){
                    throw new NotAStringException("Incorrect format.");
                }
                return input;
            } catch (NotAStringException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean readYesNo(String message){
        String input;
        System.out.println(message);
        while(true){
            System.out.println("Please enter an s for yes or an n for no:");
            try {
                input = read.next();
                if(Objects.equals(input, "s")){
                    return true;
                } else if (Objects.equals(input, "n")){
                    return false;
                }
                throw new NotABooleanException("Incorrect format.");
            } catch (NotABooleanException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}


