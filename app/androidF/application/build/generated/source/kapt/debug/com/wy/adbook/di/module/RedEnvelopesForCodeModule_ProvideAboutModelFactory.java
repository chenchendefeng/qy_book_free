package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract;
import com.wy.adbook.mvp.model.RedEnvelopesForCodeModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedEnvelopesForCodeModule_ProvideAboutModelFactory
    implements Factory<RedEnvelopesForCodeContract.Model> {
  private final RedEnvelopesForCodeModule module;

  private final Provider<RedEnvelopesForCodeModel> modelProvider;

  public RedEnvelopesForCodeModule_ProvideAboutModelFactory(
      RedEnvelopesForCodeModule module, Provider<RedEnvelopesForCodeModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public RedEnvelopesForCodeContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static RedEnvelopesForCodeModule_ProvideAboutModelFactory create(
      RedEnvelopesForCodeModule module, Provider<RedEnvelopesForCodeModel> modelProvider) {
    return new RedEnvelopesForCodeModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static RedEnvelopesForCodeContract.Model proxyProvideAboutModel(
      RedEnvelopesForCodeModule instance, RedEnvelopesForCodeModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
