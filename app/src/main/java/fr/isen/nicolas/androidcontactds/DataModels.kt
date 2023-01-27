package fr.isen.nicolas.androidcontactds

import com.google.gson.*
import java.lang.reflect.Type

class DataModels {
    data class Contact(
        val surname: String? = null,
        val name: String? = null,
        val adress: String? = null,
        val email: String? = null
    )
    class ContactsDeserializer : JsonDeserializer<Contact> {

        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Contact {
            json as JsonObject

            val surname = json.get("surname").asString
            val name = json.get("name").asString
            val adress = json.get("adress").asString
            val email = json.get("email").asString
            //val addressJson = json.get("address")

            val gSon = GsonBuilder().registerTypeAdapter(DataModels::class.java, ContactsDeserializer()).create()
            val contacts = gSon.fromJson<Contact>(json, DataModels::class.java)

            return Contact(name, surname, adress, email)
        }
    }
}