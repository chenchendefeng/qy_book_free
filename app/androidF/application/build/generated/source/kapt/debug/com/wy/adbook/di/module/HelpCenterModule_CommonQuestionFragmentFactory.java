package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModule_CommonQuestionFragmentFactory
    implements Factory<CommonQuestionFragment> {
  private final HelpCenterModule module;

  public HelpCenterModule_CommonQuestionFragmentFactory(HelpCenterModule module) {
    this.module = module;
  }

  @Override
  public CommonQuestionFragment get() {
    return Preconditions.checkNotNull(
        module.commonQuestionFragment(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static HelpCenterModule_CommonQuestionFragmentFactory create(HelpCenterModule module) {
    return new HelpCenterModule_CommonQuestionFragmentFactory(module);
  }

  public static CommonQuestionFragment proxyCommonQuestionFragment(HelpCenterModule instance) {
    return Preconditions.checkNotNull(
        instance.commonQuestionFragment(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
