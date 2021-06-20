package robert.pakpahan.jetprokedua.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import robert.pakpahan.jetprokedua.source.local.MovieCatalogueRepository
import robert.pakpahan.jetprokedua.source.local.entity.DetailEntity

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    private lateinit var detailData: LiveData<DetailEntity>

    fun setFilm(id: String, category: String) {
        when (category) {
            TV_SHOW -> {
                detailData = movieCatalogueRepository.getDetailTvShow(id)
            }

            MOVIE -> {
                detailData = movieCatalogueRepository.getDetailMovie(id)
            }
        }
    }

    fun getDataDetail() = detailData

}