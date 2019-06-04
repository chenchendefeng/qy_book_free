package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.BannerItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationModule_ProvideBannerListFactory
    implements Factory<List<BannerItem>> {
  private final ClassificationModule module;

  public ClassificationModule_ProvideBannerListFactory(ClassificationModule module) {
    this.module = module;
  }

  @Override
  public List<BannerItem> get() {
    return Preconditions.checkNotNull(
        module.provideBannerList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ClassificationModule_ProvideBannerListFactory create(ClassificationModule module) {
    return new ClassificationModule_ProvideBannerListFactory(module);
  }

  public static List<BannerItem> proxyProvideBannerList(ClassificationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideBannerList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
