package robert.pakpahan.jetprokedua.source.local

import androidx.lifecycle.LiveData
import robert.pakpahan.jetprokedua.source.local.entity.DetailEntity
import robert.pakpahan.jetprokedua.source.local.entity.MovieEntity
import robert.pakpahan.jetprokedua.source.local.entity.TvShowEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}