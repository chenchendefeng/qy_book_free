package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.ProjectModule;
import com.wy.adbook.di.module.ProjectModule_BannerListFactory;
import com.wy.adbook.di.module.ProjectModule_HeaderViewFactory;
import com.wy.adbook.di.module.ProjectModule_ProjectAdapterFactory;
import com.wy.adbook.di.module.ProjectModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.ProjectModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.ProjectModule_ProvideLayoutManager1Factory;
import com.wy.adbook.di.module.ProjectModule_ProvideProjectListFactory;
import com.wy.adbook.mvp.contranct.ProjectContract;
import com.wy.adbook.mvp.model.ProjectModel;
import com.wy.adbook.mvp.model.ProjectModel_Factory;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.presenter.ProjectPresenter;
import com.wy.adbook.mvp.presenter.ProjectPresenter_Factory;
import com.wy.adbook.mvp.view.adapter.ProjectAdapter;
import com.wy.adbook.mvp.view.adapter.ProjectItem;
import com.wy.adbook.mvp.view.fragment.ProjectFragment;
import com.wy.adbook.mvp.view.fragment.ProjectFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerProjectComponent implements ProjectComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<ProjectModel> projectModelProvider;

  private Provider<ProjectContract.Model> provideAboutModelProvider;

  private Provider<ProjectContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<BannerItem>> bannerListProvider;

  private Provider<List<ProjectItem>> provideProjectListProvider;

  private Provider<ProjectAdapter> projectAdapterProvider;

  private Provider<ProjectPresenter> projectPresenterProvider;

  private Provider<LinearLayoutManager> provideLayoutManager1Provider;

  private Provider<View> headerViewProvider;

  private DaggerProjectComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.projectModelProvider =
        DoubleCheck.provider(ProjectModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            ProjectModule_ProvideAboutModelFactory.create(
                builder.projectModule, projectModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(ProjectModule_ProvideAboutViewFactory.create(builder.projectModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.bannerListProvider =
        DoubleCheck.provider(ProjectModule_BannerListFactory.create(builder.projectModule));
    this.provideProjectListProvider =
        DoubleCheck.provider(ProjectModule_ProvideProjectListFactory.create(builder.projectModule));
    this.projectAdapterProvider =
        DoubleCheck.provider(
            ProjectModule_ProjectAdapterFactory.create(
                builder.projectModule, provideProjectListProvider));
    this.projectPresenterProvider =
        DoubleCheck.provider(
            ProjectPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                bannerListProvider,
                projectAdapterProvider,
                provideProjectListProvider));
    this.provideLayoutManager1Provider =
        DoubleCheck.provider(
            ProjectModule_ProvideLayoutManager1Factory.create(builder.projectModule));
    this.headerViewProvider =
        DoubleCheck.provider(ProjectModule_HeaderViewFactory.create(builder.projectModule));
  }

  @Override
  public void inject(ProjectFragment inject) {
    injectProjectFragment(inject);
  }

  private ProjectFragment injectProjectFragment(ProjectFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, projectPresenterProvider.get());
    ProjectFragment_MembersInjector.injectProjectAdapter(instance, projectAdapterProvider.get());
    ProjectFragment_MembersInjector.injectProjectLinearLayout(
        instance, provideLayoutManager1Provider.get());
    ProjectFragment_MembersInjector.injectHeaderView(instance, headerViewProvider.get());
    ProjectFragment_MembersInjector.injectBannerList(instance, bannerListProvider.get());
    return instance;
  }

  public static final class Builder {
    private ProjectModule projectModule;

    private AppComponent appComponent;

    private Builder() {}

    public ProjectComponent build() {
      if (projectModule == null) {
        throw new IllegalStateException(ProjectModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerProjectComponent(this);
    }

    public Builder projectModule(ProjectModule projectModule) {
      this.projectModule = Preconditions.checkNotNull(projectModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }

  private static class com_jess_arms_di_component_AppComponent_repositoryManager
      implements Provider<IRepositoryManager> {
    private final AppComponent appComponent;

    com_jess_arms_di_component_AppComponent_repositoryManager(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public IRepositoryManager get() {
      return Preconditions.checkNotNull(
          appComponent.repositoryManager(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_jess_arms_di_component_AppComponent_rxErrorHandler
      implements Provider<RxErrorHandler> {
    private final AppComponent appComponent;

    com_jess_arms_di_component_AppComponent_rxErrorHandler(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public RxErrorHandler get() {
      return Preconditions.checkNotNull(
          appComponent.rxErrorHandler(),
          "Cannot return null from a non-@Nullable component method");
    }
  }
}
