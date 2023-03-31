import java.util.Arrays;


public class Manager {
        private final TicketRepository repository;

        public Manager(TicketRepository repository) {
            this.repository = repository;
        }

    public void add(Ticket product) {
            repository.add(product);

        }

        public Ticket[] findAll(String arrivals, String departure) {
            Ticket[] result = new Ticket[0];
            for (Ticket ticket : repository.findAll()) {
                if (matches(ticket, arrivals, departure)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                    }
                    tmp[result.length] = ticket;
                    result = tmp;
                }
            }
            Arrays.sort(result);
            return result;
        }

        public boolean matches(Ticket tickets, String arrivals, String departure) {

            if (tickets.getDeparture().equals(departure)) {
                return tickets.getArrivals().equals((arrivals));
            }
                return false;
        }

}


