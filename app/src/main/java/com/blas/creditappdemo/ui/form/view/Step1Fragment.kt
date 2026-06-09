package com.blas.creditappdemo.ui.form.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.blas.creditappdemo.R
import com.blas.creditappdemo.databinding.FragmentStep1Binding
import com.blas.creditappdemo.ui.form.viewmodel.SharedFormViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step1Fragment : Fragment() {

    private var _binding: FragmentStep1Binding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedFormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStep1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tujuanList = listOf(
            "Modal Kerja",
            "Sekolah",
            "Kebutuhan"
        )

        val adapterTujuan = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            tujuanList
        )

        binding.spTujuan.setAdapter(adapterTujuan)
        binding.spTujuan.setOnClickListener {
            binding.spTujuan.showDropDown()
        }

        val riwayatList = listOf(
            "Baik (Tidak Pernah Telat)",
            "Baik (Sesekali Telat)",
            "Kurang Baik (Sering Telat)"
        )

        val adapterRiwayat = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            riwayatList
        )

        binding.spRiwayat.setAdapter(adapterRiwayat)
        binding.spRiwayat.setOnClickListener {
            binding.spRiwayat.showDropDown()
        }

        // Optional: kosong saat awal
        binding.spTujuan.setText("", false)
        binding.spRiwayat.setText("", false)

        binding.btnNext.setOnClickListener {
            viewModel.updateStep1(
                binding.etName.text.toString()
            )

            findNavController().navigate(R.id.action_step1_to_step2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}