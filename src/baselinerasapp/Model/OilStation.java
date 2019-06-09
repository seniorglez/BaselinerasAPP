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

public class OilStation {


    private int id, kilometers;
    private Company con;
    private String name;
    private Road nomenclature;
    private Employee chief;


    public OilStation(int id, Company con, Employee chief, Road nomenclature, String name, int kilometers) {//revisar el id empleado

        this.id = id;
        this.con = con;
        this.nomenclature = nomenclature;
        this.name = name;
        this.kilometers = kilometers;
        this.chief = chief;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCon() {
        return con;
    }

    public void setCon(Company con) {
        this.con = con;
    }

    public Road getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Road nomenclature) {
        this.nomenclature = nomenclature;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

}
