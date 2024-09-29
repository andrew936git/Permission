package com.example.permission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.permission.databinding.FragmentFirstBinding
import android.Manifest
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentTransaction


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
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

        binding.cameraMB.setOnClickListener{
            val permission = Manifest.permission.CAMERA
            permissionLauncherCamera.launch(permission)

        }

        binding.contactMB.setOnClickListener{
            val permission = Manifest.permission.READ_CONTACTS
            permissionLauncherContracts.launch(permission)
        }


    }

    private val permissionLauncherCamera = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Получено разрешение", Toast.LENGTH_SHORT).show()

            val cameraFragment = CameraFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, cameraFragment)
            transaction?.addToBackStack(null)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction?.commit()
        }
        else Toast.makeText(context, "В разрешении отказано", Toast.LENGTH_SHORT).show()
    }

    private val permissionLauncherContracts = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
            isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Получено разрешение", Toast.LENGTH_SHORT).show()

            val contactFragment = ContactFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, contactFragment)
            transaction?.addToBackStack(null)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction?.commit()
        }
        else Toast.makeText(context, "В разрешении отказано", Toast.LENGTH_SHORT).show()
    }

}