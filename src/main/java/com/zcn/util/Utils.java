package com.zcn.util;

import com.mongodb.lang.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sinan
 */
public final class Utils extends org.springframework.util.StringUtils {

    private static final AtomicInteger HOUR = new AtomicInteger(24);
    public static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);

    /**
     * scale 4, HALF_DOWN
     *
     * @param value
     * @return
     */
    public static BigDecimal toBigDecimal(final String value) {
        if (value != null) {
            return new BigDecimal(value).setScale(4, RoundingMode.HALF_DOWN);
        }
        return BigDecimal.ZERO;
    }

    /**
     *
     * @param value
     * @return
     */
    public static Integer toInteger(final String value) {
        if (value != null) {
            return Integer.parseInt(value);
        }
        return 0;
    }


    /**
     * @param value
     * @return
     */
    public static Long toLong(final String value) {
        if (value != null) {
            return Long.parseLong(value);
        }
        return 0L;
    }

    /**
     * pattern : yyyy-MM-dd HH:mm
     *
     * @param value
     * @return
     */
    public static LocalDateTime toLocalDate(final String value) {
        if (!isEmpty(value)) {
            return LocalDateTime.parse(value, pattern);
        }
        return null;
    }

    /**
     * @param collection
     * @return
     */
    public static boolean isEmpty(@Nullable final Collection<?> collection) {
        return org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    /**
     * @param map
     * @return
     */
    public static boolean isEmpty(@Nullable final Map<?, ?> map) {
        return org.springframework.util.CollectionUtils.isEmpty(map);
    }


    /**
     * pattern : yyyy-MM-dd HH:mm
     *
     * @param value
     * @return
     */
    public static String toString(final LocalDateTime value) {
        if (value == null) {
            return null;
        }
        return value.format(pattern);
    }

    /**
     * @param firstDecimal
     * @param secondDecimal
     * @return
     */
    public static boolean equals(final BigDecimal firstDecimal, final BigDecimal secondDecimal) {
        var first = firstDecimal.setScale(4);
        var second = secondDecimal.setScale(4);
        return first.equals(second);
    }


    /**
     * @param firstDate
     * @param stopDate
     * @return
     */
    public static String formatterDaysAndHour(final LocalDateTime firstDate,
                                              final LocalDateTime stopDate) {
        if (isEmpty(firstDate) || isEmpty(stopDate)) {
            return null;
        }
        long diffDays = ChronoUnit.DAYS.between(firstDate, stopDate);
        long diffHours = ChronoUnit.HOURS.between(firstDate, stopDate);

        diffHours = diffHours > HOUR.get() ? diffHours % HOUR.get() : diffHours;

        return new StringBuilder(" ").append(diffDays).append(" Days ")
            .append((diffHours)).append(" Hours.").toString();
    }

    /**
     * @param firstDate
     * @param stopDate
     * @return
     */
    public static long calcDifferenceHours(final LocalDateTime firstDate,
                                             final LocalDateTime stopDate) {
        if (isEmpty(firstDate) || isEmpty(stopDate)) {
            return 0L;
        }
        long diffHours = ChronoUnit.HOURS.between(firstDate, stopDate);
        return diffHours;
    }


    /**
     * @param value
     * @return
     */
    public static String toString(final BigDecimal value) {
        if (value == null) {
            return "";
        } else {
            return String.valueOf(value);
        }
    }

}
