# Cron Expression Parser API - Ruby Gem

Cron Expression Parser decodes 5-field and 6-field cron expressions into human-readable schedules. Pass any cron string to verify syntax, read plain-language timing explanations, and get the next five execution timestamps.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_cronparser'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_cronparser
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_cronparser'

# Initialize the client
client = APIVerve::Cronparser::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ expression: "0 9 * * 1-5" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ expression: "0 9 * * 1-5" })
  puts response["data"]
rescue APIVerve::Cronparser::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Cronparser::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Cronparser::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/cronparser?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/cronparser?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/cronparser?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
