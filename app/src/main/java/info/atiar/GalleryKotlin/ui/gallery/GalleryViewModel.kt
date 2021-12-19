package info.atiar.GalleryKotlin.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import info.atiar.GalleryKotlin.model.PexelsRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: PexelsRepository
    ) : ViewModel(){

}