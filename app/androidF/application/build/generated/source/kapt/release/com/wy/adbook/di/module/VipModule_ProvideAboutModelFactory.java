package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.VipContract;
import com.wy.adbook.mvp.model.VipModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VipModule_ProvideAboutModelFactory implements Factory<VipContract.Model> {
  private final VipModule module;

  private final Provider<VipModel> modelProvider;

  public VipModule_ProvideAboutModelFactory(VipModule module, Provider<VipModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public VipContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static VipModule_ProvideAboutModelFactory create(
      VipModule module, Provider<VipModel> modelProvider) {
    return new VipModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static VipContract.Model proxyProvideAboutModel(VipModule instance, VipModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
