package com.wy.adbook.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.presenter.ProjectPresenter;
import com.wy.adbook.mvp.view.adapter.ProjectAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProjectFragment_MembersInjector implements MembersInjector<ProjectFragment> {
  private final Provider<ProjectPresenter> mPresenterProvider;

  private final Provider<ProjectAdapter> projectAdapterProvider;

  private final Provider<LinearLayoutManager> projectLinearLayoutProvider;

  private final Provider<View> headerViewProvider;

  private final Provider<List<BannerItem>> bannerListProvider;

  public ProjectFragment_MembersInjector(
      Provider<ProjectPresenter> mPresenterProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<LinearLayoutManager> projectLinearLayoutProvider,
      Provider<View> headerViewProvider,
      Provider<List<BannerItem>> bannerListProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.projectAdapterProvider = projectAdapterProvider;
    this.projectLinearLayoutProvider = projectLinearLayoutProvider;
    this.headerViewProvider = headerViewProvider;
    this.bannerListProvider = bannerListProvider;
  }

  public static MembersInjector<ProjectFragment> create(
      Provider<ProjectPresenter> mPresenterProvider,
      Provider<ProjectAdapter> projectAdapterProvider,
      Provider<LinearLayoutManager> projectLinearLayoutProvider,
      Provider<View> headerViewProvider,
      Provider<List<BannerItem>> bannerListProvider) {
    return new ProjectFragment_MembersInjector(
        mPresenterProvider,
        projectAdapterProvider,
        projectLinearLayoutProvider,
        headerViewProvider,
        bannerListProvider);
  }

  @Override
  public void injectMembers(ProjectFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectProjectAdapter(instance, projectAdapterProvider.get());
    injectProjectLinearLayout(instance, projectLinearLayoutProvider.get());
    injectHeaderView(instance, headerViewProvider.get());
    injectBannerList(instance, bannerListProvider.get());
  }

  public static void injectProjectAdapter(ProjectFragment instance, ProjectAdapter projectAdapter) {
    instance.projectAdapter = projectAdapter;
  }

  public static void injectProjectLinearLayout(
      ProjectFragment instance, LinearLayoutManager projectLinearLayout) {
    instance.projectLinearLayout = projectLinearLayout;
  }

  public static void injectHeaderView(ProjectFragment instance, View headerView) {
    instance.headerView = headerView;
  }

  public static void injectBannerList(ProjectFragment instance, List<BannerItem> bannerList) {
    instance.bannerList = bannerList;
  }
}
