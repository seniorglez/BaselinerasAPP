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
public class OilStationDB {

    private int id, kilometers;
    private CompanyDB con;
    private String nomenclature, name;
    private EmployeeDB chief;

    public OilStationDB(int id, CompanyDB con, EmployeeDB chief, String nomenclature, String name, int kilometers) {//revisar el id empleado
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

    public CompanyDB getCon() {
        return con;
    }

    public void setCon(CompanyDB con) {
        this.con = con;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
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

    public EmployeeDB getChief() {
        return chief;
    }

    public void setChief(EmployeeDB chief) {
        this.chief = chief;
    }

}
