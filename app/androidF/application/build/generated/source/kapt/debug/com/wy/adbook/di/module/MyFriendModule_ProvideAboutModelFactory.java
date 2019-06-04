package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyFriendContract;
import com.wy.adbook.mvp.model.MyFriendModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModule_ProvideAboutModelFactory
    implements Factory<MyFriendContract.Model> {
  private final MyFriendModule module;

  private final Provider<MyFriendModel> modelProvider;

  public MyFriendModule_ProvideAboutModelFactory(
      MyFriendModule module, Provider<MyFriendModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public MyFriendContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyFriendModule_ProvideAboutModelFactory create(
      MyFriendModule module, Provider<MyFriendModel> modelProvider) {
    return new MyFriendModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static MyFriendContract.Model proxyProvideAboutModel(
      MyFriendModule instance, MyFriendModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
