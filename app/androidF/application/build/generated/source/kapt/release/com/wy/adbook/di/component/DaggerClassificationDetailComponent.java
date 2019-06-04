package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.ClassificationDetailModule;
import com.wy.adbook.di.module.ClassificationDetailModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.ClassificationDetailModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.ClassificationDetailContract;
import com.wy.adbook.mvp.model.ClassificationDetailModel;
import com.wy.adbook.mvp.model.ClassificationDetailModel_Factory;
import com.wy.adbook.mvp.presenter.ClassificationDetailPresenter;
import com.wy.adbook.mvp.presenter.ClassificationDetailPresenter_Factory;
import com.wy.adbook.mvp.view.activity.ClassificationDetailActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerClassificationDetailComponent implements ClassificationDetailComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<ClassificationDetailModel> classificationDetailModelProvider;

  private Provider<ClassificationDetailContract.Model> provideAboutModelProvider;

  private Provider<ClassificationDetailContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<ClassificationDetailPresenter> classificationDetailPresenterProvider;

  private DaggerClassificationDetailComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.classificationDetailModelProvider =
        DoubleCheck.provider(ClassificationDetailModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            ClassificationDetailModule_ProvideAboutModelFactory.create(
                builder.classificationDetailModule, classificationDetailModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            ClassificationDetailModule_ProvideAboutViewFactory.create(
                builder.classificationDetailModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.classificationDetailPresenterProvider =
        DoubleCheck.provider(
            ClassificationDetailPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(ClassificationDetailActivity inject) {
    injectClassificationDetailActivity(inject);
  }

  private ClassificationDetailActivity injectClassificationDetailActivity(
      ClassificationDetailActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(
        instance, classificationDetailPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private ClassificationDetailModule classificationDetailModule;

    private AppComponent appComponent;

    private Builder() {}

    public ClassificationDetailComponent build() {
      if (classificationDetailModule == null) {
        throw new IllegalStateException(
            ClassificationDetailModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerClassificationDetailComponent(this);
    }

    public Builder classificationDetailModule(
        ClassificationDetailModule classificationDetailModule) {
      this.classificationDetailModule = Preconditions.checkNotNull(classificationDetailModule);
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
