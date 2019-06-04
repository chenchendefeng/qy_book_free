package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordModule_LlmFactory implements Factory<LinearLayoutManager> {
  private final WithdrawalRecordModule module;

  public WithdrawalRecordModule_LlmFactory(WithdrawalRecordModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.llm(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WithdrawalRecordModule_LlmFactory create(WithdrawalRecordModule module) {
    return new WithdrawalRecordModule_LlmFactory(module);
  }

  public static LinearLayoutManager proxyLlm(WithdrawalRecordModule instance) {
    return Preconditions.checkNotNull(
        instance.llm(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
