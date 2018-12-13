package tools;

import framework.Pokemon;
import scenes.Combat;

import java.io.File;

public class CombatProgress {
    public static void writePokemon(String line) {
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt",
                tempLine = line;
        File temp = new File(path);

        if (!temp.exists()) tempLine = "$\n" + tempLine;//check if custom file alr exist
        Writer.writer(tempLine, "Pokemons", true);

    }

    public static void writeProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        Writer.saveObject(Combat.getController(), path);


    }

    public static Pokemon[][] getProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        return (Pokemon[][]) Writer.loadObject(path);

    }
}
