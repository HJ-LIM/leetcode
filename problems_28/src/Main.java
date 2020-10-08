import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      System.out.println(new Solution().solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
//      System.out.println(new Solution().solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
//      System.out.println(new Solution().solution(new String[]{"2016-09-15 20:59:57.421 0.351s"
//          , "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s"
//          , "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s"
//          , "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s"
//          , "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s"
//          , "2016-09-15 21:00:02.066 2.62s"}));
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


      for (Interval interval : intervals) {
         interval.getFrom().getTimeInMillis();
//         long from = interval.getFrom().getTimeInMillis();
//         long to = interval.getTo().getTimeInMillis();
//
//         int start_count = 0;
//         int end_count = 0;
//         for (Interval other : intervals) {
//            if(from <= other.getTo().getTimeInMillis() && from+999 >= other.getFrom().getTimeInMillis()){
//               start_count++;
//            }
//
//            if(to <= other.getTo().getTimeInMillis() && to+999 >= other.getFrom().getTimeInMillis()){
//               end_count++;
//            }
//         }

//         answer = start_count > answer ? start_count : answer;
//         answer = end_count > answer ? end_count : answer;
      }



      return answer;

   }
}


class CalendarUtils{
//   // yy-MM-dd HH:mm:ss.SSS
//   public static Calendar newCalendar(String time) {
//      Calendar calendar = Calendar.getInstance();
//      return calendar;
//   }

   // yyyy-mm-dd
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
   public Interval(String time) {
      String[] split = time.split(" ");
      String yyyymmdd = split[0];
      String hhmmssSSS = split[1];
      String duration = split[2];

      to = CalendarUtils.newCalendar(yyyymmdd, hhmmssSSS);

      long sec = (long) (Float.parseFloat(duration.replace("s", "")) * 1000);

      long l = to.getTimeInMillis() - sec + 1;
      from = CalendarUtils.newCalendar(l);
   }

   public Calendar getFrom() {
      return from;
   }

   public Calendar getTo() {
      return to;
   }

   @Override
   public String toString(){
      return CalendarUtils.toString(from) + " ~ " + CalendarUtils.toString(to);
   }
}
