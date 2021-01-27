import java.util.stream.Stream;

public class Palindromes {
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
    public int cantidadPalabrasPalindromes(){
        int contador = (int) Stream.of("Ababa", "Abalaba", "Ana", "alacazan").filter(this::isPalindrome).count();
        return  contador;
    }
}

