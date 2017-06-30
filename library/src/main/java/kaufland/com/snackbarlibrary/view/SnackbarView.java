package kaufland.com.snackbarlibrary.view;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by vkos2006 on 6/29/17.
 */

public class SnackbarView {

    private final Integer backgroundColor;
    private final String title;
    private final Integer titleColor;
    private final String message;
    private final Integer messageColor;
    private final Integer actionButtonDrawable;
    private final ActionListener actionButtonListener;


    private SnackbarView(Builder builder ){
        this.backgroundColor=builder.backgroundColor;
        this.title=builder.title;
        this.titleColor=builder.titleColor;
        this.message=builder.message;
        this.messageColor=builder.messageColor;
        this.actionButtonDrawable=builder.actionButtonDrawable;
        this.actionButtonListener=builder.actionButtonListener;
    }


    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public Integer getTitleColor() {
        return titleColor;
    }

    public String getMessage() {
        return message;
    }

    public Integer getMessageColor() {
        return messageColor;
    }

    public Integer getActionButtonDrawable() {
        return actionButtonDrawable;
    }

    public ActionListener getActionButtonListener() {
        return actionButtonListener;
    }

    public static class Builder{

        private Integer backgroundColor;
        private String title;
        private Integer titleColor;
        private String message;
        private Integer messageColor;
        private ActionListener actionButtonListener;
        private Integer actionButtonDrawable;


        public Builder withBackgroundColor(@ColorRes int backgroundColor){

            this.backgroundColor=backgroundColor;
            return this;
        }

        public Builder withTitle(String title){
            this.title=title;
            return this;
        }

        public Builder withTitleColor(@ColorRes int color){
            titleColor=color;
            return this;
        }

        public Builder withMessage(String message){
            this.message=message;
            return this;
        }

        public Builder withMessageColor(@ColorRes int messageColor){
            this.messageColor=messageColor;
            return this;
        }

        public Builder withActionDrawable(@DrawableRes int actionButtonDrawable){
            this.actionButtonDrawable= actionButtonDrawable;
            return this;
        }

        public Builder withActionListener(final ActionListener actionButtonListener){
            this.actionButtonListener=actionButtonListener;
            return this;
        }

        public SnackbarView build(){
            return new SnackbarView(this);
        }
    }

}
