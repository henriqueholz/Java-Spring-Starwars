package org.starwars.api.entities;

import javax.persistence.Entity;

public class GetAllStarshipDataResponse {
    private int count;

    private String next;

    private String previous;

    private Starship[] results;

    public GetAllStarshipDataResponse() {
    }

    public GetAllStarshipDataResponse(int count, String next, String previous, Starship[] results) {
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

    public Starship[] getResults() {
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

    public void setResults(Starship[] results) {
        this.results = results;
    }
}
