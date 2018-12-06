package tools;

import java.util.Random;

public class FourLetter {
    static Random r = new Random();


    private static int wasDumb = 0;
    private static int wasMean = 0;

    public static String getPhrase(int niceness) {
//todo add more lines
        String[]

                nice = {
                "Nice!",
                "WOW!",
                "You smell like flowers.",
                "You're cool",
                "I like you already :)",
                "You have a nice face",
                "Good one",
                "You have a nice face, really... (not in a creepy way) :-)",
                "Hey cutie ;)"
        },


                mean = {
                        "You can't even do this?",
                        "You're the reason I have depression.",
                        "Do you need a nudge on your head?",
                        "I bet you have a TikTok account.",
                        "I spent days coding this and you can't even do this right?",
                        "What the frick?",
                        "Your parents will dab on you when you die",
                        "This is something that doesn't even require high intelligence level"
                },
                sarcastic = {
                        "Wow! You're so very very smart now!",
                        "Congratulations! Your mother must be proud",
                        "You deserve an award!!!"
                },
                computer = {
                        "Is that all you got?",
                        "Bring it on.",
                        "My grandma could do better",
                        "You should stick to Candy Crush"
                };


        //2 is nice/1 is mean/0 is sarcastic
        if (niceness < 10) {
            if (wasMean > 3 && niceness == 2) {
                wasDumb = 0;
                wasMean = 0;
            }
            if (wasDumb > 3 && niceness == 2) {
                niceness = 0;
            }
        } else if (niceness < 20) {
            niceness = 3;
        }


        switch (niceness) {
            case 0:
                wasMean++;
                return sarcastic[r.nextInt(sarcastic.length)];
            case 1:
                wasDumb++;
                return mean[r.nextInt(mean.length)];
            case 2:
                return nice[r.nextInt(nice.length)];
            case 3:
                return computer[r.nextInt(computer.length)];

            default:
                return "Mr. Stark I don't feel so good";
        }


    }
}
