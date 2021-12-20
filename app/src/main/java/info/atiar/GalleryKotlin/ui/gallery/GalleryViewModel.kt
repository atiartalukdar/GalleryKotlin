package info.atiar.GalleryKotlin.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import info.atiar.GalleryKotlin.data.PexelsRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: PexelsRepository
    ) : ViewModel(){

    companion object{
        private const val DEFAULT_QUERY = "cat"
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap {
        repository.getSearchResult(it).cachedIn(viewModelScope)
    }

    fun searchPhoto(query: String){
        currentQuery.value = query
    }

}