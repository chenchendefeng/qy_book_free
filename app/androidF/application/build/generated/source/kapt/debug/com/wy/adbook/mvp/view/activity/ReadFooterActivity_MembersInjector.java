package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import com.wy.adbook.mvp.presenter.ReadFooterPresenter;
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterActivity_MembersInjector
    implements MembersInjector<ReadFooterActivity> {
  private final Provider<ReadFooterPresenter> mPresenterProvider;

  private final Provider<ReadFooterAdapter> readFooterAdapterProvider;

  private final Provider<List<ReadFooterItem>> listProvider;

  private final Provider<LinearLayoutManager> linearLayoutManagerProvider;

  public ReadFooterActivity_MembersInjector(
      Provider<ReadFooterPresenter> mPresenterProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider,
      Provider<List<ReadFooterItem>> listProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.readFooterAdapterProvider = readFooterAdapterProvider;
    this.listProvider = listProvider;
    this.linearLayoutManagerProvider = linearLayoutManagerProvider;
  }

  public static MembersInjector<ReadFooterActivity> create(
      Provider<ReadFooterPresenter> mPresenterProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider,
      Provider<List<ReadFooterItem>> listProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    return new ReadFooterActivity_MembersInjector(
        mPresenterProvider, readFooterAdapterProvider, listProvider, linearLayoutManagerProvider);
  }

  @Override
  public void injectMembers(ReadFooterActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectReadFooterAdapter(instance, readFooterAdapterProvider.get());
    injectList(instance, listProvider.get());
    injectLinearLayoutManager(instance, linearLayoutManagerProvider.get());
  }

  public static void injectReadFooterAdapter(
      ReadFooterActivity instance, ReadFooterAdapter readFooterAdapter) {
    instance.readFooterAdapter = readFooterAdapter;
  }

  public static void injectList(ReadFooterActivity instance, List<ReadFooterItem> list) {
    instance.list = list;
  }

  public static void injectLinearLayoutManager(
      ReadFooterActivity instance, LinearLayoutManager linearLayoutManager) {
    instance.linearLayoutManager = linearLayoutManager;
  }
}
