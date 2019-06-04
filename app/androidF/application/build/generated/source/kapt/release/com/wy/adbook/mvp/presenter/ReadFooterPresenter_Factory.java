package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.ReadFooterContract;
import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterPresenter_Factory implements Factory<ReadFooterPresenter> {
  private final Provider<ReadFooterContract.Model> modelProvider;

  private final Provider<ReadFooterContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<ReadFooterItem>> readFooterItemListProvider;

  private final Provider<ReadFooterAdapter> readFooterAdapterProvider;

  public ReadFooterPresenter_Factory(
      Provider<ReadFooterContract.Model> modelProvider,
      Provider<ReadFooterContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<ReadFooterItem>> readFooterItemListProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.readFooterItemListProvider = readFooterItemListProvider;
    this.readFooterAdapterProvider = readFooterAdapterProvider;
  }

  @Override
  public ReadFooterPresenter get() {
    ReadFooterPresenter instance = new ReadFooterPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    ReadFooterPresenter_MembersInjector.injectReadFooterItemList(
        instance, readFooterItemListProvider.get());
    ReadFooterPresenter_MembersInjector.injectReadFooterAdapter(
        instance, readFooterAdapterProvider.get());
    return instance;
  }

  public static ReadFooterPresenter_Factory create(
      Provider<ReadFooterContract.Model> modelProvider,
      Provider<ReadFooterContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<ReadFooterItem>> readFooterItemListProvider,
      Provider<ReadFooterAdapter> readFooterAdapterProvider) {
    return new ReadFooterPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        readFooterItemListProvider,
        readFooterAdapterProvider);
  }

  public static ReadFooterPresenter newReadFooterPresenter(
      ReadFooterContract.Model model, ReadFooterContract.View view) {
    return new ReadFooterPresenter(model, view);
  }
}
