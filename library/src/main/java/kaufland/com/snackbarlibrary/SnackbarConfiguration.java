package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {
    
    private Gravity gravity;
    private SnackbarType snackbarType;

    private SnackbarConfiguration(Builder builder) {
        this.gravity = builder.gravity;
        this.snackbarType = builder.type;
    }


    public Gravity getGravity() {
        return gravity;
    }

    public SnackbarType getSnackbarType() {
        return snackbarType;
    }

    public static SnackbarConfiguration configure(Builder builder) {
       return new SnackbarConfiguration(builder);
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
