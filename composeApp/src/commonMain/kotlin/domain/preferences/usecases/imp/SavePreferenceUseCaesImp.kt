package domain.preferences.usecases.imp

import domain.preferences.PreferenceRepository
import domain.preferences.usecases.SavePreferenceUseCase

class SavePreferenceUseCaesImp(private val preferenceRepository: PreferenceRepository) : SavePreferenceUseCase {
    override suspend fun execute(key: String, value: String) {
        preferenceRepository.savePreference(key, value)
    }
}
