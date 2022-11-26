package org.starwars.api.entities.Vehicle;

public class GetAllVehicleDataResponse {
    private int count;

    private String next;

    private String previous;

    private Vehicle[] results;

    public GetAllVehicleDataResponse() {
    }

    public GetAllVehicleDataResponse(int count, String next, String previous, Vehicle[] results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public Vehicle[] getResults() {
        return results;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setResults(Vehicle[] results) {
        this.results = results;
    }
}
