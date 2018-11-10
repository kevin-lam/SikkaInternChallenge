package kevinlamcs.android.com.sikkainternchallenge.ui.twitter;

import android.os.Bundle;
import android.app.Activity;

import kevinlamcs.android.com.sikkainternchallenge.R;

public class TwitterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
