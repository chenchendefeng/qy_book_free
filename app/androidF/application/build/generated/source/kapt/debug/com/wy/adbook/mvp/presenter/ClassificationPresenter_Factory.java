package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.ClassificationContract;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.model.entity.Classification;
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter;
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationPresenter_Factory implements Factory<ClassificationPresenter> {
  private final Provider<ClassificationContract.Model> modelProvider;

  private final Provider<ClassificationContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  private final Provider<ClassificationAdapter> classificationAdapterProvider;

  private final Provider<ClassificationContentAdapter> classificationContentAdapterProvider;

  private final Provider<List<Classification>> classificationListProvider;

  public ClassificationPresenter_Factory(
      Provider<ClassificationContract.Model> modelProvider,
      Provider<ClassificationContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.bannerListProvider = bannerListProvider;
    this.classificationAdapterProvider = classificationAdapterProvider;
    this.classificationContentAdapterProvider = classificationContentAdapterProvider;
    this.classificationListProvider = classificationListProvider;
  }

  @Override
  public ClassificationPresenter get() {
    ClassificationPresenter instance =
        new ClassificationPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    ClassificationPresenter_MembersInjector.injectBannerList(instance, bannerListProvider.get());
    ClassificationPresenter_MembersInjector.injectClassificationAdapter(
        instance, classificationAdapterProvider.get());
    ClassificationPresenter_MembersInjector.injectClassificationContentAdapter(
        instance, classificationContentAdapterProvider.get());
    ClassificationPresenter_MembersInjector.injectClassificationList(
        instance, classificationListProvider.get());
    return instance;
  }

  public static ClassificationPresenter_Factory create(
      Provider<ClassificationContract.Model> modelProvider,
      Provider<ClassificationContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider) {
    return new ClassificationPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        bannerListProvider,
        classificationAdapterProvider,
        classificationContentAdapterProvider,
        classificationListProvider);
  }

  public static ClassificationPresenter newClassificationPresenter(
      ClassificationContract.Model model, ClassificationContract.View view) {
    return new ClassificationPresenter(model, view);
  }
}
