package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {

    private Gravity mGravity;

    private SnackbarConfiguration(Builder builder) {
        mGravity = builder.gravity;
    }

    public Gravity getGravity() {
        return mGravity;
    }

    public enum Gravity {
        GRAVITY_TOP, GRAVITY_BOTTOM;
    }

    public static class Builder {

        private Gravity gravity;

        public Builder setGravity(Gravity gravity) {
            this.gravity = gravity;
            return this;
        }

        public SnackbarConfiguration build() {
            return new SnackbarConfiguration(this);
        }
    }
}
