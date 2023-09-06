package sortalgrth;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {

        // 1. User enter a positive number for size of the array 
        int size = inputInt("Enter number of array:", 0, Integer.MAX_VALUE);

        // 2. Create a random number array in range 
        int array[] = getRandomIntegerArray(size);

        // 3. Display array before sort
        display(array, "Unsorted array:  ");

        // 4. Quick sort to sort separate order 
        sortSeparateQuickSort(array);

        // 5. Display array after sort
        display(array, "Sorted array:  ");

    }

    /*
    Function 1 - Display a screen to prompt users to input a positive decimal number
    
    Param
    msg: Sentence will notify on screen before user input integer number 
    min: number return must great than or equal min
    max: number return must less than or equal max
    
    Users run the program, display a screen to ask users to enter a positive decimal number and store value into a variable 
    If user enter a negative number require user enter a positive decimal number again 
    
     */
    public static int inputInt(String msg, int min, int max) {

        // Loop use to continue input number till return correct format, if catch a user exception or system exception
        while (true) {

            // If result value is not number then notify error number format for user and catch NumberFormatException to handle and continue input number 
            try {

                // Display message notify user input number 
                System.out.println(msg);

                // Use Scanner class to input and store value inputted into a new String variable
                Scanner sc = new Scanner(System.in);
                String result_raw = sc.next();

                // Parse String value to Int value
                int result = Integer.parseInt(result_raw);

                // If result value less than min or great than max then notify error format for user and continue loop
                if (result < min || result > max) {
                    System.out.println("You must enter number have range from " + min + " to " + max + " ! Again !");
                    continue;
                }

                // If not error then return result number 
                return result;

            } catch (NumberFormatException e) {

                System.out.println("You must enter number format !");

                continue;

            }

        }
    }

    /* 
        Function 2 - Display & sort array
     */
    // Generate random integer in number range for each array element
    public static int[] getRandomIntegerArray(int size) {
        // Declear new array to store random array 
        int array[] = new int[size];

        // Loop use to accessed from the first to last element of array
        for (int i = 0; i < size; i++) {

            // number range is equal to size 
            int number_range = size;

            Random random = new Random();
            int random_number = random.nextInt(number_range);

            // assign random_number to value of each value elements in array 
            array[i] = random_number;

        }
        return array;
    }

// Display array 
    public static void display(int array[], String msg) {

        System.out.print(msg);

        int size = array.length;

        // declare end_bracket_index to process problem close bracket of display array ( ... ] )
        int end_bracket_index = size - 1;

        // display open bracket 
        System.out.print("[");

        // loop use to display element in the array 
        for (int i = 0; i < size; i++) {

            System.out.print(array[i]);

            // if index of element not equal to end_bracket_index then add `, ` to display 
            if (i != end_bracket_index) {
                System.out.print(", ");
            }
        }

        // display close bracket
        System.out.print("]");

        if (msg.equals("Unsorted array:  ")) {
            System.out.println();
        }
    }

// Use quick sort to divide the array into 2 pieces
    public static int[] sortSeparateQuickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int array[], int l, int h) /*l = low, h = high*/ {
        if (l < h) {

            // Find pivot element such that element smaller than pivot are on the left element greater than pivot are on the right
            int p = partition(array, l, h);

            // Recursively sort elements before and after the partition
            quickSort(array, l, p - 1);
            quickSort(array, p + 1, h);
        }
    }

//    public static int partition(int array[], int l, int h) /*l = low, h = high*/ {
//        int pivot = array[h];
//        int i = (l - 1);
//
//        for (int j = l; j < h; j++) {
//            
//            // If the current element is smaller than or equal to the pivot
//            if (array[j] <= pivot) {
//                i++;
//
//                // swap array[i] and array[j]
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//        }
//
//        // swap array[i+1] and array[high] (or pivot)
//        int temp = array[i + 1];
//        array[i + 1] = array[h];
//        array[h] = temp;
//
//        return i + 1;
//    }
    public static int partition(int[] a, int l, int h) {
        int p = a[l];
        int m = l;

        for (int k = l + 1; k <= h; k++) {
            if (a[k] < p) {
                m++;
                swap(a, k, m);
            }
        }

        swap(a, l, m);
        return m;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
