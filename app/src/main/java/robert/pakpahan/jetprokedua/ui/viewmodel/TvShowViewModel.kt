package robert.pakpahan.jetprokedua.ui.viewmodel

import androidx.lifecycle.ViewModel
import robert.pakpahan.jetprokedua.source.local.MovieCatalogueRepository

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getTvShows() = movieCatalogueRepository.getTvShows()
}