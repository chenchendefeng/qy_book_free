package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.accout.RewardItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideRewardDataListFactory
    implements Factory<List<RewardItem>> {
  private final SignCalenderModule module;

  public SignCalenderModule_ProvideRewardDataListFactory(SignCalenderModule module) {
    this.module = module;
  }

  @Override
  public List<RewardItem> get() {
    return Preconditions.checkNotNull(
        module.provideRewardDataList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideRewardDataListFactory create(SignCalenderModule module) {
    return new SignCalenderModule_ProvideRewardDataListFactory(module);
  }

  public static List<RewardItem> proxyProvideRewardDataList(SignCalenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideRewardDataList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
