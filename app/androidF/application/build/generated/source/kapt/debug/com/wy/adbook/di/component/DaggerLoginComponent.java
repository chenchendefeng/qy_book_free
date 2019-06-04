package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.LoginModule;
import com.wy.adbook.di.module.LoginModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.LoginModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.LoginContract;
import com.wy.adbook.mvp.model.LoginModel;
import com.wy.adbook.mvp.model.LoginModel_Factory;
import com.wy.adbook.mvp.presenter.LoginPresenter;
import com.wy.adbook.mvp.presenter.LoginPresenter_Factory;
import com.wy.adbook.mvp.view.activity.LoginActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerLoginComponent implements LoginComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<LoginModel> loginModelProvider;

  private Provider<LoginContract.Model> provideAboutModelProvider;

  private Provider<LoginContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<LoginPresenter> loginPresenterProvider;

  private DaggerLoginComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.loginModelProvider =
        DoubleCheck.provider(LoginModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            LoginModule_ProvideAboutModelFactory.create(builder.loginModule, loginModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(LoginModule_ProvideAboutViewFactory.create(builder.loginModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.loginPresenterProvider =
        DoubleCheck.provider(
            LoginPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(LoginActivity inject) {
    injectLoginActivity(inject);
  }

  private LoginActivity injectLoginActivity(LoginActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, loginPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private LoginModule loginModule;

    private AppComponent appComponent;

    private Builder() {}

    public LoginComponent build() {
      if (loginModule == null) {
        throw new IllegalStateException(LoginModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerLoginComponent(this);
    }

    public Builder loginModule(LoginModule loginModule) {
      this.loginModule = Preconditions.checkNotNull(loginModule);
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
