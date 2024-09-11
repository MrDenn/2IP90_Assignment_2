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

    int operationType; // Number to store the type of operation that will be carried out
    int numbersCount; // Number of values to be processed as palindromes
    String[] numbers; // An array of given numbers stored as Strings


    /*
      Function that returns:
        'S' if the given number is already a palindrome
        'L' if the left half of palindrome is larger than the reversed right half
        'R' if the reversed right half of the palindrome is larger than the left half
     */
    public char TestPalindrome (String inputNum) {
        System.out.println("testing numper " + inputNum);

        if (inputNum.length() == 1) {
            return 'S';
        }

        int rightSide = Integer.valueOf(inputNum.substring(inputNum.length() / 2 + inputNum.length() % 2, inputNum.length()));
        int leftSideRev = Integer.valueOf(new StringBuilder(inputNum.substring(0, inputNum.length() / 2)).reverse().toString());

        System.out.println("right side: " + rightSide + " left side rev: " + leftSideRev);

        if (leftSideRev == rightSide) {
            return 'S';
        } else if (leftSideRev > rightSide) {
            return 'L';
        } else {
            return 'R';
        }
    }

    /*
       Function that turns the given number (in string form) into a palindrome
     */
    /*String MakePalindrome (String inputNum) {

        if (this.IsPalindrome(inputNum)) {
            return inputNum; // If number is already a palindrome, no action is needed, number itself is returned
        } else {
            char bigger = 'S'; // Indicator of which half of the palindrome is bigger: 'R' or 'L'
            char[] palindrome = inputNum.toCharArray();

            for (int i = 0; (i < palindrome.length / 2) && (bigger == 'S'); i++) {
                int posLeft = palindrome.length / 2 - i - 1;
                int posRight = palindrome.length / 2 + palindrome.length % 2 +  i;

                if (palindrome[posLeft] > palindrome[posRight]) {
                    bigger = 'L'; // Left side of palindrome is bigger
                } else if (palindrome[posLeft] < palindrome[posRight]) {
                    bigger = 'R'; // Right side of palindrome is bigger
                }
            }

            if (bigger == 'R'){
                palindrome[palindrome.length / 2 - 1] += 1;

            }

            StringBuilder answer = new StringBuilder(inputNum); // Variable to store the final palindrome in

            if (bigger == 'L'){
                for (int i = 0; i < inputNum.length() / 2; i++) {
                    answerNum.replace(i, inputNum.charAt(i));
                }
            }
        }



        return "nada";
    }*/

    /*
        Function that returns the number of elements of the largest magic set
        that can be obtained from list of palindromes
     */
    int LargestMagicSetElementCount () {
        return 0; // заглушка
    };

    /*
        Function that returns the array of palindromes from which the largest magic set is formed in ascending order
        If there are several such largest magic sets, the one with the largest first palindrome is displayed
        If there are no magic sets, the largest number in the given list is displayed
     */
    int LargestMagicSet () {
        return 0; // заглушка, неправильный тип возврата функции
    };

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in); // Creating scanner to read user input
        KingsPalindromeList palindromes = new KingsPalindromeList(); // Creating instance of custom class
        palindromes.operationType = scanner.nextInt(); // Recording type of task that needs to be solved
        palindromes.numbersCount = scanner.nextInt(); // Recording number of values to be read from keyboard
        palindromes.numbers = new String[palindromes.numbersCount]; // Initialising "numbers" array with given length

        for (int i = 0; i < palindromes.numbersCount; i++) {
            palindromes.numbers[i] = scanner.next(); // Recording numbers to the list
        }

        for (int i = 0; i < palindromes.numbersCount; i++) {
            System.out.println("for num " + (i + 1) + ":" + palindromes.TestPalindrome(palindromes.numbers[i]));
        }



    }
}