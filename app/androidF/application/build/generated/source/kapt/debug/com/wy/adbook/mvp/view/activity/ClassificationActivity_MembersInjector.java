package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.model.entity.Classification;
import com.wy.adbook.mvp.presenter.ClassificationPresenter;
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter;
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationActivity_MembersInjector
    implements MembersInjector<ClassificationActivity> {
  private final Provider<ClassificationPresenter> mPresenterProvider;

  private final Provider<ClassificationContentAdapter> classificationContentAdapterProvider;

  private final Provider<List<Classification>> classificationListProvider;

  private final Provider<ClassificationAdapter> classificationAdapterProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  private final Provider<LinearLayoutManager> linearLayoutManager1AndLinearLayoutManager2Provider;

  private final Provider<View> headerViewProvider;

  public ClassificationActivity_MembersInjector(
      Provider<ClassificationPresenter> mPresenterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<LinearLayoutManager> linearLayoutManager1AndLinearLayoutManager2Provider,
      Provider<View> headerViewProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.classificationContentAdapterProvider = classificationContentAdapterProvider;
    this.classificationListProvider = classificationListProvider;
    this.classificationAdapterProvider = classificationAdapterProvider;
    this.bannerListProvider = bannerListProvider;
    this.linearLayoutManager1AndLinearLayoutManager2Provider =
        linearLayoutManager1AndLinearLayoutManager2Provider;
    this.headerViewProvider = headerViewProvider;
  }

  public static MembersInjector<ClassificationActivity> create(
      Provider<ClassificationPresenter> mPresenterProvider,
      Provider<ClassificationContentAdapter> classificationContentAdapterProvider,
      Provider<List<Classification>> classificationListProvider,
      Provider<ClassificationAdapter> classificationAdapterProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<LinearLayoutManager> linearLayoutManager1AndLinearLayoutManager2Provider,
      Provider<View> headerViewProvider) {
    return new ClassificationActivity_MembersInjector(
        mPresenterProvider,
        classificationContentAdapterProvider,
        classificationListProvider,
        classificationAdapterProvider,
        bannerListProvider,
        linearLayoutManager1AndLinearLayoutManager2Provider,
        headerViewProvider);
  }

  @Override
  public void injectMembers(ClassificationActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectClassificationContentAdapter(instance, classificationContentAdapterProvider.get());
    injectClassificationList(instance, classificationListProvider.get());
    injectClassificationAdapter(instance, classificationAdapterProvider.get());
    injectBannerList(instance, bannerListProvider.get());
    injectLinearLayoutManager1(instance, linearLayoutManager1AndLinearLayoutManager2Provider.get());
    injectLinearLayoutManager2(instance, linearLayoutManager1AndLinearLayoutManager2Provider.get());
    injectHeaderView(instance, headerViewProvider.get());
  }

  public static void injectClassificationContentAdapter(
      ClassificationActivity instance, ClassificationContentAdapter classificationContentAdapter) {
    instance.classificationContentAdapter = classificationContentAdapter;
  }

  public static void injectClassificationList(
      ClassificationActivity instance, List<Classification> classificationList) {
    instance.classificationList = classificationList;
  }

  public static void injectClassificationAdapter(
      ClassificationActivity instance, ClassificationAdapter classificationAdapter) {
    instance.classificationAdapter = classificationAdapter;
  }

  public static void injectBannerList(
      ClassificationActivity instance, List<BannerItem> bannerList) {
    instance.bannerList = bannerList;
  }

  public static void injectLinearLayoutManager1(
      ClassificationActivity instance, LinearLayoutManager linearLayoutManager1) {
    instance.linearLayoutManager1 = linearLayoutManager1;
  }

  public static void injectLinearLayoutManager2(
      ClassificationActivity instance, LinearLayoutManager linearLayoutManager2) {
    instance.linearLayoutManager2 = linearLayoutManager2;
  }

  public static void injectHeaderView(ClassificationActivity instance, View headerView) {
    instance.headerView = headerView;
  }
}
