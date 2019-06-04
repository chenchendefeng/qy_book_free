package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.WebModule;
import com.wy.adbook.di.module.WebModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WebModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.view.web.act.WebActivity;
import com.wy.adbook.mvp.view.web.act.WebContract;
import com.wy.adbook.mvp.view.web.act.WebModel;
import com.wy.adbook.mvp.view.web.act.WebModel_Factory;
import com.wy.adbook.mvp.view.web.act.WebPresenter;
import com.wy.adbook.mvp.view.web.act.WebPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerWebComponent implements WebComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WebModel> webModelProvider;

  private Provider<WebContract.Model> provideAboutModelProvider;

  private Provider<WebContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<WebPresenter> webPresenterProvider;

  private DaggerWebComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.webModelProvider =
        DoubleCheck.provider(WebModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            WebModule_ProvideAboutModelFactory.create(builder.webModule, webModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(WebModule_ProvideAboutViewFactory.create(builder.webModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.webPresenterProvider =
        DoubleCheck.provider(
            WebPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(WebActivity inject) {
    injectWebActivity(inject);
  }

  private WebActivity injectWebActivity(WebActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, webPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private WebModule webModule;

    private AppComponent appComponent;

    private Builder() {}

    public WebComponent build() {
      if (webModule == null) {
        throw new IllegalStateException(WebModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWebComponent(this);
    }

    public Builder webModule(WebModule webModule) {
      this.webModule = Preconditions.checkNotNull(webModule);
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
