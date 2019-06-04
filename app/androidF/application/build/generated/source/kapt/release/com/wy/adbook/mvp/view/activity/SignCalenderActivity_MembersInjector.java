package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.SignCalenderPresenter;
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter;
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderActivity_MembersInjector
    implements MembersInjector<SignCalenderActivity> {
  private final Provider<SignCalenderPresenter> mPresenterProvider;

  private final Provider<LinearLayoutManager> mLayoutManager1Provider;

  private final Provider<FullyGridLayoutManager> mLayoutManager2Provider;

  private final Provider<SignCalendarAdapter> mSignCalendarAdapterProvider;

  private final Provider<ContinuousSignInAdapter> mContinuousSignInAdapterProvider;

  public SignCalenderActivity_MembersInjector(
      Provider<SignCalenderPresenter> mPresenterProvider,
      Provider<LinearLayoutManager> mLayoutManager1Provider,
      Provider<FullyGridLayoutManager> mLayoutManager2Provider,
      Provider<SignCalendarAdapter> mSignCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> mContinuousSignInAdapterProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.mLayoutManager1Provider = mLayoutManager1Provider;
    this.mLayoutManager2Provider = mLayoutManager2Provider;
    this.mSignCalendarAdapterProvider = mSignCalendarAdapterProvider;
    this.mContinuousSignInAdapterProvider = mContinuousSignInAdapterProvider;
  }

  public static MembersInjector<SignCalenderActivity> create(
      Provider<SignCalenderPresenter> mPresenterProvider,
      Provider<LinearLayoutManager> mLayoutManager1Provider,
      Provider<FullyGridLayoutManager> mLayoutManager2Provider,
      Provider<SignCalendarAdapter> mSignCalendarAdapterProvider,
      Provider<ContinuousSignInAdapter> mContinuousSignInAdapterProvider) {
    return new SignCalenderActivity_MembersInjector(
        mPresenterProvider,
        mLayoutManager1Provider,
        mLayoutManager2Provider,
        mSignCalendarAdapterProvider,
        mContinuousSignInAdapterProvider);
  }

  @Override
  public void injectMembers(SignCalenderActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectMLayoutManager1(instance, mLayoutManager1Provider.get());
    injectMLayoutManager2(instance, mLayoutManager2Provider.get());
    injectMSignCalendarAdapter(instance, mSignCalendarAdapterProvider.get());
    injectMContinuousSignInAdapter(instance, mContinuousSignInAdapterProvider.get());
  }

  public static void injectMLayoutManager1(
      SignCalenderActivity instance, LinearLayoutManager mLayoutManager1) {
    instance.mLayoutManager1 = mLayoutManager1;
  }

  public static void injectMLayoutManager2(
      SignCalenderActivity instance, FullyGridLayoutManager mLayoutManager2) {
    instance.mLayoutManager2 = mLayoutManager2;
  }

  public static void injectMSignCalendarAdapter(
      SignCalenderActivity instance, SignCalendarAdapter mSignCalendarAdapter) {
    instance.mSignCalendarAdapter = mSignCalendarAdapter;
  }

  public static void injectMContinuousSignInAdapter(
      SignCalenderActivity instance, ContinuousSignInAdapter mContinuousSignInAdapter) {
    instance.mContinuousSignInAdapter = mContinuousSignInAdapter;
  }
}
