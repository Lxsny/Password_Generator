
class passUtils {

    /**
     *
     * @param Length is the length of the output password
     * @param Lowercase whether to add lowercase alphabets or not
     * @param Uppercase whether to add uppercase alphabets or not
     * @param Digits whether to add digits or not
     * @param Symbols whether to add printable, non-alphanumeric symbols or not
     */
    public static String generator(int Lenght, boolean Lowercase, boolean Uppercase, boolean Digits, boolean Symbols) {

        if (Lenght < 3) {
            throw new IllegalArgumentException("Your password should be more than 3 letters.");
        }
        if (!Lowercase && !Uppercase && !Digits && !Symbols) {
            throw new IllegalArgumentException("How tf you want your password to be made with NOTHING?");
        }

        String printMe = "";
        for (int i = 0; i < Lenght; i++) {
            int r = ((int) (Math.random() * 94) + 33); // 33 -> 126
            if (r > 96 && r < 123 && Lowercase == true) {
                char test = ((char) r);
                printMe += test;
            } else if (r > 64 && r < 91 && Uppercase == true) {
                char test = ((char) r);
                printMe += test;
            } else if (r > 47 && r < 58 && Digits == true) {
                char test = ((char) r);
                printMe += test;
            } else if (((r > 32 && r < 48) || (r > 57 && r < 65) || (r > 90 && r < 97) || (r > 122 && r < 127)) && Symbols == true) {
                char test = ((char) r);
                printMe += test;
            } else {
                i--;
            }
        }
        return printMe;
    }

    /**
     * 
     * @param Password is your password to be checked according to the REGEX rules
     */
    public static String checker(String Password) {
    /*
    1 - Pathetically fragile
    2 - Extremely fragile
    3 - Somewhat fragile
    4 - Fairly solid
    5 - Quite strong
    6 - Extremely powerful 
    */
        int points = 0; // 0 -> 6
        if(Password == null || Password == "")
        return "Password is Empty.";
        // --
        if (Password.length() > 16) {
            points += 2; 
        }else if (Password.length() > 8) {
            points++;
        }
        if (Password.matches(".*\\d.*")) // Atleast 1 Digit
        points++;
        if (Password.matches(".*[a-z].*")) // Atleast 1 Caps off
        points++;
        if (Password.matches(".*[A-Z].*")) // Atleast 1 Caps on
        points++;
        if (Password.matches(".*[^a-zA-Z0-9].*")) // Atleast 1 Symbol
        points++;   
        
        if (points == 1)
        return "1/6 -- Pathetically fragile";
        else if (points == 2)
        return "2/6 -- Extremely fragile";
        else if (points == 3)
        return "3/6 -- Somewhat fragile";
        else if (points == 4)
        return "4/6 -- Fairly solid";
        else if (points == 5)
        return "5/6 -- Quite strong";
        else if (points == 6)
        return "6/6 -- Extremely strong";
        // --
        else
        return "Error";
    }
}
