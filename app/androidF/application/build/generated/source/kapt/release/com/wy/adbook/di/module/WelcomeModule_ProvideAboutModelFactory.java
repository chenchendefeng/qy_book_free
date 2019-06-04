package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.IWelcomeContract;
import com.wy.adbook.mvp.model.WelcomeModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomeModule_ProvideAboutModelFactory
    implements Factory<IWelcomeContract.Model> {
  private final WelcomeModule module;

  private final Provider<WelcomeModel> modelProvider;

  public WelcomeModule_ProvideAboutModelFactory(
      WelcomeModule module, Provider<WelcomeModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public IWelcomeContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WelcomeModule_ProvideAboutModelFactory create(
      WelcomeModule module, Provider<WelcomeModel> modelProvider) {
    return new WelcomeModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static IWelcomeContract.Model proxyProvideAboutModel(
      WelcomeModule instance, WelcomeModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
