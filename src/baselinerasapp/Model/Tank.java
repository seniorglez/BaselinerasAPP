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
public class Tank {


    private OilStation oilStation;
    private Oil id;
    private int capacity, currentCapacity;
    private double pricePerLiter;

    public Tank(OilStation oils, Oil id, int capacity, int currentCapacity, double pricePerLiter) {
        this.oilStation = oils;

        this.id = id;
        this.currentCapacity = currentCapacity;
        this.pricePerLiter = pricePerLiter;
        this.capacity = capacity;
    }


    public OilStation getOilStation() {
        return oilStation;
    }

    public void setOilStation(OilStation oils) {
        this.oilStation = oils;

    }

    public Oil getId() {
        return id;
    }

    public void setId(Oil id) {
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

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

}
