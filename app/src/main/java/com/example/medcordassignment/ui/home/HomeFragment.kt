package com.example.medcordassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.medcordassignment.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),View.OnClickListener {
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn1->{
                activity?.let { homeViewModel.apicall(btn1.text.toString(), it)?.observe(this,
                    Observer { response->response
                    Toast.makeText(context,response,Toast.LENGTH_LONG).show()

                    }) }
            }
            R.id.btn2->{
                activity?.let { homeViewModel.apicall(btn1.text.toString(), it)?.observe(this,
                    Observer { response->response
                        Toast.makeText(context,response,Toast.LENGTH_LONG).show()
                    }) }
            }
        R.id.btn3->{
            activity?.let { homeViewModel.apicall(btn1.text.toString(), it)?.observe(this, Observer { response->response
                Toast.makeText(context,response,Toast.LENGTH_LONG).show()
            }) }
        }
        R.id.btn4->{
            activity?.let { homeViewModel.apicall(btn1.text.toString(), it)?.observe(this, Observer { response->response
                Toast.makeText(context,response,Toast.LENGTH_LONG).show()
            }) }
        }
        else ->{

        }


        }
    }

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
     val btn1=root.findViewById<Button>(R.id.btn1)
     val btn2=root.findViewById<Button>(R.id.btn2)
     val btn3=root.findViewById<Button>(R.id.btn3)
     val btn4=root.findViewById<Button>(R.id.btn4)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)


        return root
    }
}