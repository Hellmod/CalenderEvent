package com.example.calenderevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var title: EditText
    lateinit var location: EditText
    lateinit var description: EditText
    lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.title)
        location = findViewById(R.id.location)
        description = findViewById(R.id.description)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            if (title.text.isNotEmpty() && location.text.isNotEmpty() && description.text.isNotEmpty()) {
                var intent: Intent = Intent(Intent.ACTION_INSERT)
                intent.data = CalendarContract.Events.CONTENT_URI
                intent.putExtra(CalendarContract.Events.TITLE, title.text)
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.text)
                intent.putExtra(CalendarContract.Events.DESCRIPTION, description.text)
                intent.putExtra(CalendarContract.Events.ALL_DAY, true)

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Uzupełnij dane", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Uzupełnij dane", Toast.LENGTH_SHORT).show()
        }

    }
}