package com.wy.adbook.di.module;

import com.wy.adbook.dialog.WarningDialog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderModule_ProvideWarningDialog$application_releaseFactory
    implements Factory<WarningDialog> {
  private final GenderModule module;

  public GenderModule_ProvideWarningDialog$application_releaseFactory(GenderModule module) {
    this.module = module;
  }

  @Override
  public WarningDialog get() {
    return Preconditions.checkNotNull(
        module.provideWarningDialog$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static GenderModule_ProvideWarningDialog$application_releaseFactory create(
      GenderModule module) {
    return new GenderModule_ProvideWarningDialog$application_releaseFactory(module);
  }

  public static WarningDialog proxyProvideWarningDialog$application_release(GenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideWarningDialog$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
