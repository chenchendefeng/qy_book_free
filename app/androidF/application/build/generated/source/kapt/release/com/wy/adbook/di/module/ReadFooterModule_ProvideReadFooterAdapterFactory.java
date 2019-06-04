package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.ReadFooterItem;
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModule_ProvideReadFooterAdapterFactory
    implements Factory<ReadFooterAdapter> {
  private final ReadFooterModule module;

  private final Provider<List<ReadFooterItem>> listProvider;

  public ReadFooterModule_ProvideReadFooterAdapterFactory(
      ReadFooterModule module, Provider<List<ReadFooterItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public ReadFooterAdapter get() {
    return Preconditions.checkNotNull(
        module.provideReadFooterAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadFooterModule_ProvideReadFooterAdapterFactory create(
      ReadFooterModule module, Provider<List<ReadFooterItem>> listProvider) {
    return new ReadFooterModule_ProvideReadFooterAdapterFactory(module, listProvider);
  }

  public static ReadFooterAdapter proxyProvideReadFooterAdapter(
      ReadFooterModule instance, List<ReadFooterItem> list) {
    return Preconditions.checkNotNull(
        instance.provideReadFooterAdapter(list),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
