package kaufland.com.snackbarlibrary.view;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kaufland.com.snackbarlibrary.R;
import kaufland.com.snackbarlibrary.utils.ViewUtils;


public class DefaultSnackbarView extends SnackbarView {

    private FrameLayout view;
    private RelativeLayout parentLayout;
    private TextView mTitle;
    private TextView mMessage;

    private String title;
    private String message;
    private Integer titleColor;
    private Integer messageColor;
    private Integer backgroundColor;
    private Integer duration;

    private boolean isTitleBold;
    private boolean isMessageBold;

    private Integer titleMarginLeft;
    private Integer titleMarginTop;
    private Integer titleMarginRight;
    private Integer titleMarginBottom;
    private Integer messageMarginLeft;
    private Integer messageMarginTop;
    private Integer messageMarginRight;
    private Integer messageMarginBottom;
    private Integer titleTextSize;
    private Integer messageTextSize;
    private Integer titleStyle;
    private Integer messageStyle;
    private Integer elevation;

    public DefaultSnackbarView(Builder builder) {
        title = builder.title;
        message = builder.message;
        titleColor = builder.titleColor;
        messageColor = builder.messageColor;
        backgroundColor = builder.backgroundColor;
        duration = builder.duration;
        isTitleBold = builder.isTitleBold;
        isMessageBold = builder.isMessageBold;
        titleMarginLeft = builder.titleMarginLeft;
        titleMarginTop = builder.titleMarginTop;
        titleMarginRight = builder.titleMarginRight;
        titleMarginBottom = builder.titleMarginBottom;
        messageMarginLeft = builder.messageMarginLeft;
        messageMarginTop = builder.messageMarginTop;
        messageMarginRight = builder.messageMarginRight;
        messageMarginBottom = builder.messageMarginBottom;
        titleTextSize = builder.titleTextSize;
        messageTextSize = builder.messageTextSize;
        titleStyle = builder.titleStyle;
        messageStyle = builder.messageStyle;
        elevation = builder.elevation;
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        view = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_default_snakbar_item, parent, false);
        parentLayout = view.findViewById(R.id.view_snackbar_item_parent);
        mTitle = view.findViewById(R.id.text_view_title);
        mMessage = view.findViewById(R.id.text_view_message);
        return view;
    }

    @Override
    public void onBindView() {

        if (view == null || parentLayout == null || mTitle == null || mMessage == null) {
            return;
        }

        if (title != null) {
            mTitle.setText(title);
        } else {
            mTitle.setVisibility(View.GONE);
        }

        if (message != null) {
            mMessage.setText(message);
        } else {
            mMessage.setVisibility(View.GONE);
        }

        if (titleColor != null) {
            mTitle.setTextColor(ContextCompat.getColor(view.getContext(), titleColor));
        }

        if (messageColor != null) {
            mMessage.setTextColor(ContextCompat.getColor(view.getContext(), messageColor));
        }

        if (isTitleBold) {
            mTitle.setTypeface(mTitle.getTypeface(), Typeface.BOLD);
        }

        if (isMessageBold) {
            mMessage.setTypeface(mTitle.getTypeface(), Typeface.BOLD);
        }

        if (backgroundColor != null) {
            parentLayout.setBackgroundColor(ContextCompat.getColor(view.getContext(), backgroundColor));
        }

        if (titleMarginLeft != null && titleMarginRight != null && titleMarginTop != null && titleMarginBottom != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mTitle.getLayoutParams();
            int marginLeftPx = ViewUtils.convertDpToPixel(view.getContext(), titleMarginLeft);
            int marginRightPx = ViewUtils.convertDpToPixel(view.getContext(), titleMarginRight);
            int marginTopPx = ViewUtils.convertDpToPixel(view.getContext(), titleMarginTop);
            int marginBottomPx = ViewUtils.convertDpToPixel(view.getContext(), titleMarginBottom);

            layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
            mTitle.setLayoutParams(layoutParams);
        }

        if (messageMarginLeft != null && messageMarginRight != null && messageMarginTop != null && messageMarginBottom != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mMessage.getLayoutParams();
            int marginLeftPx = ViewUtils.convertDpToPixel(view.getContext(), messageMarginLeft);
            int marginRightPx = ViewUtils.convertDpToPixel(view.getContext(), messageMarginRight);
            int marginTopPx = ViewUtils.convertDpToPixel(view.getContext(), messageMarginTop);
            int marginBottomPx = ViewUtils.convertDpToPixel(view.getContext(), messageMarginBottom);
            layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
            mMessage.setLayoutParams(layoutParams);
        }

        if (titleTextSize != null) {
            mTitle.setTextSize(titleTextSize);
        }

        if (messageTextSize != null) {
            mMessage.setTextSize(messageTextSize);
        }

        if (titleStyle != null) {
            if (Build.VERSION.SDK_INT < 23) {
                mTitle.setTextAppearance(view.getContext(), titleStyle);
            } else {
                mTitle.setTextAppearance(titleStyle);
            }

        }

        if (messageStyle != null) {
            if (Build.VERSION.SDK_INT < 23) {
                mMessage.setTextAppearance(view.getContext(), messageStyle);
            } else {
                mTitle.setTextAppearance(messageStyle);
            }

        }

        if (elevation != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            view.setClipToPadding(false);
            view.setPadding(0, 0, 0, ViewUtils.convertDpToPixel(view.getContext(), elevation));
            parentLayout.setElevation(ViewUtils.convertDpToPixel(view.getContext(), elevation));
        }
    }

    @Override
    public void onDismissed() {
        //no work here
    }

    @Override
    public Integer getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Integer getTitleColor() {
        return titleColor;
    }

    public Integer getMessageColor() {
        return messageColor;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public boolean isTitleBold() {
        return isTitleBold;
    }

    public boolean isMessageBold() {
        return isMessageBold;
    }

    public Integer getTitleMarginLeft() {
        return titleMarginLeft;
    }

    public Integer getTitleMarginTop() {
        return titleMarginTop;
    }

    public Integer getTitleMarginRight() {
        return titleMarginRight;
    }

    public Integer getTitleMarginBottom() {
        return titleMarginBottom;
    }

    public Integer getMessageMarginLeft() {
        return messageMarginLeft;
    }

    public Integer getMessageMarginTop() {
        return messageMarginTop;
    }

    public Integer getMessageMarginRight() {
        return messageMarginRight;
    }

    public Integer getMessageMarginBottom() {
        return messageMarginBottom;
    }

    public Integer getTitleTextSize() {
        return titleTextSize;
    }

    public Integer getMessageTextSize() {
        return messageTextSize;
    }

    public Integer getTitleStyle() {
        return titleStyle;
    }

    public Integer getMessageStyle() {
        return messageStyle;
    }

    public Integer getElevation() {
        return elevation;
    }

    public static class Builder {

        private String title;
        private String message;
        private Integer titleColor;
        private Integer messageColor;
        private Integer backgroundColor;
        private Integer duration;
        private boolean isTitleBold;
        private boolean isMessageBold;
        private Integer titleMarginLeft;
        private Integer titleMarginTop;
        private Integer titleMarginRight;
        private Integer titleMarginBottom;
        private Integer messageMarginLeft;
        private Integer messageMarginTop;
        private Integer messageMarginRight;
        private Integer messageMarginBottom;
        private Integer titleTextSize;
        private Integer messageTextSize;
        private Integer titleStyle;
        private Integer messageStyle;
        private Integer elevation;

        public Builder withBackgroundColor(@ColorRes int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder withTitle(@NonNull String title) {
            this.title = title;
            return this;
        }

        public Builder withTitleColor(@ColorRes int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder withMarginsAroundTitle(@NonNull Integer left, @NonNull Integer top, @NonNull Integer right, @NonNull Integer bottom) {
            titleMarginLeft = left;
            titleMarginTop = top;
            titleMarginRight = right;
            titleMarginBottom = bottom;
            return this;
        }

        public Builder withTitleTextSize(Integer titleTextSize) {
            this.titleTextSize = titleTextSize;
            return this;
        }

        public Builder withMessage(@NonNull String message) {
            this.message = message;
            return this;
        }

        public Builder withMessageColor(@ColorRes int messageColor) {
            this.messageColor = messageColor;
            return this;
        }

        public Builder withMarginsAroundMessage(@NonNull Integer left, @NonNull Integer top, @NonNull Integer right, @NonNull Integer bottom) {
            messageMarginLeft = left;
            messageMarginTop = top;
            messageMarginRight = right;
            messageMarginBottom = bottom;
            return this;
        }

        public Builder withMessageTextSize(Integer messageTextSize) {
            this.messageTextSize = messageTextSize;
            return this;
        }

        public Builder withTitleStyle(@StyleRes Integer titleStyle) {
            this.titleStyle = titleStyle;
            return this;
        }

        public Builder withMessageStyle(@StyleRes Integer messageStyle) {
            this.messageStyle = messageStyle;
            return this;
        }

        public Builder withDuration(@NonNull Integer duration) {
            this.duration = duration;
            return this;
        }


        public Builder withBoldTitleStyle() {
            isTitleBold = true;
            return this;
        }

        public Builder withBoldMessageStyle() {
            isMessageBold = true;
            return this;
        }

        public Builder withElevation(Integer elevation) {
            this.elevation = elevation;
            return this;
        }

        public SnackbarView build() {
            return new DefaultSnackbarView(this);
        }
    }
}
