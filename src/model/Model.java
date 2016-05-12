package model;

/**
 * Created on 15:12 12.05.2016
 *
 * @author Bersik (Serhii Kisilchuk)
 */
public class Model {
    public static final SortOrder DEFAULT_SORT_ORDER = SortOrder.UP;

    private int[] arr;
    private int sortOrder = DEFAULT_SORT_ORDER.getNum();

    public void bubbleSort() {
        boolean f;
        for (int i = arr.length - 1; i > 0; i--) {
            f = false;
            for (int j = 0; j < i; j--) {
                if (compare(arr[j], arr[j + 1]) < 0) {
                    swap(j, j + 1);
                    f = true;
                }
            }
            if (!f) {
                break;
            }
        }
    }

    public void changeSort() {
        int min, v;
        for (int p = 0; p < arr.length - 1; p++) {
            min = arr[p];
            v = p;
            for (int i = p + 1; i < arr.length; i++) {
                if (compare(arr[i], min) == 1) {
                    min = arr[i];
                    v = i;
                }
            }
            if (p != v)
                swap(p, v);
        }
    }

    public void mergeSort() {
        final int PART = 2;
        int s = arr.length / PART;
        merge(0, s);
        merge(s + 1, arr.length - 1);
        int left = 0;
        int right = s + 1;
        int[] z = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (left > s) {
                z[i] = arr[right];
                right++;
                continue;
            }
            if (right >= arr.length) {
                z[i] = arr[left++];
                continue;
            }
            if (compare(arr[left], arr[right]) == 1)
                z[i] = arr[left++];
            else
                z[i] = arr[right++];
        }
        System.arraycopy(z, 0, arr, 0, arr.length);
    }

    private void merge(int left, int right) {
        for (int p = left; p < right; p++) {
            int m = p;
            for (int i = p + 1; i <= right; i++) {
                if (compare(arr[m], arr[i]) == -1)
                    m = i;
            }
            if (m != p)
                swap(m, p);
        }
    }

    public void recursionSort() {
        recursion(0, arr.length - 1);
    }

    private void recursion(int left, int right) {
        int s = arr[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (compare(arr[i], s) == 1)
                i++;
            while (compare(s, arr[j]) == 1)
                j--;
            if (i <= j)
                swap(i++, j--);
        }
        if (left < j)
            recursion(left, j);
        if (i < right)
            recursion(i, right);
    }

    /**
     * Compare two numbers.
     * Depends on SORT_ORDER.
     * If SORT_ORDER is UP, return: 1 if {@literal a > b}, -1 if {@literal a < b}
     * If SORT_ORDER is DOWN, return: 1 if {@literal a < b}, -1 if {@literal a > b}
     * Return 0 if {@literal a == b}
     *
     * @param a number 1
     * @param b number 2
     * @return 1, -1 or 0
     */
    protected int compare(int a, int b) {
        if (a > b)
            return sortOrder;
        if (a < b)
            return -sortOrder;
        return 0;
    }

    /**
     * Swaps two elements in the array
     *
     * @param a index of first element
     * @param b index of second element
     */
    protected void swap(int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public int[] getArray() {
        return arr;
    }

    public void setArray(int[] arr) {
        this.arr = arr;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder.getNum();
    }
}
