package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.di.module.MyModule;
import com.wy.adbook.di.module.MyModule_LmFactory;
import com.wy.adbook.di.module.MyModule_MyAdapterFactory;
import com.wy.adbook.di.module.MyModule_MyItemListFactory;
import com.wy.adbook.di.module.MyModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.MyModule_ProvideAboutViewFactory;
import com.wy.adbook.mvp.contranct.MyContract;
import com.wy.adbook.mvp.model.MyModel;
import com.wy.adbook.mvp.model.MyModel_Factory;
import com.wy.adbook.mvp.presenter.MyPresenter;
import com.wy.adbook.mvp.presenter.MyPresenter_Factory;
import com.wy.adbook.mvp.view.adapter.MyAdapter;
import com.wy.adbook.mvp.view.adapter.MyItem;
import com.wy.adbook.mvp.view.fragment.MyFragment;
import com.wy.adbook.mvp.view.fragment.MyFragment_MembersInjector;
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
public final class DaggerMyComponent implements MyComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<MyModel> myModelProvider;

  private Provider<MyContract.Model> provideAboutModelProvider;

  private Provider<MyContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<MyItem>> myItemListProvider;

  private Provider<MyAdapter> myAdapterProvider;

  private Provider<MyPresenter> myPresenterProvider;

  private Provider<LinearLayoutManager> lmProvider;

  private DaggerMyComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.myModelProvider = DoubleCheck.provider(MyModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            MyModule_ProvideAboutModelFactory.create(builder.myModule, myModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(MyModule_ProvideAboutViewFactory.create(builder.myModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.myItemListProvider =
        DoubleCheck.provider(MyModule_MyItemListFactory.create(builder.myModule));
    this.myAdapterProvider =
        DoubleCheck.provider(
            MyModule_MyAdapterFactory.create(builder.myModule, myItemListProvider));
    this.myPresenterProvider =
        DoubleCheck.provider(
            MyPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                myAdapterProvider,
                myItemListProvider));
    this.lmProvider = DoubleCheck.provider(MyModule_LmFactory.create(builder.myModule));
  }

  @Override
  public void inject(MyFragment fragment) {
    injectMyFragment(fragment);
  }

  private MyFragment injectMyFragment(MyFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, myPresenterProvider.get());
    MyFragment_MembersInjector.injectMyAdapter(instance, myAdapterProvider.get());
    MyFragment_MembersInjector.injectLinearLayoutManager(instance, lmProvider.get());
    return instance;
  }

  public static final class Builder {
    private MyModule myModule;

    private AppComponent appComponent;

    private Builder() {}

    public MyComponent build() {
      if (myModule == null) {
        throw new IllegalStateException(MyModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMyComponent(this);
    }

    public Builder myModule(MyModule myModule) {
      this.myModule = Preconditions.checkNotNull(myModule);
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
