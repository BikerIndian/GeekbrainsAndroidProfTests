package net.svishch.github

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.svishch.BuildConfig
import net.svishch.R
import net.svishch.github.view.search.MainActivity
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activitySearch_IsWorking() {
        onView(withId(R.id.searchEditText)).perform(click())
        onView(withId(R.id.searchEditText)).perform(replaceText("algol"), closeSoftKeyboard())
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())

        if (BuildConfig.TYPE == MainActivity.FAKE) {
            onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results: 42")))
        } else {
            onView(isRoot()).perform(delay())
            onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results: 2283")))
        }
    }

    private fun delay(): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()
            override fun getDescription(): String = "wait for $2 seconds"
            override fun perform(uiController: UiController, v: View?) {
                uiController.loopMainThreadForAtLeast(2000)
            }
        }
    }

    @After
    fun close() {
        scenario.close()
    }

    @Test
    fun progressBar_GONE() {
        checkGONE(R.id.progressBar)
    }

    @Test
    fun searchEditText_VISIBLE() {
        checkVISIBLE(R.id.searchEditText)
    }

    @Test
    fun searchEditText_checkText() {
        onView(withId(R.id.searchEditText)).check(matches(withHint("Enter keyword e.g. android")))
    }

    @Test
    fun searchEditText_IsCompletelyDisplayed() {
        isCompletelyDisplayed(R.id.searchEditText)
    }

    @Test
    fun toDetailsActivityButton_VISIBLE() {
        checkVISIBLE(R.id.toDetailsActivityButton)
    }

    @Test
    fun toDetailsActivityButton_IsCompletelyDisplayed() {
        isCompletelyDisplayed(R.id.toDetailsActivityButton)
    }

    @Test
    fun toDetailsActivityButton_checkText() {
        onView(withId(R.id.toDetailsActivityButton)).check(matches(withText("to details")))
    }


    private fun checkGONE(id: Int) {
        onView(withId(id)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    private fun checkVISIBLE(id: Int) {
        onView(withId(id)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    private fun isCompletelyDisplayed(id: Int) {
        onView(withId(id)).check(matches(isCompletelyDisplayed()))
    }
}
