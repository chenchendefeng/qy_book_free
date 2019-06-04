package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.web.act.WebContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebModule_ProvideAboutViewFactory implements Factory<WebContract.View> {
  private final WebModule module;

  public WebModule_ProvideAboutViewFactory(WebModule module) {
    this.module = module;
  }

  @Override
  public WebContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WebModule_ProvideAboutViewFactory create(WebModule module) {
    return new WebModule_ProvideAboutViewFactory(module);
  }

  public static WebContract.View proxyProvideAboutView(WebModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
