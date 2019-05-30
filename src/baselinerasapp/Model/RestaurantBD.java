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
public class RestaurantBD {

    private int id, tables, capacity;//tables stands for the piece of furniture, not for the db's object
    private String name, nif;
    private OilStationBD oils;

    public RestaurantBD(int id, OilStationBD oils, String name, String nif, int tables, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.nif = nif;
        this.tables = tables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public OilStationBD getOils() {
        return oils;
    }

    public void setOils(OilStationBD oils) {
        this.oils = oils;
    }

}
