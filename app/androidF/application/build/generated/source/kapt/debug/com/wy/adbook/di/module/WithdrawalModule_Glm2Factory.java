package com.wy.adbook.di.module;

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalModule_Glm2Factory implements Factory<FullyGridLayoutManager> {
  private final WithdrawalModule module;

  public WithdrawalModule_Glm2Factory(WithdrawalModule module) {
    this.module = module;
  }

  @Override
  public FullyGridLayoutManager get() {
    return Preconditions.checkNotNull(
        module.glm2(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalModule_Glm2Factory create(WithdrawalModule module) {
    return new WithdrawalModule_Glm2Factory(module);
  }

  public static FullyGridLayoutManager proxyGlm2(WithdrawalModule instance) {
    return Preconditions.checkNotNull(
        instance.glm2(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
