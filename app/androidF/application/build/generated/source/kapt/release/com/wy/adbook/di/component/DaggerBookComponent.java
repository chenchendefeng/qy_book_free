package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.BookModule;
import com.wy.adbook.di.module.BookModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.BookModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.BookContract;
import com.wy.adbook.mvp.model.BookModel;
import com.wy.adbook.mvp.model.BookModel_Factory;
import com.wy.adbook.mvp.presenter.BookPresenter;
import com.wy.adbook.mvp.presenter.BookPresenter_Factory;
import com.wy.adbook.mvp.view.fragment.BookFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBookComponent implements BookComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<BookModel> bookModelProvider;

  private Provider<BookContract.Model> provideAboutModelProvider;

  private Provider<BookContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<BookPresenter> bookPresenterProvider;

  private DaggerBookComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.bookModelProvider =
        DoubleCheck.provider(BookModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            BookModule_ProvideAboutModelFactory.create(builder.bookModule, bookModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(BookModule_ProvideAboutViewFactory.create(builder.bookModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.bookPresenterProvider =
        DoubleCheck.provider(
            BookPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(BookFragment inject) {
    injectBookFragment(inject);
  }

  private BookFragment injectBookFragment(BookFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, bookPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private BookModule bookModule;

    private AppComponent appComponent;

    private Builder() {}

    public BookComponent build() {
      if (bookModule == null) {
        throw new IllegalStateException(BookModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerBookComponent(this);
    }

    public Builder bookModule(BookModule bookModule) {
      this.bookModule = Preconditions.checkNotNull(bookModule);
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
