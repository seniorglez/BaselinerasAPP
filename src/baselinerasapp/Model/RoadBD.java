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
public class RoadBD {

    private String nomenclature;
    private int kilometers;
    private ComunidadAutonomaBD ca;

    public RoadBD(String nomenclature, int Kilometers, ComunidadAutonomaBD ca) {
        this.nomenclature = nomenclature;
        this.kilometers = kilometers;
        this.ca = ca;
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

    public ComunidadAutonomaBD getCa() {
        return ca;
    }

    public void setCa(ComunidadAutonomaBD ca) {
        this.ca = ca;
    }
    
}
