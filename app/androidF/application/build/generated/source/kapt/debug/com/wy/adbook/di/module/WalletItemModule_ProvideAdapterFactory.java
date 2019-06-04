package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.accout.FlowItem;
import com.wy.adbook.mvp.view.adapter.WalletItemAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemModule_ProvideAdapterFactory implements Factory<WalletItemAdapter> {
  private final WalletItemModule module;

  private final Provider<List<FlowItem>> listProvider;

  public WalletItemModule_ProvideAdapterFactory(
      WalletItemModule module, Provider<List<FlowItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public WalletItemAdapter get() {
    return Preconditions.checkNotNull(
        module.provideAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WalletItemModule_ProvideAdapterFactory create(
      WalletItemModule module, Provider<List<FlowItem>> listProvider) {
    return new WalletItemModule_ProvideAdapterFactory(module, listProvider);
  }

  public static WalletItemAdapter proxyProvideAdapter(
      WalletItemModule instance, List<FlowItem> list) {
    return Preconditions.checkNotNull(
        instance.provideAdapter(list), "Cannot return null from a non-@Nullable @Provides method");
  }
}
