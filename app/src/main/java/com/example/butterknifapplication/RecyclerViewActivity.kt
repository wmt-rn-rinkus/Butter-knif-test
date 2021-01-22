package com.example.butterknifapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class RecyclerViewActivity : AppCompatActivity() {
    val list = ArrayList<DataClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        init()
    }

    private fun init() {
        empRecyclers.layoutManager = LinearLayoutManager(this)
        val adapter = EmpAdapter(this, list)
        empRecyclers.adapter = adapter
        val fileInString: String =
            applicationContext.assets.open("Data.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(fileInString)
        try {
            var i = 0
            while (i < jsonArray.length()) {
                val dataClass = DataClass()
                val obj: JSONObject = jsonArray.getJSONObject(i)
                dataClass.email = obj.getString("email")
                dataClass.fullName = obj.getString("fullName")
                dataClass.image = obj.getString("image")
                dataClass.number = obj.getString("number")
                list.add(dataClass)
                i++
            }
        } catch (e: JSONException) {
            e.printStackTrace()

        }

        adapter.notifyDataSetChanged()
    }


}


