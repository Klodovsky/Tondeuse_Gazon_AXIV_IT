/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Traitements;

import tondeuse_gazon_axiv_it.Exceptions.Tondeuse_Exception;
import tondeuse_gazon_axiv_it.Models.Coordonnees;
import tondeuse_gazon_axiv_it.Models.Parametres;
import tondeuse_gazon_axiv_it.Models.Parametres.InstructionTondeuse;
import tondeuse_gazon_axiv_it.Models.Parametres.Orientation;
import tondeuse_gazon_axiv_it.Models.Position_Tondeuse;

/**
 *
 * @author asus
 */
public class Traitement_Instruction {

    private Traitement_Instruction() {

    }
        // faire avancer la tondeuse et retourner les nouvelles coordonnees
    public static Coordonnees avancerTondeuse(Position_Tondeuse positionTondeuse, Coordonnees coordonnesMax) throws Tondeuse_Exception {
        Coordonnees coordonneesSuivantes = null;
        int x, y;
        switch (positionTondeuse.getOrientationTondeuse()) {
            case NORTH:
                x = positionTondeuse.getCoordonneesTondeuse().getX();
                y = positionTondeuse.getCoordonneesTondeuse().getY() + 1;
                break;
            case EAST:
                x = positionTondeuse.getCoordonneesTondeuse().getX() + 1;
                y = positionTondeuse.getCoordonneesTondeuse().getY();
                break; 
            case SOUTH:
                x = positionTondeuse.getCoordonneesTondeuse().getX();
                y = positionTondeuse.getCoordonneesTondeuse().getY() - 1;
                break;
            case WEST:
                x = positionTondeuse.getCoordonneesTondeuse().getX() - 1;
                y = positionTondeuse.getCoordonneesTondeuse().getY();
                break;
            default:
                throw new Tondeuse_Exception(Parametres.POSITION_INCORRECTE);
        }
        coordonneesSuivantes = new Coordonnees(x, y);
        // si les nouvelles coordonnées sont en dehors de la pelouse, on garde la derniere position connu
        if (coordonneesSuivantes != null
                && coordonnesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
            return coordonneesSuivantes;
        } else {
            return positionTondeuse.getCoordonneesTondeuse();
        }
    }

    // faire pivoter la tondeuse à droite et retourner la nouvelle orientation
    public static Orientation pivoterDroite(Orientation orientation) throws Tondeuse_Exception {
        Orientation orientationSuivante = null;
        switch (orientation) {
            case NORTH:
                orientationSuivante = Orientation.EAST;
                break;
            case EAST:
                orientationSuivante = Orientation.SOUTH;
                break;
            case SOUTH:
                orientationSuivante = Orientation.WEST;
                break;
            case WEST:
                orientationSuivante = Orientation.NORTH;
                break;
            default:
                throw new Tondeuse_Exception(Parametres.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    // pivoter la tondeuse à gauche et retourner la nouvelle orientation
    public static Orientation pivoterGauche(Orientation orientation) throws Tondeuse_Exception {
        Orientation orientationSuivante = null;
        switch (orientation) {
            case NORTH:
                orientationSuivante = Orientation.WEST;
                break;
            case EAST:
                orientationSuivante = Orientation.NORTH;
                break;
            case SOUTH:
                orientationSuivante = Orientation.EAST;
                break;
            case WEST:
                orientationSuivante = Orientation.SOUTH;
                break;
            default:
                throw new Tondeuse_Exception(Parametres.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    // executer une seule instruction ( A, D ou G)
    public static void executerInstruction(Position_Tondeuse positionTondeuse, InstructionTondeuse instruction, Coordonnees coordonnesMax) throws Tondeuse_Exception {

        switch (instruction) {
            case AVANCER:
                positionTondeuse.setCoordonneesTondeuse(Traitement_Instruction.avancerTondeuse(positionTondeuse, coordonnesMax));
                break;
            case DROITE:
                positionTondeuse.setOrientationTondeuse(Traitement_Instruction.pivoterDroite(positionTondeuse.getOrientationTondeuse()));
                break;
            case GAUCHE:
                positionTondeuse.setOrientationTondeuse(Traitement_Instruction.pivoterGauche(positionTondeuse.getOrientationTondeuse()));
                break;
            default:
                throw new Tondeuse_Exception(Parametres.INSTRUCTION_INCORRECTE);
        }
    }
}
