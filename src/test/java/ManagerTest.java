import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class ManagerTest {

    @Test
    public void testSortTickets() {
        TicketRepository repo = new TicketRepository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1400, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1900, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket2, ticket1, ticket3, ticket8};
        Ticket[] actual = manager.findAll("MSK", "TMN");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSortTicketsNoFound() {
        TicketRepository repo = new TicketRepository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1400, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1900, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "NYC");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSortTicketsOneFound() {
        TicketRepository repo = new TicketRepository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1400, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1900, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.findAll("SPB", "MSK");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSortTicketsWhenAlreadySort() {
        TicketRepository repo = new TicketRepository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1600, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1700, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN1", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN2", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = manager.findAll("MSK", "TMN");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSortTicketsWhenSamePrice() {
        TicketRepository repo = new TicketRepository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1500, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1500, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN1", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN2", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = manager.findAll("MSK", "TMN");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeByIdWhenIdIsCorrect() {


        TicketRepository repo = new TicketRepository();

        Ticket ticket1 = new Ticket(1, 1500, "TMN", "MSK", 120);
        Ticket ticket2 = new Ticket(2, 1500, "TMN", "MSK", 125);
        Ticket ticket3 = new Ticket(3, 1500, "TMN", "MSK", 121);
        Ticket ticket4 = new Ticket(4, 2000, "MSK", "TMN", 123);
        Ticket ticket5 = new Ticket(5, 2500, "MSK", "UFA", 150);
        Ticket ticket6 = new Ticket(6, 2400, "SPB", "TMN", 160);
        Ticket ticket7 = new Ticket(7, 2300, "SPB", "UFA", 145);
        Ticket ticket8 = new Ticket(8, 2900, "TMN1", "MSK", 130);
        Ticket ticket9 = new Ticket(9, 1000, "TMN2", "MSK", 200);
        Ticket ticket10 = new Ticket(10, 3400, "MSK", "SPB", 93);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);
        repo.add(ticket10);

        repo.removeById(5);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2,ticket3, ticket4, ticket6, ticket7, ticket8, ticket9, ticket10};

        Assertions.assertArrayEquals(expected, actual);

    }
}
