package com.example.lesson_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson_4.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMain.setNavigationOnClickListener { onBackPressed() }

        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_circle -> {
                    val dialogFragment = CircleDialogFragment()
                    dialogFragment.show(supportFragmentManager, "custom")
                }
                R.id.item_home -> {
                    Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }


        val cards = fillDate()
    }

    private fun fillDate(): ArrayList<BaseInfoItem> {
        val data = ArrayList<BaseInfoItem>()

        val headers = ArrayList<String>(
            listOf(
                "Квитанции",
                "Счетчики",
                "Рассрочка",
                "Страхование",
                "Интернет и ТВ",
                "Домофон",
                "Охрана",
                "Контакты УК и служб",
                "Мои заявки",
                "Памятка жителя А101"
            )
        )

        val info = ArrayList<String>(
            listOf(
                "- 40 080,55",
                "Подайте показания",
                "Сл. платеж 25.02.2018",
                "Полис до 12.01.2019",
                "Баланс 350 Р",
                "Подключен",
                "Нет",
                "",
                "",
                ""
            )
        )

        val images = ArrayList<Int>(
            listOf(
                R.drawable.ic_bill,
                R.drawable.ic_counter,
                R.drawable.ic_installment,
                R.drawable.ic_insurance,
                R.drawable.ic_internet_tv,
                R.drawable.ic_intercom,
                R.drawable.ic_security,
                R.drawable.ic_contacts,
                R.drawable.ic_applications,
                R.drawable.ic_memo
            )
        )

        val attentions = ArrayList<Boolean>(
            listOf(
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false
            )
        )

        for (i in 0 until headers.size) {
            if (info.get(i) != "") {
                data.add(DetailInfoItem(headers[i], info[i], images[i], attentions[i]))
            } else {
                data.add(BaseInfoItem(headers[i], images[i]))
            }
        }

        return data
    }
}