package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SignCalenderContract;
import com.wy.adbook.mvp.model.SignCalenderModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideAboutModelFactory
    implements Factory<SignCalenderContract.Model> {
  private final SignCalenderModule module;

  private final Provider<SignCalenderModel> modelProvider;

  public SignCalenderModule_ProvideAboutModelFactory(
      SignCalenderModule module, Provider<SignCalenderModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public SignCalenderContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideAboutModelFactory create(
      SignCalenderModule module, Provider<SignCalenderModel> modelProvider) {
    return new SignCalenderModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static SignCalenderContract.Model proxyProvideAboutModel(
      SignCalenderModule instance, SignCalenderModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
