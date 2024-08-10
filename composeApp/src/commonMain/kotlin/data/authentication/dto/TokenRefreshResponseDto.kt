package data.authentication.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenRefreshResponseDto(
    @SerialName("expires_in")
    val expiresIn: String = "",
    @SerialName("id_token")
    val idToken: String = "",
    @SerialName("project_id")
    val projectId: String = "",
    @SerialName("refresh_token")
    val refreshToken: String = "",
    @SerialName("token_type")
    val tokenType: String = "",
    @SerialName("user_id")
    val userId: String = ""
)