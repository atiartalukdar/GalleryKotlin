package info.atiar.GalleryKotlin.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import info.atiar.GalleryKotlin.api.PexelsApi
import javax.inject.Inject

class PexelsRepository @Inject constructor(private val pexelsApi: PexelsApi){

    fun getSearchResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {PexelsPaginSource(pexelsApi,query)}
        ).liveData

}