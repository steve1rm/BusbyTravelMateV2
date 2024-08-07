package domain.authentication.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginAuthenticationModel(
    @SerialName("postBody")
    val postBody: PostBody,
    @SerialName("requestUri")
    val requestUri: String = "",
    @SerialName("returnIdpCredential")
    val returnIdpCredential: Boolean = true,
    @SerialName("returnSecureToken")
    val returnSecureToken: Boolean = true
)

@Serializable
data class PostBody(
    @SerialName("id_token")
    val idToken: String,
    val providerId: String
)