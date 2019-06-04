package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.adapter.MyAdapter;
import com.wy.adbook.mvp.view.adapter.MyItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModule_MyAdapterFactory implements Factory<MyAdapter> {
  private final MyModule module;

  private final Provider<List<MyItem>> listProvider;

  public MyModule_MyAdapterFactory(MyModule module, Provider<List<MyItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public MyAdapter get() {
    return Preconditions.checkNotNull(
        module.myAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyModule_MyAdapterFactory create(
      MyModule module, Provider<List<MyItem>> listProvider) {
    return new MyModule_MyAdapterFactory(module, listProvider);
  }

  public static MyAdapter proxyMyAdapter(MyModule instance, List<MyItem> list) {
    return Preconditions.checkNotNull(
        instance.myAdapter(list), "Cannot return null from a non-@Nullable @Provides method");
  }
}
