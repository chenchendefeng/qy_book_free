package ooh.chaos.util;

import java.util.UUID;

/**
 * @author ZHI ZUN BAO
 * @since 2018/10/14
 */
public class UuidUtil {

    public static String getUuid(){
        UUID uuid = UUID.randomUUID();
        String uuidStr =  uuid.toString();
        uuidStr = uuidStr.replace("-", "");
        return uuidStr;
    }

    /**
     *  时间+ UUID
     * @return
     */
    public static String getId(){
        return (DateFormatUtil.getCurrentDate()+getUuid());
    }

    /**
     *  获取时间的uuid
     * @return
     */
    public static String getDateUUid(){
        return DateFormatUtil.getCurrentDateyyMMDD()+getUuid();
    }

    public static String getCodeByCuid(Long cuId){
        StringBuffer sb = new StringBuffer();
        sb.append(cuId);
        sb.append("_");
        String date = String.valueOf(DateFormatUtil.getCurrentTimestamp());
        sb.append(date);
        int length = sb.length();
        if (length > 32){
            return sb.subSequence(0,32).toString();
        }
        return sb.toString();
    }




    public static void main(String[] args) {

        for (int i = 0;i < 1000; i++) {
            String codeByUid = getCodeByCuid(1l);
            System.out.println(codeByUid);
        }
    }


}
