package com.pmm.demo.module.lib3.eventbus

import android.os.Bundle
import com.pmm.demo.R
import com.pmm.demo.base.BaseViewActivity
import com.pmm.ui.ktx.getContent
import com.pmm.ui.ktx.click
import com.pmm.ui.ktx.toast
import kotlinx.android.synthetic.main.activity_event_bus_sec.*
import org.greenrobot.eventbus.EventBus

class EventBusSecActivity : BaseViewActivity() {
    override fun getLayoutResID(): Int = R.layout.activity_event_bus_sec


    override fun afterViewAttach(savedInstanceState: Bundle?) {
        mToolbar.with(this)
                .centerTitle { this.text = "EventBusSecActivity" }
                .navigationIcon { this.click { onBackPressed() } }


        btn_send.setOnClickListener {
            val message = et_send.getContent()
            EventBus.getDefault().post(TextEvent(message))
            toast("发送成功 返回查看")
        }
    }


}