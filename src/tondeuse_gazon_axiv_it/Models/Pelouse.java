/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Models;

/**
 *
 * @author asus
 */
public class Pelouse {

    private Coordonnees positionMax;

    public Pelouse() {

    }

    public Pelouse(Coordonnees pPositionMax) {
        this.positionMax = pPositionMax;
    }

    public Coordonnees getPositionMax() {
        return positionMax;
    }

    public void setPositionMax(Coordonnees positionMax) {
        this.positionMax = positionMax;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((positionMax == null) ? 0 : positionMax.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pelouse other = (Pelouse) obj;
        if (positionMax == null) {
            if (other.positionMax != null) {
                return false;
            }
        } else if (!positionMax.equals(other.positionMax)) {
            return false;
        }
        return true;
    }

}
