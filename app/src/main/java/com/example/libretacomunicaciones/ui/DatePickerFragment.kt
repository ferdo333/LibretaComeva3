package com.example.libretacomunicaciones.ui

    import android.app.DatePickerDialog
    import android.app.Dialog
    import android.os.Bundle
    import androidx.fragment.app.DialogFragment
    import java.util.*

    class DatePickerFragment (
        private val listener: DatePickerDialog.OnDateSetListener,
        private val initialDate: Date
    ): DialogFragment() {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar = GregorianCalendar()
            calendar.time = initialDate
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(requireActivity(), listener, year, month, day)
        }

}

// le ddamos el formato a la fecha