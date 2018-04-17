package kaufland.com.snackbarlibrary.utils;


public enum Limit {

    SINGLE(1), TWO(2), DEFAULT(1);

    private int mLimit;

    Limit(int limit) {
        mLimit = limit;
    }

    public int getLimit() {
        return mLimit;
    }
}
