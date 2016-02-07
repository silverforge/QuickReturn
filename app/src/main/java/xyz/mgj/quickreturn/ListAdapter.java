package xyz.mgj.quickreturn;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private String[] items = new String[] {"Donec", "vulputate", "nulla", "sed", "ex", "tristique",
        "nec", "mattis", "nulla", "malesuada.", "Morbi", "bibendum", "metus", "sit", "amet",
        "dignissim", "varius.", "Nulla", "purus", "justo", "ornare", "nec", "ligula", "quis",
        "placerat", "congue", "mauris.", "Nunc", "ultrices", "libero", "in", "justo", "placerat",
        "tincidunt.", "Sed", "ante", "orci", "congue", "vel", "diam", "in", "euismod", "ultrices",
        "erat.", "Praesent", "rhoncus", "ante", "eros", "aliquet", "commodo", "libero", "semper",
        "at.", "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit.",};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.card_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.contentText.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView contentText;

        public ViewHolder(View itemView) {
            super(itemView);

            contentText = (TextView)itemView.findViewById(R.id.content_text);
        }
    }
}
