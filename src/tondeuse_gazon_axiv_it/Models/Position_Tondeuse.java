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
public class Position_Tondeuse {

    private Coordonnees coordonneesTondeuse;
    private Parametres.Orientation orientationTondeuse;

    public Position_Tondeuse(Coordonnees pCoordonneesTondeuse,
            Parametres.Orientation pOrientationTondeuse) {
        this.coordonneesTondeuse = pCoordonneesTondeuse;
        this.orientationTondeuse = pOrientationTondeuse;
    }

    public Parametres.Orientation getOrientationTondeuse() {
        return orientationTondeuse;
    }

    public void setOrientationTondeuse(Parametres.Orientation pOrientationTondeuse) {
        this.orientationTondeuse = pOrientationTondeuse;
    }

    public Coordonnees getCoordonneesTondeuse() {
        return coordonneesTondeuse;
    }

    public void setCoordonneesTondeuse(Coordonnees pCoordonneesTondeuse) {
        this.coordonneesTondeuse = pCoordonneesTondeuse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordonneesTondeuse == null) ? 0 : coordonneesTondeuse.hashCode());
        result = prime * result + ((orientationTondeuse == null) ? 0 : orientationTondeuse.hashCode());
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
        Position_Tondeuse other = (Position_Tondeuse) obj;
        if (coordonneesTondeuse == null) {
            if (other.coordonneesTondeuse != null) {
                return false;
            }
        } else if (!coordonneesTondeuse.equals(other.coordonneesTondeuse)) {
            return false;
        }
        if (orientationTondeuse != other.orientationTondeuse) {
            return false;
        }
        return true;
    }

}
