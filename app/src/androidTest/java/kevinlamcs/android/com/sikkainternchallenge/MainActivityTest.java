package kevinlamcs.android.com.sikkainternchallenge;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kevinlamcs.android.com.sikkainternchallenge.ui.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, true);

    UiDevice device;


    @Before
    public void setup() {
        startUiAutomator();
    }

    private void startUiAutomator() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void clickYoutubeButtonDisplaysVideoEntries() throws UiObjectNotFoundException {
        // Click youtube button
        onView(withId(R.id.image_button_main_youtube))
                .perform(click());

        // Wait for loading in youtube video entries
        UiObject videoEntry = device.findObject(new UiSelector().resourceId("R.id.constraint_layout_item_youtube_entry"));
        videoEntry.waitForExists(100);

        // Check list of video entries contains an entry
        assert (videoEntry.exists());
    }


    @Test
    public void clickInstagramButtonDisplaysInstagramPhotos() throws UiObjectNotFoundException {
        // Click instagram button
        onView(withId(R.id.image_button_main_instagram))
                .perform(click());

        // Wait for loading in instagram photos
        UiObject instagramPhoto = device.findObject(new UiSelector().resourceId("R.id.constraint_layout_item_instagram_entry"));
        instagramPhoto.waitForExists(500);

        // Check list of instagram photos is not empty
        assert (instagramPhoto.exists());
    }
}