package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.di.component.DaggerFaceToFaceComponent
import com.wy.adbook.di.module.FaceToFaceModule
import com.wy.adbook.ext.loadImage
import com.wy.adbook.mvp.contranct.FaceToFaceContract
import com.wy.adbook.mvp.presenter.FaceToFacePresenter
import kotlinx.android.synthetic.main.activity_face_to_face.*

/**
 * Created by leafye on 2019-05-29.
 */
class FaceToFaceActivity : QYBaseActivity<FaceToFacePresenter>(), FaceToFaceContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, FaceToFaceActivity::class.java))
        }
    }

    override fun getToolbar(): View? = title_bar_view

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerFaceToFaceComponent.builder()
            .appComponent(appComponent)
            .faceToFaceModule(FaceToFaceModule((this@FaceToFaceActivity)))
            .build()
            .inject(this@FaceToFaceActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_face_to_face

    override fun initData(savedInstanceState: Bundle?) {
        val inviteCode = QYAccount.getInviteCode()
        val inviteQrCode = QYAccount.getInviteQrCode()
        center_qr_code_iv.loadImage(inviteQrCode)
        val builder = SpanUtils()
            .append(ResUtils.getString(R.string.open_wx_to_scan_qr_code_from_pic_1))
            .append(ResUtils.getString(R.string.open_wx_to_scan_qr_code_from_pic_2))
            .setForegroundColor(ResUtils.getColor(R.color.color_ffed76))
            .append(ResUtils.getString(R.string.open_wx_to_scan_qr_code_from_pic_3))
            .append(ResUtils.getString(R.string.open_wx_to_scan_qr_code_from_pic_4))
            .setForegroundColor(ResUtils.getColor(R.color.color_ffed76))
            .append(ResUtils.getString(R.string.open_wx_to_scan_qr_code_from_pic_5))
            .create()
        top_tip_tv.text = builder
        red_code_tv.text = inviteCode
    }
}