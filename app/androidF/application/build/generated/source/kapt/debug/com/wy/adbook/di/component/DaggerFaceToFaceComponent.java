package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.FaceToFaceModule;
import com.wy.adbook.di.module.FaceToFaceModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.FaceToFaceModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.FaceToFaceContract;
import com.wy.adbook.mvp.model.FaceToFaceModel;
import com.wy.adbook.mvp.model.FaceToFaceModel_Factory;
import com.wy.adbook.mvp.presenter.FaceToFacePresenter;
import com.wy.adbook.mvp.presenter.FaceToFacePresenter_Factory;
import com.wy.adbook.mvp.view.activity.FaceToFaceActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFaceToFaceComponent implements FaceToFaceComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<FaceToFaceModel> faceToFaceModelProvider;

  private Provider<FaceToFaceContract.Model> provideAboutModelProvider;

  private Provider<FaceToFaceContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<FaceToFacePresenter> faceToFacePresenterProvider;

  private DaggerFaceToFaceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.faceToFaceModelProvider =
        DoubleCheck.provider(FaceToFaceModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            FaceToFaceModule_ProvideAboutModelFactory.create(
                builder.faceToFaceModule, faceToFaceModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            FaceToFaceModule_ProvideAboutViewFactory.create(builder.faceToFaceModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.faceToFacePresenterProvider =
        DoubleCheck.provider(
            FaceToFacePresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(FaceToFaceActivity inject) {
    injectFaceToFaceActivity(inject);
  }

  private FaceToFaceActivity injectFaceToFaceActivity(FaceToFaceActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, faceToFacePresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private FaceToFaceModule faceToFaceModule;

    private AppComponent appComponent;

    private Builder() {}

    public FaceToFaceComponent build() {
      if (faceToFaceModule == null) {
        throw new IllegalStateException(FaceToFaceModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFaceToFaceComponent(this);
    }

    public Builder faceToFaceModule(FaceToFaceModule faceToFaceModule) {
      this.faceToFaceModule = Preconditions.checkNotNull(faceToFaceModule);
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
