package kaufland.com.snackbarlibrary.view;

import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kaufland.com.snackbarlibrary.R;

/**
 * Created by vkos2006 on 7/3/17.
 */

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

    public SnackbarViewWithTitleAndMessage(Builder builder){
        title = builder.title;
        message = builder.message;
        titleColor=builder.titleColor;
        messageColor=builder.messageColor;
        backgroundColor=builder.backgroundColor;
        duration=builder.duration;
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.view_snakbar_item_with_title_and_message,parent,false);
        mTitle= (TextView) view.findViewById(R.id.text_view_title);
        mMessage = (TextView) view.findViewById(R.id.text_view_message);
        return view;
    }

    @Override
    public void onBindView() {

        if(title !=null){
            mTitle.setText(title);
        }

        if(message!=null){
            mMessage.setText(message);
        }

        if(titleColor!=null){
            mTitle.setTextColor(ContextCompat.getColor(view.getContext(),titleColor));
        }

        if(messageColor!=null){
            mMessage.setTextColor(ContextCompat.getColor(view.getContext(),messageColor));
        }

        if(backgroundColor!=null){
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(),backgroundColor));
        }

        if(duration!=null && duration>0 && getCallback()!=null){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getCallback().onDismiss(SnackbarViewWithTitleAndMessage.this);
                }
            },duration);
        }
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public static class Builder{

        private String title;
        private String message;
        private Integer titleColor;
        private Integer messageColor;
        private Integer backgroundColor;
        private Integer duration;



        public Builder withBackgroundColor(@ColorRes int backgroundColor){
            this.backgroundColor=backgroundColor;
            return this;
        }

        public Builder withTitle(@NonNull String title){
            this.title=title;
            return this;
        }

        public Builder withTitleColor(@ColorRes int titleColor){
            this.titleColor=titleColor;
            return this;
        }

        public Builder withMessage(@NonNull String message){
            this.message=message;
            return this;
        }

        public Builder withMessageColor(@ColorRes int messageColor){
            this.messageColor =messageColor;
            return this;
        }

        public Builder withDuration(@NonNull Integer duration){
            this.duration=duration;
            return this;
        }

        public SnackbarView build(){
            return new SnackbarViewWithTitleAndMessage(this);
        }
    }

}
