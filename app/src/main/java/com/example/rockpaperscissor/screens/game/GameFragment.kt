package com.example.rockpaperscissor.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.databinding.GameFragmentBinding


class GameFragment : Fragment() {
    private lateinit var binding: GameFragmentBinding
    private var roundsRemaining: Int = 5
    private val imageResources = arrayOf(R.drawable.rock,R.drawable.paper,R.drawable.scissor)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater,R.layout.game_fragment,
                                                container,false)
        (activity as AppCompatActivity)?.supportActionBar?.hide()

        binding.startButton.setOnClickListener {
           gameStartOperations()
        }
        binding.rockSignImageButton.setOnClickListener {
            binding.yourImageView.setImageResource(R.drawable.rock)
            val playerFlag = 0
            gameOperation(playerFlag)
        }
        binding.paperSignImageButton.setOnClickListener {
            binding.yourImageView.setImageResource(R.drawable.paper)
            val playerFlag = 1
            gameOperation(playerFlag)
        }
        binding.scissorSignImageButton.setOnClickListener {
            binding.yourImageView.setImageResource(R.drawable.scissor)
            val playerFlag = 2
            gameOperation(playerFlag)
        }
        return binding.root
    }

    private fun updateScore(playerChoice: Int, computerChoice: Int) {
        val number = (binding.scoreOfYour.text.toString()).toInt()
        val computerNumber = (binding.scoreOfComputer.text.toString()).toInt()

        if ((playerChoice == 0 && computerChoice == 2) || (playerChoice == 1 && computerChoice == 0) ||
            (playerChoice == 2 && computerChoice == 1)){
                binding.scoreOfYour.text = getString(R.string.your_score,(number + 1))
        } else if ((computerChoice == 0 && playerChoice == 2) || (computerChoice == 1 && playerChoice == 0)
            || (computerChoice == 2 && playerChoice == 1)){
                binding.scoreOfComputer.text = getString(R.string.your_score, (computerNumber + 1))
        }
    }

    private fun gameCompleted(){
        if (roundsRemaining == 0){
            val yourScore = (binding.scoreOfYour.text.toString()).toInt()
            val computerScore = (binding.scoreOfComputer.text.toString()).toInt()
            if (yourScore > computerScore) {
                findNavController()
                    .navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment())
            } else {
                findNavController()
                    .navigate(GameFragmentDirections.actionGameFragmentToGameLostFragment())
            }
        }
    }
    private fun gameOperation(playerFlag: Int){
        val computerFlag = (Math.random() * imageResources.size).toInt()
        binding.computerImageView.setImageResource(imageResources[computerFlag])
        updateScore(playerFlag,computerFlag)
        roundsRemaining--
        gameCompleted()
    }
    private fun gameStartOperations(){
        binding.apply {
            startButton.visibility = View.INVISIBLE
            startButton.isEnabled = false
            rockSignImageButton.visibility = View.VISIBLE
            paperSignImageButton.visibility = View.VISIBLE
            scissorSignImageButton.visibility = View.VISIBLE
            rockSignImageButton.isEnabled = true
            paperSignImageButton.isEnabled = true
            scissorSignImageButton.isEnabled = true
        }
    }
}