package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.CommonQuestionModule;
import com.wy.adbook.di.module.CommonQuestionModule_LinearLayoutFactory;
import com.wy.adbook.di.module.CommonQuestionModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.CommonQuestionModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.CommonQuestionModule_ProvideCommonQuestionAdapterFactory;
import com.wy.adbook.di.module.CommonQuestionModule_ProvideFaqListFactory;
import com.wy.adbook.mvp.contranct.CommonQuestionContract;
import com.wy.adbook.mvp.model.CommonQuestionModel;
import com.wy.adbook.mvp.model.CommonQuestionModel_Factory;
import com.wy.adbook.mvp.model.entity.FaqItem;
import com.wy.adbook.mvp.presenter.CommonQuestionPresenter;
import com.wy.adbook.mvp.presenter.CommonQuestionPresenter_Factory;
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter;
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment;
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment_MembersInjector;
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
public final class DaggerCommonQuestionComponent implements CommonQuestionComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<CommonQuestionModel> commonQuestionModelProvider;

  private Provider<CommonQuestionContract.Model> provideAboutModelProvider;

  private Provider<CommonQuestionContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<FaqItem>> provideFaqListProvider;

  private Provider<CommonQuestionAdapter> provideCommonQuestionAdapterProvider;

  private Provider<CommonQuestionPresenter> commonQuestionPresenterProvider;

  private Provider<LinearLayoutManager> linearLayoutProvider;

  private DaggerCommonQuestionComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.commonQuestionModelProvider =
        DoubleCheck.provider(CommonQuestionModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            CommonQuestionModule_ProvideAboutModelFactory.create(
                builder.commonQuestionModule, commonQuestionModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            CommonQuestionModule_ProvideAboutViewFactory.create(builder.commonQuestionModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.provideFaqListProvider =
        DoubleCheck.provider(
            CommonQuestionModule_ProvideFaqListFactory.create(builder.commonQuestionModule));
    this.provideCommonQuestionAdapterProvider =
        DoubleCheck.provider(
            CommonQuestionModule_ProvideCommonQuestionAdapterFactory.create(
                builder.commonQuestionModule, provideFaqListProvider));
    this.commonQuestionPresenterProvider =
        DoubleCheck.provider(
            CommonQuestionPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                provideCommonQuestionAdapterProvider,
                provideFaqListProvider));
    this.linearLayoutProvider =
        DoubleCheck.provider(
            CommonQuestionModule_LinearLayoutFactory.create(builder.commonQuestionModule));
  }

  @Override
  public void inject(CommonQuestionFragment inject) {
    injectCommonQuestionFragment(inject);
  }

  private CommonQuestionFragment injectCommonQuestionFragment(CommonQuestionFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, commonQuestionPresenterProvider.get());
    CommonQuestionFragment_MembersInjector.injectCommonQuestionAdapter(
        instance, provideCommonQuestionAdapterProvider.get());
    CommonQuestionFragment_MembersInjector.injectLinearLayoutManager(
        instance, linearLayoutProvider.get());
    CommonQuestionFragment_MembersInjector.injectFaqList(instance, provideFaqListProvider.get());
    return instance;
  }

  public static final class Builder {
    private CommonQuestionModule commonQuestionModule;

    private AppComponent appComponent;

    private Builder() {}

    public CommonQuestionComponent build() {
      if (commonQuestionModule == null) {
        throw new IllegalStateException(
            CommonQuestionModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerCommonQuestionComponent(this);
    }

    public Builder commonQuestionModule(CommonQuestionModule commonQuestionModule) {
      this.commonQuestionModule = Preconditions.checkNotNull(commonQuestionModule);
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
