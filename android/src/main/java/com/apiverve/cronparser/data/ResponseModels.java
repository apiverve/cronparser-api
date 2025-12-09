// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     CronExpressionParserData data = Converter.fromJsonString(jsonString);

package com.apiverve.cronparser.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static CronExpressionParserData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CronExpressionParserData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(CronExpressionParserData.class);
        writer = mapper.writerFor(CronExpressionParserData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// CronExpressionParserData.java

package com.apiverve.cronparser.data;

import com.fasterxml.jackson.annotation.*;

public class CronExpressionParserData {
    private String expression;
    private boolean isValid;
    private String format;
    private Fields fields;
    private String description;
    private Frequency frequency;

    @JsonProperty("expression")
    public String getExpression() { return expression; }
    @JsonProperty("expression")
    public void setExpression(String value) { this.expression = value; }

    @JsonProperty("isValid")
    public boolean getIsValid() { return isValid; }
    @JsonProperty("isValid")
    public void setIsValid(boolean value) { this.isValid = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("fields")
    public Fields getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(Fields value) { this.fields = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("frequency")
    public Frequency getFrequency() { return frequency; }
    @JsonProperty("frequency")
    public void setFrequency(Frequency value) { this.frequency = value; }
}

// Fields.java

package com.apiverve.cronparser.data;

import com.fasterxml.jackson.annotation.*;

public class Fields {
    private DayOfMonth second;
    private DayOfMonth minute;
    private DayOfMonth hour;
    private DayOfMonth dayOfMonth;
    private DayOfMonth month;
    private DayOfMonth dayOfWeek;

    @JsonProperty("second")
    public DayOfMonth getSecond() { return second; }
    @JsonProperty("second")
    public void setSecond(DayOfMonth value) { this.second = value; }

    @JsonProperty("minute")
    public DayOfMonth getMinute() { return minute; }
    @JsonProperty("minute")
    public void setMinute(DayOfMonth value) { this.minute = value; }

    @JsonProperty("hour")
    public DayOfMonth getHour() { return hour; }
    @JsonProperty("hour")
    public void setHour(DayOfMonth value) { this.hour = value; }

    @JsonProperty("dayOfMonth")
    public DayOfMonth getDayOfMonth() { return dayOfMonth; }
    @JsonProperty("dayOfMonth")
    public void setDayOfMonth(DayOfMonth value) { this.dayOfMonth = value; }

    @JsonProperty("month")
    public DayOfMonth getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(DayOfMonth value) { this.month = value; }

    @JsonProperty("dayOfWeek")
    public DayOfMonth getDayOfWeek() { return dayOfWeek; }
    @JsonProperty("dayOfWeek")
    public void setDayOfWeek(DayOfMonth value) { this.dayOfWeek = value; }
}

// DayOfMonth.java

package com.apiverve.cronparser.data;

import com.fasterxml.jackson.annotation.*;

public class DayOfMonth {
    private String expression;
    private String description;
    private long[] values;

    @JsonProperty("expression")
    public String getExpression() { return expression; }
    @JsonProperty("expression")
    public void setExpression(String value) { this.expression = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("values")
    public long[] getValues() { return values; }
    @JsonProperty("values")
    public void setValues(long[] value) { this.values = value; }
}

// Frequency.java

package com.apiverve.cronparser.data;

import com.fasterxml.jackson.annotation.*;

public class Frequency {
    private String type;
    private String interval;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("interval")
    public String getInterval() { return interval; }
    @JsonProperty("interval")
    public void setInterval(String value) { this.interval = value; }
}