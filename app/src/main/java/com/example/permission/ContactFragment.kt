package com.example.permission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permission.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
    private val contacts = mutableListOf(
        Contact("Евгений", "+79000979762"),
        Contact("Александра", "+79670979762"),
        Contact("Максим", "+79530979782"),
        Contact("Екатерина", "+79630989762"),
        Contact("Андрей", "+79528963762"),
        Contact("Анастасия", "+79861979232"),
        Contact("Дмитрий", "+79220979762"),
        Contact("Мария", "+79320922762"),
        Contact("Роман", "+79360986462"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_exit)
            setNavigationOnClickListener{
                activity?.finishAffinity()
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = CustomAdapter(contacts)
    }

}