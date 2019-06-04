package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.LoginContract;
import com.wy.adbook.mvp.model.LoginModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginModule_ProvideAboutModelFactory implements Factory<LoginContract.Model> {
  private final LoginModule module;

  private final Provider<LoginModel> modelProvider;

  public LoginModule_ProvideAboutModelFactory(
      LoginModule module, Provider<LoginModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public LoginContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static LoginModule_ProvideAboutModelFactory create(
      LoginModule module, Provider<LoginModel> modelProvider) {
    return new LoginModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static LoginContract.Model proxyProvideAboutModel(LoginModule instance, LoginModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
