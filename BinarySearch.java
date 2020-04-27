import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
* The BinarySearch program implements an application that generates 256 values between 0 - 256
* and accepts input from the user to find their input in the generated values via binary search.
*
* @author  Bradley Wills
* @version 1.0
* @since   2020-04-26
*/

public class BinarySearch {
  
  static int randomizedNum;
  static int[] numberArray = new int[257];
  
  /**
  * Populates the array with random numbers and outputs the position the inputted number is at.
  */
  
  public static void main(String[] args) {
    
    boolean finished = false;
    boolean finished2 = false;
    int inputtedNum;
    int maxValue;
    int midValue;
    int minValue;
    Scanner userInput = new Scanner(System.in);
    Random randomizer = new Random();
    for (int m = 1; m <= 256; m++) {
      // Generate random number
      randomizedNum = (randomizer.nextInt(257));
      // Appends the value to the array
      numberArray[m - 1] = randomizedNum;
    }
    // Sorts from smallest to largest.
    Arrays.sort(numberArray);
    System.out.println("Values generated.");
    System.out.println("Input an integer value between 0 and 256.");
    while (finished == false) {
      try {
        inputtedNum = userInput.nextInt();
        if ((inputtedNum <= 256) && (inputtedNum >= 0)) {
          finished = true;
          finished2 = false;
          maxValue = 256;
          midValue = 128;
          minValue = 0;
          while (finished2 == false) {
            midValue = ((maxValue + minValue) / 2);
            if (numberArray[midValue] == inputtedNum) {
              System.out.println("Your number is found at " + midValue);
              finished2 = true;
            } else if ((maxValue == minValue) || (maxValue == minValue + 1)) {
              System.out.println("Your number was not generated.");
              finished2 = true;
            } else if (numberArray[midValue] < inputtedNum) {
              minValue = midValue;
              finished2 = false;
            } else {
              maxValue = midValue;
              finished2 = false;
            }
          }
        } else {
          // Informs user their input is invalid
          System.out.println("Invalid Input. Try Again.");
          finished = false;
        }
      } catch (Exception e) {
        // Informs user their input is invalid
        System.out.println("Invalid Input. Try Again.");
        finished = false;
      }
    }
  }
}