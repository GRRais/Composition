package ru.rayanis.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rayanis.composition.R
import ru.rayanis.composition.databinding.FragmentChooseLevelBinding
import ru.rayanis.composition.databinding.FragmentGameFinishedBinding
import ru.rayanis.composition.domain.entity.GameResult

class GameFinishedFragment : Fragment() {

    private lateinit var gameResult: GameResult

    private var _b: FragmentGameFinishedBinding? = null
    private val b: FragmentGameFinishedBinding
        get() = _b ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        _b = FragmentGameFinishedBinding.inflate(inflater , container , false)
        return b.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _b = null
    }

    private fun parseArgs() {
        gameResult = requireArguments().getSerializable(KEY_GAME_RESULT) as GameResult

    }

    companion object {

        private const val KEY_GAME_RESULT = "game_result"

        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}