package kevinlamcs.android.com.sikkainternchallenge.rx;

import io.reactivex.disposables.Disposable;

public interface Disposer {
    void addDisposable(Disposable disposable);
}
