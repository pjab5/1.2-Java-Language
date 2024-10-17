package Level3;

import java.util.Objects;

public class Seat {
    private int nrow;
    private int nseat;
    private String buyer;

    public Seat(int nrow, int nseat, String buyer){
        this.nrow = nrow;
        this.nseat = nseat;
        this.buyer = buyer;
    }
    public int getNrow() {
        return nrow;
    }

    public int getNseat() {
        return nseat;
    }

    public String getBuyer() {
        return buyer;
    }


    public boolean Equals(Seat seat) {
        return nrow == seat.nrow && nseat == seat.nseat;
    }

    @Override
    public String toString() {
        return "Row: " + nrow + ", Seat: " + nseat + ", Buyer: " + buyer;
    }
}
