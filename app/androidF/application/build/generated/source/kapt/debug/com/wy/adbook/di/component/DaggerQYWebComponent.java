package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.QYWebModule;
import com.wy.adbook.di.module.QYWebModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.QYWebModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.QYWebModule_ProvideWebViewFactory;
import com.wy.adbook.mvp.view.web.QYWebView;
import com.wy.adbook.mvp.view.web.frag.QYWebContract;
import com.wy.adbook.mvp.view.web.frag.QYWebFragment;
import com.wy.adbook.mvp.view.web.frag.QYWebFragment_MembersInjector;
import com.wy.adbook.mvp.view.web.frag.QYWebModel;
import com.wy.adbook.mvp.view.web.frag.QYWebModel_Factory;
import com.wy.adbook.mvp.view.web.frag.QYWebPresenter;
import com.wy.adbook.mvp.view.web.frag.QYWebPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerQYWebComponent implements QYWebComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<QYWebModel> qYWebModelProvider;

  private Provider<QYWebContract.Model> provideAboutModelProvider;

  private Provider<QYWebContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<QYWebPresenter> qYWebPresenterProvider;

  private Provider<QYWebView> provideWebViewProvider;

  private DaggerQYWebComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.qYWebModelProvider =
        DoubleCheck.provider(QYWebModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            QYWebModule_ProvideAboutModelFactory.create(builder.qYWebModule, qYWebModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(QYWebModule_ProvideAboutViewFactory.create(builder.qYWebModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.qYWebPresenterProvider =
        DoubleCheck.provider(
            QYWebPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
    this.provideWebViewProvider =
        DoubleCheck.provider(QYWebModule_ProvideWebViewFactory.create(builder.qYWebModule));
  }

  @Override
  public void inject(QYWebFragment inject) {
    injectQYWebFragment(inject);
  }

  private QYWebFragment injectQYWebFragment(QYWebFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, qYWebPresenterProvider.get());
    QYWebFragment_MembersInjector.injectWebView(instance, provideWebViewProvider.get());
    return instance;
  }

  public static final class Builder {
    private QYWebModule qYWebModule;

    private AppComponent appComponent;

    private Builder() {}

    public QYWebComponent build() {
      if (qYWebModule == null) {
        throw new IllegalStateException(QYWebModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerQYWebComponent(this);
    }

    public Builder qYWebModule(QYWebModule qYWebModule) {
      this.qYWebModule = Preconditions.checkNotNull(qYWebModule);
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
