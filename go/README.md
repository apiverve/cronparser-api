# Cron Expression Parser API - Go Client

Cron Expression Parser is a comprehensive tool for parsing and validating cron expressions. It supports both 5-field and 6-field formats and returns detailed information about each field.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Cron Expression Parser API](https://apiverve.com/marketplace/cronparser?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/cronparser-api/go
```

---

## Configuration

Before using the Cron Expression Parser API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Cron Expression Parser API documentation is found here: [https://docs.apiverve.com/ref/cronparser](https://docs.apiverve.com/ref/cronparser?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/cronparser-api/go"
)

func main() {
    // Create a new client
    client := cronparser.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "expression": "0 9 * * 1-5"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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
    }
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
