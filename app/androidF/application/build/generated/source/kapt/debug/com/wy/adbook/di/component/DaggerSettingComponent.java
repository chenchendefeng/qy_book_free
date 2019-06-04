package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.SettingModule;
import com.wy.adbook.di.module.SettingModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.SettingModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.SettingContract;
import com.wy.adbook.mvp.model.SettingModel;
import com.wy.adbook.mvp.model.SettingModel_Factory;
import com.wy.adbook.mvp.presenter.SettingPresenter;
import com.wy.adbook.mvp.presenter.SettingPresenter_Factory;
import com.wy.adbook.mvp.view.activity.SettingActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSettingComponent implements SettingComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<SettingModel> settingModelProvider;

  private Provider<SettingContract.Model> provideAboutModelProvider;

  private Provider<SettingContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<SettingPresenter> settingPresenterProvider;

  private DaggerSettingComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.settingModelProvider =
        DoubleCheck.provider(SettingModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            SettingModule_ProvideAboutModelFactory.create(
                builder.settingModule, settingModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(SettingModule_ProvideAboutViewFactory.create(builder.settingModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.settingPresenterProvider =
        DoubleCheck.provider(
            SettingPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(SettingActivity inject) {
    injectSettingActivity(inject);
  }

  private SettingActivity injectSettingActivity(SettingActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, settingPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private SettingModule settingModule;

    private AppComponent appComponent;

    private Builder() {}

    public SettingComponent build() {
      if (settingModule == null) {
        throw new IllegalStateException(SettingModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSettingComponent(this);
    }

    public Builder settingModule(SettingModule settingModule) {
      this.settingModule = Preconditions.checkNotNull(settingModule);
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
