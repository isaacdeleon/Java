package org.ginger.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Controller that contains the logic for Bingo Electronico.
 *
 * @author Isaac Laurrabaquio &lt;
 * @version 1.0.0
 * @since 1.0.0
 */
public class BingoController {

    /**
     * Logger Class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BingoController.class);

    /**
     * Set of numbers of the bingo.
     */
    private static LinkedHashSet<String> bingoNumberSet = new LinkedHashSet<String>();

    /**
     * Random Generator for bingo numbers.
     */
    private static Random random = new Random();

    /**
     * Bingo letter to compose thenumber.
     */
    private final String alphabet;

    /**
     * Constructor for BingoResource.
     * @param alphabet the bingo alphabet.
     */
    public BingoController(final String alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Generate a New Game.
     * @return int (0 successfull restar, 1 if it was a problem).
     */
    public int generateNewGame() {
        try {
            random = new Random();
            bingoNumberSet = new LinkedHashSet<String>();
            return 0;
        } catch (Exception ex) {
            LOGGER.error("Error Restarting game:{}", ex);
            return 1;
        }
    }

    /**
     * Returns a set with generated numbers.
     * @return HashSet with numbers.
     */
    public HashSet<String> getGeneratedNumbers() {
        return bingoNumberSet;
    }

    /**
     * Method to get RandomNumber.
     * @return bingoGenerated Number.
     */
    public String getRandomNumber() throws Exception {
        String bingoNumber;
        do {
            bingoNumber = generateRandomComb(alphabet);
            LOGGER.info("find size " + bingoNumberSet.size() + "  " + bingoNumberSet.contains(bingoNumber) + " number " + bingoNumber);
        } while(bingoNumberSet.contains(bingoNumber) && bingoNumberSet.size() < 75);

        if(bingoNumberSet.size() < 74) {
            bingoNumberSet.add(bingoNumber);
        } else if (!bingoNumberSet.contains(bingoNumber)) {
            bingoNumberSet.add(bingoNumber);
        } else {
            bingoNumber = "Juego Finalizo";
        }
        return bingoNumber;
    }

    /**
     * Method to generate RandomNumber.
     * @param alphabet the bingo alphabet.
     * @return bingoGenerated Number.
     */
    public String generateRandomComb(final String alphabet) throws Exception {
        String letter = String.valueOf(alphabet.charAt(random.nextInt(5)));
        String bingoNumberGenerated = null;
        switch (letter) {
            case "B": bingoNumberGenerated = letter + String.valueOf(random.nextInt(15-0) + 1); break;
            case "I": bingoNumberGenerated = letter + String.valueOf(random.nextInt(30-15) + 16); break;
            case "N": bingoNumberGenerated = letter + String.valueOf(random.nextInt(45-30) + 31); break;
            case "G": bingoNumberGenerated = letter + String.valueOf(random.nextInt(60-45) + 46); break;
            case "O": bingoNumberGenerated = letter + String.valueOf(random.nextInt(75-60) + 61); break;
        }
        return bingoNumberGenerated;
    }
}
