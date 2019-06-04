package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MainContract;
import com.wy.adbook.mvp.model.MainModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideAboutModelFactory implements Factory<MainContract.Model> {
  private final MainModule module;

  private final Provider<MainModel> modelProvider;

  public MainModule_ProvideAboutModelFactory(MainModule module, Provider<MainModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public MainContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MainModule_ProvideAboutModelFactory create(
      MainModule module, Provider<MainModel> modelProvider) {
    return new MainModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static MainContract.Model proxyProvideAboutModel(MainModule instance, MainModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
