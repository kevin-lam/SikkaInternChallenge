package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import java.util.List;

import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.Datum;

public interface InstagramView {
    void updateMedia(List<Datum> taggedMedia);
    void errorResponse(String error);
}
