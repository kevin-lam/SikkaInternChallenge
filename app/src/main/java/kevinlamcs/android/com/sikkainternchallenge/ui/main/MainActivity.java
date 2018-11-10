package kevinlamcs.android.com.sikkainternchallenge.ui.main;

import android.content.Intent;
import android.os.Bundle;

import butterknife.OnClick;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.ui.base.BaseActivity;
import kevinlamcs.android.com.sikkainternchallenge.ui.youtube.YoutubeActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.image_button_main_youtube)
    public void onYoutubeClicked() {
        Intent intent = YoutubeActivity.newInstance(MainActivity.this);
        startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
