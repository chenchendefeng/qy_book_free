package com.wy.adbook.di.component;

import android.view.View;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.ClassificationModule;
import com.wy.adbook.di.module.ClassificationModule_ClassificationAdapterFactory;
import com.wy.adbook.di.module.ClassificationModule_GetLinearLayoutManagerFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideBannerListFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideClassificationContentAdapterFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideClassificationListFactory;
import com.wy.adbook.di.module.ClassificationModule_ProvideHeaderViewFactory;
import com.wy.adbook.mvp.contranct.ClassificationContract;
import com.wy.adbook.mvp.model.ClassificationModel;
import com.wy.adbook.mvp.model.ClassificationModel_Factory;
import com.wy.adbook.mvp.model.entity.BannerItem;
import com.wy.adbook.mvp.model.entity.Classification;
import com.wy.adbook.mvp.presenter.ClassificationPresenter;
import com.wy.adbook.mvp.presenter.ClassificationPresenter_Factory;
import com.wy.adbook.mvp.view.activity.ClassificationActivity;
import com.wy.adbook.mvp.view.activity.ClassificationActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter;
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerClassificationComponent implements ClassificationComponent {
  private ClassificationModule classificationModule;

  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<ClassificationModel> classificationModelProvider;

  private Provider<ClassificationContract.Model> provideAboutModelProvider;

  private Provider<ClassificationContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<BannerItem>> provideBannerListProvider;

  private Provider<List<Classification>> provideClassificationListProvider;

  private Provider<ClassificationAdapter> classificationAdapterProvider;

  private Provider<ClassificationContentAdapter> provideClassificationContentAdapterProvider;

  private Provider<ClassificationPresenter> classificationPresenterProvider;

  private Provider<View> provideHeaderViewProvider;

  private DaggerClassificationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.classificationModelProvider =
        DoubleCheck.provider(ClassificationModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideAboutModelFactory.create(
                builder.classificationModule, classificationModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideAboutViewFactory.create(builder.classificationModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.provideBannerListProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideBannerListFactory.create(builder.classificationModule));
    this.provideClassificationListProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideClassificationListFactory.create(
                builder.classificationModule));
    this.classificationAdapterProvider =
        DoubleCheck.provider(
            ClassificationModule_ClassificationAdapterFactory.create(
                builder.classificationModule, provideClassificationListProvider));
    this.provideClassificationContentAdapterProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideClassificationContentAdapterFactory.create(
                builder.classificationModule));
    this.classificationPresenterProvider =
        DoubleCheck.provider(
            ClassificationPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                provideBannerListProvider,
                classificationAdapterProvider,
                provideClassificationContentAdapterProvider,
                provideClassificationListProvider));
    this.classificationModule = builder.classificationModule;
    this.provideHeaderViewProvider =
        DoubleCheck.provider(
            ClassificationModule_ProvideHeaderViewFactory.create(builder.classificationModule));
  }

  @Override
  public void inject(ClassificationActivity inject) {
    injectClassificationActivity(inject);
  }

  private ClassificationActivity injectClassificationActivity(ClassificationActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(
        instance, classificationPresenterProvider.get());
    ClassificationActivity_MembersInjector.injectClassificationContentAdapter(
        instance, provideClassificationContentAdapterProvider.get());
    ClassificationActivity_MembersInjector.injectClassificationList(
        instance, provideClassificationListProvider.get());
    ClassificationActivity_MembersInjector.injectClassificationAdapter(
        instance, classificationAdapterProvider.get());
    ClassificationActivity_MembersInjector.injectBannerList(
        instance, provideBannerListProvider.get());
    ClassificationActivity_MembersInjector.injectLinearLayoutManager1(
        instance,
        ClassificationModule_GetLinearLayoutManagerFactory.proxyGetLinearLayoutManager(
            classificationModule));
    ClassificationActivity_MembersInjector.injectLinearLayoutManager2(
        instance,
        ClassificationModule_GetLinearLayoutManagerFactory.proxyGetLinearLayoutManager(
            classificationModule));
    ClassificationActivity_MembersInjector.injectHeaderView(
        instance, provideHeaderViewProvider.get());
    return instance;
  }

  public static final class Builder {
    private ClassificationModule classificationModule;

    private AppComponent appComponent;

    private Builder() {}

    public ClassificationComponent build() {
      if (classificationModule == null) {
        throw new IllegalStateException(
            ClassificationModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerClassificationComponent(this);
    }

    public Builder classificationModule(ClassificationModule classificationModule) {
      this.classificationModule = Preconditions.checkNotNull(classificationModule);
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
