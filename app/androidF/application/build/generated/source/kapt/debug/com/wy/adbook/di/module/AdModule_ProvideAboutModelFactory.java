package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.AdContract;
import com.wy.adbook.mvp.model.AdModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdModule_ProvideAboutModelFactory implements Factory<AdContract.Model> {
  private final AdModule module;

  private final Provider<AdModel> modelProvider;

  public AdModule_ProvideAboutModelFactory(AdModule module, Provider<AdModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public AdContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AdModule_ProvideAboutModelFactory create(
      AdModule module, Provider<AdModel> modelProvider) {
    return new AdModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static AdContract.Model proxyProvideAboutModel(AdModule instance, AdModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
