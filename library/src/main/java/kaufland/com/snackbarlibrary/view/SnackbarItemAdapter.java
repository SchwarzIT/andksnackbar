package kaufland.com.snackbarlibrary.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by vkos2006 on 6/29/17.
 */

public class SnackbarItemAdapter extends RecyclerView.Adapter<SnackbarItemAdapter.ViewHolder> {

    private List<SnackbarItem> mSnackbarItems;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSnackbarItems == null ? 0 : mSnackbarItems.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void addItem(SnackbarItem item){
        mSnackbarItems.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(SnackbarItem item){
        mSnackbarItems.remove(item);
        notifyDataSetChanged();
    }

    public void clear(){
        mSnackbarItems.clear();
        notifyDataSetChanged();
    }
}
