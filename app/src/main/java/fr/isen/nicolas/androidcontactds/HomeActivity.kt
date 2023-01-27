package fr.isen.nicolas.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.nicolas.androidcontactds.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //version sans l'API
        val contacts = resources.getStringArray(R.array.contactLists)
        binding.contactList.layoutManager = LinearLayoutManager(this)
        binding.contactList.adapter = ContactAdapter(contacts)


        //cette fonction fait crash l'application dès que je la lance donc attention
        //loadContactFromAPI()
    }
    private fun loadContactFromAPI(){

        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val jsonRequest = JsonObjectRequest(Request.Method.GET,url,null, {
            Log.w("HomeActivity", "response : $it")
            println(it.getJSONArray("data"))
            DataModels.ContactsDeserializer()
        }, {
            Log.w("HomeActivity", "erreur : $it")
        }
        )
        Volley.newRequestQueue(this).add(jsonRequest)

    }
}