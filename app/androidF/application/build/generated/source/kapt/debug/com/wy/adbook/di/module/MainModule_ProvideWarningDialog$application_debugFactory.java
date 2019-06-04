package com.wy.adbook.di.module;

import com.wy.adbook.dialog.WarningDialog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideWarningDialog$application_debugFactory
    implements Factory<WarningDialog> {
  private final MainModule module;

  public MainModule_ProvideWarningDialog$application_debugFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public WarningDialog get() {
    return Preconditions.checkNotNull(
        module.provideWarningDialog$application_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MainModule_ProvideWarningDialog$application_debugFactory create(MainModule module) {
    return new MainModule_ProvideWarningDialog$application_debugFactory(module);
  }

  public static WarningDialog proxyProvideWarningDialog$application_debug(MainModule instance) {
    return Preconditions.checkNotNull(
        instance.provideWarningDialog$application_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
