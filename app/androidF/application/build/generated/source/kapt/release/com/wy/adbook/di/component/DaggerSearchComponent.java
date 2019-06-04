package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.SearchModule;
import com.wy.adbook.di.module.SearchModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.SearchModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.SearchContract;
import com.wy.adbook.mvp.model.SearchModel;
import com.wy.adbook.mvp.model.SearchModel_Factory;
import com.wy.adbook.mvp.presenter.SearchPresenter;
import com.wy.adbook.mvp.presenter.SearchPresenter_Factory;
import com.wy.adbook.mvp.view.activity.SearchActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSearchComponent implements SearchComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<SearchModel> searchModelProvider;

  private Provider<SearchContract.Model> provideAboutModelProvider;

  private Provider<SearchContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<SearchPresenter> searchPresenterProvider;

  private DaggerSearchComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.searchModelProvider =
        DoubleCheck.provider(SearchModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            SearchModule_ProvideAboutModelFactory.create(
                builder.searchModule, searchModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(SearchModule_ProvideAboutViewFactory.create(builder.searchModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.searchPresenterProvider =
        DoubleCheck.provider(
            SearchPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(SearchActivity inject) {
    injectSearchActivity(inject);
  }

  private SearchActivity injectSearchActivity(SearchActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, searchPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private SearchModule searchModule;

    private AppComponent appComponent;

    private Builder() {}

    public SearchComponent build() {
      if (searchModule == null) {
        throw new IllegalStateException(SearchModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSearchComponent(this);
    }

    public Builder searchModule(SearchModule searchModule) {
      this.searchModule = Preconditions.checkNotNull(searchModule);
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
