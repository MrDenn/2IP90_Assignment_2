import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Reads a list of numbers, and can reconstruct the corresponding list of Palindromes,
 * produce the size of the largest magic set, and the content of that magic set.
 *
 * Usage:
 * TODO: Documentation
 * On the first line enter 1, 2 or 3 to indicate which task needs to be solved:
 * 1 for printing the correct palindrome list.
 * 2 for printing the size of the largest magic set.
 * 3 for printing the largest magic set.
 * On the second line enter the number of elements in the list received from the king's advisor.
 * On the third line enter the numbers from the list, separated by a space.
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

    /**
     Custom constructor for object that reads needed data from user.
     @param scanner the scanner to read user input.
     */
    public KingsPalindromeList(Scanner scanner) {

        this.operationType = scanner.nextInt();
        // Recording type of task that needs to be solved
        this.numbersCount = scanner.nextInt();
        // Recording number of values to be read from keyboard
        this.numbers = new String[this.numbersCount];
        // Initialising "numbers" array with given length

        for (int i = 0; i < this.numbersCount; i++) {
            this.numbers[i] = scanner.next(); // Recording numbers to the list
        }
    }

    /**
     Method that checks whether the given number is a palindrome
     and if not, turns the given number into a palindrome.
     @param inputNum the given number.
     @return palindrome.
     */
    private String fixPalindrome(String inputNum) {

        int centerIndex = inputNum.length() / 2;
        // Index denoting the center of the given number

        if (inputNum.length() == 1) {
            return inputNum;
        }

        int rightSide = Integer.parseInt(
                inputNum.substring(centerIndex + 1)
        );
        int leftSideRev = Integer.parseInt(
                new StringBuilder(inputNum.substring(0, centerIndex)).reverse().toString()
        );

        if (leftSideRev == rightSide) {
            return inputNum;
        } else {
            String leftSide = inputNum.substring(0, centerIndex + 1);

            if (leftSideRev < rightSide) {
                leftSide = String.valueOf(Integer.parseInt(leftSide) + 1);
            }

            StringBuilder rightSideAns = new StringBuilder(leftSide.substring(0, centerIndex));
            rightSideAns.reverse();
            return (leftSide + rightSideAns);
        }
    }

    /**
     Method that returns the largest magic set that can be obtained from list of palindromes.
     @return maxList the list containing the largest magic set.
     */
    private String[] searchMagicSet() {

        String[] numSplit = new String[numbers.length]; // Array of right half of each number

        Arrays.sort(this.numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });

        int maxLength = 0; // The length of the longest magic set
        String[] maxList = new String[1];
        maxList[0] = "start";


        for (int i = 0; i < this.numbersCount; i++) {
            int numLength = this.numbers[i].length();
            if (numLength > 1) {
                numSplit[i] = this.numbers[i].substring(numLength / 2, numLength);
            } else {
                numSplit[i] = this.numbers[i];
            }
        }

        for (int i = numbersCount - 1; (i >= 0) && (numSplit[i].length() > maxLength); i--) {
            List<String> currentList = new ArrayList<String> ();
            currentList.add(this.numbers[i]);

            for (int j = 1; j < numSplit[i].length(); j++) {
                boolean found = false;

                for (int k = i - 1; (k >= 0) && !found; k--) {
                    if (numSplit[k].equals(numSplit[i].substring(0, numSplit[i].length() - j))) {
                        found = true;
                        currentList.add(this.numbers[k]);
                    }
                }
            }

            if ((currentList.size() > maxList.length) || (maxList[0].equals("start"))) {
                maxList = new String[currentList.size()];
                for (int j = 0; j < currentList.size(); j++) {
                    maxList[j] = currentList.get(currentList.size() - 1 - j);
                }
            }
        }

        return maxList;
    }

    /**
     Method that executes the functionality defined by operationType.
     */
    public void run() {

        for (int i = 0; i < this.numbersCount; i++) {
            this.numbers[i] = fixPalindrome(this.numbers[i]);
        }

        switch (this.operationType) {
            case 1:
                printNumbers();
                break;
            case 2:
                printMagicSetSize();
                break;
            case 3:
                printMagicSetElements();
                break;
            default:
                System.err.println("Unknown operation type: " + this.operationType);
        }
    }

    /**
     * Method that prints numbers from the correct palindrome list.
     */
    private void printNumbers() {

        for (String number : this.numbers) {
            System.out.print(number + " ");
        }
    }

    /**
     * Method that prints magic set size.
     */
    private void printMagicSetSize() {

        String[] ansArray = this.searchMagicSet();
        System.out.print(ansArray.length);
    }

    /**
     * Method that prints the magic set list.
     */
    private void printMagicSetElements() {

        String[] ansArray = this.searchMagicSet();
        for (String element : ansArray) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Creating scanner to read user input
        KingsPalindromeList palindromes = new KingsPalindromeList(scanner);
        // Creating instance of custom class
        palindromes.run();
    }
}