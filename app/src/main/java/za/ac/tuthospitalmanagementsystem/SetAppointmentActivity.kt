package za.ac.tuthospitalmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.random.Random

class SetAppointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_appointment)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Set Appointment"
        var buttonBack = findViewById<Button>(R.id.buttonBack)
        var buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val randomValues = Random.nextInt(1000)
            submitAppointment(randomValues)
        }

        buttonBack.setOnClickListener {
            goToPatientActivity()
        }
    }

    private fun submitAppointment(appointmentNumber: Int) {
        val editTextDisease :String = findViewById<EditText>(R.id.editTextDisease).text.toString()
        val spinnerAvailability :String = findViewById<Spinner>(R.id.spinnerAvailability).selectedItem.toString()
        val editTextDate : String = findViewById<EditText>(R.id.editTextDate).text.toString()
        var username : String = intent.getStringExtra("username").toString()

        val database  = Firebase.database
        val myref = database.getReference("Appointment").child(appointmentNumber.toString())

        myref.setValue(Appointment(username, doctor="null",editTextDisease,spinnerAvailability,editTextDate))

        val intent = Intent(this,AppointmentActivity::class.java)
        intent.putExtra("username",username)
        startActivity(intent)
    }

    private fun goToPatientActivity() {
        val intent = Intent(this,PatientActivity::class.java)
        startActivity(intent)
    }
}