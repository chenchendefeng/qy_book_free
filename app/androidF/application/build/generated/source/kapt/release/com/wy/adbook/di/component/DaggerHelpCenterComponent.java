package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.HelpCenterModule;
import com.wy.adbook.di.module.HelpCenterModule_CommonQuestionFragmentFactory;
import com.wy.adbook.di.module.HelpCenterModule_FeedbackFragmentFactory;
import com.wy.adbook.di.module.HelpCenterModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.HelpCenterModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.HelpCenterModule_ProvideIndicatorListFactory;
import com.wy.adbook.mvp.contranct.HelpCenterContract;
import com.wy.adbook.mvp.model.HelpCenterModel;
import com.wy.adbook.mvp.model.HelpCenterModel_Factory;
import com.wy.adbook.mvp.presenter.HelpCenterPresenter;
import com.wy.adbook.mvp.presenter.HelpCenterPresenter_Factory;
import com.wy.adbook.mvp.view.activity.HelpCenterActivity;
import com.wy.adbook.mvp.view.activity.HelpCenterActivity_MembersInjector;
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment;
import com.wy.adbook.mvp.view.fragment.FeedbackFragment;
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
public final class DaggerHelpCenterComponent implements HelpCenterComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<HelpCenterModel> helpCenterModelProvider;

  private Provider<HelpCenterContract.Model> provideAboutModelProvider;

  private Provider<HelpCenterContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<HelpCenterPresenter> helpCenterPresenterProvider;

  private Provider<List<String>> provideIndicatorListProvider;

  private Provider<CommonQuestionFragment> commonQuestionFragmentProvider;

  private Provider<FeedbackFragment> feedbackFragmentProvider;

  private DaggerHelpCenterComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.helpCenterModelProvider =
        DoubleCheck.provider(HelpCenterModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            HelpCenterModule_ProvideAboutModelFactory.create(
                builder.helpCenterModule, helpCenterModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            HelpCenterModule_ProvideAboutViewFactory.create(builder.helpCenterModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.helpCenterPresenterProvider =
        DoubleCheck.provider(
            HelpCenterPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
    this.provideIndicatorListProvider =
        DoubleCheck.provider(
            HelpCenterModule_ProvideIndicatorListFactory.create(builder.helpCenterModule));
    this.commonQuestionFragmentProvider =
        DoubleCheck.provider(
            HelpCenterModule_CommonQuestionFragmentFactory.create(builder.helpCenterModule));
    this.feedbackFragmentProvider =
        DoubleCheck.provider(
            HelpCenterModule_FeedbackFragmentFactory.create(builder.helpCenterModule));
  }

  @Override
  public void inject(HelpCenterActivity inject) {
    injectHelpCenterActivity(inject);
  }

  private HelpCenterActivity injectHelpCenterActivity(HelpCenterActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, helpCenterPresenterProvider.get());
    HelpCenterActivity_MembersInjector.injectIndicatorList(
        instance, provideIndicatorListProvider.get());
    HelpCenterActivity_MembersInjector.injectCommonQuestionFragment(
        instance, commonQuestionFragmentProvider.get());
    HelpCenterActivity_MembersInjector.injectFeedbackFragment(
        instance, feedbackFragmentProvider.get());
    return instance;
  }

  public static final class Builder {
    private HelpCenterModule helpCenterModule;

    private AppComponent appComponent;

    private Builder() {}

    public HelpCenterComponent build() {
      if (helpCenterModule == null) {
        throw new IllegalStateException(HelpCenterModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerHelpCenterComponent(this);
    }

    public Builder helpCenterModule(HelpCenterModule helpCenterModule) {
      this.helpCenterModule = Preconditions.checkNotNull(helpCenterModule);
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
