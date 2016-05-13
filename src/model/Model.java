package model;

/**
 * Created on 15:12 12.05.2016
 *
 * @author Bersik (Serhii Kisilchuk)
 */
public class Model {
    public static final SortOrder DEFAULT_SORT_ORDER = SortOrder.UP;

    private int[] array;
    private int sortOrder = DEFAULT_SORT_ORDER.getNum();

    public void bubbleSort() {
        boolean f;
        for (int i = array.length - 1; i > 0; i--) {
            f = false;
            for (int j = 0; j < i; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    swap(j, j + 1);
                    f = true;
                }
            }
            if (!f) {
                break;
            }
        }
    }

    public void insertionSort() {
        int min, v;
        for (int p = 0; p < array.length - 1; p++) {
            min = array[p];
            v = p;
            for (int i = p + 1; i < array.length; i++) {
                if (compare(array[i], min) < 0) {
                    min = array[i];
                    v = i;
                }
            }
            if (p != v)
                swap(p, v);
        }
    }

    public void cocktailSort() {
        cocktail(0, array.length - 1);
    }

    private void cocktail(int left, int right) {
        do {
            for (int i = left; i < right; i++) {
                if (compare(array[i], array[i + 1]) > 0) {
                    swap(i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (compare(array[i], array[i - 1]) < 0) {
                    swap(i, i - 1);
                }
            }
            left++;
        } while (left <= right);

    }

    public void mergeSort() {
        final int PART = 2;
        int s = array.length / PART;
        merge(0, s);
        merge(s + 1, array.length - 1);
        int left = 0;
        int right = s + 1;
        int[] z = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (left > s) {
                z[i] = array[right];
                right++;
                continue;
            }
            if (right >= array.length) {
                z[i] = array[left++];
                continue;
            }
            if (compare(array[left], array[right]) < 0)
                z[i] = array[left++];
            else
                z[i] = array[right++];
        }
        System.arraycopy(z, 0, array, 0, array.length);
    }

    private void merge(int left, int right) {
        for (int p = left; p < right; p++) {
            int m = p;
            for (int i = p + 1; i <= right; i++) {
                if (compare(array[m], array[i]) > 0)
                    m = i;
            }
            if (m != p)
                swap(m, p);
        }
    }

    public void quickSort() {
        recursion(0, array.length - 1);
    }

    private void recursion(int left, int right) {
        int s = array[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (compare(array[i], s) < 0)
                i++;
            while (compare(s, array[j]) < 0)
                j--;
            if (i <= j)
                swap(i++, j--);
        }
        if (left < j)
            recursion(left, j);
        if (i < right)
            recursion(i, right);
    }

    public void heapSort() {
        for (int heapsize = 0; heapsize < array.length; heapsize++) {

            int n = heapsize;
            while (n > 0) {
                int p = (n - 1) / 2;
                if (compare(array[n], array[p]) > 0) {
                    swap(n, p);
                    n = p;
                } else
                    break;
            }
        }

        for (int heapsize = array.length; heapsize > 0; ) {
            swap(0, --heapsize);
            int n = 0;
            while (true) {
                int left = (n * 2) + 1;
                if (left >= heapsize)
                    break;
                int right = left + 1;
                if (right >= heapsize) {
                    if (compare(array[left], array[n]) > 0)
                        swap(left, n);
                    break;
                }
                if (compare(array[left], array[n]) > 0) {
                    if (compare(array[left], array[right]) > 0) {
                        swap(left, n);
                        n = left;
                    } else {
                        swap(right, n);
                        n = right;
                    }
                } else {
                    if (compare(array[right], array[n]) > 0) {
                        swap(right, n);
                        n = right;
                    } else {
                        break;
                    }
                }
            }
        }
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
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder.getNum();
    }
}
