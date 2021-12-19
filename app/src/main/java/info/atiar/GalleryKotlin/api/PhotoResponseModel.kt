package info.atiar.GalleryKotlin.api

import info.atiar.GalleryKotlin.data.PhotoModel

data class PhotoResponseModel(
    val results: List<PhotoModel>
)