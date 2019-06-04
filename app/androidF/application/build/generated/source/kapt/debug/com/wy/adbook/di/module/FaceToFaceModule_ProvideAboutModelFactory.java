package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.FaceToFaceContract;
import com.wy.adbook.mvp.model.FaceToFaceModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FaceToFaceModule_ProvideAboutModelFactory
    implements Factory<FaceToFaceContract.Model> {
  private final FaceToFaceModule module;

  private final Provider<FaceToFaceModel> modelProvider;

  public FaceToFaceModule_ProvideAboutModelFactory(
      FaceToFaceModule module, Provider<FaceToFaceModel> modelProvider) {
    this.module = module;
    this.modelProvider = modelProvider;
  }

  @Override
  public FaceToFaceContract.Model get() {
    return Preconditions.checkNotNull(
        module.provideAboutModel(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static FaceToFaceModule_ProvideAboutModelFactory create(
      FaceToFaceModule module, Provider<FaceToFaceModel> modelProvider) {
    return new FaceToFaceModule_ProvideAboutModelFactory(module, modelProvider);
  }

  public static FaceToFaceContract.Model proxyProvideAboutModel(
      FaceToFaceModule instance, FaceToFaceModel model) {
    return Preconditions.checkNotNull(
        instance.provideAboutModel(model),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
