public class TicketRepository {


    protected Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int removeId) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != removeId) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    private Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


}

