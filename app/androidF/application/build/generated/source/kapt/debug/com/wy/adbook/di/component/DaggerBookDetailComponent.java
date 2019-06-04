package com.wy.adbook.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.BookDetailModule;
import com.wy.adbook.di.module.BookDetailModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.BookDetailModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.BookDetailContract;
import com.wy.adbook.mvp.model.BookDetailModel;
import com.wy.adbook.mvp.model.BookDetailModel_Factory;
import com.wy.adbook.mvp.presenter.BookDetailPresenter;
import com.wy.adbook.mvp.presenter.BookDetailPresenter_Factory;
import com.wy.adbook.mvp.view.activity.BookDetailActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBookDetailComponent implements BookDetailComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<BookDetailModel> bookDetailModelProvider;

  private Provider<BookDetailContract.Model> provideAboutModelProvider;

  private Provider<BookDetailContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<BookDetailPresenter> bookDetailPresenterProvider;

  private DaggerBookDetailComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.bookDetailModelProvider =
        DoubleCheck.provider(BookDetailModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            BookDetailModule_ProvideAboutModelFactory.create(
                builder.bookDetailModule, bookDetailModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(
            BookDetailModule_ProvideAboutViewFactory.create(builder.bookDetailModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.bookDetailPresenterProvider =
        DoubleCheck.provider(
            BookDetailPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(BookDetailActivity inject) {
    injectBookDetailActivity(inject);
  }

  private BookDetailActivity injectBookDetailActivity(BookDetailActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, bookDetailPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private BookDetailModule bookDetailModule;

    private AppComponent appComponent;

    private Builder() {}

    public BookDetailComponent build() {
      if (bookDetailModule == null) {
        throw new IllegalStateException(BookDetailModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerBookDetailComponent(this);
    }

    public Builder bookDetailModule(BookDetailModule bookDetailModule) {
      this.bookDetailModule = Preconditions.checkNotNull(bookDetailModule);
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
