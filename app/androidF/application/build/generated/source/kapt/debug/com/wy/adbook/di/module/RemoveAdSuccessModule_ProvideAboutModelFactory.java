package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract;
import com.wy.adbook.mvp.model.RemoveAdSuccessModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoveAdSuccessModule_ProvideAboutModelFactory
    implements Factory<RemoveAdSuccessContract.Model> {
  private final RemoveAdSuccessModule module;

  private final Provider<RemoveAdSuccessModel> modelProvider;

  public RemoveAdSuccessModule_ProvideAboutModelFactory(
      RemoveAdSuccessModule module, Provider<RemoveAdSuccessModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public RemoveAdSuccessContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static RemoveAdSuccessModule_ProvideAboutModelFactory create(
      RemoveAdSuccessModule module, Provider<RemoveAdSuccessModel> modelProvider) {
    return new RemoveAdSuccessModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static RemoveAdSuccessContract.Model proxyProvideAboutModel(
      RemoveAdSuccessModule instance, RemoveAdSuccessModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
