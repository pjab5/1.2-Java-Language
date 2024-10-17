package Level3;

import java.util.Scanner;

public class MovieTheater {
    private int rows;
    private int seats;
    SeatingManagement seatingManagement;
    TheaterManagement theaterManagement;

    public MovieTheater(){
        seatingManagement = new SeatingManagement();
        theaterManagement = new TheaterManagement(this);
        getInitialData();
    }

    public void getInitialData(){
        Scanner read = new Scanner(System.in);
        read.useDelimiter("\r?\n");
        System.out.println("How many rows does this movie theater have?");
        this.rows = read.nextInt();
        System.out.println("How many seats are in each row?");
        this.seats = read.nextInt();
    }

    public void start() {
        int option, row, seat;
        String name;
        Scanner read = new Scanner(System.in);
        read.useDelimiter("\r?\n");
        do{
            option = theaterManagement.menu();
            switch (option){
                case 1:
                    theaterManagement.showSeating();
                    break;
                case 2:
                    System.out.println("What is the buyer's name?");
                    name = read.next();
                    theaterManagement.showSeatingBuyer(name);
                    break;
                case 3:
                    System.out.println("In which row?");
                    row = read.nextInt();
                    System.out.println("Which seat?");
                    seat = read.nextInt();
                    System.out.println("Under what name?");
                    name = read.next();
                    try{
                        theaterManagement.bookSeat(row,seat,name);
                    }catch(WrongRowException | WrongSeatException | WrongPersonNameException | FilledSeatException e){
                        System.out.println(e.getMessage());
                }
                    break;
                case 4:
                    System.out.println("In which row?");
                    row = read.nextInt();
                    System.out.println("Which seat?");
                    seat = read.nextInt();
                    try{
                        theaterManagement.cancelReservation(row, seat);
                    }catch(WrongRowException | WrongSeatException | FreeSeatException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Which buyer's reservations do you want to cancel?");
                    name = read.next();
                    try{
                        theaterManagement.cancelReservationBuyer(name);
                    }catch (WrongPersonNameException | FreeSeatException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }while(option!=0);
    }

    public int getRows() {
        return rows;
    }

    public int getSeats() {
        return seats;
    }
}
