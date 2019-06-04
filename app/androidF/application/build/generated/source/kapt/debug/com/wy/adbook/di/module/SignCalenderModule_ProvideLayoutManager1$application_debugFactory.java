package com.wy.adbook.di.module;

import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideLayoutManager1$application_debugFactory
    implements Factory<FullyLinearLayoutManager> {
  private final SignCalenderModule module;

  public SignCalenderModule_ProvideLayoutManager1$application_debugFactory(
      SignCalenderModule module) {
    this.module = module;
  }

  @Override
  public FullyLinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.provideLayoutManager1$application_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideLayoutManager1$application_debugFactory create(
      SignCalenderModule module) {
    return new SignCalenderModule_ProvideLayoutManager1$application_debugFactory(module);
  }

  public static FullyLinearLayoutManager proxyProvideLayoutManager1$application_debug(
      SignCalenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideLayoutManager1$application_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
