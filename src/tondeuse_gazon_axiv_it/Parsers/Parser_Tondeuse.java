/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Parsers;

/**
 *
 * @author asus
 */
public class Parser_Tondeuse {

    private String pelouse;
    private String tondeuse;
    private String instructions;

    public Parser_Tondeuse() {
        this.pelouse = "";
        this.tondeuse = "";
        this.instructions = "";
    }

    
     // retourne vrai si les informations de la tondeuse sont correctes, faux sinon
     
    public boolean executeParse() {
        return Parser_Donnees.parseTondeuse(tondeuse)
                && Parser_Donnees.parsePelouse(pelouse)
                && Parser_Donnees.parseListInstruction(instructions);
    }

    public String getPelouse() {
        return pelouse;
    }

    public void setPelouse(String pelouse) {
        this.pelouse = pelouse;
    }

    public String getTondeuse() {
        return tondeuse;
    }

    public void setTondeuse(String tondeuse) {
        this.tondeuse = tondeuse;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
