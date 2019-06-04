package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.ReadModule;
import com.wy.adbook.di.module.ReadModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.ReadModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.ReadContract;
import com.wy.adbook.mvp.model.ReadModel;
import com.wy.adbook.mvp.model.ReadModel_Factory;
import com.wy.adbook.mvp.presenter.ReadPresenter;
import com.wy.adbook.mvp.presenter.ReadPresenter_Factory;
import com.wy.adbook.mvp.view.activity.ReadActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerReadComponent implements ReadComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<ReadModel> readModelProvider;

  private Provider<ReadContract.Model> provideAboutModelProvider;

  private Provider<ReadContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<ReadPresenter> readPresenterProvider;

  private DaggerReadComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.readModelProvider =
        DoubleCheck.provider(ReadModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            ReadModule_ProvideAboutModelFactory.create(builder.readModule, readModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(ReadModule_ProvideAboutViewFactory.create(builder.readModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.readPresenterProvider =
        DoubleCheck.provider(
            ReadPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(ReadActivity inject) {
    injectReadActivity(inject);
  }

  private ReadActivity injectReadActivity(ReadActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, readPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private ReadModule readModule;

    private AppComponent appComponent;

    private Builder() {}

    public ReadComponent build() {
      if (readModule == null) {
        throw new IllegalStateException(ReadModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerReadComponent(this);
    }

    public Builder readModule(ReadModule readModule) {
      this.readModule = Preconditions.checkNotNull(readModule);
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
