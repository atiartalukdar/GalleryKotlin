package info.atiar.GalleryKotlin.data

import androidx.paging.PagingSource
import info.atiar.GalleryKotlin.api.PexelsApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1
class PexelsPaginSource(
    private val pexelsApi: PexelsApi,
    private val query: String
): PagingSource<Int, PhotoModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoModel> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return  try {
            val response = pexelsApi.searchPhotos(query,position,params.loadSize)
            val photos = response.results


            LoadResult.Page(
                data = photos,
                prevKey = if (position==STARTING_PAGE_INDEX) null else position-1,
                nextKey = if (photos.isEmpty()) null else position+1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }
}