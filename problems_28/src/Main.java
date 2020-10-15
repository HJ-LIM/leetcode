import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
   public static void main(String[] args) {
//      System.out.println(new Solution().solution(new String[]{"2016-09-15 23:59:59.999 0.001s"}));
//      System.out.println(new Solution().solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
//      System.out.println(new Solution().solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
      System.out.println(new Solution().solution(new String[]{"2016-09-15 20:59:57.421 0.351s"
          , "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s"
          , "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s"
          , "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s"
          , "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s"
          , "2016-09-15 21:00:02.066 2.62s"}));
   }
}

class Solution {
   public int solution(String[] lines) {
      int answer = 0;

      List<Interval> intervals = new ArrayList<>();

      for (int i = 0; i < lines.length; i++) {
         String time = lines[i];
         Interval interval = new Interval(time);
         intervals.add(interval);
      }
      for (Interval target_transaction : intervals) {
//         System.out.println(target_transaction.toString());
         target_transaction.getFrom().getTimeInMillis();

         int inner_cnt = 0;
         for (Interval transaction : intervals) {
            if(target_transaction.equals(transaction)){
               inner_cnt++;
               continue;
            }
            boolean inner = target_transaction.isInner(transaction);
            if(inner) inner_cnt++;
         }

         answer = inner_cnt > answer ? inner_cnt : answer;
      }
      return answer;
   }
}


class CalendarUtils{
   // hh:mm:ss.SSS
   public static Calendar newCalendar(String yyyymmdd, String hhmmssSSS) {
      Calendar cal = Calendar.getInstance();

      String[] date = yyyymmdd.split("-");
      cal.set(Calendar.YEAR , Integer.parseInt(date[0]));
      cal.set(Calendar.MONTH , Integer.parseInt(date[1])-1);
      cal.set(Calendar.DATE , Integer.parseInt(date[2]));

      String[] origin_time = hhmmssSSS.split("\\.");

      String[] time = origin_time[0].split(":");
      cal.set(Calendar.HOUR_OF_DAY , Integer.parseInt(time[0]));
      cal.set(Calendar.MINUTE , Integer.parseInt(time[1]));
      cal.set(Calendar.SECOND , Integer.parseInt(time[2]));
      cal.set(Calendar.MILLISECOND , Integer.parseInt(origin_time[1]));

      return cal;


   }

   public static Calendar newCalendar(long l) {
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(l);
      return cal;
   }

   public static String toString(Calendar calendar) {
      return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(calendar.getTime());
   }
}

class Interval{
   private Calendar from;
   private Calendar to;
   private long took;
   public Interval(String time) {
      String[] split = time.split(" ");
      String yyyymmdd = split[0];
      String hhmmssSSS = split[1];
      String duration = split[2];

      to = CalendarUtils.newCalendar(yyyymmdd, hhmmssSSS);

      took = (long) (Float.parseFloat(duration.replace("s", "")) * 1000);

      long l = to.getTimeInMillis() - took+1;
      from = CalendarUtils.newCalendar(l);
   }

   public Calendar getFrom() {
      return from;
   }
   public Calendar getTo() {
      return to;
   }

   public long getTook() {
      return took;
   }

   @Override
   public String toString(){
      return CalendarUtils.toString(from) + " ~ " + CalendarUtils.toString(to);
   }

   public boolean isInner(Interval transaction) {
      Calendar _from = (Calendar) this.from.clone();
      Calendar _to = (Calendar) this.to.clone();

      _from.add(Calendar.SECOND , 1);
      _to.add(Calendar.SECOND , 1);
      if(this.from.getTimeInMillis() <= transaction.to.getTimeInMillis() &&
              ((_from.getTimeInMillis() <= transaction.from.getTimeInMillis() && transaction.from.getTimeInMillis() < _to.getTimeInMillis())
              || (_from.getTimeInMillis() <= transaction.to.getTimeInMillis() && transaction.to.getTimeInMillis() < _to.getTimeInMillis()))){
         return true;
      }else if(this.getTook() < 1000 &&
              (this.from.getTimeInMillis() <= transaction.from.getTimeInMillis() && transaction.from.getTimeInMillis() <= this.to.getTimeInMillis()
              || this.to.getTimeInMillis() <= transaction.to.getTimeInMillis() && transaction.to.getTimeInMillis() <= this.to.getTimeInMillis())){
         return true;
      }

      return false;
   }
}
