package za.ac.tuthospitalmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class AdminActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)

        toggle  = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation_drawer,R.string.close_navigation_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.doctorRegister->{
                    goToDoctorRegister()
                }
                R.id.patients->{
                    goToPatients()
                }
                R.id.doctors->{
                    goToDoctors()
                }
                R.id.appointment->{
                    goToAppointment()
                }
                R.id.notification->{
                    goToNotification()
                }
                R.id.logout->{
                    goToLogin()
                }
                R.id.profile->{
                    goToProfile()
                }
            }
            true
        }
    }

    private fun goToNotification() {
        val intent = Intent(this,AppointmentActivity::class.java)
        startActivity(intent)
    }

    private fun goToDoctors() {
        val intent = Intent(this,AdminDoctorActivity::class.java)
        startActivity(intent)
    }

    private fun goToPatients() {
        val intent = Intent(this,AdminPatientsActivity::class.java)
        startActivity(intent)
    }

    private fun goToDoctorRegister() {
        val intent = Intent(this,DoctorRegisterActivity::class.java)
        startActivity(intent)
    }

    private fun goToAppointment() {
        val intent = Intent(this,AppointmentActivity::class.java)
        startActivity(intent)
    }

    private fun goToLogin() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goToProfile() {
        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)
    }
}