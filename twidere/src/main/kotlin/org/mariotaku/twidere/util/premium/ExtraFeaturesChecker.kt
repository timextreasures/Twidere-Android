package org.mariotaku.twidere.util.premium

import android.content.Context
import android.content.Intent
import android.support.annotation.CallSuper
import java.util.*

/**
 * Created by mariotaku on 2016/12/25.
 */

abstract class ExtraFeaturesChecker {
    protected lateinit var context: Context

    @CallSuper
    protected open fun init(context: Context) {
        this.context = context
    }

    open fun release() {
    }

    abstract fun isSupported(): Boolean

    abstract fun isEnabled(): Boolean

    abstract fun createPurchaseIntent(context: Context): Intent

    abstract fun createRestorePurchaseIntent(context: Context): Intent?

    companion object {

        fun newInstance(context: Context): ExtraFeaturesChecker {
            val instance = ServiceLoader.load(ExtraFeaturesChecker::class.java).first()
            instance.init(context)
            return instance
        }

    }
}
