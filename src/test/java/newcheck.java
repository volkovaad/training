import java.util.HashMap;

public class newcheck {
    // Morse code dictionary
    private static final HashMap<Character, String> morseCodeMap = new HashMap<>();
    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
    }

    // Function to convert a character to Morse code
    private static String charToMorse(char c) {
        return morseCodeMap.getOrDefault(Character.toUpperCase(c), "");
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Function to check if a string is a Morse Code Palindrome
    private static boolean isMorseCodePalindrome(String input) {
        StringBuilder morseCodeBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                morseCodeBuilder.append(charToMorse(c));
            }
        }
        String morseCode = morseCodeBuilder.toString();
        return isPalindrome(morseCode);
    }

    public static void main(String[] args) {
        // Input string
        String input = "A E";

        // Check if the input string is a Morse Code Palindrome
        if (isMorseCodePalindrome(input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}


