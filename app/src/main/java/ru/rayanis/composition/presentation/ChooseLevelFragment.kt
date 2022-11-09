package ru.rayanis.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rayanis.composition.R
import ru.rayanis.composition.databinding.FragmentChooseLevelBinding


class ChooseLevelFragment : Fragment() {

    private var _b: FragmentChooseLevelBinding? = null
    private val b: FragmentChooseLevelBinding
    get() = _b ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        _b = FragmentChooseLevelBinding.inflate(inflater , container , false)
        return b.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _b = null
    }

    companion object {
        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }

    }
}