package Level3;

import java.util.ArrayList;

public class SeatingManagement {
    ArrayList<Seat> seats;
    public SeatingManagement(){
        seats = new ArrayList<Seat>();
    }
    public void addSeat(Seat seat) throws FilledSeatException {
        if(findSeat(seat.getNrow(),seat.getNseat())>0){
            throw new FilledSeatException("The seat is taken.");
        }else{
            seats.add(seat);
        }
    }

    public void removeSeat(int nrow, int nseat) throws FreeSeatException {
        int i = findSeat(nrow,nseat);
        if(findSeat(nrow,nseat)!=-1){
            seats.remove(seats.get(i));
        }else{
            throw new FreeSeatException("The seat is free.");
        }
    }


    public int findSeat(int nrow, int nseat){
        if(seats.isEmpty()){
            return 0;
        }
        for (Seat seat: seats){
            if(seat.getNrow()==nrow && seat.getNseat()==nseat){
                return seats.indexOf(seat);
            }
        }
        return -1;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}

