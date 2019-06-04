package com.wy.adbook.di.component;

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.SignCalenderModule;
import com.wy.adbook.di.module.SignCalenderModule_ContinuousSignInAdapterFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideAttendanceCalendarDataListFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideLayoutManager1$application_debugFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideLayoutManager2$application_debugFactory;
import com.wy.adbook.di.module.SignCalenderModule_ProvideRewardDataListFactory;
import com.wy.adbook.di.module.SignCalenderModule_SignCalendarAdapterFactory;
import com.wy.adbook.mvp.contranct.SignCalenderContract;
import com.wy.adbook.mvp.model.SignCalenderModel;
import com.wy.adbook.mvp.model.SignCalenderModel_Factory;
import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem;
import com.wy.adbook.mvp.model.entity.accout.RewardItem;
import com.wy.adbook.mvp.presenter.SignCalenderPresenter;
import com.wy.adbook.mvp.presenter.SignCalenderPresenter_Factory;
import com.wy.adbook.mvp.view.activity.SignCalenderActivity;
import com.wy.adbook.mvp.view.activity.SignCalenderActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.ContinuousSignInAdapter;
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter;
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
public final class DaggerSignCalenderComponent implements SignCalenderComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<SignCalenderModel> signCalenderModelProvider;

  private Provider<SignCalenderContract.Model> provideAboutModelProvider;

  private Provider<SignCalenderContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<AttendanceCalendarItem>> provideAttendanceCalendarDataListProvider;

  private Provider<SignCalendarAdapter> signCalendarAdapterProvider;

  private Provider<List<RewardItem>> provideRewardDataListProvider;

  private Provider<ContinuousSignInAdapter> continuousSignInAdapterProvider;

  private Provider<SignCalenderPresenter> signCalenderPresenterProvider;

  private Provider<FullyLinearLayoutManager> provideLayoutManager1$application_debugProvider;

  private Provider<FullyGridLayoutManager> provideLayoutManager2$application_debugProvider;

  private DaggerSignCalenderComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.signCalenderModelProvider =
        DoubleCheck.provider(SignCalenderModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideAboutModelFactory.create(
                builder.signCalenderModule, signCalenderModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideAboutViewFactory.create(builder.signCalenderModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.provideAttendanceCalendarDataListProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideAttendanceCalendarDataListFactory.create(
                builder.signCalenderModule));
    this.signCalendarAdapterProvider =
        DoubleCheck.provider(
            SignCalenderModule_SignCalendarAdapterFactory.create(
                builder.signCalenderModule, provideAttendanceCalendarDataListProvider));
    this.provideRewardDataListProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideRewardDataListFactory.create(builder.signCalenderModule));
    this.continuousSignInAdapterProvider =
        DoubleCheck.provider(
            SignCalenderModule_ContinuousSignInAdapterFactory.create(
                builder.signCalenderModule, provideRewardDataListProvider));
    this.signCalenderPresenterProvider =
        DoubleCheck.provider(
            SignCalenderPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                signCalendarAdapterProvider,
                continuousSignInAdapterProvider,
                provideAttendanceCalendarDataListProvider,
                provideRewardDataListProvider));
    this.provideLayoutManager1$application_debugProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideLayoutManager1$application_debugFactory.create(
                builder.signCalenderModule));
    this.provideLayoutManager2$application_debugProvider =
        DoubleCheck.provider(
            SignCalenderModule_ProvideLayoutManager2$application_debugFactory.create(
                builder.signCalenderModule));
  }

  @Override
  public void inject(SignCalenderActivity inject) {
    injectSignCalenderActivity(inject);
  }

  private SignCalenderActivity injectSignCalenderActivity(SignCalenderActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, signCalenderPresenterProvider.get());
    SignCalenderActivity_MembersInjector.injectMLayoutManager1(
        instance, provideLayoutManager1$application_debugProvider.get());
    SignCalenderActivity_MembersInjector.injectMLayoutManager2(
        instance, provideLayoutManager2$application_debugProvider.get());
    SignCalenderActivity_MembersInjector.injectMSignCalendarAdapter(
        instance, signCalendarAdapterProvider.get());
    SignCalenderActivity_MembersInjector.injectMContinuousSignInAdapter(
        instance, continuousSignInAdapterProvider.get());
    return instance;
  }

  public static final class Builder {
    private SignCalenderModule signCalenderModule;

    private AppComponent appComponent;

    private Builder() {}

    public SignCalenderComponent build() {
      if (signCalenderModule == null) {
        throw new IllegalStateException(
            SignCalenderModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSignCalenderComponent(this);
    }

    public Builder signCalenderModule(SignCalenderModule signCalenderModule) {
      this.signCalenderModule = Preconditions.checkNotNull(signCalenderModule);
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
