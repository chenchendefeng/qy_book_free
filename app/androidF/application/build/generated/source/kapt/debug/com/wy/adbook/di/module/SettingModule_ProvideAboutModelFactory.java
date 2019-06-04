package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SettingContract;
import com.wy.adbook.mvp.model.SettingModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingModule_ProvideAboutModelFactory
    implements Factory<SettingContract.Model> {
  private final SettingModule module;

  private final Provider<SettingModel> modelProvider;

  public SettingModule_ProvideAboutModelFactory(
      SettingModule module, Provider<SettingModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public SettingContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SettingModule_ProvideAboutModelFactory create(
      SettingModule module, Provider<SettingModel> modelProvider) {
    return new SettingModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static SettingContract.Model proxyProvideAboutModel(
      SettingModule instance, SettingModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
