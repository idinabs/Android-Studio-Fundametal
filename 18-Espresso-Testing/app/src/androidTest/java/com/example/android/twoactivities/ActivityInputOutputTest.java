package com.example.android.twoactivities;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(
            MainActivity.class
    );

    @Test
    public void textInputOutputMain() {

        onView(withId(R.id.editText_main)).perform(typeText(
                "Hello World"
        ));
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_message)).check(matches(
                withText("Hello World")));

        onView(withId(R.id.editText_second)).perform(typeText(
                "Hello Juga"
        ));
        onView(withId(R.id.button_second)).perform(click());
        onView(withId(R.id.text_message_reply)).check(matches(
                withText("Hello Juga")
        ));
    }

}
