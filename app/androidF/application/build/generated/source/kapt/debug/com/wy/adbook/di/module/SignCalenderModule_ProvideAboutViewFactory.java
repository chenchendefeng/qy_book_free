package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SignCalenderContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideAboutViewFactory
    implements Factory<SignCalenderContract.View> {
  private final SignCalenderModule module;

  public SignCalenderModule_ProvideAboutViewFactory(SignCalenderModule module) {
    this.module = module;
  }

  @Override
  public SignCalenderContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideAboutViewFactory create(SignCalenderModule module) {
    return new SignCalenderModule_ProvideAboutViewFactory(module);
  }

  public static SignCalenderContract.View proxyProvideAboutView(SignCalenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
