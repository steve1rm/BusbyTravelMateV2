package domain.authentication.models

data class TokenAuthorizationModel(
    /** Short lived token */
    val tokenId: String,
    /** Long lived token to be used to request another accessToken */
    val refreshToken: String,
)
