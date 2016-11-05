package com.khangtoh.android.testing.notes.screenshots;

/**
 * Created by khangtoh on 4/11/16.
 */


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import com.khangtoh.android.testing.notes.R;
import com.khangtoh.android.testing.notes.notes.NotesActivity;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.base.Preconditions.checkArgument;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class ScreenShotTest {
    @ClassRule public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityTestRule<NotesActivity> activityRule =
            new ActivityTestRule<>(NotesActivity.class);

    @Test
    public void testTakeScreenshot() {

        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());


        Screengrab.screenshot("before_button_click");

        onView(withId(R.id.fab_add_notes)).perform(click());

        Screengrab.screenshot("after_button_click");
    }

}
