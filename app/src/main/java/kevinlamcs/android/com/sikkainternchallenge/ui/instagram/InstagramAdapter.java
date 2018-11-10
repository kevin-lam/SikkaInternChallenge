package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum;

public class InstagramAdapter extends RecyclerView.Adapter<InstagramViewHolder> {

    private final Context context;
    private List<Datum> media = new ArrayList<>();

    public InstagramAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InstagramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_instagram_entry, viewGroup, false);
        return new InstagramViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull InstagramViewHolder instagramViewHolder, int i) {
        Datum medium = media.get(i);
        instagramViewHolder.onBind(medium);
    }

    @Override
    public int getItemCount() {
        return media != null ? media.size() : 0;
    }

    public void setMedia(List<Datum> media) {
        this.media.clear();
        this.media.addAll(media);
        notifyDataSetChanged();
    }
}
