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
public class Carwash {

    private int id, tunnels, hosepipes;
    private String name, nif;
    private OilStation oils;

    public Carwash(int id, OilStation oils, String name, String nif, int tunnels, int hosepipes) {

        this.hosepipes = hosepipes;
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.oils = oils;
        this.tunnels = tunnels;
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

    public int getTunnels() {
        return tunnels;
    }

    public void setTunnels(int tunnels) {
        this.tunnels = tunnels;
    }

    public int getHosepipes() {
        return hosepipes;
    }

    public void setHosepipes(int hosepipes) {
        this.hosepipes = hosepipes;
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
