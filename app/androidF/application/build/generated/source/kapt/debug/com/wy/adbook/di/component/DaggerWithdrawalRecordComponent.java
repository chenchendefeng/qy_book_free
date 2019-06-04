package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.WithdrawalRecordModule;
import com.wy.adbook.di.module.WithdrawalRecordModule_LlmFactory;
import com.wy.adbook.di.module.WithdrawalRecordModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WithdrawalRecordModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.WithdrawalRecordModule_WithdrawalRecordAdapterFactory;
import com.wy.adbook.di.module.WithdrawalRecordModule_WithdrawalRecordItemListFactory;
import com.wy.adbook.mvp.contranct.WithdrawalRecordContract;
import com.wy.adbook.mvp.model.WithdrawalRecordModel;
import com.wy.adbook.mvp.model.WithdrawalRecordModel_Factory;
import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem;
import com.wy.adbook.mvp.presenter.WithdrawalRecordPresenter;
import com.wy.adbook.mvp.presenter.WithdrawalRecordPresenter_Factory;
import com.wy.adbook.mvp.view.activity.WithdrawalRecordActivity;
import com.wy.adbook.mvp.view.activity.WithdrawalRecordActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter;
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
public final class DaggerWithdrawalRecordComponent implements WithdrawalRecordComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WithdrawalRecordModel> withdrawalRecordModelProvider;

  private Provider<WithdrawalRecordContract.Model> provideAboutModelProvider;

  private Provider<WithdrawalRecordContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<WithdrawalRecordItem>> withdrawalRecordItemListProvider;

  private Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider;

  private Provider<WithdrawalRecordPresenter> withdrawalRecordPresenterProvider;

  private Provider<LinearLayoutManager> llmProvider;

  private DaggerWithdrawalRecordComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.withdrawalRecordModelProvider =
        DoubleCheck.provider(WithdrawalRecordModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            WithdrawalRecordModule_ProvideAboutModelFactory.create(
                builder.withdrawalRecordModule, withdrawalRecordModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            WithdrawalRecordModule_ProvideAboutViewFactory.create(builder.withdrawalRecordModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.withdrawalRecordItemListProvider =
        DoubleCheck.provider(
            WithdrawalRecordModule_WithdrawalRecordItemListFactory.create(
                builder.withdrawalRecordModule));
    this.withdrawalRecordAdapterProvider =
        DoubleCheck.provider(
            WithdrawalRecordModule_WithdrawalRecordAdapterFactory.create(
                builder.withdrawalRecordModule, withdrawalRecordItemListProvider));
    this.withdrawalRecordPresenterProvider =
        DoubleCheck.provider(
            WithdrawalRecordPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                withdrawalRecordAdapterProvider,
                withdrawalRecordItemListProvider));
    this.llmProvider =
        DoubleCheck.provider(
            WithdrawalRecordModule_LlmFactory.create(builder.withdrawalRecordModule));
  }

  @Override
  public void inject(WithdrawalRecordActivity inject) {
    injectWithdrawalRecordActivity(inject);
  }

  private WithdrawalRecordActivity injectWithdrawalRecordActivity(
      WithdrawalRecordActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(
        instance, withdrawalRecordPresenterProvider.get());
    WithdrawalRecordActivity_MembersInjector.injectWithdrawalRecordAdapter(
        instance, withdrawalRecordAdapterProvider.get());
    WithdrawalRecordActivity_MembersInjector.injectLinearLayoutManager(instance, llmProvider.get());
    return instance;
  }

  public static final class Builder {
    private WithdrawalRecordModule withdrawalRecordModule;

    private AppComponent appComponent;

    private Builder() {}

    public WithdrawalRecordComponent build() {
      if (withdrawalRecordModule == null) {
        throw new IllegalStateException(
            WithdrawalRecordModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWithdrawalRecordComponent(this);
    }

    public Builder withdrawalRecordModule(WithdrawalRecordModule withdrawalRecordModule) {
      this.withdrawalRecordModule = Preconditions.checkNotNull(withdrawalRecordModule);
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
