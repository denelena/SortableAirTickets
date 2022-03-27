package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.storage.Repository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsManagerTest {
    Repository repository = new Repository();
    Ticket t1 = new Ticket(1000, 75, "NYC", "BOS", 90);
    Ticket t2 = new Ticket(1100, 490, "NYC", "SVO", 500);
    Ticket t3 = new Ticket(1200, 90, "SVO", "KZN", 100);
    Ticket t4 = new Ticket(1300, 120, "KZN", "IST", 150);
    Ticket t5 = new Ticket(1400, 180, "IST", "BOS", 350);
    Ticket t6 = new Ticket(1500, 420, "NYC", "SVO", 450);
    Ticket t7 = new Ticket(1600, 480, "NYC", "SVO", 600);
    Ticket t8 = new Ticket(1700, 580, "NYC", "SVO", 450);

    @Test
    public void shouldFindSeveralSortByPrice() {
        TicketManager tm = new TicketManager(repository);
        tm.add(t1);
        tm.add(t2);
        tm.add(t3);
        tm.add(t4);
        tm.add(t5);
        tm.add(t6);
        tm.add(t7);
        tm.add(t8);

        Ticket[] expected = new Ticket[]{t6, t7, t2, t8};
        Ticket[] actual = tm.findAll("NYC", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSingle() {
        TicketManager tm = new TicketManager(repository);
        tm.add(t1);
        tm.add(t2);
        tm.add(t3);
        tm.add(t4);
        tm.add(t5);
        tm.add(t6);
        tm.add(t7);
        tm.add(t8);

        Ticket[] expected = new Ticket[]{t5};
        Ticket[] actual = tm.findAll("IST", "BOS");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        TicketManager tm = new TicketManager(repository);
        tm.add(t1);
        tm.add(t2);
        tm.add(t3);
        tm.add(t4);
        tm.add(t5);
        tm.add(t6);
        tm.add(t7);
        tm.add(t8);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tm.findAll("LAX", "BOS");
        assertArrayEquals(expected, actual);
    }
}
