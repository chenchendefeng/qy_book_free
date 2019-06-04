package com.wy.adbook.di.component;

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.WithdrawalModule;
import com.wy.adbook.di.module.WithdrawalModule_CashWithdrawalAdapterFactory;
import com.wy.adbook.di.module.WithdrawalModule_CashWithdrawalItemListFactory;
import com.wy.adbook.di.module.WithdrawalModule_Glm1Factory;
import com.wy.adbook.di.module.WithdrawalModule_Glm2Factory;
import com.wy.adbook.di.module.WithdrawalModule_GoldWithdrawalItemListFactory;
import com.wy.adbook.di.module.WithdrawalModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WithdrawalModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.WithdrawalModule_WithdrawalAdapterFactory;
import com.wy.adbook.mvp.contranct.WithdrawalContract;
import com.wy.adbook.mvp.model.WithdrawalModel;
import com.wy.adbook.mvp.model.WithdrawalModel_Factory;
import com.wy.adbook.mvp.model.entity.WithdrawalItem;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter_Factory;
import com.wy.adbook.mvp.view.activity.WithdrawalActivity;
import com.wy.adbook.mvp.view.activity.WithdrawalActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter;
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
public final class DaggerWithdrawalComponent implements WithdrawalComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WithdrawalModel> withdrawalModelProvider;

  private Provider<WithdrawalContract.Model> provideAboutModelProvider;

  private Provider<WithdrawalContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<WithdrawalItem>> goldWithdrawalItemListProvider;

  private Provider<WithdrawablAdapter> withdrawalAdapterProvider;

  private Provider<List<WithdrawalItem>> cashWithdrawalItemListProvider;

  private Provider<WithdrawablAdapter> cashWithdrawalAdapterProvider;

  private Provider<WithdrawalPresenter> withdrawalPresenterProvider;

  private Provider<FullyGridLayoutManager> glm1Provider;

  private Provider<FullyGridLayoutManager> glm2Provider;

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
    this.goldWithdrawalItemListProvider =
        DoubleCheck.provider(
            WithdrawalModule_GoldWithdrawalItemListFactory.create(builder.withdrawalModule));
    this.withdrawalAdapterProvider =
        DoubleCheck.provider(
            WithdrawalModule_WithdrawalAdapterFactory.create(
                builder.withdrawalModule, goldWithdrawalItemListProvider));
    this.cashWithdrawalItemListProvider =
        DoubleCheck.provider(
            WithdrawalModule_CashWithdrawalItemListFactory.create(builder.withdrawalModule));
    this.cashWithdrawalAdapterProvider =
        DoubleCheck.provider(
            WithdrawalModule_CashWithdrawalAdapterFactory.create(
                builder.withdrawalModule, cashWithdrawalItemListProvider));
    this.withdrawalPresenterProvider =
        DoubleCheck.provider(
            WithdrawalPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                withdrawalAdapterProvider,
                cashWithdrawalAdapterProvider,
                goldWithdrawalItemListProvider,
                cashWithdrawalItemListProvider));
    this.glm1Provider =
        DoubleCheck.provider(WithdrawalModule_Glm1Factory.create(builder.withdrawalModule));
    this.glm2Provider =
        DoubleCheck.provider(WithdrawalModule_Glm2Factory.create(builder.withdrawalModule));
  }

  @Override
  public void inject(WithdrawalActivity inject) {
    injectWithdrawalActivity(inject);
  }

  private WithdrawalActivity injectWithdrawalActivity(WithdrawalActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, withdrawalPresenterProvider.get());
    WithdrawalActivity_MembersInjector.injectGoldAdapter(instance, withdrawalAdapterProvider.get());
    WithdrawalActivity_MembersInjector.injectCashAdapter(
        instance, cashWithdrawalAdapterProvider.get());
    WithdrawalActivity_MembersInjector.injectGlm1(instance, glm1Provider.get());
    WithdrawalActivity_MembersInjector.injectGlm2(instance, glm2Provider.get());
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
