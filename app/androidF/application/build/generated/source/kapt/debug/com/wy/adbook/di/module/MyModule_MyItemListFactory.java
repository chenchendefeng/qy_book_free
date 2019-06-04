package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.adapter.MyItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModule_MyItemListFactory implements Factory<List<MyItem>> {
  private final MyModule module;

  public MyModule_MyItemListFactory(MyModule module) {
    this.module = module;
  }

  @Override
  public List<MyItem> get() {
    return Preconditions.checkNotNull(
        module.myItemList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyModule_MyItemListFactory create(MyModule module) {
    return new MyModule_MyItemListFactory(module);
  }

  public static List<MyItem> proxyMyItemList(MyModule instance) {
    return Preconditions.checkNotNull(
        instance.myItemList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
