package org.mariotaku.twidere.util.premium

import android.content.Context
import android.content.Intent
import com.anjlab.android.iab.v3.BillingProcessor
import org.mariotaku.twidere.Constants.GOOGLE_PLAY_LICENCING_PUBKEY
import org.mariotaku.twidere.activity.GooglePlayInAppPurchaseActivity

/**
 * Created by mariotaku on 2016/12/25.
 */

class GooglePlayExtraFeaturesChecker() : ExtraFeaturesChecker() {
    private val EXTRA_FEATURE_PRODUCT_ID = "twidere.extra.features"

    private lateinit var bp: BillingProcessor

    override fun init(context: Context) {
        super.init(context)
        bp = BillingProcessor(context, GOOGLE_PLAY_LICENCING_PUBKEY, null)
    }

    override fun release() {
        bp.release()
    }

    override fun isSupported(): Boolean = true

    override fun isEnabled(): Boolean {
        val details = bp.getPurchaseTransactionDetails(EXTRA_FEATURE_PRODUCT_ID) ?: return false
        return bp.isValidTransactionDetails(details)
    }

    override fun createPurchaseIntent(context: Context): Intent {
        return Intent(context, GooglePlayInAppPurchaseActivity::class.java).apply {
            putExtra(GooglePlayInAppPurchaseActivity.EXTRA_PRODUCT_ID, EXTRA_FEATURE_PRODUCT_ID)
        }
    }

    override fun createRestorePurchaseIntent(context: Context): Intent? {
        return null
    }

}
