package tools;

import framework.Pokemon;
import scenes.Combat;

import java.io.File;
import java.io.IOException;

public class CombatProgress {
    public static void writePokemon(String line) {
        //todo remove pokemon in admin

        //todo save border style
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt",
                tempLine = line;
        File temp = new File(path);

        if (!temp.exists()) tempLine = "$\n" + tempLine;//check if custom file alr exist
        Writer.writer(tempLine, "Pokemons", true);

    }

    public static void writeProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        try {
            Writer.saveObject(Combat.getController(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Pokemon[][] getProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        try {
            return (Pokemon[][]) Writer.loadObject(path);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
