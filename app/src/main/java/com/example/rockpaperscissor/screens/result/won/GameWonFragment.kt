package com.example.rockpaperscissor.screens.result.won

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.databinding.GameFragmentBinding
import com.example.rockpaperscissor.databinding.GameWonFragmentBinding
import com.example.rockpaperscissor.screens.game.GameFragmentDirections
import com.example.rockpaperscissor.screens.result.won.GameWonFragmentDirections.Companion.actionGameWonFragmentToGameFragment

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameWonFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_won_fragment,
            container, false
        )
        binding.playAgainButton.setOnClickListener {
            findNavController()
                .navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        return binding.root
    }
}