package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.Item;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {

    private final Context context;
    private List<Item> videoEntries = new ArrayList<>();

    public YoutubeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_youtube_entry, viewGroup, false);
        return new YoutubeViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder youtubeViewHolder, int i) {
        Item item = videoEntries.get(i);
        if (item != null) youtubeViewHolder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return videoEntries != null ? videoEntries.size() : 0;
    }

    public void setVideoEntries(List<Item> videoEntries) {
        this.videoEntries.clear();
        this.videoEntries.addAll(videoEntries);
        notifyDataSetChanged();
    }
}
