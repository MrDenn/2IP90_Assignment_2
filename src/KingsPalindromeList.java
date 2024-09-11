import java.util.Scanner;

/**
 * Reads a list of numbers, and can reconstruct the corresponding list of Palindromes,
 * produce the size of the largest magic set, and the content of that magic set.
 *
 * Usage:
 * TODO: Documentation
 *
 * END TODO
 *
 * @author <Denis Shaikhatarov>
 * @ID <2110415>
 * @author <Aleksandr Sharov>
 * @ID <2155915>
 *
 */
class KingsPalindromeList {

    int operationNum; // Number to store the type of operation that will be carried out
    int numbersCount; // Number of values to be processed as palindromes
    String[] numbers; // An array of given numbers stored as Strings

    boolean IsPalindrome (String inputNum) {
        boolean isPalindrome = true;
        for (int i = 0; (i < inputNum.length() / 2) && isPalindrome; i++) {
            if (inputNum.charAt(i) != inputNum.charAt(inputNum.length() - 1 - i)) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    String MakePalindrome (String inputNum) {
        return "nada";
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); // Creating scanner to read user inputs
        KingsPalindromeList palindromes = new KingsPalindromeList(); // Creating instance of custom class
        palindromes.numbersCount = scanner.nextInt(); // Recording number of values to be read from keyboard
        palindromes.numbers = new String[palindromes.numbersCount]; // Initialising "numbers" array with given length

        for (int i = 0; i < palindromes.numbersCount; i++) {
            palindromes.numbers[i] = scanner.next();
        }

        for (int i = 0; i < palindromes.numbersCount; i++) {
            System.out.println("for number" + (i + 1) + ": " + palindromes.IsPalindrome(palindromes.numbers[i]));
        }



    }
}