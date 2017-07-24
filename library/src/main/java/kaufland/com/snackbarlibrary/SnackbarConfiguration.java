package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {

    private Gravity mGravity;
    private SnackbarType mSnackbarType;

    private SnackbarConfiguration(Builder builder) {
        mGravity = builder.gravity;
        mSnackbarType = builder.type;
    }

    public static SnackbarConfiguration configure(Builder builder) {
        return new SnackbarConfiguration(builder);
    }

    public Gravity getGravity() {
        return mGravity;
    }

    public SnackbarType getSnackbarType() {
        return mSnackbarType;
    }

    public enum Gravity {
        GRAVITY_TOP, GRAVITY_BOTTOM;
    }

    public enum SnackbarType {
        MULTIPLE_SNACKBARS, SINGLE_SNACKBAR;
    }

    public static class Builder {

        private Gravity gravity;
        private SnackbarType type;


        public Builder gravity(Gravity gravity) {
            this.gravity = gravity;

            return this;
        }

        public Builder type(SnackbarType type) {

            this.type = type;

            return this;

        }
    }


}
