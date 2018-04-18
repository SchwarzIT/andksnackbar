package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {

    private Gravity mGravity;
    private int mSnackbarCount;

    private SnackbarConfiguration(Builder builder) {
        mGravity = builder.gravity;
        mSnackbarCount = builder.count;
    }

    public static SnackbarConfiguration configure(Builder builder) {
        return new SnackbarConfiguration(builder);
    }

    public Gravity getGravity() {
        return mGravity;
    }

    public int getSnackbarCount() {
        return mSnackbarCount;
    }

    public enum Gravity {
        GRAVITY_TOP, GRAVITY_BOTTOM;
    }

    public static class Builder {

        private Gravity gravity;
        private int count;


        public Builder gravity(Gravity gravity) {
            this.gravity = gravity;

            return this;
        }

        public Builder count(int count) {

            this.count = count;

            return this;

        }
    }


}
