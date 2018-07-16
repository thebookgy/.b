package com.meet.btoy.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    private var mActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            context.let {
                this.mActivity = it
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }


    fun init() {
    }

    fun finish() {
        mActivity?.let {
            it.finish()
        }
    }

    fun hideKeyboard() {
        mActivity?.let {
            it.hideKeyboard()
        }
    }

    fun onReplaceFragment() {
        mActivity?.let {
        }
    }


}