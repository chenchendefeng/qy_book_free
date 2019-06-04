package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.MyContract;
import com.wy.adbook.mvp.view.adapter.MyAdapter;
import com.wy.adbook.mvp.view.adapter.MyItem;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyPresenter_Factory implements Factory<MyPresenter> {
  private final Provider<MyContract.Model> modelProvider;

  private final Provider<MyContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<MyAdapter> myAdapterProvider;

  private final Provider<List<MyItem>> myItemListProvider;

  public MyPresenter_Factory(
      Provider<MyContract.Model> modelProvider,
      Provider<MyContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<List<MyItem>> myItemListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.myAdapterProvider = myAdapterProvider;
    this.myItemListProvider = myItemListProvider;
  }

  @Override
  public MyPresenter get() {
    MyPresenter instance = new MyPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    MyPresenter_MembersInjector.injectMyAdapter(instance, myAdapterProvider.get());
    MyPresenter_MembersInjector.injectMyItemList(instance, myItemListProvider.get());
    return instance;
  }

  public static MyPresenter_Factory create(
      Provider<MyContract.Model> modelProvider,
      Provider<MyContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyAdapter> myAdapterProvider,
      Provider<List<MyItem>> myItemListProvider) {
    return new MyPresenter_Factory(
        modelProvider, viewProvider, mErrorHandlerProvider, myAdapterProvider, myItemListProvider);
  }

  public static MyPresenter newMyPresenter(MyContract.Model model, MyContract.View view) {
    return new MyPresenter(model, view);
  }
}
