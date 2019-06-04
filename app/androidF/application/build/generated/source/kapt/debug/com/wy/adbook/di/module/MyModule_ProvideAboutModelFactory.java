package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyContract;
import com.wy.adbook.mvp.model.MyModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModule_ProvideAboutModelFactory implements Factory<MyContract.Model> {
  private final MyModule module;

  private final Provider<MyModel> modelProvider;

  public MyModule_ProvideAboutModelFactory(MyModule module, Provider<MyModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public MyContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyModule_ProvideAboutModelFactory create(
      MyModule module, Provider<MyModel> modelProvider) {
    return new MyModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static MyContract.Model proxyProvideAboutModel(MyModule instance, MyModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
