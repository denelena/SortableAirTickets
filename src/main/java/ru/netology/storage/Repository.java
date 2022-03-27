package ru.netology.storage;

import ru.netology.domain.Ticket;
import ru.netology.exceptions.*;

import java.util.Arrays;

public class Repository {
    private Ticket[] items = new Ticket[0];

    public Repository() {
    }

    public void addItem(Ticket newItem) {

        int newItemId = newItem.getId();
        if (findById(newItemId) != null)
            throw new AlreadyExistsException("Ticket with id " + newItemId + " already exists");

        Ticket[] modifiedStorage = new Ticket[items.length + 1];
        System.arraycopy(items, 0, modifiedStorage, 0, items.length);
        modifiedStorage[items.length] = newItem;
        items = modifiedStorage;
    }

    public Ticket[] findAll() {
        Ticket[] temp = new Ticket[items.length];
        System.arraycopy(items, 0, temp, 0, items.length);
        return temp;
    }

    public void removeItemById(int id) {

        if (findById(id) == null)
            throw new NotFoundException("Product with id " + id + " was not found");

        //now we know for sure, that we will modify items array:
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    private Ticket findById(int idToFind) {
        for (Ticket curr : items) {
            if (curr.getId() == idToFind)
                return curr;
        }
        return null;
    }
}
