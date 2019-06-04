package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.MainModule;
import com.wy.adbook.di.module.MainModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.MainModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.MainContract;
import com.wy.adbook.mvp.model.MainModel;
import com.wy.adbook.mvp.model.MainModel_Factory;
import com.wy.adbook.mvp.presenter.MainPresenter;
import com.wy.adbook.mvp.presenter.MainPresenter_Factory;
import com.wy.adbook.mvp.view.activity.MainActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainComponent implements MainComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<MainModel> mainModelProvider;

  private Provider<MainContract.Model> provideAboutModelProvider;

  private Provider<MainContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<MainPresenter> mainPresenterProvider;

  private DaggerMainComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.mainModelProvider =
        DoubleCheck.provider(MainModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            MainModule_ProvideAboutModelFactory.create(builder.mainModule, mainModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(MainModule_ProvideAboutViewFactory.create(builder.mainModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.mainPresenterProvider =
        DoubleCheck.provider(
            MainPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(MainActivity activity) {
    injectMainActivity(activity);
  }

  private MainActivity injectMainActivity(MainActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mainPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private MainModule mainModule;

    private AppComponent appComponent;

    private Builder() {}

    public MainComponent build() {
      if (mainModule == null) {
        throw new IllegalStateException(MainModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainComponent(this);
    }

    public Builder mainModule(MainModule mainModule) {
      this.mainModule = Preconditions.checkNotNull(mainModule);
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
