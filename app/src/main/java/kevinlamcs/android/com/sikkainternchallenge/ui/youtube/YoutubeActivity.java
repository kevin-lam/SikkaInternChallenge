package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.ui.base.BaseActivity;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.Item;
import kevinlamcs.android.com.sikkainternchallenge.ui.main.MainActivity;

public class YoutubeActivity extends BaseActivity implements YoutubeView {

    @BindView(R.id.toolbar)
    Toolbar toolbarYoutube;

    @BindView(R.id.recyclerview_youtube_listing)
    RecyclerView recyclerViewYoutubeListing;

    @BindView(R.id.coordinator_layout_youtube_listing)
    CoordinatorLayout coordinatorLayoutYoutubeListing;

    @BindView(R.id.toolbar_logo)
    ImageView toolbarLogo;

    @BindString(R.string.no_connection_message)
    String noConnectionMessage;

    @BindDrawable(R.drawable.youtube_logo_monochrome)
    Drawable youtubeLogo;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Inject
    YoutubeAdapter adapterYoutubeListing;

    @Inject
    YoutubePresenter presenter;

    public static Intent newInstance(MainActivity mainActivity) {
        return new Intent(mainActivity, YoutubeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbarYoutube);
        setActionBarNoTitle();
        setBackButtonEnabled();
        setToolbarLogo();
        setupRecyclerview();
    }

    private void setToolbarLogo() {
        toolbarLogo.setImageDrawable(youtubeLogo);
    }

    private void setupRecyclerview() {
        recyclerViewYoutubeListing.setLayoutManager(linearLayoutManager);
        recyclerViewYoutubeListing.setAdapter(adapterYoutubeListing);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPlaylist();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_youtube;
    }

    @Override
    public void updateVideos(List<Item> videoEntries) {
        adapterYoutubeListing.setVideoEntries(videoEntries);
    }

    @Override
    public void errorResponse(String error) {
        showMessage(coordinatorLayoutYoutubeListing, error);
    }

    private void loadPlaylist() {
        if (isConnected()) {
            presenter.loadPlaylist();
        } else {
            showMessage(coordinatorLayoutYoutubeListing, noConnectionMessage);
        }
    }
}
