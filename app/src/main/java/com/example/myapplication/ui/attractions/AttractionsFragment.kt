package com.example.myapplication.ui.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.attractions.AttractionsInfo
import com.example.myapplication.databinding.FragmentAttractionsBinding
import com.example.myapplication.ui.attractions.viewholder.AttractionsAdapter

class AttractionsFragment : Fragment() {
    private var _binding: FragmentAttractionsBinding? = null
    private val binding get() = _binding!!
    private var dataList = mutableListOf<AttractionsInfo>()

    private lateinit var attractionsAdapter: AttractionsAdapter
    lateinit var viewModel: AttractionsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.attractionInfo.observe(viewLifecycleOwner) {
            dataList.clear()
            dataList.addAll(it ?: emptyList())
            attractionsAdapter.notifyDataSetChanged()
        }
        viewModel.getAttractionInfo("zh-cn", "34", 120f, 25f)
        initial()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AttractionsViewModel::class.java)
        _binding = FragmentAttractionsBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun initial() {
        attractionsAdapter = AttractionsAdapter(dataList)
        attractionsAdapter.onItemClick = {
            findNavController().navigate(
                AttractionsFragmentDirections.actionAttractionsFragmentToAttractionDetailFragment(it)
            )
        }
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = attractionsAdapter
        }
        (requireActivity() as MainActivity).changeLang={
            viewModel.getAttractionInfo(it, "34", 120f, 25f)
        }


    }


}