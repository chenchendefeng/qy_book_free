package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.VipModule;
import com.wy.adbook.di.module.VipModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.VipModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.VipContract;
import com.wy.adbook.mvp.model.VipModel;
import com.wy.adbook.mvp.model.VipModel_Factory;
import com.wy.adbook.mvp.presenter.VipPresenter;
import com.wy.adbook.mvp.presenter.VipPresenter_Factory;
import com.wy.adbook.mvp.view.activity.VipActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerVipComponent implements VipComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<VipModel> vipModelProvider;

  private Provider<VipContract.Model> provideAboutModelProvider;

  private Provider<VipContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<VipPresenter> vipPresenterProvider;

  private DaggerVipComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.vipModelProvider =
        DoubleCheck.provider(VipModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            VipModule_ProvideAboutModelFactory.create(builder.vipModule, vipModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(VipModule_ProvideAboutViewFactory.create(builder.vipModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.vipPresenterProvider =
        DoubleCheck.provider(
            VipPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(VipActivity inject) {
    injectVipActivity(inject);
  }

  private VipActivity injectVipActivity(VipActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, vipPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private VipModule vipModule;

    private AppComponent appComponent;

    private Builder() {}

    public VipComponent build() {
      if (vipModule == null) {
        throw new IllegalStateException(VipModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerVipComponent(this);
    }

    public Builder vipModule(VipModule vipModule) {
      this.vipModule = Preconditions.checkNotNull(vipModule);
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
