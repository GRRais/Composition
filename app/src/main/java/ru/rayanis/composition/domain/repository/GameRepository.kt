package ru.rayanis.composition.domain.repository

import ru.rayanis.composition.domain.entity.GameSettings
import ru.rayanis.composition.domain.entity.Level
import ru.rayanis.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}