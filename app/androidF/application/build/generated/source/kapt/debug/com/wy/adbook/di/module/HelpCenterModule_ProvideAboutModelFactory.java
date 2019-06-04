package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.HelpCenterContract;
import com.wy.adbook.mvp.model.HelpCenterModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModule_ProvideAboutModelFactory
    implements Factory<HelpCenterContract.Model> {
  private final HelpCenterModule module;

  private final Provider<HelpCenterModel> modelProvider;

  public HelpCenterModule_ProvideAboutModelFactory(
      HelpCenterModule module, Provider<HelpCenterModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public HelpCenterContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static HelpCenterModule_ProvideAboutModelFactory create(
      HelpCenterModule module, Provider<HelpCenterModel> modelProvider) {
    return new HelpCenterModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static HelpCenterContract.Model proxyProvideAboutModel(
      HelpCenterModule instance, HelpCenterModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
