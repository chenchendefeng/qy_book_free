package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.view.adapter.MyAdapter;
import com.wy.adbook.mvp.view.adapter.MyItem;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyPresenter_MembersInjector implements MembersInjector<MyPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<MyAdapter> myAdapterProvider;

  private final Provider<List<MyItem>> myItemListProvider;

  public MyPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<List<MyItem>> myItemListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.myAdapterProvider = myAdapterProvider;
    this.myItemListProvider = myItemListProvider;
  }

  public static MembersInjector<MyPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<List<MyItem>> myItemListProvider) {
    return new MyPresenter_MembersInjector(
        mErrorHandlerProvider, myAdapterProvider, myItemListProvider);
  }

  @Override
  public void injectMembers(MyPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectMyAdapter(instance, myAdapterProvider.get());
    injectMyItemList(instance, myItemListProvider.get());
  }

  public static void injectMyAdapter(MyPresenter instance, MyAdapter myAdapter) {
    instance.myAdapter = myAdapter;
  }

  public static void injectMyItemList(MyPresenter instance, List<MyItem> myItemList) {
    instance.myItemList = myItemList;
  }
}
