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
public class Road {

    private String nomenclature;
    private int kilometers;
    private ComunidadAutonoma ca;

    public Road(String nomenclature, int Kilometers, ComunidadAutonoma ca) {
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

    public ComunidadAutonoma getCa() {
        return ca;
    }

    public void setCa(ComunidadAutonoma ca) {
        this.ca = ca;
    }
    
}
