package com.example.me_garamssi.n6_dateAndTimeAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class dateAndTimeAPI {
        public static void main(String[] args) {

                /**
                 * clear : 명확하고
                 * immutable : 스레드 세이프
                 * fluent
                 * extensible
                 * */
                // 보통 기계용, 메소드 시간 체크할 때 사용
                Instant instant = Instant.now();
                System.out.println(instant); // 기준시 UTC, GMT

                ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
                System.out.println(zonedDateTime);

                // 현재 시간을 가져옴 ( 물리적 서버가 있는 곳 )
                LocalDateTime now = LocalDateTime.now();
                System.out.println(now);

//                LocalDateTime birthDay = LocalDateTime.of(1993, Month.JANUARY, 0, 0, 0, 0);


                // instant와 ZonedDateTime은 서로 변환이 가능하다.
                ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
                System.out.println(nowInKorea);



                /**
                 * LocalDate
                 * */
                LocalDate today = LocalDate.now();
                LocalDate thisYearBirthDay = LocalDate.of(2022, Month.JANUARY, 29);

                Period between = Period.between(today, thisYearBirthDay);
                System.out.println(between.getDays());


                /**
                 * Duration 머신용 비교
                 * */
                Instant now2 = Instant.now();
                Instant plus = now2.plus(10, ChronoUnit.SECONDS);
                Duration between1 = Duration.between(now2, plus);
                System.out.println(between1.getSeconds());

                /**
                 * LocalDateTime
                 * */
                LocalDateTime now3 = LocalDateTime.now();
                System.out.println(now3);

                DateTimeFormatter MMddyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                System.out.println(now.format(MMddyyy));


                /**
                 * Parse
                 * */
                LocalDate parse = LocalDate.parse("07/15/1982", MMddyyy);
                System.out.println(parse);


                /**
                 * 레거시 API 지원  등등
                 * */
                Date date = new Date();
                Instant instant1 = date.toInstant();

                Date newDate = date.from(instant1);

                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                LocalDateTime dateTime = LocalDateTime.from(gregorianCalendar.toInstant());

                GregorianCalendar from = GregorianCalendar.from(ZonedDateTime.from(dateTime));


        }
}
