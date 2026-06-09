package com.blas.creditappdemo.ui.form.view
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.blas.creditappdemo.R


class Step2Fragment : Fragment(R.layout.fragment_step2) {

    private var ktpVerified = false
    private var slipGajiVerified = false
    private var npwpVerified = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iconKtp = view.findViewById<TextView>(R.id.iconKtp)
        val iconBgKtp = view.findViewById<FrameLayout>(R.id.iconBgKtp)
        val badgeKtp = view.findViewById<TextView>(R.id.badgeKtp)
        val btnPeriksaKtp = view.findViewById<Button>(R.id.btnPeriksaKtp)

        val iconSlipGaji = view.findViewById<TextView>(R.id.iconSlipGaji)
        val iconBgSlipGaji = view.findViewById<FrameLayout>(R.id.iconBgSlipGaji)
        val badgeSlipGaji = view.findViewById<TextView>(R.id.badgeSlipGaji)
        val btnPeriksaSlipGaji = view.findViewById<Button>(R.id.btnPeriksaSlipGaji)

        val iconNpwp = view.findViewById<TextView>(R.id.iconNpwp)
        val iconBgNpwp = view.findViewById<FrameLayout>(R.id.iconBgNpwp)
        val badgeNpwp = view.findViewById<TextView>(R.id.badgeNpwp)
        val btnPeriksaNpwp = view.findViewById<Button>(R.id.btnPeriksaNpwp)

        val btnLanjutScoring = view.findViewById<Button>(R.id.btnLanjutScoring)
        val btnKembali = view.findViewById<Button>(R.id.btnKembali)

        btnPeriksaKtp.setOnClickListener {
            ktpVerified = true
            setVerified(iconKtp, iconBgKtp, badgeKtp, btnPeriksaKtp)
            checkAllVerified(btnLanjutScoring)
        }

        btnPeriksaSlipGaji.setOnClickListener {
            slipGajiVerified = true
            setVerified(iconSlipGaji, iconBgSlipGaji, badgeSlipGaji, btnPeriksaSlipGaji)
            checkAllVerified(btnLanjutScoring)
        }

        btnPeriksaNpwp.setOnClickListener {
            npwpVerified = true
            setVerified(iconNpwp, iconBgNpwp, badgeNpwp, btnPeriksaNpwp)
            checkAllVerified(btnLanjutScoring)
        }

        btnKembali.setOnClickListener {
            findNavController().popBackStack()
        }

        btnLanjutScoring.setOnClickListener {
            findNavController().navigate(R.id.action_step2_to_step3)
        }
    }

    private fun setVerified(
        icon: TextView,
        iconBg: FrameLayout,
        badge: TextView,
        btnPeriksa: Button
    ) {
        icon.text = "✓"
        icon.setTextColor(0xFF16A34A.toInt())
        iconBg.setBackgroundColor(0xFFDCFCE7.toInt())
        badge.text = "Terverifikasi"
        badge.setTextColor(0xFF16A34A.toInt())
        badge.setBackgroundColor(0xFFDCFCE7.toInt())
        btnPeriksa.visibility = View.GONE
    }

    private fun checkAllVerified(btnLanjut: Button) {
        if (ktpVerified && slipGajiVerified && npwpVerified) {
            btnLanjut.isEnabled = true
            btnLanjut.backgroundTintList =
                android.content.res.ColorStateList.valueOf(0xFF5B6CF9.toInt())
        }
    }
}