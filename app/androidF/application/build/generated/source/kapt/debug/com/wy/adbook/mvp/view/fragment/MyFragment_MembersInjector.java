package com.wy.adbook.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.MyPresenter;
import com.wy.adbook.mvp.view.adapter.MyAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFragment_MembersInjector implements MembersInjector<MyFragment> {
  private final Provider<MyPresenter> mPresenterProvider;

  private final Provider<MyAdapter> myAdapterProvider;

  private final Provider<LinearLayoutManager> linearLayoutManagerProvider;

  public MyFragment_MembersInjector(
      Provider<MyPresenter> mPresenterProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.myAdapterProvider = myAdapterProvider;
    this.linearLayoutManagerProvider = linearLayoutManagerProvider;
  }

  public static MembersInjector<MyFragment> create(
      Provider<MyPresenter> mPresenterProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    return new MyFragment_MembersInjector(
        mPresenterProvider, myAdapterProvider, linearLayoutManagerProvider);
  }

  @Override
  public void injectMembers(MyFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectMyAdapter(instance, myAdapterProvider.get());
    injectLinearLayoutManager(instance, linearLayoutManagerProvider.get());
  }

  public static void injectMyAdapter(MyFragment instance, MyAdapter myAdapter) {
    instance.myAdapter = myAdapter;
  }

  public static void injectLinearLayoutManager(
      MyFragment instance, LinearLayoutManager linearLayoutManager) {
    instance.linearLayoutManager = linearLayoutManager;
  }
}
