package info.atiar.GalleryKotlin.api

import info.atiar.GalleryKotlin.model.PhotoModel

data class PhotoResponseModel(
    val results: List<PhotoModel>
)