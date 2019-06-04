package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.LoginContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginModule_ProvideAboutViewFactory implements Factory<LoginContract.View> {
  private final LoginModule module;

  public LoginModule_ProvideAboutViewFactory(LoginModule module) {
    this.module = module;
  }

  @Override
  public LoginContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static LoginModule_ProvideAboutViewFactory create(LoginModule module) {
    return new LoginModule_ProvideAboutViewFactory(module);
  }

  public static LoginContract.View proxyProvideAboutView(LoginModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
