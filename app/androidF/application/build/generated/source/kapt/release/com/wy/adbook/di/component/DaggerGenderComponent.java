package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.GenderModule;
import com.wy.adbook.di.module.GenderModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.GenderModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.GenderContract;
import com.wy.adbook.mvp.model.GenderModel;
import com.wy.adbook.mvp.model.GenderModel_Factory;
import com.wy.adbook.mvp.presenter.GenderPresenter;
import com.wy.adbook.mvp.presenter.GenderPresenter_Factory;
import com.wy.adbook.mvp.view.activity.GenderSelectActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerGenderComponent implements GenderComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<GenderModel> genderModelProvider;

  private Provider<GenderContract.Model> provideAboutModelProvider;

  private Provider<GenderContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<GenderPresenter> genderPresenterProvider;

  private DaggerGenderComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.genderModelProvider =
        DoubleCheck.provider(GenderModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            GenderModule_ProvideAboutModelFactory.create(
                builder.genderModule, genderModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(GenderModule_ProvideAboutViewFactory.create(builder.genderModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.genderPresenterProvider =
        DoubleCheck.provider(
            GenderPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(GenderSelectActivity activity) {
    injectGenderSelectActivity(activity);
  }

  private GenderSelectActivity injectGenderSelectActivity(GenderSelectActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, genderPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private GenderModule genderModule;

    private AppComponent appComponent;

    private Builder() {}

    public GenderComponent build() {
      if (genderModule == null) {
        throw new IllegalStateException(GenderModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerGenderComponent(this);
    }

    public Builder genderModule(GenderModule genderModule) {
      this.genderModule = Preconditions.checkNotNull(genderModule);
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
