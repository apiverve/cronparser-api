using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.CronExpressionParser
{
    /// <summary>
    /// Query options for the Cron Expression Parser API
    /// </summary>
    public class CronExpressionParserQueryOptions
    {
        /// <summary>
        /// The cron expression to parse (5-field or 6-field format)
        /// Example: 0 9 * * 1-5
        /// </summary>
        [JsonProperty("expression")]
        public string Expression { get; set; }
    }
}
