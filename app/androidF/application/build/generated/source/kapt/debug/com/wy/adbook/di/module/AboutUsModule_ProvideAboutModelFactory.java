package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.AboutUsContract;
import com.wy.adbook.mvp.model.AboutUsModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsModule_ProvideAboutModelFactory
    implements Factory<AboutUsContract.Model> {
  private final AboutUsModule module;

  private final Provider<AboutUsModel> modelProvider;

  public AboutUsModule_ProvideAboutModelFactory(
      AboutUsModule module, Provider<AboutUsModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public AboutUsContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AboutUsModule_ProvideAboutModelFactory create(
      AboutUsModule module, Provider<AboutUsModel> modelProvider) {
    return new AboutUsModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static AboutUsContract.Model proxyProvideAboutModel(
      AboutUsModule instance, AboutUsModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
