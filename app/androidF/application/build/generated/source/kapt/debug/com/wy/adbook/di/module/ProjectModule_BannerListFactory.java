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
public final class ProjectModule_BannerListFactory implements Factory<List<BannerItem>> {
  private final ProjectModule module;

  public ProjectModule_BannerListFactory(ProjectModule module) {
    this.module = module;
  }

  @Override
  public List<BannerItem> get() {
    return Preconditions.checkNotNull(
        module.bannerList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ProjectModule_BannerListFactory create(ProjectModule module) {
    return new ProjectModule_BannerListFactory(module);
  }

  public static List<BannerItem> proxyBannerList(ProjectModule instance) {
    return Preconditions.checkNotNull(
        instance.bannerList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
