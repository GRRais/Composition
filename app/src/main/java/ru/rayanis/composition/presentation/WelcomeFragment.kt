package ru.rayanis.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.rayanis.composition.R
import ru.rayanis.composition.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _b: FragmentWelcomeBinding? = null
    private val b: FragmentWelcomeBinding
        get() = _b ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _b = FragmentWelcomeBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.buttonUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    private fun launchChooseLevelFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChooseLevelFragment.newInstance())
            .addToBackStack(ChooseLevelFragment.NAME)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _b = null
    }
}