package com.enty.partyinvetation.ui.invitation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enty.partyinvetation.data.Repository
import com.enty.partyinvetation.data.dto.InvitationDto

class InvitationViewModel(app: Application): AndroidViewModel(app) {
    private val repository: Repository = Repository()

    private val _invitation = MutableLiveData<InvitationDto>()
    val invitation: LiveData<InvitationDto> = _invitation

    fun getInvitation() {
        val gsonString = repository.readJson(getApplication(),"invitation.json")
        _invitation.postValue(repository.getDataModel(gsonString))
    }
}