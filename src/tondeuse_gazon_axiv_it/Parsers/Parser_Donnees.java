/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Parsers;

import tondeuse_gazon_axiv_it.Models.Parametres.InstructionTondeuse;
import tondeuse_gazon_axiv_it.Models.Parametres.Orientation;

/**
 *
 * @author asus
 */
public class Parser_Donnees {
    
    	private Parser_Donnees(){

	}


	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
			.append("|").append(Orientation.SOUTH.getCodeOrientation())
			.append("|").append(Orientation.EAST.getCodeOrientation())
			.append("|").append(Orientation.WEST.getCodeOrientation());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	

	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(InstructionTondeuse.AVANCER.getCodeInstruction())
		.append("|").append(InstructionTondeuse.DROITE.getCodeInstruction())
		.append("|").append(InstructionTondeuse.GAUCHE.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}


	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
    
}
