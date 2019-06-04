package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.view.BasicInfo;
import com.wy.adbook.mvp.view.adapter.BasicInfoAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModule_BasicAdapterFactory implements Factory<BasicInfoAdapter> {
  private final BasicInfoModule module;

  private final Provider<List<BasicInfo>> listProvider;

  public BasicInfoModule_BasicAdapterFactory(
      BasicInfoModule module, Provider<List<BasicInfo>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public BasicInfoAdapter get() {
    return Preconditions.checkNotNull(
        module.basicAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BasicInfoModule_BasicAdapterFactory create(
      BasicInfoModule module, Provider<List<BasicInfo>> listProvider) {
    return new BasicInfoModule_BasicAdapterFactory(module, listProvider);
  }

  public static BasicInfoAdapter proxyBasicAdapter(BasicInfoModule instance, List<BasicInfo> list) {
    return Preconditions.checkNotNull(
        instance.basicAdapter(list), "Cannot return null from a non-@Nullable @Provides method");
  }
}
