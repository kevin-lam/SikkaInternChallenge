package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kevinlamcs.android.com.sikkainternchallenge.data.TaggedMediaRepository;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.InstagramTagResponse;
import kevinlamcs.android.com.sikkainternchallenge.rx.Disposer;

import static kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum.byLikesDesc;

public class InstagramPresenter {

    private final TaggedMediaRepository repo;
    private final InstagramView view;

    @Inject
    public InstagramPresenter(InstagramView view, TaggedMediaRepository repo) {
        this.view = view;
        this.repo = repo;
    }

    public void loadFourTaggedMedia(String tag1, String tag2, String tag3, String tag4) {
        ((Disposer) view).addDisposable(
                Single.zip(
                        loadTaggedMedia(tag1),
                        loadTaggedMedia(tag2),
                        loadTaggedMedia(tag3),
                        loadTaggedMedia(tag4),
                        (response1, response2, response3, response4) -> new ArrayList<>(Arrays.asList(response1, response2, response3, response4)))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(responseList -> {
                            List<Datum> taggedMedia = new ArrayList<>();
                            for (InstagramTagResponse response : responseList) {
                                taggedMedia.addAll(response.getData());
                            }
                            Collections.sort(taggedMedia, byLikesDesc);
                            view.updateMedia(taggedMedia);
                        }, throwable -> {
                            view.errorResponse("Could not load from Instagram");
                        })
        );
    }

    public Single<InstagramTagResponse> loadTaggedMedia(String tag) {
        return repo.getTaggedMedia(tag);
    }
}
