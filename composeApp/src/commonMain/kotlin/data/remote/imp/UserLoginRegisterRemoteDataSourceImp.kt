package data.remote.imp

import co.touchlab.kermit.Logger
import data.remote.UserLoginRegisterRemoteDataSource
import domain.authentication.models.RegisterUserModel
import domain.utils.CheckResult
import domain.utils.DataError
import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserLoginRegisterRemoteDataSourceImp() :
    UserLoginRegisterRemoteDataSource {

    override suspend fun registerUser(registerUserModel: RegisterUserModel): CheckResult<String, DataError.Network, String> {
       /* firebaseAuth.currentUser?.let {
            Logger.d {
                "User is already registered ${firebaseAuth.currentUser?.uid}"
            }
            return CheckResult.Success(it.uid)
        }

        return suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Logger.d("User has been created ${firebaseAuth.currentUser?.uid}")
                        continuation.resume(CheckResult.Success(firebaseAuth.currentUser?.uid ?: ""))
                    }
                    else {
                        Logger.d("Error when creating ${firebaseAuth.currentUser?.uid}")
                        continuation.resume(CheckResult.Failure(exceptionError = DataError.Network.UNAUTHORIZED))
                    }
                }
        }*/
        TODO()
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