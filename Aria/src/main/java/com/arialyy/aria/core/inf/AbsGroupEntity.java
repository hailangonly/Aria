/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arialyy.aria.core.inf;

import android.os.Parcel;
import android.os.Parcelable;
import com.arialyy.aria.orm.Primary;

/**
 * Created by AriaL on 2017/6/3.
 */
public abstract class AbsGroupEntity extends AbsEntity implements Parcelable {
  /**
   * 组名
   */
  @Primary
  private String groupName = "";

  /**
   * 任务地址相加的urlmd5
   */
  private String urlmd5 = "";

  public String getUrlmd5() {
    return urlmd5;
  }

  public void setUrlmd5(String urlmd5) {
    this.urlmd5 = urlmd5;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public AbsGroupEntity() {
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.groupName);
    dest.writeString(this.urlmd5);
  }

  protected AbsGroupEntity(Parcel in) {
    super(in);
    this.groupName = in.readString();
    this.urlmd5 = in.readString();
  }
}