package tools;

import java.util.Random;

public class FourLetter {
    private static final Random r = new Random();


    private static int wasDumb = 0;
    private static int wasMean = 0;

    public static String getPhrase(int niceness) {
        int tempNiceness = niceness;
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
                "Awesome!!!" 
        },


                mean = {
                        "You can't even do this?",
                        "You're the reason I have depression.",
                        "Do you need a nudge on your head?",
                        "I bet you have a TikTok account.",
                        "I spent days coding this and you can't even do this right?",
                        "What the frick?",
                        "Your parents will dab on you when you die",
                        "This isn't even something that requires a high level of intelligence"
                        "Dude, just gth."
                },
                sarcastic = {
                        "Wow! You're so very very smart now!",
                        "Congratulations! Your mother must be proud",
                        "You deserve an award!!!",
                        "I am very happy that you have improved your thinking skills"
                },
                computer = {
                        "Is that all you got?",
                        "Bring it on.",
                        "My grandma could do better",
                        "You should stick to Candy Crush",
                        "You gotta do a little better than that if you wanna beat me",
                        "I'm telling you, you're hopeless."
                };


        //2 is nice/1 is mean/0 is sarcastic
        if (tempNiceness < 10) {
            if (wasMean > 3 && tempNiceness == 2) {
                wasDumb = 0;
                wasMean = 0;
            }
            if (wasDumb > 3 && tempNiceness == 2) {
                tempNiceness = 0;
            }
        } else if (tempNiceness < 20) {
            tempNiceness = 3;
        }


        switch (tempNiceness) {
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
