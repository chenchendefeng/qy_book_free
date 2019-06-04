package com.wy.adbook.di.module;

import com.wy.adbook.mvp.view.web.QYWebView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebModule_ProvideWebViewFactory implements Factory<QYWebView> {
  private final QYWebModule module;

  public QYWebModule_ProvideWebViewFactory(QYWebModule module) {
    this.module = module;
  }

  @Override
  public QYWebView get() {
    return Preconditions.checkNotNull(
        module.provideWebView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static QYWebModule_ProvideWebViewFactory create(QYWebModule module) {
    return new QYWebModule_ProvideWebViewFactory(module);
  }

  public static QYWebView proxyProvideWebView(QYWebModule instance) {
    return Preconditions.checkNotNull(
        instance.provideWebView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
