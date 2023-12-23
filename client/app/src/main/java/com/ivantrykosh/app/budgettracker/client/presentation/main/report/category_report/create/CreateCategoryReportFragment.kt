package com.ivantrykosh.app.budgettracker.client.presentation.main.report.category_report.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.components.Legend
import com.ivantrykosh.app.budgettracker.client.R
import com.ivantrykosh.app.budgettracker.client.databinding.FragmentCreatedCategoryReportBinding
import com.ivantrykosh.app.budgettracker.client.presentation.main.report.category_report.CategoryReportViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateCategoryReportFragment : Fragment() {
    private var _binding: FragmentCreatedCategoryReportBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoryReportViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreatedCategoryReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createdCategoryReportTopAppBar.setOnClickListener {
            findNavController().navigate(R.id.action_createdCategoryReport_to_categoryReportFragment)
        }

        showReport()
    }

    private fun showReport() {
        val barData = viewModel.getBarDataByCategory()
        barData.setValueTextSize(16f)
        binding.createdCategoryReportBarchart.data = barData
        binding.createdCategoryReportBarchart.description.isEnabled = false
        binding.createdCategoryReportBarchart.xAxis.setDrawLabels(false)
        binding.createdCategoryReportBarchart.xAxis.setDrawGridLines(false)
        binding.createdCategoryReportBarchart.axisLeft.textSize = 16f
        binding.createdCategoryReportBarchart.axisRight.textSize = 16f

        binding.createdCategoryReportBarchart.axisLeft.axisMinimum = -viewModel.maxCategoryValue
        binding.createdCategoryReportBarchart.axisLeft.axisMaximum = viewModel.maxCategoryValue
        binding.createdCategoryReportBarchart.axisRight.axisMinimum = -viewModel.maxCategoryValue
        binding.createdCategoryReportBarchart.axisRight.axisMaximum = viewModel.maxCategoryValue

        val legend = binding.createdCategoryReportBarchart.legend

        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.form = Legend.LegendForm.SQUARE
        legend.isWordWrapEnabled = true
        legend.setDrawInside(false)
        legend.textSize = 16f
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}