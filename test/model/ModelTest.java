package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Model test
 *
 * @author Bersik (Serhii Kisilchuk)
 */
@RunWith(Parameterized.class)
public class ModelTest {
    private static final int[] array = new int[]{4, 3, 6, 32, 6, 3, 41, 1, 53};
    private static final int[] resultArrayUp = new int[]{1, 3, 3, 4, 6, 6, 32, 41, 53};
    private static final int[] resultArrayDown = new int[]{53, 41, 32, 6, 6, 4, 3, 3, 1};

    private Model model = new Model();
    private int[] resultArray;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {SortOrder.DOWN, resultArrayDown},
                {SortOrder.UP, resultArrayUp},
        });
    }

    public ModelTest(SortOrder sortOrder, int[] resultArray) {
        model.setSortOrder(sortOrder);
        this.resultArray = resultArray;
    }

    @Before
    public void before() throws Exception {
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        model.setArray(arr);
    }

    @Test
    public void bubbleSort() throws Exception {
        model.bubbleSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

    @Test
    public void insertionSort() throws Exception {
        model.insertionSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

    @Test
    public void cocktailSort() throws Exception {
        model.cocktailSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

    @Test
    public void mergeSort() throws Exception {
        model.mergeSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

    @Test
    public void quickSort() throws Exception {
        model.quickSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

    @Test
    public void heapSort() throws Exception {
        model.heapSort();
        assertArrayEquals(model.getArray(), resultArray);
    }

}