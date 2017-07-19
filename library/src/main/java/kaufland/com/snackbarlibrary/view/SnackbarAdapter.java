package kaufland.com.snackbarlibrary.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


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

        if (snackbarView != null) {
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
        return mSnackbarViews == null || mSnackbarViews.size() == 0;
    }

    public void addItem(SnackbarView item) {
        mSnackbarViews.add(item);
        int position = mSnackbarViews.indexOf(item);
        notifyItemInserted(position);
    }

    public void removeItem(SnackbarView view) {
        int position = mSnackbarViews.indexOf(view);
        if(position>-1){
            mSnackbarViews.remove(position);
            notifyItemRemoved(position);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
