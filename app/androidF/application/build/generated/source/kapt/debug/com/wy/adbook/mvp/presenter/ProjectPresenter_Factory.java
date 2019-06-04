package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.ProjectContract;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.view.adapter.ProjectAdapter;
import com.wy.adbook.mvp.view.adapter.ProjectItem;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectPresenter_Factory implements Factory<ProjectPresenter> {
  private final Provider<ProjectContract.Model> modelProvider;

  private final Provider<ProjectContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  private final Provider<ProjectAdapter> projectAdapterProvider;

  private final Provider<List<ProjectItem>> mProjectListProvider;

  public ProjectPresenter_Factory(
      Provider<ProjectContract.Model> modelProvider,
      Provider<ProjectContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<List<ProjectItem>> mProjectListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.bannerListProvider = bannerListProvider;
    this.projectAdapterProvider = projectAdapterProvider;
    this.mProjectListProvider = mProjectListProvider;
  }

  @Override
  public ProjectPresenter get() {
    ProjectPresenter instance = new ProjectPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    ProjectPresenter_MembersInjector.injectBannerList(instance, bannerListProvider.get());
    ProjectPresenter_MembersInjector.injectProjectAdapter(instance, projectAdapterProvider.get());
    ProjectPresenter_MembersInjector.injectMProjectList(instance, mProjectListProvider.get());
    return instance;
  }

  public static ProjectPresenter_Factory create(
      Provider<ProjectContract.Model> modelProvider,
      Provider<ProjectContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<List<BannerItem>> bannerListProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<List<ProjectItem>> mProjectListProvider) {
    return new ProjectPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        bannerListProvider,
        projectAdapterProvider,
        mProjectListProvider);
  }

  public static ProjectPresenter newProjectPresenter(
      ProjectContract.Model model, ProjectContract.View view) {
    return new ProjectPresenter(model, view);
  }
}
