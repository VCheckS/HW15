public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departure;
    private String arrivals;
    private int duration;

    public Ticket(int id, int price, String departure, String arrivals, int duration) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrivals = arrivals;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrivals() {
        return arrivals;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
