package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.ReadFooterModule;
import com.wy.adbook.di.module.ReadFooterModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.ReadFooterModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.ReadFooterModule_ProvideLinearLayoutFactory;
import com.wy.adbook.di.module.ReadFooterModule_ProvideReadFooterAdapterFactory;
import com.wy.adbook.di.module.ReadFooterModule_ProvideReadFooterItemListFactory;
import com.wy.adbook.mvp.contranct.ReadFooterContract;
import com.wy.adbook.mvp.model.ReadFooterModel;
import com.wy.adbook.mvp.model.ReadFooterModel_Factory;
import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import com.wy.adbook.mvp.presenter.ReadFooterPresenter;
import com.wy.adbook.mvp.presenter.ReadFooterPresenter_Factory;
import com.wy.adbook.mvp.view.activity.ReadFooterActivity;
import com.wy.adbook.mvp.view.activity.ReadFooterActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter;
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
public final class DaggerReadFooterComponent implements ReadFooterComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<ReadFooterModel> readFooterModelProvider;

  private Provider<ReadFooterContract.Model> provideAboutModelProvider;

  private Provider<ReadFooterContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<ReadFooterItem>> provideReadFooterItemListProvider;

  private Provider<ReadFooterAdapter> provideReadFooterAdapterProvider;

  private Provider<ReadFooterPresenter> readFooterPresenterProvider;

  private Provider<LinearLayoutManager> provideLinearLayoutProvider;

  private DaggerReadFooterComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.readFooterModelProvider =
        DoubleCheck.provider(ReadFooterModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            ReadFooterModule_ProvideAboutModelFactory.create(
                builder.readFooterModule, readFooterModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            ReadFooterModule_ProvideAboutViewFactory.create(builder.readFooterModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.provideReadFooterItemListProvider =
        DoubleCheck.provider(
            ReadFooterModule_ProvideReadFooterItemListFactory.create(builder.readFooterModule));
    this.provideReadFooterAdapterProvider =
        DoubleCheck.provider(
            ReadFooterModule_ProvideReadFooterAdapterFactory.create(
                builder.readFooterModule, provideReadFooterItemListProvider));
    this.readFooterPresenterProvider =
        DoubleCheck.provider(
            ReadFooterPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                provideReadFooterItemListProvider,
                provideReadFooterAdapterProvider));
    this.provideLinearLayoutProvider =
        DoubleCheck.provider(
            ReadFooterModule_ProvideLinearLayoutFactory.create(builder.readFooterModule));
  }

  @Override
  public void inject(ReadFooterActivity inject) {
    injectReadFooterActivity(inject);
  }

  private ReadFooterActivity injectReadFooterActivity(ReadFooterActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, readFooterPresenterProvider.get());
    ReadFooterActivity_MembersInjector.injectReadFooterAdapter(
        instance, provideReadFooterAdapterProvider.get());
    ReadFooterActivity_MembersInjector.injectList(
        instance, provideReadFooterItemListProvider.get());
    ReadFooterActivity_MembersInjector.injectLinearLayoutManager(
        instance, provideLinearLayoutProvider.get());
    return instance;
  }

  public static final class Builder {
    private ReadFooterModule readFooterModule;

    private AppComponent appComponent;

    private Builder() {}

    public ReadFooterComponent build() {
      if (readFooterModule == null) {
        throw new IllegalStateException(ReadFooterModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerReadFooterComponent(this);
    }

    public Builder readFooterModule(ReadFooterModule readFooterModule) {
      this.readFooterModule = Preconditions.checkNotNull(readFooterModule);
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
