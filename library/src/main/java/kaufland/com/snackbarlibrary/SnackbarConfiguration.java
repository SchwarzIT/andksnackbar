package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {

    private Gravity mGravity;
    private int mSnackbarMaxCount;

    private SnackbarConfiguration(Builder builder) {
        mGravity = builder.gravity;
        mSnackbarMaxCount = builder.maxCount;
    }

    public static SnackbarConfiguration configure(Builder builder) {
        return new SnackbarConfiguration(builder);
    }

    public Gravity getGravity() {
        return mGravity;
    }

    public int getSnackbarMaxCount() {
        return mSnackbarMaxCount;
    }

    public enum Gravity {
        GRAVITY_TOP, GRAVITY_BOTTOM;
    }

    public static class Builder {

        private Gravity gravity;
        private int maxCount;


        public Builder gravity(Gravity gravity) {
            this.gravity = gravity;

            return this;
        }

        public Builder maxCount(int maxCount) {

            this.maxCount = maxCount;

            return this;

        }
    }


}
