import java.util.Scanner;

/**
 * Reads a list of numbers, and can reconstruct the corresponding list of Palindromes,
 * produce the size of the largest magic set, and the content of that magic set.
 *
 * Usage:
 * TODO: Documentation
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
       Function that checks whether the given number is a palindrome
       and if not, turns the given number into a palindrome
     */
    private String FixPalindrome (String inputNum) {
        System.out.println("testing numper " + inputNum);
        //int leftSideEnd = ;
        int leftEndIndex = inputNum.length() / 2; // Index denoting end of number's left half
        int rightStartIndex = inputNum.length() / 2 + inputNum.length() % 2;
            // Index denoting the first element number's right half

        if (inputNum.length() == 1) {
            return inputNum;
        }

        int rightSide = Integer.parseInt(inputNum.substring(rightStartIndex)
        );
        int leftSideRev = Integer.parseInt(
                new StringBuilder(inputNum.substring(0, leftEndIndex)).reverse().toString()
         );

        if (leftSideRev == rightSide) {
            return inputNum;
        } else {
            String leftSide = inputNum.substring(0, rightStartIndex);

            if (leftSideRev < rightSide) {
                leftSide = String.valueOf(Integer.parseInt(leftSide) + 1);
            }

            StringBuilder rightSideAns = new StringBuilder(leftSide.substring(0, leftEndIndex));
            rightSideAns.reverse();
            return (leftSide + rightSideAns);
        }
    }


    /*
       Function that for all elements of this object executes FixPalindrome
     */
    public void FixList () {
        for (int i=0; i < this.numbersCount; i++) {
            this.numbers[i] = FixPalindrome(this.numbers[i]);
        }
    }

    public void Print () {
        if (this.operationType == 1) {
            for (int i=0; i < this.numbersCount; i++) {
                //System.out.println("Number " + (i + 1) + " is turned into: " + this.numbers[i]);
                System.out.println();
            }
        }
    }

    /*
        Function that returns the number of elements of the largest magic set
        that can be obtained from list of palindromes
     */
    int LargestMagicSetElementCount () {
        return 0; // заглушка
    }

    /*
        Function that returns the array of palindromes from which the largest magic set is formed in ascending order
        If there are several such largest magic sets, the one with the largest first palindrome is displayed
        If there are no magic sets, the largest number in the given list is displayed
     */
    int LargestMagicSet () {
        return 0; // заглушка, неправильный тип возврата функции
    }

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in); // Creating scanner to read user input
        KingsPalindromeList palindromes = new KingsPalindromeList(); // Creating instance of custom class
        palindromes.operationType = scanner.nextInt(); // Recording type of task that needs to be solved
        palindromes.numbersCount = scanner.nextInt(); // Recording number of values to be read from keyboard
        palindromes.numbers = new String[palindromes.numbersCount]; // Initialising "numbers" array with given length

        for (int i = 0; i < palindromes.numbersCount; i++) {
            palindromes.numbers[i] = scanner.next(); // Recording numbers to the list
        }

        //for (int i = 0; i < palindromes.numbersCount; i++) {
        //    System.out.println(palindromes.FixPalindrome(palindromes.numbers[i]));
        //}



    }
}