package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum;
import kevinlamcs.android.com.sikkainternchallenge.util.image.ImageLoader;

public class InstagramViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.instagram_entry_thumbnail)
    ImageView thumbnail;

    private final ImageLoader imageLoader;
    private final Context context;
    private Datum datum;

    public InstagramViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.imageLoader = new ImageLoader(context);
    }

    public void onBind(Datum datum) {
        this.datum = datum;
        if (datum.hasImageUrl()) {
            imageLoader.load(datum.getImageUrl())
                    .thumbnail(datum.getThumbnailUrl())
                    .into(thumbnail);
        }
    }

    @OnClick(R.id.constraint_layout_item_instagram_entry)
    public void onItemClicked() {
        if (datum.hasLink()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(datum.getLink()));
            context.startActivity(intent);
        }
    }
}
