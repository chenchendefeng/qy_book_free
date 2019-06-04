package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.web.act.WebContract;
import com.wy.adbook.mvp.view.web.act.WebModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebModule_ProvideAboutModelFactory implements Factory<WebContract.Model> {
  private final WebModule module;

  private final Provider<WebModel> modelProvider;

  public WebModule_ProvideAboutModelFactory(WebModule module, Provider<WebModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public WebContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WebModule_ProvideAboutModelFactory create(
      WebModule module, Provider<WebModel> modelProvider) {
    return new WebModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static WebContract.Model proxyProvideAboutModel(WebModule instance, WebModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
