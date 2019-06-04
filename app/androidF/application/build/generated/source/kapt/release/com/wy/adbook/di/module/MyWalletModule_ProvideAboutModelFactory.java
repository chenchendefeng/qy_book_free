package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyWalletContract;
import com.wy.adbook.mvp.model.MyWalletModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyWalletModule_ProvideAboutModelFactory
    implements Factory<MyWalletContract.Model> {
  private final MyWalletModule module;

  private final Provider<MyWalletModel> modelProvider;

  public MyWalletModule_ProvideAboutModelFactory(
      MyWalletModule module, Provider<MyWalletModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public MyWalletContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyWalletModule_ProvideAboutModelFactory create(
      MyWalletModule module, Provider<MyWalletModel> modelProvider) {
    return new MyWalletModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static MyWalletContract.Model proxyProvideAboutModel(
      MyWalletModule instance, MyWalletModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
