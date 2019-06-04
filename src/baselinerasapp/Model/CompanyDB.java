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
public class CompanyDB {

    private int id;
    private String location;
    private String name;
    private String nif;

    public CompanyDB(int id, String location, String name, String nif) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.nif = nif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

}
