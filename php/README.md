# Cron Expression Parser API - PHP Package

Cron Expression Parser is a comprehensive tool for parsing and validating cron expressions. It supports both 5-field and 6-field formats and returns detailed information about each field.

## Installation

Install via Composer:

```bash
composer require apiverve/cronparser
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Cronparser\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['expression' => '0 9 * * 1-5']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Cronparser\Client;
use APIVerve\Cronparser\Exceptions\APIException;
use APIVerve\Cronparser\Exceptions\ValidationException;

try {
    $response = $client->execute(['expression' => '0 9 * * 1-5']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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
    },
    "nextRuns": [
      "2026-02-19T09:00:00.000Z",
      "2026-02-20T09:00:00.000Z",
      "2026-02-21T09:00:00.000Z",
      "2026-02-24T09:00:00.000Z",
      "2026-02-25T09:00:00.000Z"
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/cronparser?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/cronparser?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/cronparser?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
