package ru.rayanis.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rayanis.composition.R
import ru.rayanis.composition.databinding.FragmentChooseLevelBinding
import ru.rayanis.composition.databinding.FragmentGameBinding
import ru.rayanis.composition.domain.entity.GameResult
import ru.rayanis.composition.domain.entity.GameSettings
import ru.rayanis.composition.domain.entity.Level

class GameFragment : Fragment() {

    private lateinit var level: Level

    private var _b: FragmentGameBinding? = null
    private val b: FragmentGameBinding
        get() = _b ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        _b = FragmentGameBinding.inflate(inflater , container , false)
        return b.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        b.tvOption1.setOnClickListener {
            launchGameFinishedFragment(
                GameResult(
                true,
                0,
                0,
                GameSettings(0,0,0,0)
            )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _b = null
    }

    private fun parseArgs() {
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        private const val KEY_LEVEL = "level"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL, level)
                }
            }
        }
    }
}