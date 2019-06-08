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
public class TankDB {

    private OilStationDB oils;
    private int id, capacity, currentCapacity, pricePerLiter;

    public TankDB(OilStationDB oils, int id, int capacity, int currentCapacity, int pricePerLiter) {
        this.oils = oils;
        this.id = id;
        this.currentCapacity = currentCapacity;
        this.pricePerLiter = pricePerLiter;
        this.capacity = capacity;
    }

    public OilStationDB getOils() {
        return oils;
    }

    public void setOils(OilStationDB oils) {
        this.oils = oils;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(int pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

}
