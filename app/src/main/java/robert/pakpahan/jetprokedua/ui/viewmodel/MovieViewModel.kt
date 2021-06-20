package robert.pakpahan.jetprokedua.ui.viewmodel

import androidx.lifecycle.ViewModel
import robert.pakpahan.jetprokedua.source.local.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getMovies() = movieCatalogueRepository.getMovies()
}