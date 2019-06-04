package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ReadContract;
import com.wy.adbook.mvp.model.ReadModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadModule_ProvideAboutModelFactory implements Factory<ReadContract.Model> {
  private final ReadModule module;

  private final Provider<ReadModel> modelProvider;

  public ReadModule_ProvideAboutModelFactory(ReadModule module, Provider<ReadModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public ReadContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadModule_ProvideAboutModelFactory create(
      ReadModule module, Provider<ReadModel> modelProvider) {
    return new ReadModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static ReadContract.Model proxyProvideAboutModel(ReadModule instance, ReadModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
