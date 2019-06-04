package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.GenderContract;
import com.wy.adbook.mvp.model.GenderModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderModule_ProvideAboutModelFactory implements Factory<GenderContract.Model> {
  private final GenderModule module;

  private final Provider<GenderModel> modelProvider;

  public GenderModule_ProvideAboutModelFactory(
      GenderModule module, Provider<GenderModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public GenderContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static GenderModule_ProvideAboutModelFactory create(
      GenderModule module, Provider<GenderModel> modelProvider) {
    return new GenderModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static GenderContract.Model proxyProvideAboutModel(
      GenderModule instance, GenderModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
