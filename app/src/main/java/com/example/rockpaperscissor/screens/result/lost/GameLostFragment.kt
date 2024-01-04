package com.example.rockpaperscissor.screens.result.lost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.databinding.GameLostFragmentBinding

class GameLostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameLostFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_lost_fragment, container, false
        )
        binding.tryAgainButton.setOnClickListener {
            findNavController()
                .navigate(GameLostFragmentDirections.actionGameLostFragmentToGameFragment())
        }
        return binding.root
    }
}