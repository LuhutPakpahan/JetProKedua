package robert.pakpahan.jetprokedua.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import robert.pakpahan.jetprokedua.source.local.MovieCatalogueRepository
import robert.pakpahan.jetprokedua.source.local.entity.DetailEntity
import robert.pakpahan.jetprokedua.ui.viewmodel.DetailViewModel.Companion.MOVIE
import robert.pakpahan.jetprokedua.ui.viewmodel.DetailViewModel.Companion.TV_SHOW
import robert.pakpahan.jetprokedua.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getDetailMovie()
    private val dummyMovieId = dummyMovie.id.toString()

    private val dummyTvShow = DataDummy.getDetailTvShow()
    private val dummyTvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    // Get Data Movie Testing
    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyMovie

        Mockito.`when`(movieCatalogueRepository.getDetailMovie(dummyMovieId)).thenReturn(movie)
        viewModel.setFilm(dummyMovieId, MOVIE)
        val detailEntity = viewModel.getDataDetail().value as DetailEntity
        verify(movieCatalogueRepository).getDetailMovie(dummyMovieId)

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.backdropPath, detailEntity.backdropPath)
        assertEquals(dummyMovie.genres, detailEntity.genres)
        assertEquals(dummyMovie.id, detailEntity.id)
        assertEquals(dummyMovie.overview, detailEntity.overview)
        assertEquals(dummyMovie.posterPath, detailEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyMovie.runtime, detailEntity.runtime)
        assertEquals(dummyMovie.title, detailEntity.title)
        assertEquals(dummyMovie.voteAverage.toInt(), detailEntity.voteAverage.toInt())

        viewModel.getDataDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    // Get Data TV Show Testing
    @Before
    fun setupTvShow() {
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(movieCatalogueRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)
        viewModel.setFilm(dummyTvShowId, TV_SHOW)
        val detailEntity = viewModel.getDataDetail().value as DetailEntity
        verify(movieCatalogueRepository).getDetailTvShow(dummyTvShowId)

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.backdropPath, detailEntity.backdropPath)
        assertEquals(dummyTvShow.genres, detailEntity.genres)
        assertEquals(dummyTvShow.id, detailEntity.id)
        assertEquals(dummyTvShow.overview, detailEntity.overview)
        assertEquals(dummyTvShow.posterPath, detailEntity.posterPath)
        assertEquals(dummyTvShow.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyTvShow.runtime, detailEntity.runtime)
        assertEquals(dummyTvShow.title, detailEntity.title)
        assertEquals(dummyTvShow.voteAverage.toInt(), detailEntity.voteAverage.toInt())

        viewModel.getDataDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyTvShow)
    }
}