package com.example.feature1

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.feature1.databinding.Feature1FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Feature1SecondFragment : Fragment() {

    private var _binding: Feature1FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<Feature1SecondFragmentArgs>()
    private var id: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Feature1FragmentSecondBinding.inflate(inflater, container, false)
        return binding. root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id = args.feature1SecondArgument
        binding.tvF1Second.text = String.format("%s: %s", getText(R.string.hello_feature1_second_fragment), id)

        binding.btnF1SecondToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.btnFeature1SecondToAppMainActivity.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://app/mainActivity"))
        }

        binding.btnF1SecondToAppSecond.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://app/secondFragment"))
        }

        binding.btnF1SecondToF2Second.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://feature2/secondFragment"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}