# Cron Expression Parser API - Dart/Flutter Client

Cron Expression Parser is a comprehensive tool for parsing and validating cron expressions. It supports both 5-field and 6-field formats and returns detailed information about each field.

[![pub package](https://img.shields.io/pub/v/apiverve_cronparser.svg)](https://pub.dev/packages/apiverve_cronparser)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Cron Expression Parser API](https://apiverve.com/marketplace/cronparser?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_cronparser: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_cronparser/apiverve_cronparser.dart';

void main() async {
  final client = CronparserClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'expression': '0 9 * * 1-5'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "expression": "0 9 * * 1-5",
    "isValid": true,
    "format": "5-field",
    "fields": {
      "second": {
        "expression": "0",
        "description": "At 0",
        "values": [
          0
        ]
      },
      "minute": {
        "expression": "0",
        "description": "At 0",
        "values": [
          0
        ]
      },
      "hour": {
        "expression": "9",
        "description": "At 9",
        "values": [
          9
        ]
      },
      "dayOfMonth": {
        "expression": "*",
        "description": "Every",
        "values": [
          1,
          2,
          3,
          4,
          5,
          6,
          7,
          8,
          9,
          10,
          11,
          12,
          13,
          14,
          15,
          16,
          17,
          18,
          19,
          20,
          21,
          22,
          23,
          24,
          25,
          26,
          27,
          28,
          29,
          30,
          31
        ]
      },
      "month": {
        "expression": "*",
        "description": "Every",
        "values": [
          1,
          2,
          3,
          4,
          5,
          6,
          7,
          8,
          9,
          10,
          11,
          12
        ]
      },
      "dayOfWeek": {
        "expression": "1-5",
        "description": "From 1 to 5",
        "values": [
          1,
          2,
          3,
          4,
          5
        ]
      }
    },
    "description": "At 9:00 AM on Monday, Tuesday, Wednesday, Thursday, Friday",
    "frequency": {
      "type": "Daily",
      "interval": "day"
    }
  }
}
```

## API Reference

- **API Home:** [Cron Expression Parser API](https://apiverve.com/marketplace/cronparser?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/cronparser](https://docs.apiverve.com/ref/cronparser?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
