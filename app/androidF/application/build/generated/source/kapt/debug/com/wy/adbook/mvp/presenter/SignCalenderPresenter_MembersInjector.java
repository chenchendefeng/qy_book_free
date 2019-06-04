package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem;
import com.wy.adbook.mvp.model.entity.accout.RewardItem;
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter;
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderPresenter_MembersInjector
    implements MembersInjector<SignCalenderPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<SignCalendarAdapter> signCalendarAdapterProvider;

  private final Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider;

  private final Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider;

  private final Provider<List<RewardItem>> rewardListProvider;

  public SignCalenderPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<SignCalendarAdapter> signCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider,
      Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider,
      Provider<List<RewardItem>> rewardListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.signCalendarAdapterProvider = signCalendarAdapterProvider;
    this.continuousSignInAdapterProvider = continuousSignInAdapterProvider;
    this.attendanceCalendarListProvider = attendanceCalendarListProvider;
    this.rewardListProvider = rewardListProvider;
  }

  public static MembersInjector<SignCalenderPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<SignCalendarAdapter> signCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider,
      Provider<List<AttendanceCalendarItem>> attendanceCalendarListProvider,
      Provider<List<RewardItem>> rewardListProvider) {
    return new SignCalenderPresenter_MembersInjector(
        mErrorHandlerProvider,
        signCalendarAdapterProvider,
        continuousSignInAdapterProvider,
        attendanceCalendarListProvider,
        rewardListProvider);
  }

  @Override
  public void injectMembers(SignCalenderPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectSignCalendarAdapter(instance, signCalendarAdapterProvider.get());
    injectContinuousSignInAdapter(instance, continuousSignInAdapterProvider.get());
    injectAttendanceCalendarList(instance, attendanceCalendarListProvider.get());
    injectRewardList(instance, rewardListProvider.get());
  }

  public static void injectSignCalendarAdapter(
      SignCalenderPresenter instance, SignCalendarAdapter signCalendarAdapter) {
    instance.signCalendarAdapter = signCalendarAdapter;
  }

  public static void injectContinuousSignInAdapter(
      SignCalenderPresenter instance, ContinuousSignInAdapter continuousSignInAdapter) {
    instance.continuousSignInAdapter = continuousSignInAdapter;
  }

  public static void injectAttendanceCalendarList(
      SignCalenderPresenter instance, List<AttendanceCalendarItem> attendanceCalendarList) {
    instance.attendanceCalendarList = attendanceCalendarList;
  }

  public static void injectRewardList(SignCalenderPresenter instance, List<RewardItem> rewardList) {
    instance.rewardList = rewardList;
  }
}
