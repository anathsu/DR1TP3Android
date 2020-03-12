package com.example.menu.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.menu.R
import kotlinx.android.synthetic.main.fragment_date.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class DateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date, container, false)
    }

    override fun onViewCreated (view: View ,
                                savedInstanceState: Bundle ?) {
        super .onViewCreated(view, savedInstanceState)
        // Ao clicar no campo de texto com id date_edittext,
        // mostrar seletor de data
        date.setOnClickListener {
            exibirSeletorDeData()
        }
    }
    // listener com o método que é executado após
    // o usuário selecionar uma data no seletor
    private val dateListener =
        DatePickerDialog.OnDateSetListener {
                datePicker, y, m, d ->
            val dataFormatada = formatarData(d, m, y)
            date.setText(dataFormatada)
        }
    private fun exibirSeletorDeData (){
        // executará se context não for nulo
        context?.let { contexto->
            val c = Calendar.getInstance()
            // dia, mês e ano do momento atual
            val ano = c.get(Calendar.YEAR)
            val mes = c.get(Calendar.MONTH)
            val dia = c.get(Calendar.DAY_OF_MONTH)
            // Exibe o Date Picker usando a data atual
            // como referência
            DatePickerDialog(contexto,
                dateListener, ano, mes, dia).show()
        }
    }

    // formata a data de acordo com a região do usuário
    fun formatarData (dia: Int , mes: Int , ano: Int ): String {
        val c = Calendar.getInstance()
        // configura a data no calendário
        c.set(Calendar.YEAR, ano)
        c.set(Calendar.MONTH, mes)
        c.set(Calendar.DAY_OF_MONTH, dia)
        val data = c.time
        // obtém uma instância de DateFormat que formata
        // apenas dia, mês e ano (sem hora)
        val df = DateFormat.getDateInstance(
            DateFormat.SHORT
        )
        return df.format(data)
    }

}

