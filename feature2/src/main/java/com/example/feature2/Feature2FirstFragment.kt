package com.example.feature2

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.feature2.databinding.Feature2FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Feature2FirstFragment : Fragment() {

    private var _binding: Feature2FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Feature2FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnF2FirstGoToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btnF2FirstGoToF1Second.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://feature1/secondFragment/123456"))
        }

        binding.btnF2FirstGoToAppSecond.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://app/secondFragment"))
        }

        binding.btnF2FirstGoToAppMain.setOnClickListener {
            findNavController().navigate(Uri.parse("tanyaApp://app/mainActivity"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}