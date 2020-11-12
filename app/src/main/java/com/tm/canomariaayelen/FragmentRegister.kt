package com.tm.canomariaayelen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.tm.canomariaayelen.persistence.MyDBHeleper
import kotlinx.android.synthetic.main.fragm_registro.*

class FragmenteRegister(applicationContext: Context) : Fragment(){

    val TAG= "FragmentRegister"
    private var listener: OnFragmentActionsListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        Log.d(TAG,"onCreateView")
        return inflater!!.inflate(R.layout.fragm_registro,container,false) //los !! significa que no es null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        guardarRegistro.setOnClickListener { listener?.onClickFragmentButton() }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionsListener) {
            listener = context
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}