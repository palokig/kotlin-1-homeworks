package ru.netology.kotlin.a5
import kotlinx.android.synthetic.main.post_card.view.*

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.a5.Odb.list as list

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter(list)
        }
        /*list.forEach {
            // root указывает на родительский ContraintLayout
            val view = layoutInflater.inflate(R.layout.post_card, container, false).apply {
                // благодаря kotlinx и импорту можем работать вот так:
                textView.text =  it.content
            }
            container.addView(view)
        }*/

    }
}
