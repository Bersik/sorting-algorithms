package controller;

import model.Model;
import view.View;

import java.util.Scanner;

/**
 * Controller class
 *
 * @author Serhii Kisilchuk
 */
public class Controller {
    private static final String ARRAY_PATTERN = "[ \\d]+";

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        model.setArray(readArray(sc));
        int menuItem;

        view.printMessage(View.HELLO_MESSAGE);
        while (true) {
            view.printMessage(View.MAIN_MENU);
            menuItem = inputIntValueWithScanner(sc);
            switch (menuItem) {
                case 1:
                    model.setArray(readArray(sc));
                    break;
                case 2:
                    view.printArray(model.getArray());
                    break;
                case 3:
                    model.bubbleSort();
                    break;
                case 4:
                    model.insertionSort();
                    break;
                case 5:
                    model.mergeSort();
                    break;
                case 6:
                    model.quickSort();
                    break;
                case 7:
                    model.cocktailSort();
                    break;
                case 8:
                    model.heapSort();
                    break;
                case 9:
                    return;
                default:
                    view.printMessage(View.WRONG_MENU_ITEM);
                    break;
            }
        }
    }

    // The Utility methods
    private int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    private int[] readArray(Scanner sc) {
        String line = inputArray(sc).replaceAll("[^\\d]+", " ");
        String[] strArray = line.split(" ");
        int[] result = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }

    private String inputArray(Scanner sc) {
        view.printMessage(View.INPUT_ARRAY);
        String line;
        while (true) {
            line = sc.nextLine();
            if (line.matches(ARRAY_PATTERN)) {
                return line;
            } else {
                view.printMessage(View.INPUT_ERROR);
            }
        }
    }
}
