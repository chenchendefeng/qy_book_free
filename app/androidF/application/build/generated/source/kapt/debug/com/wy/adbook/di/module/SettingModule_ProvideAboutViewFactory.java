package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.SettingContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingModule_ProvideAboutViewFactory implements Factory<SettingContract.View> {
  private final SettingModule module;

  public SettingModule_ProvideAboutViewFactory(SettingModule module) {
    this.module = module;
  }

  @Override
  public SettingContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SettingModule_ProvideAboutViewFactory create(SettingModule module) {
    return new SettingModule_ProvideAboutViewFactory(module);
  }

  public static SettingContract.View proxyProvideAboutView(SettingModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
