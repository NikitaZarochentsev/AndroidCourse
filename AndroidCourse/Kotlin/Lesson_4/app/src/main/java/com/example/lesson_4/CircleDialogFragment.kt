package com.example.lesson_4

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CircleDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val alertDialog = builder
            .setTitle("Диалог")
            .setMessage("Любой текст")
            .setPositiveButton("ОК", null)
            .create()

        alertDialog.show()
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(R.attr.colorOnPrimary)

        return alertDialog
    }
}