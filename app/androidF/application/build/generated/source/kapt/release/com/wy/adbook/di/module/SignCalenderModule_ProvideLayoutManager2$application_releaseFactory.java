package com.wy.adbook.di.module;

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideLayoutManager2$application_releaseFactory
    implements Factory<FullyGridLayoutManager> {
  private final SignCalenderModule module;

  public SignCalenderModule_ProvideLayoutManager2$application_releaseFactory(
      SignCalenderModule module) {
    this.module = module;
  }

  @Override
  public FullyGridLayoutManager get() {
    return Preconditions.checkNotNull(
        module.provideLayoutManager2$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideLayoutManager2$application_releaseFactory create(
      SignCalenderModule module) {
    return new SignCalenderModule_ProvideLayoutManager2$application_releaseFactory(module);
  }

  public static FullyGridLayoutManager proxyProvideLayoutManager2$application_release(
      SignCalenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideLayoutManager2$application_release(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
