package com.pedroabinajm.hamburgers.view.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.pedroabinajm.hamburgers.view.anko.ActivityAnkoComponent
import com.pedroabinajm.hamburgers.view.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragmentActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>>
    : BaseActivity<UI>(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}