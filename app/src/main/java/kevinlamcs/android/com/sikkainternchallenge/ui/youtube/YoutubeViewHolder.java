package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.Item;
import kevinlamcs.android.com.sikkainternchallenge.util.image.ImageLoader;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.youtube_entry_title)
    TextView title;

    @BindView(R.id.youtube_entry_description)
    TextView description;

    @BindView(R.id.youtube_entry_thumbnail)
    ImageView thumbnail;

    private final Context context;
    private final ImageLoader imageLoader;
    private Item item;

    public YoutubeViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.imageLoader = new ImageLoader(context);
    }

    public void onBind(Item item) {
        this.item = item;
        if (item.hasSnippet()) {
            title.setText(item.getSnippet().getTitle());
            description.setText(item.getSnippet().getDescription());
            if (item.hasImageUrl()) {
                imageLoader.load(item.getImageUrl())
                        .thumbnail(item.getThumbnailUrl())
                        .into(thumbnail);
            }

        }
    }
}
