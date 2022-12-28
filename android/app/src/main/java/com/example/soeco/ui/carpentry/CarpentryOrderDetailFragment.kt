package com.example.soeco.ui.carpentry

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.soeco.R
import com.example.soeco.ui.viewmodels.OrderDetailsViewModel
import com.example.soeco.utils.viewModelFactory
import java.util.*

class CarpentryOrderDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carpentry_order_detail, container, false)
        val viewmodel by viewModels<OrderDetailsViewModel> { viewModelFactory }

        val orderNumberTextView : TextView = view.findViewById(R.id.textView_carpentry_products_view_order_number)
        val viewProductsButton : Button = view.findViewById(R.id.button_carpentry_viewProducts)
        val viewMaterialsButton : Button = view.findViewById(R.id.button_carpentry_viewMaterials)
        val reportDeviationButton: Button = view.findViewById(R.id.button_carpentry_reportDeviation)
        val order_id = this.arguments?.getString("order")
        val order = order_id?.let { viewmodel.getOrder(it) }
        if (order != null) {
            orderNumberTextView.text= order.OrderNumber
        }

        return view
    }

     private fun setDateButtonListener(dateButton: Button, dateText: TextView) {
         val calendar = Calendar.getInstance()
         val year = calendar.get(Calendar.YEAR)
         val month = calendar.get(Calendar.MONTH)
         val day = calendar.get(Calendar.DAY_OF_MONTH)
         dateText.text = String.format("%d/%d/%d", day, month+1, year)
         dateButton.setOnClickListener {
             val datePickerDialog = activity?.let { it1 ->
                 DatePickerDialog(it1, { _, year, month, dayOfMonth ->
                     dateText.text = String.format("%d/%d/%d", dayOfMonth, month+1, year)
                                       }, year, month, day)
             }
             datePickerDialog?.show()
         }
     }
}