package domain.preferences.usecases

fun interface SavePreferenceUseCase {
    suspend fun execute(key: String, value: String)
}