package org.d3if4068.pra_assesment.Fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import org.d3if4068.pra_assesment.R
import org.d3if4068.pra_assesment.databinding.FragmentPersegiPanjangBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    private lateinit var binding : FragmentPersegiPanjangBinding
    private var luas = 0.0
    private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_persegi_panjang,container,false)

        binding.btnHitung.setOnClickListener { check() }
        binding.btnShare.setOnClickListener { share() }


        return binding.root
    }

    private fun check(){
        if (binding.etA.text.isEmpty() && binding.etB.text.isEmpty()){
            Toast.makeText(activity,"Inputan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            persegiPanjang()
        }
    }

    private fun persegiPanjang(){
        luas = binding.etA.text.toString().toDouble() * binding.etB.text.toString().toDouble()
        binding.tvKeliling.visibility = View.VISIBLE
        keliling = 2 * (binding.etA.text.toString().toDouble() + binding.etB.text.toString().toDouble())
        binding.tvLuas.visibility = View.VISIBLE
        binding.tvLuas.text = "$luas"
        binding.tvKeliling.text = "$keliling"
    }

    private fun share(){
        val intent = Intent(Intent.ACTION_SENDTO)
        val subject = "Persegi Panjang"
        val message = """
            - Panjang     = ${binding.etA.text}
            - Lebar       = ${binding.etB.text}
            - Luas        = ${binding.tvLuas.text}
            - Keliling    = ${binding.tvKeliling.text}
        """.trimIndent()
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("luas", luas)
        outState.putDouble("keliling", keliling)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            luas = savedInstanceState.getDouble("luas")
            keliling = savedInstanceState.getDouble("keliling")
            binding.tvKeliling.text = "$keliling"
            binding.tvLuas.text = "$luas"
            binding.tvKeliling.visibility = View.VISIBLE
            binding.tvLuas.visibility = View.VISIBLE
        }
        super.onViewStateRestored(savedInstanceState)
    }
}
