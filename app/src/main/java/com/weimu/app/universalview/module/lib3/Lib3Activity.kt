package com.weimu.app.universalview.module.lib3

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.weimu.app.universalview.R
import com.weimu.app.universalview.base.BaseViewActivity
import com.weimu.app.universalview.module.lib3.eventbus.EventBusActivity
import com.weimu.app.universalview.module.lib3.materialdialog.MaterialDialogActivity
import com.weimu.app.universalview.module.main.CategoryB
import com.weimu.app.universalview.module.main.CategoryListAdapter
import com.weimu.universalview.core.recyclerview.decoration.LinearItemDecoration
import com.weimu.universalview.ktx.dip2px
import com.weimu.universalview.ktx.init
import kotlinx.android.synthetic.main.activity_lib3.*
import kotlinx.android.synthetic.main.include_recyclerview.*

class Lib3Activity : BaseViewActivity() {

    private val category = arrayListOf<CategoryB>()
    private val adapter: CategoryListAdapter by lazy { CategoryListAdapter(getContext()) }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, Lib3Activity::class.java)
        }
    }

    override fun getLayoutResID() = R.layout.activity_lib3


    override fun afterViewAttach(savedInstanceState: Bundle?) {
        mToolbar.with(this)
                .navigationIcon {
                    setImageResource(R.drawable.universal_arrow_back_white)
                }
                .centerTitle {
                    text = "实用第三方库"
                    setTextColor(Color.WHITE)
                }
        initRecy()
    }


    fun initRecy() {
        adapter.onItemClick = { item, position ->
            when (position) {
                0 -> {
                    //MaterialDialog
                    startActivity(MaterialDialogActivity.newIntent(getContext()))
                }
                1 -> {
                    //EventBus
                    startActivity(EventBusActivity.newIntent(getContext()))

                }
            }
        }
        recyclerView.init()
        recyclerView.addItemDecoration(LinearItemDecoration(
                context = this,
                dividerSize = dip2px(16f)
        ))
        recyclerView.adapter = adapter



        category.add(CategoryB("MaterialDialog", "MD,Dialog"))
        category.add(CategoryB("EventBus", "事件总线，事件分发"))

        adapter.setDataToAdapter(category)
    }
}
