package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.BasicInfoContract;
import com.wy.adbook.mvp.model.BasicInfoModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModule_ProvideAboutModelFactory
    implements Factory<BasicInfoContract.Model> {
  private final BasicInfoModule module;

  private final Provider<BasicInfoModel> modelProvider;

  public BasicInfoModule_ProvideAboutModelFactory(
      BasicInfoModule module, Provider<BasicInfoModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public BasicInfoContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BasicInfoModule_ProvideAboutModelFactory create(
      BasicInfoModule module, Provider<BasicInfoModel> modelProvider) {
    return new BasicInfoModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static BasicInfoContract.Model proxyProvideAboutModel(
      BasicInfoModule instance, BasicInfoModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
