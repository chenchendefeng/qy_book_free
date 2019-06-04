package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.RemoveAdSuccessModule;
import com.wy.adbook.di.module.RemoveAdSuccessModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.RemoveAdSuccessModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract;
import com.wy.adbook.mvp.model.RemoveAdSuccessModel;
import com.wy.adbook.mvp.model.RemoveAdSuccessModel_Factory;
import com.wy.adbook.mvp.presenter.RemoveAdSuccessPresenter;
import com.wy.adbook.mvp.presenter.RemoveAdSuccessPresenter_Factory;
import com.wy.adbook.mvp.view.activity.RemoveAdSuccessActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRemoveAdSuccessComponent implements RemoveAdSuccessComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<RemoveAdSuccessModel> removeAdSuccessModelProvider;

  private Provider<RemoveAdSuccessContract.Model> provideAboutModelProvider;

  private Provider<RemoveAdSuccessContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<RemoveAdSuccessPresenter> removeAdSuccessPresenterProvider;

  private DaggerRemoveAdSuccessComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.removeAdSuccessModelProvider =
        DoubleCheck.provider(RemoveAdSuccessModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            RemoveAdSuccessModule_ProvideAboutModelFactory.create(
                builder.removeAdSuccessModule, removeAdSuccessModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            RemoveAdSuccessModule_ProvideAboutViewFactory.create(builder.removeAdSuccessModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.removeAdSuccessPresenterProvider =
        DoubleCheck.provider(
            RemoveAdSuccessPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(RemoveAdSuccessActivity inject) {
    injectRemoveAdSuccessActivity(inject);
  }

  private RemoveAdSuccessActivity injectRemoveAdSuccessActivity(RemoveAdSuccessActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(
        instance, removeAdSuccessPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private RemoveAdSuccessModule removeAdSuccessModule;

    private AppComponent appComponent;

    private Builder() {}

    public RemoveAdSuccessComponent build() {
      if (removeAdSuccessModule == null) {
        throw new IllegalStateException(
            RemoveAdSuccessModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerRemoveAdSuccessComponent(this);
    }

    public Builder removeAdSuccessModule(RemoveAdSuccessModule removeAdSuccessModule) {
      this.removeAdSuccessModule = Preconditions.checkNotNull(removeAdSuccessModule);
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
