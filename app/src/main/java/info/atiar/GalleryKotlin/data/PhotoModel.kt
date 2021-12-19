package info.atiar.GalleryKotlin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoModel(
    val id: String,
    val description: String?,
    val urls: PhotoUrls,
    val authors: Author
):Parcelable {
    @Parcelize
    data class PhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ):Parcelable {

    }
    @Parcelize
    data class Author (
        val name: String,
        val username: String
        ):Parcelable{
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=GalleryKotlin&utm_medium=referral"
    }
}


