package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.storage.Repository;

import java.util.Arrays;

public class TicketManager {
    private Repository repository;

    public TicketManager(Repository r) {
        repository = r;
    }

    public void add(Ticket newItem) {
        repository.addItem(newItem);
    }

    public void removeById(int ticketId) {
        repository.removeItemById(ticketId);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] all = repository.findAll();
        Ticket[] filtered = new Ticket[0];
        for (Ticket curr :all) {
            if(curr.getAirportFrom().equalsIgnoreCase(from) && curr.getAirportTo().equalsIgnoreCase(to)){
                Ticket[] temp = new Ticket[filtered.length + 1];
                System.arraycopy(filtered, 0, temp, 0, filtered.length);
                temp[filtered.length] = curr;
                filtered = temp;
            }
        }
        Arrays.sort(filtered);

        return filtered;
    }
}
