package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterPresenter_MembersInjector
    implements MembersInjector<ReadFooterPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<ReadFooterItem>> readFooterItemListProvider;

  private final Provider<ReadFooterAdapter> readFooterAdapterProvider;

  public ReadFooterPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<ReadFooterItem>> readFooterItemListProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.readFooterItemListProvider = readFooterItemListProvider;
    this.readFooterAdapterProvider = readFooterAdapterProvider;
  }

  public static MembersInjector<ReadFooterPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<ReadFooterItem>> readFooterItemListProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider) {
    return new ReadFooterPresenter_MembersInjector(
        mErrorHandlerProvider, readFooterItemListProvider, readFooterAdapterProvider);
  }

  @Override
  public void injectMembers(ReadFooterPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectReadFooterItemList(instance, readFooterItemListProvider.get());
    injectReadFooterAdapter(instance, readFooterAdapterProvider.get());
  }

  public static void injectReadFooterItemList(
      ReadFooterPresenter instance, List<ReadFooterItem> readFooterItemList) {
    instance.readFooterItemList = readFooterItemList;
  }

  public static void injectReadFooterAdapter(
      ReadFooterPresenter instance, ReadFooterAdapter readFooterAdapter) {
    instance.readFooterAdapter = readFooterAdapter;
  }
}
