package data.authentication.remote.imp

import data.authentication.dto.AuthenticationInfoDto
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.dto.ErrorResponseDto
import data.utils.safeApiRequest
import domain.authentication.models.RegisterUserModel
import domain.utils.CheckResult
import domain.utils.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class UserLoginRegisterRemoteDataSourceImp(private val httpClient: HttpClient) :
    UserLoginRegisterRemoteDataSource {

    override suspend fun registerUser(registerUserModel: RegisterUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {

        /* Alternative way to send the request in the body
         * Keeping it here for references purposes
        val requestBody = buildJsonObject {
            this.put("email", registerUserModel.email)
            this.put("password", registerUserModel.password)
            this.put("returnSecureToken", registerUserModel.returnSecureToken)
        } */

        val safeResult = safeApiRequest<AuthenticationInfoDto> {
            val response = httpClient
                .post("https://identitytoolkit.googleapis.com/v1/accounts:signUp") {
                    this.setBody(
                        registerUserModel
                    )
                    this.url {
                        this.parameters.append("key", "AIzaSyCn7yR54vYpXVRoisRIwIoVlvjwoACBPiM")
                    }

                    this.headers {
                        append("Content-Type", "application/json")
                    }
                }
            response
        }

        return safeResult
    }

    override suspend fun loginUser(email: String, password: String): CheckResult<String, Unit, Unit> {
        /** Remove this, its just to add a small delay to simulate when a user logins */
       /* delay(2_000)

        firebaseAuth.currentUser?.let {
            Logger.d("User is already logged in ${firebaseAuth.currentUser?.uid}")
            return CheckResult.Success(it.uid)
        }

        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Logger.d("User has been logged in [$email, $password] ${firebaseAuth.currentUser?.uid}")
                        continuation.resume(CheckResult.Success(firebaseAuth.currentUser?.uid ?: ""))
                    }
                    else {
                        Logger.e("Error when logging in ${task.exception?.message}")
                        continuation.resume(CheckResult.Failure(exceptionError = DataError.Network.UNAUTHORIZED))
                    }
                }
        }*/
        TODO()
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