package com.wy.adbook.di.module;

import com.wy.adbook.dialog.WarningDialog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideWarningDialog$application_releaseFactory
    implements Factory<WarningDialog> {
  private final MainModule module;

  public MainModule_ProvideWarningDialog$application_releaseFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public WarningDialog get() {
    return Preconditions.checkNotNull(
        module.provideWarningDialog$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MainModule_ProvideWarningDialog$application_releaseFactory create(
      MainModule module) {
    return new MainModule_ProvideWarningDialog$application_releaseFactory(module);
  }

  public static WarningDialog proxyProvideWarningDialog$application_release(MainModule instance) {
    return Preconditions.checkNotNull(
        instance.provideWarningDialog$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
