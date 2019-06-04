package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WelfareContract;
import com.wy.adbook.mvp.model.WelfareModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelfareModule_ProvideAboutModelFactory
    implements Factory<WelfareContract.Model> {
  private final WelfareModule module;

  private final Provider<WelfareModel> modelProvider;

  public WelfareModule_ProvideAboutModelFactory(
      WelfareModule module, Provider<WelfareModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public WelfareContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WelfareModule_ProvideAboutModelFactory create(
      WelfareModule module, Provider<WelfareModel> modelProvider) {
    return new WelfareModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static WelfareContract.Model proxyProvideAboutModel(
      WelfareModule instance, WelfareModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
