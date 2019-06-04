package com.wy.adbook.di.component;

import android.support.v7.widget.LinearLayoutManager;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.di.module.MyFriendModule;
import com.wy.adbook.di.module.MyFriendModule_FriendListFactory;
import com.wy.adbook.di.module.MyFriendModule_LinearLayoutManagerFactory;
import com.wy.adbook.di.module.MyFriendModule_ProvideAboutModelFactory;
import com.wy.adbook.di.module.MyFriendModule_ProvideAboutViewFactory;
import com.wy.adbook.di.module.MyFriendModule_ProvideMyFriendAdapterFactory;
import com.wy.adbook.mvp.contranct.MyFriendContract;
import com.wy.adbook.mvp.model.MyFriendModel;
import com.wy.adbook.mvp.model.MyFriendModel_Factory;
import com.wy.adbook.mvp.model.entity.FriendItem;
import com.wy.adbook.mvp.presenter.MyFriendPresenter;
import com.wy.adbook.mvp.presenter.MyFriendPresenter_Factory;
import com.wy.adbook.mvp.view.activity.MyFriendActivity;
import com.wy.adbook.mvp.view.activity.MyFriendActivity_MembersInjector;
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter;
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
public final class DaggerMyFriendComponent implements MyFriendComponent {
  private com_jess_arms_di_component_AppComponent_repositoryManager repositoryManagerProvider;

  private Provider<MyFriendModel> myFriendModelProvider;

  private Provider<MyFriendContract.Model> provideAboutModelProvider;

  private Provider<MyFriendContract.View> provideAboutViewProvider;

  private com_jess_arms_di_component_AppComponent_rxErrorHandler rxErrorHandlerProvider;

  private Provider<List<FriendItem>> friendListProvider;

  private Provider<MyFriendAdapter> provideMyFriendAdapterProvider;

  private Provider<MyFriendPresenter> myFriendPresenterProvider;

  private Provider<LinearLayoutManager> linearLayoutManagerProvider;

  private DaggerMyFriendComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.repositoryManagerProvider =
        new com_jess_arms_di_component_AppComponent_repositoryManager(builder.appComponent);
    this.myFriendModelProvider =
        DoubleCheck.provider(MyFriendModel_Factory.create(repositoryManagerProvider));
    this.provideAboutModelProvider =
        DoubleCheck.provider(
            MyFriendModule_ProvideAboutModelFactory.create(
                builder.myFriendModule, myFriendModelProvider));
    this.provideAboutViewProvider =
        DoubleCheck.provider(MyFriendModule_ProvideAboutViewFactory.create(builder.myFriendModule));
    this.rxErrorHandlerProvider =
        new com_jess_arms_di_component_AppComponent_rxErrorHandler(builder.appComponent);
    this.friendListProvider =
        DoubleCheck.provider(MyFriendModule_FriendListFactory.create(builder.myFriendModule));
    this.provideMyFriendAdapterProvider =
        DoubleCheck.provider(
            MyFriendModule_ProvideMyFriendAdapterFactory.create(
                builder.myFriendModule, friendListProvider));
    this.myFriendPresenterProvider =
        DoubleCheck.provider(
            MyFriendPresenter_Factory.create(
                provideAboutModelProvider,
                provideAboutViewProvider,
                rxErrorHandlerProvider,
                provideMyFriendAdapterProvider,
                friendListProvider));
    this.linearLayoutManagerProvider =
        DoubleCheck.provider(
            MyFriendModule_LinearLayoutManagerFactory.create(builder.myFriendModule));
  }

  @Override
  public void inject(MyFriendActivity inject) {
    injectMyFriendActivity(inject);
  }

  private MyFriendActivity injectMyFriendActivity(MyFriendActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, myFriendPresenterProvider.get());
    MyFriendActivity_MembersInjector.injectFriendAdapter(
        instance, provideMyFriendAdapterProvider.get());
    MyFriendActivity_MembersInjector.injectLinearLayoutManager(
        instance, linearLayoutManagerProvider.get());
    return instance;
  }

  public static final class Builder {
    private MyFriendModule myFriendModule;

    private AppComponent appComponent;

    private Builder() {}

    public MyFriendComponent build() {
      if (myFriendModule == null) {
        throw new IllegalStateException(MyFriendModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMyFriendComponent(this);
    }

    public Builder myFriendModule(MyFriendModule myFriendModule) {
      this.myFriendModule = Preconditions.checkNotNull(myFriendModule);
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
