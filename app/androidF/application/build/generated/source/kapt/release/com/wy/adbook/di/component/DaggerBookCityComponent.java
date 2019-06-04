package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.BookCityModule;
import com.wy.adbook.di.module.BookCityModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.BookCityModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.BookCityContract;
import com.wy.adbook.mvp.model.BookCityModel;
import com.wy.adbook.mvp.model.BookCityModel_Factory;
import com.wy.adbook.mvp.presenter.BookCityPresenter;
import com.wy.adbook.mvp.presenter.BookCityPresenter_Factory;
import com.wy.adbook.mvp.view.fragment.BookCityFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBookCityComponent implements BookCityComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<BookCityModel> bookCityModelProvider;

  private Provider<BookCityContract.Model> provideAboutModelProvider;

  private Provider<BookCityContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<BookCityPresenter> bookCityPresenterProvider;

  private DaggerBookCityComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.bookCityModelProvider =
        DoubleCheck.provider(BookCityModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            BookCityModule_ProvideAboutModelFactory.create(
                builder.bookCityModule, bookCityModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(BookCityModule_ProvideAboutViewFactory.create(builder.bookCityModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.bookCityPresenterProvider =
        DoubleCheck.provider(
            BookCityPresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(BookCityFragment fragment) {
    injectBookCityFragment(fragment);
  }

  private BookCityFragment injectBookCityFragment(BookCityFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, bookCityPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private BookCityModule bookCityModule;

    private AppComponent appComponent;

    private Builder() {}

    public BookCityComponent build() {
      if (bookCityModule == null) {
        throw new IllegalStateException(BookCityModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerBookCityComponent(this);
    }

    public Builder bookCityModule(BookCityModule bookCityModule) {
      this.bookCityModule = Preconditions.checkNotNull(bookCityModule);
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
