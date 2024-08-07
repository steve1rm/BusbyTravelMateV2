package domain.authentication.models

import kotlinx.serialization.Serializable

@Serializable
data class TokenAuthorizationModel(
    /** Short lived token */
    val tokenId: String,
    /** Long lived token to be used to request another accessToken */
    val refreshToken: String,
)
