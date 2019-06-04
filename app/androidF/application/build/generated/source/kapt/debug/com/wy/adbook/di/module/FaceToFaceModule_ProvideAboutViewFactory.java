package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.FaceToFaceContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FaceToFaceModule_ProvideAboutViewFactory
    implements Factory<FaceToFaceContract.View> {
  private final FaceToFaceModule module;

  public FaceToFaceModule_ProvideAboutViewFactory(FaceToFaceModule module) {
    this.module = module;
  }

  @Override
  public FaceToFaceContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static FaceToFaceModule_ProvideAboutViewFactory create(FaceToFaceModule module) {
    return new FaceToFaceModule_ProvideAboutViewFactory(module);
  }

  public static FaceToFaceContract.View proxyProvideAboutView(FaceToFaceModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
