package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private static void exitProgram() {
        if (popups.ConfirmBox.display("Exit?", "Are you sure you want to exit?")) {

            if (inCombat)
                try {
                    PokeWriter.writeProg();
                    PokeWriter.writeLRTStr();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            window.close();

        }
    }

}
