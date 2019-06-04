package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommonQuestionModule_LinearLayoutFactory
    implements Factory<LinearLayoutManager> {
  private final CommonQuestionModule module;

  public CommonQuestionModule_LinearLayoutFactory(CommonQuestionModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.linearLayout(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static CommonQuestionModule_LinearLayoutFactory create(CommonQuestionModule module) {
    return new CommonQuestionModule_LinearLayoutFactory(module);
  }

  public static LinearLayoutManager proxyLinearLayout(CommonQuestionModule instance) {
    return Preconditions.checkNotNull(
        instance.linearLayout(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
