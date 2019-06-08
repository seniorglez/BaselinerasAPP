/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Model;

/**
 *
 * @author diego
 */
public class WorkshopDB {

    private int id, nif, capacity;
    private String name;
    private OilStationDB oils;

    public WorkshopDB(int id, OilStationDB oils, int nif, int capacity) {
        this.capacity = capacity;
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.oils = oils;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OilStationDB getOils() {
        return oils;
    }

    public void setOils(OilStationDB oils) {
        this.oils = oils;
    }

}
