package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.view.BasicInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModule_ProvideBasicListFactory implements Factory<List<BasicInfo>> {
  private final BasicInfoModule module;

  public BasicInfoModule_ProvideBasicListFactory(BasicInfoModule module) {
    this.module = module;
  }

  @Override
  public List<BasicInfo> get() {
    return Preconditions.checkNotNull(
        module.provideBasicList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BasicInfoModule_ProvideBasicListFactory create(BasicInfoModule module) {
    return new BasicInfoModule_ProvideBasicListFactory(module);
  }

  public static List<BasicInfo> proxyProvideBasicList(BasicInfoModule instance) {
    return Preconditions.checkNotNull(
        instance.provideBasicList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
