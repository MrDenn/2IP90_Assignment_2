import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Reads a list of numbers, and can reconstruct the corresponding list of Palindromes,
 * produce the size of the largest magic set, and the content of that magic set.
 *
 * Usage:
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
       Custom constructor for object that reads needed data from user
     */
    public KingsPalindromeList(Scanner scanner) {

        this.operationType = scanner.nextInt(); // Recording type of task that needs to be solved
        this.numbersCount = scanner.nextInt(); // Recording number of values to be read from keyboard
        this.numbers = new String[this.numbersCount]; // Initialising "numbers" array with given length

        for (int i = 0; i < this.numbersCount; i++) {
            this.numbers[i] = scanner.next(); // Recording numbers to the list
        }
    }

    /*
       Function that checks whether the given number is a palindrome
       and if not, turns the given number into a palindrome
     */
    private String fixPalindrome(String inputNum) {

        int leftEndIndex = inputNum.length() / 2; // Index denoting end of number's left half
        int rightStartIndex = inputNum.length() / 2 + inputNum.length() % 2;
        // Index denoting the first element number's right half

        if (inputNum.length() == 1) {
            return inputNum;
        }

        int rightSide = Integer.parseInt(
                inputNum.substring(rightStartIndex)
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
        Function that returns the number of elements of the largest magic set
        that can be obtained from list of palindromes
     */
    private String[] searchMagicSet() {

        String[] numSplit = new String[numbers.length]; // Array of right halves of each number

        // Arrays.sort(this.numbers);

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

                //System.out.println("running tests number " + this.numbers[i]);

            for (int j = 1; j < numSplit[i].length(); j++) {
                boolean found = false;

                for (int k = i - 1; (k >= 0) && !found; k--) {
                    if (numSplit[k].equals(numSplit[i].substring(0, numSplit[i].length() - j))) {
                        found = true;
                            //System.out.println("found number " + numSplit[i].substring(0, numSplit[i].length() - j));
                        currentList.add(this.numbers[k]);
                    }
                }
            }

            if ((currentList.size() > maxList.length) || (maxList[0] == "start")) {
                maxList = new String[currentList.size()];
                for (int j = 0; j < currentList.size(); j++) {
                    maxList[j] = currentList.get(currentList.size() - 1 - j);
                }
            }

        }

        return maxList;
    }

    /*
       Function that executes the functionality defined by operationType
     */
    public void run() {

        for (int i = 0; i < this.numbersCount; i++) {
            this.numbers[i] = fixPalindrome(this.numbers[i]);
        }

        if (this.operationType == 1) {
            for (int i = 0; i < this.numbersCount; i++) {
                System.out.print(this.numbers[i] + " ");
            }
        } else {
            String[] ansArray = this.searchMagicSet();

            if (this.operationType == 2) {
                System.out.print(ansArray.length);
            } else if (this.operationType == 3) {
                for (int i = 0; i < ansArray.length; i++) {
                    System.out.print(ansArray[i] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Creating scanner to read user input
        KingsPalindromeList palindromes = new KingsPalindromeList(scanner);
            // Creating instance of custom class
        palindromes.run();
    }
}