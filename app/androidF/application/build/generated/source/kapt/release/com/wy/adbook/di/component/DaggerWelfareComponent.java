package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.WelfareModule;
import com.wy.adbook.di.module.WelfareModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.WelfareModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.WelfareContract;
import com.wy.adbook.mvp.model.WelfareModel;
import com.wy.adbook.mvp.model.WelfareModel_Factory;
import com.wy.adbook.mvp.presenter.WelfarePresenter;
import com.wy.adbook.mvp.presenter.WelfarePresenter_Factory;
import com.wy.adbook.mvp.view.fragment.WelfareFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerWelfareComponent implements WelfareComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<WelfareModel> welfareModelProvider;

  private Provider<WelfareContract.Model> provideAboutModelProvider;

  private Provider<WelfareContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<WelfarePresenter> welfarePresenterProvider;

  private DaggerWelfareComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.welfareModelProvider =
        DoubleCheck.provider(WelfareModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            WelfareModule_ProvideAboutModelFactory.create(
                builder.welfareModule, welfareModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(WelfareModule_ProvideAboutViewFactory.create(builder.welfareModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.welfarePresenterProvider =
        DoubleCheck.provider(
            WelfarePresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(WelfareFragment fragment) {
    injectWelfareFragment(fragment);
  }

  private WelfareFragment injectWelfareFragment(WelfareFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, welfarePresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private WelfareModule welfareModule;

    private AppComponent appComponent;

    private Builder() {}

    public WelfareComponent build() {
      if (welfareModule == null) {
        throw new IllegalStateException(WelfareModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWelfareComponent(this);
    }

    public Builder welfareModule(WelfareModule welfareModule) {
      this.welfareModule = Preconditions.checkNotNull(welfareModule);
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
