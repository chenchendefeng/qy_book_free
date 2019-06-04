package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.view.adapter.ProjectAdapter;
import com.wy.adbook.mvp.view.adapter.ProjectItem;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectPresenter_MembersInjector implements MembersInjector<ProjectPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  private final Provider<ProjectAdapter> projectAdapterProvider;

  private final Provider<List<ProjectItem>> mProjectListProvider;

  public ProjectPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<List<ProjectItem>> mProjectListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.bannerListProvider = bannerListProvider;
    this.projectAdapterProvider = projectAdapterProvider;
    this.mProjectListProvider = mProjectListProvider;
  }

  public static MembersInjector<ProjectPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<List<ProjectItem>> mProjectListProvider) {
    return new ProjectPresenter_MembersInjector(
        mErrorHandlerProvider, bannerListProvider, projectAdapterProvider, mProjectListProvider);
  }

  @Override
  public void injectMembers(ProjectPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectBannerList(instance, bannerListProvider.get());
    injectProjectAdapter(instance, projectAdapterProvider.get());
    injectMProjectList(instance, mProjectListProvider.get());
  }

  public static void injectBannerList(ProjectPresenter instance, List<BannerItem> bannerList) {
    instance.bannerList = bannerList;
  }

  public static void injectProjectAdapter(
      ProjectPresenter instance, ProjectAdapter projectAdapter) {
    instance.projectAdapter = projectAdapter;
  }

  public static void injectMProjectList(ProjectPresenter instance, List<ProjectItem> mProjectList) {
    instance.mProjectList = mProjectList;
  }
}
