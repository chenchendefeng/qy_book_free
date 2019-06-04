package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.WelcomeModule;
import com.wy.adbook.di.module.WelcomeModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WelcomeModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.IWelcomeContract;
import com.wy.adbook.mvp.model.WelcomeModel;
import com.wy.adbook.mvp.model.WelcomeModel_Factory;
import com.wy.adbook.mvp.presenter.WelcomePresenter;
import com.wy.adbook.mvp.presenter.WelcomePresenter_Factory;
import com.wy.adbook.mvp.view.activity.WelcomeActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerWelcomeComponent implements WelcomeComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WelcomeModel> welcomeModelProvider;

  private Provider<IWelcomeContract.Model> provideAboutModelProvider;

  private Provider<IWelcomeContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<WelcomePresenter> welcomePresenterProvider;

  private DaggerWelcomeComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.welcomeModelProvider =
        DoubleCheck.provider(WelcomeModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            WelcomeModule_ProvideAboutModelFactory.create(
                builder.welcomeModule, welcomeModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(WelcomeModule_ProvideAboutViewFactory.create(builder.welcomeModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.welcomePresenterProvider =
        DoubleCheck.provider(
            WelcomePresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(WelcomeActivity activity) {
    injectWelcomeActivity(activity);
  }

  private WelcomeActivity injectWelcomeActivity(WelcomeActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, welcomePresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private WelcomeModule welcomeModule;

    private AppComponent appComponent;

    private Builder() {}

    public WelcomeComponent build() {
      if (welcomeModule == null) {
        throw new IllegalStateException(WelcomeModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWelcomeComponent(this);
    }

    public Builder welcomeModule(WelcomeModule welcomeModule) {
      this.welcomeModule = Preconditions.checkNotNull(welcomeModule);
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
