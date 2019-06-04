package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.FeedbackModule;
import com.wy.adbook.di.module.FeedbackModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.FeedbackModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.FeedbackContract;
import com.wy.adbook.mvp.model.FeedbackModel;
import com.wy.adbook.mvp.model.FeedbackModel_Factory;
import com.wy.adbook.mvp.presenter.FeedbackPresenter;
import com.wy.adbook.mvp.presenter.FeedbackPresenter_Factory;
import com.wy.adbook.mvp.view.fragment.FeedbackFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFeedbackComponent implements FeedbackComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<FeedbackModel> feedbackModelProvider;

  private Provider<FeedbackContract.Model> provideAboutModelProvider;

  private Provider<FeedbackContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<FeedbackPresenter> feedbackPresenterProvider;

  private DaggerFeedbackComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.feedbackModelProvider =
        DoubleCheck.provider(FeedbackModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            FeedbackModule_ProvideAboutModelFactory.create(
                builder.feedbackModule, feedbackModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(FeedbackModule_ProvideAboutViewFactory.create(builder.feedbackModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.feedbackPresenterProvider =
        DoubleCheck.provider(
            FeedbackPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(FeedbackFragment inject) {
    injectFeedbackFragment(inject);
  }

  private FeedbackFragment injectFeedbackFragment(FeedbackFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, feedbackPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private FeedbackModule feedbackModule;

    private AppComponent appComponent;

    private Builder() {}

    public FeedbackComponent build() {
      if (feedbackModule == null) {
        throw new IllegalStateException(FeedbackModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFeedbackComponent(this);
    }

    public Builder feedbackModule(FeedbackModule feedbackModule) {
      this.feedbackModule = Preconditions.checkNotNull(feedbackModule);
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
