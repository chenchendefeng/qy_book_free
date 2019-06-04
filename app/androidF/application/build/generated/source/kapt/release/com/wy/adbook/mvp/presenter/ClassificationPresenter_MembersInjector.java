package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.model.entity.Classification;
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter;
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationPresenter_MembersInjector
    implements MembersInjector<ClassificationPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  private final Provider<ClassificationAdapter> classificationAdapterProvider;

  private final Provider<ClassificationContentAdapter> classificationContentAdapterProvider;

  private final Provider<List<Classification>> classificationListProvider;

  public ClassificationPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.bannerListProvider = bannerListProvider;
    this.classificationAdapterProvider = classificationAdapterProvider;
    this.classificationContentAdapterProvider = classificationContentAdapterProvider;
    this.classificationListProvider = classificationListProvider;
  }

  public static MembersInjector<ClassificationPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider) {
    return new ClassificationPresenter_MembersInjector(
        mErrorHandlerProvider,
        bannerListProvider,
        classificationAdapterProvider,
        classificationContentAdapterProvider,
        classificationListProvider);
  }

  @Override
  public void injectMembers(ClassificationPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectBannerList(instance, bannerListProvider.get());
    injectClassificationAdapter(instance, classificationAdapterProvider.get());
    injectClassificationContentAdapter(instance, classificationContentAdapterProvider.get());
    injectClassificationList(instance, classificationListProvider.get());
  }

  public static void injectBannerList(
      ClassificationPresenter instance, List<BannerItem> bannerList) {
    instance.bannerList = bannerList;
  }

  public static void injectClassificationAdapter(
      ClassificationPresenter instance, ClassificationAdapter classificationAdapter) {
    instance.classificationAdapter = classificationAdapter;
  }

  public static void injectClassificationContentAdapter(
      ClassificationPresenter instance, ClassificationContentAdapter classificationContentAdapter) {
    instance.classificationContentAdapter = classificationContentAdapter;
  }

  public static void injectClassificationList(
      ClassificationPresenter instance, List<Classification> classificationList) {
    instance.classificationList = classificationList;
  }
}
