package com.herlangga.university.data.models

import com.google.gson.annotations.SerializedName

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
data class UniversityResponse(
    @SerializedName("country")
    val country: String?,
    @SerializedName("domain")
    val domain: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("web_page")
    val webPage: String?
)