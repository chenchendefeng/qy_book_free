package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.RedEnvelopesForCodeModule;
import com.wy.adbook.di.module.RedEnvelopesForCodeModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.RedEnvelopesForCodeModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract;
import com.wy.adbook.mvp.model.RedEnvelopesForCodeModel;
import com.wy.adbook.mvp.model.RedEnvelopesForCodeModel_Factory;
import com.wy.adbook.mvp.presenter.RedEnvelopesForCodePresenter;
import com.wy.adbook.mvp.presenter.RedEnvelopesForCodePresenter_Factory;
import com.wy.adbook.mvp.view.activity.RedEnvelopesForCodeActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRedEnvelopesForCodeComponent implements RedEnvelopesForCodeComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<RedEnvelopesForCodeModel> redEnvelopesForCodeModelProvider;

  private Provider<RedEnvelopesForCodeContract.Model> provideAboutModelProvider;

  private Provider<RedEnvelopesForCodeContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<RedEnvelopesForCodePresenter> redEnvelopesForCodePresenterProvider;

  private DaggerRedEnvelopesForCodeComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.redEnvelopesForCodeModelProvider =
        DoubleCheck.provider(RedEnvelopesForCodeModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            RedEnvelopesForCodeModule_ProvideAboutModelFactory.create(
                builder.redEnvelopesForCodeModule, redEnvelopesForCodeModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            RedEnvelopesForCodeModule_ProvideAboutViewFactory.create(
                builder.redEnvelopesForCodeModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.redEnvelopesForCodePresenterProvider =
        DoubleCheck.provider(
            RedEnvelopesForCodePresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(RedEnvelopesForCodeActivity inject) {
    injectRedEnvelopesForCodeActivity(inject);
  }

  private RedEnvelopesForCodeActivity injectRedEnvelopesForCodeActivity(
      RedEnvelopesForCodeActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(
        instance, redEnvelopesForCodePresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private RedEnvelopesForCodeModule redEnvelopesForCodeModule;

    private AppComponent appComponent;

    private Builder() {}

    public RedEnvelopesForCodeComponent build() {
      if (redEnvelopesForCodeModule == null) {
        throw new IllegalStateException(
            RedEnvelopesForCodeModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerRedEnvelopesForCodeComponent(this);
    }

    public Builder redEnvelopesForCodeModule(RedEnvelopesForCodeModule redEnvelopesForCodeModule) {
      this.redEnvelopesForCodeModule = Preconditions.checkNotNull(redEnvelopesForCodeModule);
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
