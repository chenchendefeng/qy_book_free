package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.AboutUsModule;
import com.wy.adbook.di.module.AboutUsModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.AboutUsModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.AboutUsContract;
import com.wy.adbook.mvp.model.AboutUsModel;
import com.wy.adbook.mvp.model.AboutUsModel_Factory;
import com.wy.adbook.mvp.presenter.AboutUsPresenter;
import com.wy.adbook.mvp.presenter.AboutUsPresenter_Factory;
import com.wy.adbook.mvp.view.activity.AboutUsActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAboutUsComponent implements AboutUsComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<AboutUsModel> aboutUsModelProvider;

  private Provider<AboutUsContract.Model> provideAboutModelProvider;

  private Provider<AboutUsContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<AboutUsPresenter> aboutUsPresenterProvider;

  private DaggerAboutUsComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.aboutUsModelProvider =
        DoubleCheck.provider(AboutUsModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            AboutUsModule_ProvideAboutModelFactory.create(
                builder.aboutUsModule, aboutUsModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(AboutUsModule_ProvideAboutViewFactory.create(builder.aboutUsModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.aboutUsPresenterProvider =
        DoubleCheck.provider(
            AboutUsPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(AboutUsActivity inject) {
    injectAboutUsActivity(inject);
  }

  private AboutUsActivity injectAboutUsActivity(AboutUsActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, aboutUsPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private AboutUsModule aboutUsModule;

    private AppComponent appComponent;

    private Builder() {}

    public AboutUsComponent build() {
      if (aboutUsModule == null) {
        throw new IllegalStateException(AboutUsModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAboutUsComponent(this);
    }

    public Builder aboutUsModule(AboutUsModule aboutUsModule) {
      this.aboutUsModule = Preconditions.checkNotNull(aboutUsModule);
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
