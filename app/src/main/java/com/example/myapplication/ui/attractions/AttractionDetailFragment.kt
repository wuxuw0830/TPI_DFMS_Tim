package com.example.myapplication.ui.attractions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentAttractionDetailBinding


class AttractionDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AttractionDetailFragment()
    }

    private lateinit var viewModel: AttractionDetailViewModel
    private var _binding: FragmentAttractionDetailBinding? = null
    private val binding get() = _binding!!
    private val args: AttractionDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AttractionDetailViewModel::class.java)


        _binding = FragmentAttractionDetailBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.apply {
            Glide.with(requireContext()).load(this.detail?.url).into(binding.imageView)
            binding.tvIntroduce.text = this.detail?.introduce
            binding.tvAddress.text = this.detail?.address
            binding.tvLink.text = this.detail?.linkUrl

        }
        binding.tvLink.setOnClickListener {
            findNavController().navigate(
                AttractionDetailFragmentDirections.actionAttractionDetailFragmentToWebViewFragment(linkUrl = binding.tvLink.text.toString())
            )
        }
    }

}