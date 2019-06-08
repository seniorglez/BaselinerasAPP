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
public class EmployeeDB {

    private int id;
    private OilStationDB oils;
    private String dni, name, surname;

    public EmployeeDB(int id, OilStationDB oils, String dni, String name, String surname) {
        this.id = id;
        this.oils = oils;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OilStationDB getOils() {
        return oils;
    }

    public void setOils(OilStationDB oils) {
        this.oils = oils;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
