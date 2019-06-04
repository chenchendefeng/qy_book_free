package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.net
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.mvp.contranct.MyFriendContract
import com.wy.adbook.mvp.model.entity.FriendItem
import com.wy.adbook.mvp.model.entity.FriendPage
import com.wy.adbook.mvp.model.entity.NetFriendPage
import com.wy.adbook.mvp.view.activity.FaceToFaceActivity
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter
import com.wy.adbook.view.status.IStatusCoverView
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class MyFriendPresenter
@Inject
constructor(model: MyFriendContract.Model, view: MyFriendContract.View) :
    QYBasePresenter<MyFriendContract.Model, MyFriendContract.View>(model, view) {

    @Inject
    lateinit var friendAdapter: MyFriendAdapter
    @Inject
    lateinit var friendList: MutableList<FriendItem>

    private var friendPage: FriendPage? = null

    fun fetchData() {
        mRootView.changeStatus(IStatusCoverView.Status.LOADING)
        mRootView.setRefresh(true)
        mModel.friendPage(QYAccount.uid(), 1, 10)
            .net(mRootView)
            .doFinally {
                mRootView.setRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<NetFriendPage>(mErrorHandler) {
                override fun onNext(t: NetFriendPage) {
                    if (t.isOk()) {
                        friendPage = t.data
                        friendList.clear()
                        t.data?.friendList?.let {
                            friendList.addAll(it)
                        }
                        friendAdapter.setNewData(friendList)
                        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
                    } else {
                        mRootView.getContext().toast(t.msg)
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    fun loadMore() {
        mModel.friendPage(QYAccount.uid(), (friendPage?.pageNo ?: 1) + 1, 10)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetFriendPage>(mErrorHandler) {
                override fun onNext(t: NetFriendPage) {
                    if (t.isOk()) {
                        friendPage = t.data
                        t.data?.friendList?.let {
                            friendAdapter.addData(it)
                        }
                        if (friendPage?.pageNo ?: 0 >= friendPage?.pageSize ?: 0) {
                            friendAdapter.loadMoreEnd()
                        } else {
                            friendAdapter.loadMoreComplete()
                        }
                    } else {
                        friendAdapter.loadMoreFail()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    friendAdapter.loadMoreFail()
                }
            })
    }

    //进入聊天界面
    fun enterIm(friend: FriendItem) {

    }

    fun toInviteFriend(shareDialog: ShareDialog, shareType: Int) {
        shareDialog.dismiss()
        when (shareType) {
            Constant.ShareType.SHARE_TYPE_WX_HY -> {

            }
            Constant.ShareType.SHARE_TYPE_WX_PYQ -> {

            }
            Constant.ShareType.SHARE_TYPE_QQ -> {

            }
            Constant.ShareType.SHARE_TYPE_QQ_ZONE -> {

            }
            Constant.ShareType.SHARE_TYPE_FACE_TO_FACE -> {
                FaceToFaceActivity.startActivity(mRootView.getContext())
            }
        }
    }


}