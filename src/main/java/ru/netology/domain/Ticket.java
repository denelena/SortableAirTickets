package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int flightTimeMinutes;

    public Ticket(int id, int price, String airportFrom, String airportTo, int flightTimeMinutes) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightTimeMinutes = flightTimeMinutes;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getFlightTimeMinutes() {
        return flightTimeMinutes;
    }
    @Override
    public int compareTo(Ticket o) {
        return getPrice() - o.getPrice();
    }


}
