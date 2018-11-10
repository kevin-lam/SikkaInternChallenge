package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kevinlamcs.android.com.sikkainternchallenge.data.VideoRepository;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Youtube;
import kevinlamcs.android.com.sikkainternchallenge.rx.Disposer;

public class YoutubePresenter {

    private final YoutubeView view;
    private final VideoRepository repo;

    @Inject
    public YoutubePresenter(YoutubeView view, VideoRepository repo) {
        this.view = view;
        this.repo = repo;
    }

    public void loadPlaylist() {
        ((Disposer)view).addDisposable(
                repo.getPlaylist()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    view.updateVideos(response.getItems());
                }, throwable -> {
                    view.errorResponse("Could not load videos.");
                })
        );
    }
}
