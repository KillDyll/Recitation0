
/**
 * Write a description of class Morse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MorseCode
{
    private static final String WPAUSE = "[wpause]";
    private static final String LPAUSE = "[lpause]";

    private static String morseCode(char ch)
    {
        switch(ch){
            case 'A':
                return ".-";
            case 'B':
                return "-...";
            case 'C':
                return "-.-";
            case 'D':
                return "-..";
            case 'E':
                return ".";
            case 'F':
                return "..-.";
            case 'G':
                return "--.";
            case 'H':
                return "....";
            case 'I':
                return "..";
            case 'J':
                return ".---";
            case 'K':
                return "-.-";
            case 'L':
                return ".-..";
            case 'M':
                return "--";
            case 'N':
                return "-.";
            case 'O':
                return "---";
            case 'P':
                return ".--.";
            case 'Q':
                return "--.-";
            case 'R':
                return ".-.";
            case 'S':
                return "...";
            case 'T':
                return "-";
            case 'U':
                return "..-";
            case 'V':
                return "...-";
            case 'W':
                return ".--";
            case 'X':
                return "-..-";
            case 'Y':
                return "-.--";
            case 'Z':
                return "--..";
            case '0':
                return "-----";
            case '1':
                return ".----";
            case '2':
                return "..---";
            case '3':
                return "...--";
            case '4':
                return "....-";
            case '5':
                return ".....";
            case '6':
                return "-....";
            case '7':
                return "--...";
            case '8':
                return "---..";
            case '9':
                return "----.";
        }
        return null;
    }

    public static String encodeMessage(String message)
    {
        message = message.toUpperCase().trim();
        String encodedMessage = "";
        boolean isInWord = false;
        int index = 0;

        while (index < message.length()) {
            char ch = message.charAt(index);
            String code = morseCode(ch);
            if (isInWord){
                if ( code != null) {
                    encodedMessage += LPAUSE+code;
                } else {
                    encodedMessage += WPAUSE;
                    isInWord = false;
                }
            } else {
                if (code != null) {
                    encodedMessage += code;
                    isInWord = true;
                }
            }
            index++;
        }
        return encodedMessage;
    }
}

