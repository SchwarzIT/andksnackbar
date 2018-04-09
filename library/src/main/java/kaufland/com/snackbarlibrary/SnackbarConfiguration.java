package kaufland.com.snackbarlibrary;


public class SnackbarConfiguration {

    private Gravity mGravity;
    private SnackbarType mSnackbarType;
    private int mMaxViewCount;

    private SnackbarConfiguration(Builder builder) {
        mGravity = builder.gravity;
        mSnackbarType = builder.type;
        mMaxViewCount = builder.maxViewCount;
    }

    public Gravity getGravity() {
        return mGravity;
    }

    public int getMaxViewCount() {
        return mMaxViewCount;
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

    public enum MaxCount {
        SINGLE, TWO, DEFAULT;
    }

    public static class Builder {

        private Gravity gravity;
        private SnackbarType type;
        private int maxViewCount;

        public Builder setGravity(Gravity gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setType(SnackbarType type) {
            this.type = type;
            return this;
        }

        public Builder setMaxViewCount(int viewType) {
            this.maxViewCount = viewType;
            return this;
        }

        public Builder setMaxViewCount(MaxCount count) {
            this.maxViewCount = convertMaxCountToInt(count);
            return this;
        }

        public SnackbarConfiguration build() {
            return new SnackbarConfiguration(this);
        }
    }

    public static int convertMaxCountToInt(MaxCount count) {

        switch (count) {

            case SINGLE:
                return 1;

            case TWO:
                return 2;

            case DEFAULT:
                return 1;
        }

        return convertMaxCountToInt(MaxCount.SINGLE);
    }
}
