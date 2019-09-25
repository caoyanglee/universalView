package com.weimu.app.universalview.module.fragment.viewpager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.orhanobut.logger.Logger
import com.weimu.app.universalview.R
import com.weimu.app.universalview.base.BaseViewActivity
import com.pmm.ui.core.pager.BaseFragmentPagerAdapter
import com.pmm.ui.interfaces.MyViewPagerChangeListener
import com.pmm.ui.ktx.click
import com.pmm.ui.ktx.toast
import com.pmm.ui.widget.TabView
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : BaseViewActivity() {

    override fun getLayoutResID(): Int = R.layout.activity_view_pager

    companion object {
        fun newIntent(context: Context) = Intent(context, ViewPagerActivity::class.java)
    }

    override fun afterViewAttach(savedInstanceState: Bundle?) {
        mToolbar.with(this)
                .centerTitle {
                    this.text = "ViewPager"
                }.navigationIcon {
                    this.click { onBackPressed() }
                }

        viewpager.adapter = BaseFragmentPagerAdapter(supportFragmentManager).apply {
            val fragments = arrayListOf<Fragment>()
            fragments.add(Section1Fragment.newInstance(this@ViewPagerActivity))
            fragments.add(Section2Fragment.newInstance(this@ViewPagerActivity))
            fragments.add(Section3Fragment.newInstance(this@ViewPagerActivity))
            setFragments(fragments)
        }
        viewpager.offscreenPageLimit = 3
        viewpager.addOnPageChangeListener(object : MyViewPagerChangeListener() {
            override fun onPageSelected(position: Int) {
                mTabView.position = position
            }

        })

        mTabView.setData(
                TabView.TabData("1"),
                TabView.TabData("2"),
                TabView.TabData("3"))
        mTabView.onTabClick = {
            viewpager.currentItem = it
        }
        mTabView.onTabReClick = {
            toast("点到第${it}Fragment")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Logger.d("""
            ViewPagerActivity
            requestCode = $requestCode
            resultCode = $resultCode
            data = $data
        """.trimIndent())
    }
}
