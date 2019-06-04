package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.BasicInfoModule;
import com.wy.adbook.di.module.BasicInfoModule_BasicAdapterFactory;
import com.wy.adbook.di.module.BasicInfoModule_LmFactory;
import com.wy.adbook.di.module.BasicInfoModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.BasicInfoModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.BasicInfoModule_ProvideBasicListFactory;
import com.wy.adbook.mvp.contranct.BasicInfoContract;
import com.wy.adbook.mvp.model.BasicInfoModel;
import com.wy.adbook.mvp.model.BasicInfoModel_Factory;
import com.wy.adbook.mvp.model.view.BasicInfo;
import com.wy.adbook.mvp.presenter.BasicInfoPresenter;
import com.wy.adbook.mvp.presenter.BasicInfoPresenter_Factory;
import com.wy.adbook.mvp.view.activity.BasicInfoActivity;
import com.wy.adbook.mvp.view.activity.BasicInfoActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.BasicInfoAdapter;
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
public final class DaggerBasicInfoComponent implements BasicInfoComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<BasicInfoModel> basicInfoModelProvider;

  private Provider<BasicInfoContract.Model> provideAboutModelProvider;

  private Provider<BasicInfoContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<BasicInfoPresenter> basicInfoPresenterProvider;

  private Provider<List<BasicInfo>> provideBasicListProvider;

  private Provider<BasicInfoAdapter> basicAdapterProvider;

  private Provider<LinearLayoutManager> lmProvider;

  private DaggerBasicInfoComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.basicInfoModelProvider =
        DoubleCheck.provider(BasicInfoModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            BasicInfoModule_ProvideAboutModelFactory.create(
                builder.basicInfoModule, basicInfoModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            BasicInfoModule_ProvideAboutViewFactory.create(builder.basicInfoModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.basicInfoPresenterProvider =
        DoubleCheck.provider(
            BasicInfoPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
    this.provideBasicListProvider =
        DoubleCheck.provider(
            BasicInfoModule_ProvideBasicListFactory.create(builder.basicInfoModule));
    this.basicAdapterProvider =
        DoubleCheck.provider(
            BasicInfoModule_BasicAdapterFactory.create(
                builder.basicInfoModule, provideBasicListProvider));
    this.lmProvider =
        DoubleCheck.provider(BasicInfoModule_LmFactory.create(builder.basicInfoModule));
  }

  @Override
  public void inject(BasicInfoActivity inject) {
    injectBasicInfoActivity(inject);
  }

  private BasicInfoActivity injectBasicInfoActivity(BasicInfoActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, basicInfoPresenterProvider.get());
    BasicInfoActivity_MembersInjector.injectBasicInfoAdapter(instance, basicAdapterProvider.get());
    BasicInfoActivity_MembersInjector.injectLlm(instance, lmProvider.get());
    return instance;
  }

  public static final class Builder {
    private BasicInfoModule basicInfoModule;

    private AppComponent appComponent;

    private Builder() {}

    public BasicInfoComponent build() {
      if (basicInfoModule == null) {
        throw new IllegalStateException(BasicInfoModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerBasicInfoComponent(this);
    }

    public Builder basicInfoModule(BasicInfoModule basicInfoModule) {
      this.basicInfoModule = Preconditions.checkNotNull(basicInfoModule);
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
