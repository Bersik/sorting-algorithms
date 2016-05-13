package view;

import java.util.Arrays;

/**
 * Created on 3:26 09.05.2016
 *
 * @author Bersik (Serhii Kisilchuk)
 */
public class View {
    public static final String MAIN_MENU = "\tMenu:\n" +
            "1. Set array\n2. Print array\n" +
            "3. Bubble Sort\n4. Change Sort\n5. Merge Sort\n" +
            "6. Recursion Sort\n7. Cocktail Sort\n8. Heap Sort\n" +
            "9. Exit";
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value: ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String INPUT_ARRAY = "Input array (like \"1 2 3 4 5\":";
    public static final String INPUT_ERROR = "Input error";

    public static final String HELLO_MESSAGE = "Hello!";
    public static final String WRONG_MENU_ITEM = "Wrong menu item!";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
