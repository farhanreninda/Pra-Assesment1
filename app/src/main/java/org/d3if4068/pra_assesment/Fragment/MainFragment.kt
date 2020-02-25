package org.d3if4068.pra_assesment.Fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import org.d3if4068.pra_assesment.R
import org.d3if4068.pra_assesment.databinding.ActivityMainBinding
import org.d3if4068.pra_assesment.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main,container,false)
        setHasOptionsMenu(true)

        binding.btnPersegi.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_persegiPanjangFragment)
        }
        binding.btnSegitiga.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_segitigaFragment)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}
