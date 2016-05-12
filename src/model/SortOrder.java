package model;

/**
 * The sort order.
 * Down is degressive order.
 * Up is ascending order.
 *
 * @author Serhii Kisilchuk
 * @version 0.9, 9 Nov 2015
 * @since JDK1.7
 */
public enum SortOrder {
    DOWN(-1), UP(1);

    private int num;

    SortOrder(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
