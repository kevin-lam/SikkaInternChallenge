package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum;
import kevinlamcs.android.com.sikkainternchallenge.ui.base.BaseActivity;
import kevinlamcs.android.com.sikkainternchallenge.ui.main.MainActivity;

public class InstagramActivity extends BaseActivity implements InstagramView {

    private static final String TAG1 = "sikkasoftware";
    private static final String TAG2 = "sikkalife";
    private static final String TAG3 = "practicemobilizer";
    private static final String TAG4 = "selfdrivingpractice";

    @BindView(R.id.toolbar)
    Toolbar toolbarInstagram;

    @BindView(R.id.recyclerview_instagram_listing)
    RecyclerView recyclerViewInstagramListing;

    @BindView(R.id.coordinator_layout_instagram_listing)
    CoordinatorLayout coordinatorLayoutInstagramListing;

    @BindView(R.id.toolbar_logo)
    ImageView toolbarLogo;

    @BindDrawable(R.drawable.instagram_logo_monochrome)
    Drawable instagramLogo;

    @BindString(R.string.no_connection_message)
    String noConnectionMessage;

    @Inject
    GridLayoutManager gridLayoutManager;

    @Inject
    InstagramAdapter adapterInstagramListing;

    @Inject
    InstagramPresenter presenter;


    public static Intent newInstance(MainActivity mainActivity) {
        return new Intent(mainActivity, InstagramActivity.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_instagram;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbarInstagram);
        setActionBarNoTitle();
        setBackButtonEnabled();
        setToolbarLogo();
        setupRecyclerview();
    }

    private void setToolbarLogo() {
        toolbarLogo.setImageDrawable(instagramLogo);
    }

    private void setupRecyclerview() {
        recyclerViewInstagramListing.setAdapter(adapterInstagramListing);
        recyclerViewInstagramListing.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadMedia();
    }

    @Override
    public void updateMedia(List<Datum> taggedMedia) {
        adapterInstagramListing.setMedia(taggedMedia);
    }

    @Override
    public void errorResponse(String error) {
        showMessage(coordinatorLayoutInstagramListing, error);
    }

    private void loadMedia() {
        if (isConnected()) {
            presenter.loadFourTaggedMedia(TAG1, TAG2, TAG3, TAG4);
        } else {
            showMessage(coordinatorLayoutInstagramListing, noConnectionMessage);
        }
    }
}
