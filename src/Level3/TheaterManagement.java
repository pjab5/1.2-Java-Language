package Level3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TheaterManagement {
    MovieTheater movieTheater;

    public TheaterManagement(MovieTheater movieTheater){
        this.movieTheater = movieTheater;
    }

    public int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nChoose one of the following options: ");
        System.out.println("    1.-Display all the reserved seats.");
        System.out.println("    2.-Display all seats reserved by a person.");
        System.out.println("    3.-Reserve a seat.");
        System.out.println("    4.-Cancel seat reservation.");
        System.out.println("    5.-Cancel all reservations by a person.");
        System.out.println("    0.-Exit");
        return sc.nextInt();
    }

    public void showSeating(){
        System.out.println("The following seats are occupied:");
        for (Seat seat: movieTheater.seatingManagement.getSeats()){
            System.out.println(seat.toString());
        }
        System.out.println("\n");
    }

    public void showSeatingBuyer(String buyer){
        ArrayList<Seat> seats = movieTheater.seatingManagement.getSeats();
        seats.removeIf(seat -> !Objects.equals(seat.getBuyer(), buyer));
        System.out.println(buyer + " has booked the following seats:");
        for (Seat seat: seats){
            System.out.println(seat.toString());
        }
        System.out.println("\n");
    }

    public void bookSeat(int nrow, int nseat, String name) throws WrongRowException, WrongSeatException, WrongPersonNameException, FilledSeatException {
        if(addRow(nrow)==nrow && addSeat(nseat) == nseat && Objects.equals(addPerson(name), name)){
            movieTheater.seatingManagement.addSeat(new Seat(nrow,nseat,name));
        }
    }

    public void cancelReservation(int nrow, int nseat) throws WrongRowException, WrongSeatException, FreeSeatException {
        if(addRow(nrow)==nrow && addSeat(nseat) == nseat){
            movieTheater.seatingManagement.removeSeat(nrow,nseat);
        }
    }

    public void cancelReservationBuyer(String name) throws WrongPersonNameException, FreeSeatException {
        if(Objects.equals(addPerson(name), name)){
            movieTheater.seatingManagement.getSeats().removeIf(seat -> Objects.equals(seat.getBuyer(), name));
        }
    }



    public String addPerson(String name) throws WrongPersonNameException {
        if (!name.matches(".*\\d.*")){
            return name;
        }
        throw new WrongPersonNameException("This row doesn't exist.");
    }

    public int addRow(int nrow) throws WrongRowException {
        if (nrow>0 && nrow < movieTheater.getRows() + 1){
            return nrow;
        }
        throw new WrongRowException("This row doesn't exist.");
    }

    public int addSeat(int nseat) throws WrongSeatException {
        if (nseat>0 && nseat < movieTheater.getSeats() + 1){
            return nseat;
        }
        throw new WrongSeatException("This seat doesn't exist.");
    }
}
