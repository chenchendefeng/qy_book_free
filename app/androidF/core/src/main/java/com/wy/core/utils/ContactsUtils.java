package com.wy.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 联系人 通话记录工具
 */
public class ContactsUtils {
    private final String charset = "utf-8";

    public class ContactsCallRecord implements Serializable {
        public String contactName;//联系人名
        public String contactMobile;//	联系人手机号
        public long callBeginTime;//通话开始时间
        public long lastSeconds;//通话持续
        public String callState;//通话状态

        public ContactsCallRecord() {
        }

        public ContactsCallRecord(String contactName, String contactMobile, String callState, long callBeginTime, long lastSeconds) {
            this.contactMobile = contactMobile;
            this.callState = callState;
            this.contactName = contactName;
            this.callBeginTime = callBeginTime;
            this.lastSeconds = lastSeconds;
        }
    }

    public class ContactsFriend implements Serializable {
        public String[] friendMobiles;//	好友手机号
        public String friendName;//通讯录中的名字

        public ContactsFriend() {
        }

        public ContactsFriend(String friendName, String[] friendMobiles) {
            this.friendName = friendName;
            this.friendMobiles = friendMobiles;
        }
    }

    public class ContactsSMS implements Serializable {
        public long happenDate; ///发生时间
        public String messageNum;   //联系人号码
        public String contactsName; //联系人名称
        public String messageContent;  //短信内容

        public ContactsSMS() {
        }

    }

    private static ContactsUtils mContactsUtils;

    private ContactsUtils() {
    }

    public static ContactsUtils getInstance() {
        if (mContactsUtils == null) {
            mContactsUtils = new ContactsUtils();
        }
        return mContactsUtils;

    }

    public synchronized List<ContactsFriend> getPhoneContacts(final Context context) {
        List<ContactsFriend> list = new ArrayList<ContactsFriend>();
        Cursor cursor = null;
        try {
            String[] cols = {ContactsContract.Contacts.LOOKUP_KEY, ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER};
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols, null, null, null);

            while (cursor.moveToNext()) {
                String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
                //读取通讯录的姓名
                String name = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                if (!TextUtils.isEmpty(name)) {
                    name = new String(name.getBytes(), charset);
                }
                // 读取通讯录的号码 查看联系人有多少个号码，如果没有号码，返回0
                int phoneCount = cursor
                        .getInt(cursor
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                ArrayList<String> numbers = new ArrayList<String>();
                if (phoneCount > 0) {
                    // 获得联系人的电话号码列表
                    String[] phoneCols = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
                    Cursor phoneCursor = context.getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            phoneCols,
                            ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY
                                    + "=?", new String[]{contactId}, null);
                    while (phoneCursor.moveToNext()) {
                        //遍历所有的联系人下面所有的电话号码
                        String number = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        numbers.add(number);

                    }
                    if (phoneCursor != null && !phoneCursor.isClosed()) {
                        phoneCursor.close();
                    }

                }
                ContactsFriend phoneInfo = new ContactsFriend(name, numbers.toArray(new String[numbers.size()]));
                list.add(phoneInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return list;

    }

    public List<ContactsCallRecord> getPhoneCallRecordInfo(Context context) {
        return getPhoneCallRecordInfo(context, -1);
    }

    @SuppressLint("MissingPermission")
    public synchronized List<ContactsCallRecord> getPhoneCallRecordInfo(Context context, int max) {
        List<ContactsCallRecord> list = new ArrayList<ContactsCallRecord>();
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI,
                    null, null, null, CallLog.Calls.DEFAULT_SORT_ORDER);

            while (cursor.moveToNext()) {
                String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                //呼叫类型
                String type;
                switch (Integer.parseInt(cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE)))) {
                    case CallLog.Calls.INCOMING_TYPE:
                        type = "呼入";
                        break;
                    case CallLog.Calls.OUTGOING_TYPE:
                        type = "呼出";
                        break;
                    case CallLog.Calls.MISSED_TYPE:
                        type = "未接";
                        break;
                    default:
                        type = "挂断";//应该是挂断
                        break;
                }
                //联系人
                String name = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.CACHED_NAME));
                if (!TextUtils.isEmpty(name)) {
                    name = new String(name.getBytes(), charset);
                }

                long startTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DATE)));
                long endTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DURATION)));
                ContactsCallRecord callInfo = new ContactsCallRecord(name, number, type, startTime, endTime);
                list.add(callInfo);
                if (max > 0 && list.size() >= max) {
                    return list;
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return list;

    }

    public List<ContactsSMS> getPhoneSMSInfo(Context context) {
        return getPhoneSMSInfo(context, -1);
    }

    public synchronized List<ContactsSMS> getPhoneSMSInfo(Context context, int max) {
        List<ContactsSMS> list = new ArrayList<ContactsSMS>();
        Uri SMS_INBOX = Uri.parse("content://sms/");
        String[] projection = new String[]{"_id", Telephony.Sms.ADDRESS, Telephony.Sms.PERSON, Telephony.Sms.BODY, Telephony.Sms.DATE, Telephony.Sms.TYPE};
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(SMS_INBOX, projection, null, null, "date desc");
            if (null == cursor) {
                return list;
            }
            while (cursor.moveToNext()) {
                ContactsSMS sms = new ContactsSMS();
                sms.messageNum = cursor.getString(cursor.getColumnIndex(Telephony.Sms.ADDRESS));//手机号
                sms.contactsName = getPeopleNameFromPerson(context, sms.messageNum);//cursor.getString(cursor.getColumnIndex(Telephony.Sms.PERSON));//联系人姓名列表
                if (!TextUtils.isEmpty(sms.contactsName)) {
                    sms.contactsName = new String(sms.contactsName.getBytes(), charset);
                }
                sms.messageContent = cursor.getString(cursor.getColumnIndex(Telephony.Sms.BODY));//短信内容
                if (!TextUtils.isEmpty(sms.messageContent)) {
                    sms.messageContent = new String(sms.messageContent.getBytes(), charset);
                }
                sms.happenDate = cursor.getLong(cursor.getColumnIndex(Telephony.Sms.DATE));
                list.add(sms);
                if (max > 0 && list.size() >= max) {
                    return list;
                }
            }
            return list;
        } catch (Exception e) {

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return list;
    }

    // 通过address手机号关联Contacts联系人的显示名字
    private String getPeopleNameFromPerson(Context context, String address) {
        if (TextUtils.isEmpty(address)) {
            return "";
        }

        String strPerson = "";
        String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        Uri uri_Person = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, address);  // address 手机号过滤
        Cursor cursor = context.getContentResolver().query(uri_Person, projection, null, null, null);

        if (cursor.moveToFirst()) {
            int index_PeopleName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String strPeopleName = cursor.getString(index_PeopleName);
            strPerson = strPeopleName;
        }
        cursor.close();

        return strPerson;
    }

    private int queryContactPhoneNumber(Context context) {
        String[] cols = {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                cols, null, null, null);
        int num = 0;
        if (cursor != null) {
            num = cursor.getCount();
            cursor.close();
        }
        return num;
    }

    public synchronized int getPhoneContactNumbers(final Context context) {
        Cursor cursor = null;
        try {
            String[] cols = {ContactsContract.Contacts.LOOKUP_KEY};
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols, null, null, null);

            return cursor.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return 0;

    }
}