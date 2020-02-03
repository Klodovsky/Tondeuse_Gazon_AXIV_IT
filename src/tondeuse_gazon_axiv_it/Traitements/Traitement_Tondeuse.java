/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Traitements;
import java.util.ArrayList;
import java.util.List;


import tondeuse_gazon_axiv_it.Exceptions.Tondeuse_Exception;
import tondeuse_gazon_axiv_it.Models.Parametres;
import tondeuse_gazon_axiv_it.Models.Parametres.InstructionTondeuse;
import tondeuse_gazon_axiv_it.Models.Pelouse;
import tondeuse_gazon_axiv_it.Models.Position_Tondeuse;
/**
 *
 * @author asus
 */
public class Traitement_Tondeuse {

	private Pelouse pelouse;
	private Position_Tondeuse positionTondeuse;
	private List<Parametres.InstructionTondeuse> listeInstruction;
	
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	public void setPositionTondeuse(Position_Tondeuse positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	}

	public void setListeInstruction(
			List<Parametres.InstructionTondeuse> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<InstructionTondeuse>();
		}
	}
		//executer l'ensemble des insctructions par une tondeuse
	public void executerInstructions() throws Tondeuse_Exception{
		for(InstructionTondeuse instruction : listeInstruction){
			Traitement_Instruction.executerInstruction(positionTondeuse,
					instruction, this.pelouse.getPositionMax());
		}
	}

        @Override
	public String toString(){
		return 	positionTondeuse.getCoordonneesTondeuse().getX() 
				+ " " 
				+ positionTondeuse.getCoordonneesTondeuse().getY()
				+ " " 
				+ positionTondeuse.getOrientationTondeuse().getCodeOrientation() ;
	}
}
