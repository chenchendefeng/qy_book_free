package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem;
import com.wy.adbook.mvp.view.adapter.SignCalendarAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_SignCalendarAdapterFactory
    implements Factory<SignCalendarAdapter> {
  private final SignCalenderModule module;

  private final Provider<List<AttendanceCalendarItem>> dataListProvider;

  public SignCalenderModule_SignCalendarAdapterFactory(
      SignCalenderModule module, Provider<List<AttendanceCalendarItem>> dataListProvider) {
    this.module = module;
    this.dataListProvider = dataListProvider;
  }

  @Override
  public SignCalendarAdapter get() {
    return Preconditions.checkNotNull(
        module.signCalendarAdapter(dataListProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_SignCalendarAdapterFactory create(
      SignCalenderModule module, Provider<List<AttendanceCalendarItem>> dataListProvider) {
    return new SignCalenderModule_SignCalendarAdapterFactory(module, dataListProvider);
  }

  public static SignCalendarAdapter proxySignCalendarAdapter(
      SignCalenderModule instance, List<AttendanceCalendarItem> dataList) {
    return Preconditions.checkNotNull(
        instance.signCalendarAdapter(dataList),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
