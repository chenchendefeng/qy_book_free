package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.fragment.FeedbackFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModule_FeedbackFragmentFactory implements Factory<FeedbackFragment> {
  private final HelpCenterModule module;

  public HelpCenterModule_FeedbackFragmentFactory(HelpCenterModule module) {
    this.module = module;
  }

  @Override
  public FeedbackFragment get() {
    return Preconditions.checkNotNull(
        module.feedbackFragment(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static HelpCenterModule_FeedbackFragmentFactory create(HelpCenterModule module) {
    return new HelpCenterModule_FeedbackFragmentFactory(module);
  }

  public static FeedbackFragment proxyFeedbackFragment(HelpCenterModule instance) {
    return Preconditions.checkNotNull(
        instance.feedbackFragment(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
