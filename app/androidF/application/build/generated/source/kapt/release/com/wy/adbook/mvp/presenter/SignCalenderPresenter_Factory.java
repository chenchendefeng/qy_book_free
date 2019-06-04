package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.SignCalenderContract;
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem;
import com.wy.adbook.mvp.model.entity.accout.RewardItem;
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter;
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderPresenter_Factory implements Factory<SignCalenderPresenter> {
  private final Provider<SignCalenderContract.Model> modelProvider;

  private final Provider<SignCalenderContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<SignCalendarAdapter> signCalendarAdapterProvider;

  private final Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider;

  private final Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider;

  private final Provider<List<RewardItem>> rewardListProvider;

  public SignCalenderPresenter_Factory(
      Provider<SignCalenderContract.Model> modelProvider,
      Provider<SignCalenderContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<SignCalendarAdapter> signCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider,
      Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider,
      Provider<List<RewardItem>> rewardListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.signCalendarAdapterProvider = signCalendarAdapterProvider;
    this.continuousSignInAdapterProvider = continuousSignInAdapterProvider;
    this.attendanceCalendarListProvider = attendanceCalendarListProvider;
    this.rewardListProvider = rewardListProvider;
  }

  @Override
  public SignCalenderPresenter get() {
    SignCalenderPresenter instance =
        new SignCalenderPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    SignCalenderPresenter_MembersInjector.injectSignCalendarAdapter(
        instance, signCalendarAdapterProvider.get());
    SignCalenderPresenter_MembersInjector.injectContinuousSignInAdapter(
        instance, continuousSignInAdapterProvider.get());
    SignCalenderPresenter_MembersInjector.injectAttendanceCalendarList(
        instance, attendanceCalendarListProvider.get());
    SignCalenderPresenter_MembersInjector.injectRewardList(instance, rewardListProvider.get());
    return instance;
  }

  public static SignCalenderPresenter_Factory create(
      Provider<SignCalenderContract.Model> modelProvider,
      Provider<SignCalenderContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<SignCalendarAdapter> signCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider,
      Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider,
      Provider<List<RewardItem>> rewardListProvider) {
    return new SignCalenderPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        signCalendarAdapterProvider,
        continuousSignInAdapterProvider,
        attendanceCalendarListProvider,
        rewardListProvider);
  }

  public static SignCalenderPresenter newSignCalenderPresenter(
      SignCalenderContract.Model model, SignCalenderContract.View view) {
    return new SignCalenderPresenter(model, view);
  }
}
