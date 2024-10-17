package Level2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Your age in byte format is: " + Entry.readByte("How old are you?"));
        System.out.println("Your age in int format is: " + Entry.readInt("How old are you?"));
        System.out.println("Your age in float format is: " + Entry.readFloat("How old are you?"));
        System.out.println("Your age in double format is: " + Entry.readDouble("How old are you?"));
        System.out.println("Your age in char format is: " + Entry.readChar("How old are you?"));
        System.out.println("Your age in String format is: " + Entry.readString("How old are you?"));
        System.out.println("Your age in boolean format is: " + Entry.readYesNo("How old are you?"));
    }
}
