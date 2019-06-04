package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.WithdrawalModule;
import com.wy.adbook.di.module.WithdrawalModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WithdrawalModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.WithdrawalContract;
import com.wy.adbook.mvp.model.WithdrawalModel;
import com.wy.adbook.mvp.model.WithdrawalModel_Factory;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter_Factory;
import com.wy.adbook.mvp.view.activity.WithdrawalActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerWithdrawalComponent implements WithdrawalComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WithdrawalModel> withdrawalModelProvider;

  private Provider<WithdrawalContract.Model> provideAboutModelProvider;

  private Provider<WithdrawalContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<WithdrawalPresenter> withdrawalPresenterProvider;

  private DaggerWithdrawalComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.withdrawalModelProvider =
        DoubleCheck.provider(WithdrawalModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            WithdrawalModule_ProvideAboutModelFactory.create(
                builder.withdrawalModule, withdrawalModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            WithdrawalModule_ProvideAboutViewFactory.create(builder.withdrawalModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.withdrawalPresenterProvider =
        DoubleCheck.provider(
            WithdrawalPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(WithdrawalActivity inject) {
    injectWithdrawalActivity(inject);
  }

  private WithdrawalActivity injectWithdrawalActivity(WithdrawalActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, withdrawalPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private WithdrawalModule withdrawalModule;

    private AppComponent appComponent;

    private Builder() {}

    public WithdrawalComponent build() {
      if (withdrawalModule == null) {
        throw new IllegalStateException(WithdrawalModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWithdrawalComponent(this);
    }

    public Builder withdrawalModule(WithdrawalModule withdrawalModule) {
      this.withdrawalModule = Preconditions.checkNotNull(withdrawalModule);
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
