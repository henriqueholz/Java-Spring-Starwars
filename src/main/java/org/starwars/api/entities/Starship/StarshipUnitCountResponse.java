package org.starwars.api.entities.Starship;

public class StarshipUnitCountResponse {
    private int id;

    private String name;

    private int unitCount;

    public StarshipUnitCountResponse(int id, String name, int unitCount) {
        this.id = id;
        this.name = name;
        this.unitCount = unitCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }
}
