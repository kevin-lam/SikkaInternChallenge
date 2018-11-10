package kevinlamcs.android.com.sikkainternchallenge.ui.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kevinlamcs.android.com.sikkainternchallenge.R;
import kevinlamcs.android.com.sikkainternchallenge.rx.Disposer;

public abstract class BaseActivity extends AppCompatActivity implements Disposer {

    public abstract int getLayoutId();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        injectDependencies();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.dispose();
    }

    @Override
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void setActionBarNoTitle() {
        getSupportActionBar().setTitle(null);
    }

    protected void setBackButtonEnabled() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void showMessage(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .show();
    }

    private void injectDependencies() {
        AndroidInjection.inject(this);
    }
}
