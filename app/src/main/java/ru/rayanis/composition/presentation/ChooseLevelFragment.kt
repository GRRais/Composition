package ru.rayanis.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.rayanis.composition.R
import ru.rayanis.composition.databinding.FragmentChooseLevelBinding
import ru.rayanis.composition.domain.entity.Level


class ChooseLevelFragment : Fragment() {

    private var _b: FragmentChooseLevelBinding? = null
    private val b: FragmentChooseLevelBinding
        get() = _b ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _b = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(b) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level) {
        var args = Bundle().apply {
            putParcelable(GameFragment.KEY_LEVEL , level)
        }
        findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment, args)
    }

    override fun onDestroy() {
        super.onDestroy()
        _b = null
    }

    companion object {

        const val NAME = "ChooseLevelFragment"

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}