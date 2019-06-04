package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ReadFooterContract;
import com.wy.adbook.mvp.model.ReadFooterModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModule_ProvideAboutModelFactory
    implements Factory<ReadFooterContract.Model> {
  private final ReadFooterModule module;

  private final Provider<ReadFooterModel> modelProvider;

  public ReadFooterModule_ProvideAboutModelFactory(
      ReadFooterModule module, Provider<ReadFooterModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public ReadFooterContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadFooterModule_ProvideAboutModelFactory create(
      ReadFooterModule module, Provider<ReadFooterModel> modelProvider) {
    return new ReadFooterModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static ReadFooterContract.Model proxyProvideAboutModel(
      ReadFooterModule instance, ReadFooterModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
