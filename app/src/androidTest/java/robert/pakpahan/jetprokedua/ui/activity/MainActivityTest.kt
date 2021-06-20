package robert.pakpahan.jetprokedua.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Test
import org.junit.Before
import robert.pakpahan.jetprokedua.R
import robert.pakpahan.jetprokedua.utils.DataDummy
import robert.pakpahan.jetprokedua.utils.EspressoIdlingResource

class MainActivityTest {

    private val dummyMovie = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTvShow = DataDummy.getDetailTvShow()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.iv_detail)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.iv_detail)).check(ViewAssertions.matches(withTagValue(CoreMatchers.equalTo(dummyDetailMovie.posterPath))))
        Espresso.onView(withId(R.id.coordinator_layout)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.iv_backdrop)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.iv_backdrop)).check(ViewAssertions.matches(withTagValue(CoreMatchers.equalTo(dummyDetailMovie.backdropPath))))
        Espresso.onView(withId(R.id.collapsing)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.collapsing)).check(ViewAssertions.matches(withContentDescription(dummyDetailMovie.title)))
        Espresso.onView(withId(R.id.tv_detail_genre_duration)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview)).check(ViewAssertions.matches(withText(dummyDetailMovie.overview)))
    }

    @Test
    fun loadTvShows() {
        Espresso.onView(withText("TV SHOW")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        Espresso.onView(withText("TV SHOW")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(withId(R.id.iv_detail)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.iv_detail)).check(ViewAssertions.matches(withTagValue(CoreMatchers.equalTo(dummyDetailTvShow.posterPath))))
        Espresso.onView(withId(R.id.coordinator_layout)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.iv_backdrop)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.iv_backdrop)).check(ViewAssertions.matches(withTagValue(CoreMatchers.equalTo(dummyDetailTvShow.backdropPath))))
        Espresso.onView(withId(R.id.collapsing)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.collapsing)).check(ViewAssertions.matches(withContentDescription(dummyDetailTvShow.title)))
        Espresso.onView(withId(R.id.tv_detail_genre_duration)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview)).check(ViewAssertions.matches(withText(dummyDetailTvShow.overview)))
    }
}