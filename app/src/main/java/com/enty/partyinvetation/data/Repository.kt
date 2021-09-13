package com.enty.partyinvetation.data

import android.content.Context
import com.enty.partyinvetation.data.dto.InvitationDto
import com.google.gson.Gson
import java.io.InputStream
import java.lang.Exception

class Repository {


    fun getDataModel(jsonString: String) =
        Gson().fromJson(jsonString, InvitationDto::class.java)

    fun readJson(ctx: Context, fileName: String): String{
        var jsonString = ""
        var n: InputStream? = null

        try{
            n = ctx.assets.open(fileName)
            val buffer = ByteArray(n.available())
            n.read(buffer)
            jsonString = String(buffer)

        } catch (e: Exception){
            e.printStackTrace()
        }
        finally {
            n?.close()
        }
        return jsonString

    }


}