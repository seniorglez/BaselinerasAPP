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
public class Workshop {

    private int id, capacity;
    private String name, nif;
    private OilStation oils;

    public Workshop(int id, OilStation oils, String name, String nif, int capacity) {
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
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

    public OilStation getOils() {
        return oils;
    }

    public void setOils(OilStation oils) {
        this.oils = oils;
    }

}
