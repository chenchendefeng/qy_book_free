package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.AdModule;
import com.wy.adbook.di.module.AdModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.AdModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.AdContract;
import com.wy.adbook.mvp.model.AdModel;
import com.wy.adbook.mvp.model.AdModel_Factory;
import com.wy.adbook.mvp.presenter.AdPresenter;
import com.wy.adbook.mvp.presenter.AdPresenter_Factory;
import com.wy.adbook.mvp.view.activity.AdActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAdComponent implements AdComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<AdModel> adModelProvider;

  private Provider<AdContract.Model> provideAboutModelProvider;

  private Provider<AdContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<AdPresenter> adPresenterProvider;

  private DaggerAdComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.adModelProvider = DoubleCheck.provider(AdModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            AdModule_ProvideAboutModelFactory.create(builder.adModule, adModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(AdModule_ProvideAboutViewFactory.create(builder.adModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.adPresenterProvider =
        DoubleCheck.provider(
            AdPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(AdActivity inject) {
    injectAdActivity(inject);
  }

  private AdActivity injectAdActivity(AdActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, adPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private AdModule adModule;

    private AppComponent appComponent;

    private Builder() {}

    public AdComponent build() {
      if (adModule == null) {
        throw new IllegalStateException(AdModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAdComponent(this);
    }

    public Builder adModule(AdModule adModule) {
      this.adModule = Preconditions.checkNotNull(adModule);
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
