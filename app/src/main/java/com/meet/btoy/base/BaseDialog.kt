package com.meet.btoy.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.ViewGroup
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentManager


abstract class BaseDialog : DialogFragment() {

    val TAG = "dialog"
    private var mActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            context.let {
                this.mActivity = it
            }
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        // creating the fullscreen dialog
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        dialog.window?.let {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    fun showDialog(fragmentManager: FragmentManager) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(TAG)
        prevFragment?.let {
            transaction.remove(it)

        }
        transaction.addToBackStack(null)
        show(transaction, TAG)
    }


    fun hideKeyboard() {
        mActivity?.let {
            it.hideKeyboard()
        }
    }


}