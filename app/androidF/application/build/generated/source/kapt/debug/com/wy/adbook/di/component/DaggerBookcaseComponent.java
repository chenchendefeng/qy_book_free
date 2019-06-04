package com.wy.adbook.di.component;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.BookcaseModule;
import com.wy.adbook.di.module.BookcaseModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.BookcaseModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.BookcaseContract;
import com.wy.adbook.mvp.model.BookcaseModel;
import com.wy.adbook.mvp.model.BookcaseModel_Factory;
import com.wy.adbook.mvp.presenter.BookcasePresenter;
import com.wy.adbook.mvp.presenter.BookcasePresenter_Factory;
import com.wy.adbook.mvp.view.fragment.BookcaseFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBookcaseComponent implements BookcaseComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<BookcaseModel> bookcaseModelProvider;

  private Provider<BookcaseContract.Model> provideAboutModelProvider;

  private Provider<BookcaseContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<BookcasePresenter> bookcasePresenterProvider;

  private DaggerBookcaseComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.bookcaseModelProvider =
        DoubleCheck.provider(BookcaseModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            BookcaseModule_ProvideAboutModelFactory.create(
                builder.bookcaseModule, bookcaseModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(BookcaseModule_ProvideAboutViewFactory.create(builder.bookcaseModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.bookcasePresenterProvider =
        DoubleCheck.provider(
            BookcasePresenter_Factory.create(
                provideAboutModelProvider, provideAboutViewProvider, rxErrorHandlerProvider));
  }

  @Override
  public void inject(BookcaseFragment fragment) {
    injectBookcaseFragment(fragment);
  }

  private BookcaseFragment injectBookcaseFragment(BookcaseFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, bookcasePresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private BookcaseModule bookcaseModule;

    private AppComponent appComponent;

    private Builder() {}

    public BookcaseComponent build() {
      if (bookcaseModule == null) {
        throw new IllegalStateException(BookcaseModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerBookcaseComponent(this);
    }

    public Builder bookcaseModule(BookcaseModule bookcaseModule) {
      this.bookcaseModule = Preconditions.checkNotNull(bookcaseModule);
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
