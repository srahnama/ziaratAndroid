package ir.takstudio.ziaratashoura

import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {


                //message.setText(R.string.title_home)
                val db = DBHelper(this, "z.db", null, 1)
                db.openDatabase()
//                Log.d(db.read(), "bye")
//                Log.d("h1i", "bye")

                val tx1:TextView = findViewById(R.id.textView) as TextView
                tx1.setTextSize(resources.getDimension(R.dimen.text_size))
                tx1.setText(db.read())
                tx1.visibility = (View.VISIBLE)

                tx1.setOnClickListener{
                    Toast.makeText(this@MainActivity, "hey body!", Toast.LENGTH_SHORT).show()
                }

                val btn:Button = findViewById(R.id.button1) as Button
                btn.visibility = (View.INVISIBLE)

                val iv:ImageView = findViewById(R.id.imageView) as ImageView
                iv.visibility = (View.INVISIBLE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                val iv:ImageView = findViewById(R.id.imageView) as ImageView
                iv.visibility = (View.INVISIBLE)

                val btn:Button = findViewById(R.id.button1) as Button
                btn.visibility = (View.VISIBLE)
                btn.setOnClickListener {
                    val url = "https://cafebazaar.ir/developer/sha00256/?l=fa"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }

                //  message.setText(R.string.title_dashboard)
                val tx1:TextView = findViewById(R.id.textView) as TextView
                tx1.setText("dashboard")
                tx1.visibility = (View.INVISIBLE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val iv:ImageView = findViewById(R.id.imageView) as ImageView
                iv.visibility = (View.VISIBLE)

                val btn:Button = findViewById(R.id.button1) as Button
                btn.visibility = (View.INVISIBLE)

                val tx1:TextView = findViewById(R.id.textView) as TextView
                tx1.setText("notifications")
                tx1.visibility = (View.INVISIBLE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {

                val iv:ImageView = findViewById(R.id.imageView) as ImageView
                iv.visibility = (View.INVISIBLE)

                val btn:Button = findViewById(R.id.button1) as Button
                btn.visibility = (View.INVISIBLE)

                val tx1:TextView = findViewById(R.id.textView) as TextView
//                tx1.setText("notifications")
                tx1.visibility = (View.INVISIBLE)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    companion object {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val db = DBHelper(this, "z.db", null, 1)
        db.openDatabase()
        Log.d(db.read(), "bye")
        Log.d("h1i", "bye")


        val myFont : Typeface? = ResourcesCompat.getFont(this, R.font.irsans)
        val tx1:TextView = findViewById(R.id.textView) as TextView
        tx1.typeface = myFont
        tx1.setText(db.read())

        tx1.setOnClickListener{
            Toast.makeText(this@MainActivity, "hey body!", Toast.LENGTH_SHORT).show()
        }

    }
}
