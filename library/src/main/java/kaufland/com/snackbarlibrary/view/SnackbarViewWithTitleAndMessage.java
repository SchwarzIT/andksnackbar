package kaufland.com.snackbarlibrary.view;

import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kaufland.com.snackbarlibrary.R;
import kaufland.com.snackbarlibrary.utils.ViewUtils;


public class SnackbarViewWithTitleAndMessage extends SnackbarView {

    private View view;
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

    public SnackbarViewWithTitleAndMessage(Builder builder) {
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
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_snakbar_item_with_title_and_message, parent, false);
        mTitle = (TextView) view.findViewById(R.id.text_view_title);
        mMessage = (TextView) view.findViewById(R.id.text_view_message);
        return view;
    }

    @Override
    public void onBindView() {

        if (title != null) {
            mTitle.setText(title);
        }

        if (message != null) {
            mMessage.setText(message);
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
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), backgroundColor));
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

    }

    @Override
    public Integer getDuration() {
        return duration;
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


        public SnackbarView build() {
            return new SnackbarViewWithTitleAndMessage(this);
        }
    }

}
