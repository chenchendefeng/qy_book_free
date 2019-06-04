package com.wy.adbook.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModule_ProvideIndicatorListFactory implements Factory<List<String>> {
  private final HelpCenterModule module;

  public HelpCenterModule_ProvideIndicatorListFactory(HelpCenterModule module) {
    this.module = module;
  }

  @Override
  public List<String> get() {
    return Preconditions.checkNotNull(
        module.provideIndicatorList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static HelpCenterModule_ProvideIndicatorListFactory create(HelpCenterModule module) {
    return new HelpCenterModule_ProvideIndicatorListFactory(module);
  }

  public static List<String> proxyProvideIndicatorList(HelpCenterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideIndicatorList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
