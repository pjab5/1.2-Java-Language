package Level3;

import java.util.Objects;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws WrongSeatException, FreeSeatException, WrongPersonNameException, FilledSeatException, WrongRowException {
                MovieTheater movieTheater = new MovieTheater();
                movieTheater.start();
        }

}
