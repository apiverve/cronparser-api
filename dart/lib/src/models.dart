/// Response models for the Cron Expression Parser API.

/// API Response wrapper.
class CronparserResponse {
  final String status;
  final dynamic error;
  final CronparserData? data;

  CronparserResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory CronparserResponse.fromJson(Map<String, dynamic> json) => CronparserResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CronparserData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Cron Expression Parser API.

class CronparserData {
  String? expression;
  bool? isValid;
  String? format;
  CronparserDataFields? fields;
  String? description;
  CronparserDataFrequency? frequency;

  CronparserData({
    this.expression,
    this.isValid,
    this.format,
    this.fields,
    this.description,
    this.frequency,
  });

  factory CronparserData.fromJson(Map<String, dynamic> json) => CronparserData(
      expression: json['expression'],
      isValid: json['isValid'],
      format: json['format'],
      fields: json['fields'] != null ? CronparserDataFields.fromJson(json['fields']) : null,
      description: json['description'],
      frequency: json['frequency'] != null ? CronparserDataFrequency.fromJson(json['frequency']) : null,
    );
}

class CronparserDataFields {
  CronparserDataFieldsSecond? second;
  CronparserDataFieldsMinute? minute;
  CronparserDataFieldsHour? hour;
  CronparserDataFieldsDayofmonth? dayOfMonth;
  CronparserDataFieldsMonth? month;
  CronparserDataFieldsDayofweek? dayOfWeek;

  CronparserDataFields({
    this.second,
    this.minute,
    this.hour,
    this.dayOfMonth,
    this.month,
    this.dayOfWeek,
  });

  factory CronparserDataFields.fromJson(Map<String, dynamic> json) => CronparserDataFields(
      second: json['second'] != null ? CronparserDataFieldsSecond.fromJson(json['second']) : null,
      minute: json['minute'] != null ? CronparserDataFieldsMinute.fromJson(json['minute']) : null,
      hour: json['hour'] != null ? CronparserDataFieldsHour.fromJson(json['hour']) : null,
      dayOfMonth: json['dayOfMonth'] != null ? CronparserDataFieldsDayofmonth.fromJson(json['dayOfMonth']) : null,
      month: json['month'] != null ? CronparserDataFieldsMonth.fromJson(json['month']) : null,
      dayOfWeek: json['dayOfWeek'] != null ? CronparserDataFieldsDayofweek.fromJson(json['dayOfWeek']) : null,
    );
}

class CronparserDataFieldsSecond {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsSecond({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsSecond.fromJson(Map<String, dynamic> json) => CronparserDataFieldsSecond(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFieldsMinute {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsMinute({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsMinute.fromJson(Map<String, dynamic> json) => CronparserDataFieldsMinute(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFieldsHour {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsHour({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsHour.fromJson(Map<String, dynamic> json) => CronparserDataFieldsHour(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFieldsDayofmonth {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsDayofmonth({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsDayofmonth.fromJson(Map<String, dynamic> json) => CronparserDataFieldsDayofmonth(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFieldsMonth {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsMonth({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsMonth.fromJson(Map<String, dynamic> json) => CronparserDataFieldsMonth(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFieldsDayofweek {
  String? expression;
  String? description;
  List<int>? values;

  CronparserDataFieldsDayofweek({
    this.expression,
    this.description,
    this.values,
  });

  factory CronparserDataFieldsDayofweek.fromJson(Map<String, dynamic> json) => CronparserDataFieldsDayofweek(
      expression: json['expression'],
      description: json['description'],
      values: (json['values'] as List?)?.cast<int>(),
    );
}

class CronparserDataFrequency {
  String? type;
  String? interval;

  CronparserDataFrequency({
    this.type,
    this.interval,
  });

  factory CronparserDataFrequency.fromJson(Map<String, dynamic> json) => CronparserDataFrequency(
      type: json['type'],
      interval: json['interval'],
    );
}

class CronparserRequest {
  String expression;

  CronparserRequest({
    required this.expression,
  });

  Map<String, dynamic> toJson() => {
      'expression': expression,
    };
}
