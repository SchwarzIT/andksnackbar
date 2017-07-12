package kaufland.com.snackbarlibrary.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import kaufland.com.snackbarlibrary.Snackbar;

/**
 * Created by vkos2006 on 6/29/17.
 */

public class SnackbarAdapter extends RecyclerView.Adapter<SnackbarAdapter.ViewHolder> {

    private List<SnackbarView> mSnackbarViews = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = mSnackbarViews.get(position).onCreateView(parent);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SnackbarView snackbarView = mSnackbarViews.get(position);

        if(snackbarView!=null){
            snackbarView.onBindView();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mSnackbarViews == null ? 0 : mSnackbarViews.size();
    }

    public boolean isEmpty() {
        return mSnackbarViews==null || mSnackbarViews.size()==0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void addItem(SnackbarView item){
        mSnackbarViews.add(item);
        int position = mSnackbarViews.indexOf(item);
        notifyItemRangeChanged(position,1);
    }

    public void removeItem(SnackbarView view){
        int position = mSnackbarViews.indexOf(view);
        mSnackbarViews.remove(position);
        notifyItemRangeChanged(position,1);
    }
}
