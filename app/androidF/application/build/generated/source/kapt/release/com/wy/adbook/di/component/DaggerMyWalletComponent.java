package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.MyWalletModule;
import com.wy.adbook.di.module.MyWalletModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.MyWalletModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.MyWalletContract;
import com.wy.adbook.mvp.model.MyWalletModel;
import com.wy.adbook.mvp.model.MyWalletModel_Factory;
import com.wy.adbook.mvp.presenter.MyWalletPresenter;
import com.wy.adbook.mvp.presenter.MyWalletPresenter_Factory;
import com.wy.adbook.mvp.view.activity.MyWalletActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMyWalletComponent implements MyWalletComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<MyWalletModel> myWalletModelProvider;

  private Provider<MyWalletContract.Model> provideAboutModelProvider;

  private Provider<MyWalletContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<MyWalletPresenter> myWalletPresenterProvider;

  private DaggerMyWalletComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.myWalletModelProvider =
        DoubleCheck.provider(MyWalletModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            MyWalletModule_ProvideAboutModelFactory.create(
                builder.myWalletModule, myWalletModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(MyWalletModule_ProvideAboutViewFactory.create(builder.myWalletModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.myWalletPresenterProvider =
        DoubleCheck.provider(
            MyWalletPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(MyWalletActivity inject) {
    injectMyWalletActivity(inject);
  }

  private MyWalletActivity injectMyWalletActivity(MyWalletActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, myWalletPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private MyWalletModule myWalletModule;

    private AppComponent appComponent;

    private Builder() {}

    public MyWalletComponent build() {
      if (myWalletModule == null) {
        throw new IllegalStateException(MyWalletModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMyWalletComponent(this);
    }

    public Builder myWalletModule(MyWalletModule myWalletModule) {
      this.myWalletModule = Preconditions.checkNotNull(myWalletModule);
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
