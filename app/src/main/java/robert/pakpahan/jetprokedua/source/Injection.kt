package robert.pakpahan.jetprokedua.source

import android.content.Context
import robert.pakpahan.jetprokedua.source.local.MovieCatalogueRepository
import robert.pakpahan.jetprokedua.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}