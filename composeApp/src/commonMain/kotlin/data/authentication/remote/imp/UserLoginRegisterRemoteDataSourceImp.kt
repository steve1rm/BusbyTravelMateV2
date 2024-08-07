package data.authentication.remote.imp

import BusbyTravelMateV_.composeApp.BuildConfig
import data.authentication.dto.AuthenticationInfoDto
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.dto.ErrorResponseDto
import data.utils.Routes
import data.utils.safeApiRequest
import domain.authentication.models.AuthenticationUserModel
import domain.authentication.models.LoginAuthenticationModel
import domain.authentication.models.PostBody
import domain.utils.CheckResult
import domain.utils.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class UserLoginRegisterRemoteDataSourceImp(private val httpClient: HttpClient) :
    UserLoginRegisterRemoteDataSource {

    override suspend fun registerUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {

        /** Alternative way to send the request in the body
         * Keeping it here for references purposes
         * val requestBody = buildJsonObject {
         *    this.put("email", registerUserModel.email)
         *    this.put("password", registerUserModel.password)
         *    this.put("returnSecureToken", registerUserModel.returnSecureToken) }
         */

        val safeResult = safeApiRequest<AuthenticationInfoDto> {
            val response = httpClient
                .post(Routes.SIGN_UP) {
                    this.setBody(
                        authenticationUserModel
                    )
                    this.url {
                        this.parameters.append("key", BuildConfig.FIREBASE_AUTHENTICATION_API_KEY)
                    }

                    /** Remove this as after testing as we have added it to the HttpKtorClient */
                    this.headers {
                        append("Content-Type", "application/json")
                    }
                }
            response
        }

        return safeResult
    }

    override suspend fun loginUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        val safeResult = safeApiRequest<AuthenticationInfoDto> {
            val response = httpClient
                .post(Routes.SIGN_IN_WITH_IDP) {
                    this.setBody(
                        LoginAuthenticationModel(
                            postBody = PostBody(
                                idToken = "",
                                providerId = "google.com"
                            ),
                            requestUri = "http://localhost"
                        )
                    )

                    this.url {
                        this.parameters.append("key", BuildConfig.FIREBASE_AUTHENTICATION_API_KEY)
                    }
                }
            response
        }

        return safeResult
    }




override suspend fun logout(): CheckResult<Unit, Unit, Unit> {
       /* if(firebaseAuth.currentUser == null) {
            return CheckResult.Success(Unit)
        }

        return suspendCoroutine { continuation ->
            firebaseAuth.signOut()
            continuation.resume(CheckResult.Success(Unit))
        }*/
        TODO()
    }

    override suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit> {
        // return CheckResult.Success(firebaseAuth.currentUser == null)
        TODO()
    }
}