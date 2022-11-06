package ru.rayanis.composition.domain.usecases

import ru.rayanis.composition.domain.entity.GameSettings
import ru.rayanis.composition.domain.entity.Level
import ru.rayanis.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}