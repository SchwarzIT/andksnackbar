package kaufland.com.snackbarlibrary.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kaufland.com.snackbarlibrary.R;

/**
 * Created by vkos2006 on 6/29/17.
 */

public class SnackbarAdapter extends RecyclerView.Adapter<SnackbarAdapter.ViewHolder> {

    private List<SnackbarView> mSnackbarViews = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_snakbar_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        initItemView(holder,position);
    }

    private void initItemView(ViewHolder holder, int position){

        final SnackbarView snackbarView = mSnackbarViews.get(position);

        if(snackbarView!=null){
            setBackgroundColorOnView(holder.mSnackbarItemParent,snackbarView.getBackgroundColor());
            setTextOnTextView(holder.mTitle,snackbarView.getTitle());
            setTextColorOnTextView(holder.mTitle,snackbarView.getTitleColor());
            setTextOnTextView(holder.mMessage,snackbarView.getMessage());
            setTextColorOnTextView(holder.mMessage,snackbarView.getMessageColor());
            setDrawableBackgroundOnImageButton(holder.mActionButton,snackbarView.getActionButtonDrawable());

            if(snackbarView.getActionButtonListener()!=null){

                holder.mActionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean shouldDismiss = snackbarView.getActionButtonListener().onAction();

                        if(shouldDismiss){
                            //TODO: Dismiss this SnackbarView
                        }
                    }
                });
            }

        }
    }

    private void setTextOnTextView(TextView textView, String text){

        if(textView!=null && text!=null){
            textView.setText(text);
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void setTextColorOnTextView(TextView textView,Integer color){

        if(textView!=null && color!=null){
            textView.setTextColor(ContextCompat.getColor(textView.getContext(),color));
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void setDrawableBackgroundOnImageButton(ImageButton button,Integer drawableRes){

        if(button!=null && drawableRes!=null){
            button.setImageDrawable(ContextCompat.getDrawable(button.getContext(),drawableRes));
            button.setVisibility(View.VISIBLE);
        }
    }

    public void setBackgroundColorOnView(View view,Integer color){
        if(view!=null && color!=null){
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(),color));
        }
    }

    @Override
    public int getItemCount() {
        return mSnackbarViews == null ? 0 : mSnackbarViews.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mSnackbarItemParent;
        public TextView mTitle;
        public TextView mMessage;
        public ImageButton mActionButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            mMessage= (TextView) itemView.findViewById(R.id.text_view_message);
            mActionButton = (ImageButton) itemView.findViewById(R.id.button_action);
            mSnackbarItemParent = (RelativeLayout) itemView.findViewById(R.id.view_snackbar_item_parent);
        }
    }

    public void addItem(SnackbarView item){
        mSnackbarViews.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(SnackbarView item){
        mSnackbarViews.remove(item);
        notifyDataSetChanged();
    }

    public void clear(){
        mSnackbarViews.clear();
        notifyDataSetChanged();
    }
}
