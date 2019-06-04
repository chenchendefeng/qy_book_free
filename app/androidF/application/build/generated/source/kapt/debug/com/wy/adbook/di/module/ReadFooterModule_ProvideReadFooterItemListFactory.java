package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModule_ProvideReadFooterItemListFactory
    implements Factory<List<ReadFooterItem>> {
  private final ReadFooterModule module;

  public ReadFooterModule_ProvideReadFooterItemListFactory(ReadFooterModule module) {
    this.module = module;
  }

  @Override
  public List<ReadFooterItem> get() {
    return Preconditions.checkNotNull(
        module.provideReadFooterItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadFooterModule_ProvideReadFooterItemListFactory create(ReadFooterModule module) {
    return new ReadFooterModule_ProvideReadFooterItemListFactory(module);
  }

  public static List<ReadFooterItem> proxyProvideReadFooterItemList(ReadFooterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideReadFooterItemList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
