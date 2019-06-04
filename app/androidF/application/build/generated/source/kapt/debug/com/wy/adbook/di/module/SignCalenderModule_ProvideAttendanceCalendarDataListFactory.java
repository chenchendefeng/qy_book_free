package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.accout.AttendanceCalendarItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SignCalenderModule_ProvideAttendanceCalendarDataListFactory
    implements Factory<List<AttendanceCalendarItem>> {
  private final SignCalenderModule module;

  public SignCalenderModule_ProvideAttendanceCalendarDataListFactory(SignCalenderModule module) {
    this.module = module;
  }

  @Override
  public List<AttendanceCalendarItem> get() {
    return Preconditions.checkNotNull(
        module.provideAttendanceCalendarDataList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static SignCalenderModule_ProvideAttendanceCalendarDataListFactory create(
      SignCalenderModule module) {
    return new SignCalenderModule_ProvideAttendanceCalendarDataListFactory(module);
  }

  public static List<AttendanceCalendarItem> proxyProvideAttendanceCalendarDataList(
      SignCalenderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAttendanceCalendarDataList(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
