package com.enty.partyinvetation.ui.invitation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.enty.partyinvetation.R
import com.enty.partyinvetation.data.adapters.GuestListAdapter
import com.enty.partyinvetation.databinding.FragmentInvetationBinding


class InvitationFragment : Fragment() {

    lateinit var binding: FragmentInvetationBinding
    val adapter = GuestListAdapter()
    val viewModel: InvitationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInvetationBinding.inflate(inflater, container, false)

        setUpRecyclerView()
        viewModel.getInvitation()
        
        return binding.root
    }

    private fun setUpRecyclerView(){
        viewModel.invitation.observe(viewLifecycleOwner){
            adapter.submitList(it.guest)
        }
    }
}