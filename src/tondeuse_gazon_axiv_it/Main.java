package tondeuse_gazon_axiv_it;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tondeuse_gazon_axiv_it.Exceptions.Tondeuse_Exception;

import tondeuse_gazon_axiv_it.Models.Parametres;
import tondeuse_gazon_axiv_it.Parsers.Parser_Tondeuse;
import tondeuse_gazon_axiv_it.Traitements.Formater_ligne;
import tondeuse_gazon_axiv_it.Traitements.Traitement_Tondeuse;

public class Main {

    protected static List<String> listResultats;

    public static void main(String... args) throws Tondeuse_Exception, IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            Main instance = new Main();
            listResultats = instance.lancerTraitementsTondeuses(file);
        } else {
            throw new IllegalArgumentException();
        }
    }
		// lecture/validation du fichier et lancement des tondeuses
	
    private List<String> lancerTraitementsTondeuses(File fichier)
            throws Tondeuse_Exception, IOException {
        if (!fichier.isFile()) {
            throw new Tondeuse_Exception(Parametres.ERREUR_FICHIER_INEXISTANT);
        } else {
            Parser_Tondeuse parser = new Parser_Tondeuse();
            Scanner scanner = new Scanner(fichier);
            try {
                traiterPremiereLigne(parser, scanner);
                return traiterLignesSuivantes(parser, scanner);
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

	 // traiter la premiere ligne du fichier (erreur si le fichier contients moins de 2 lignes)
    
    protected void traiterPremiereLigne(Parser_Tondeuse parser, Scanner scanner)
            throws Tondeuse_Exception {
        if (scanner.hasNext()) {
            parser.setPelouse(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new Tondeuse_Exception(
                    Parametres.ERREUR_DONNEES_INCORRECTES);
        }
    }

	 // returner la position des tondeuses
	
    private List<String> traiterLignesSuivantes(Parser_Tondeuse parser,
            Scanner scanner) throws Tondeuse_Exception {
        List<String> listePositions = new ArrayList<String>();
        while (scanner.hasNext()) {
            // lecture de la positon initiale de la tondeuse
            parser.setTondeuse(scanner.nextLine());

            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                listePositions.add(parserEtLancerTraitement(parser));
            } else {
                throw new Tondeuse_Exception(Parametres.ERREUR_DONNEES_INCORRECTES);
            }
        }
        return listePositions;
    }

	 // Parser et executer le traitement de la tondeuse a partir de l'objet contenant les informations de la tondeuse
    
    private String parserEtLancerTraitement(Parser_Tondeuse parser)
            throws Tondeuse_Exception {
        if (!parser.executeParse()) {
            throw new Tondeuse_Exception(Parametres.ERREUR_DONNEES_INCORRECTES);
        } else {
            Traitement_Tondeuse traitement = new Traitement_Tondeuse();
            traitement.setPelouse(Formater_ligne
                    .formaterLignePelouse(parser.getPelouse()));
            traitement.setPositionTondeuse(Formater_ligne
                    .formaterLigneTondeuse(parser.getTondeuse()));
            traitement.setListeInstruction(Formater_ligne
                    .formaterLigneInstruction(parser.getInstructions()));
            traitement.executerInstructions();
            System.out.println(traitement);
            return traitement.toString();
        }
    }
}
