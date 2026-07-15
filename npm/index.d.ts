declare module '@apiverve/cronparser' {
  export interface cronparserOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface cronparserResponse {
    status: string;
    error: string | null;
    data: CronExpressionParserData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface CronExpressionParserData {
      expression:  null | string;
      isValid:     boolean | null;
      format:      null | string;
      fields:      Fields;
      description: null | string;
      frequency:   Frequency;
      nextRuns:    (Date | null)[];
  }
  
  interface Fields {
      second:     DayOfMonth;
      minute:     DayOfMonth;
      hour:       DayOfMonth;
      dayOfMonth: DayOfMonth;
      month:      DayOfMonth;
      dayOfWeek:  DayOfMonth;
  }
  
  interface DayOfMonth {
      expression:  null | string;
      description: null | string;
      values:      (number | null)[];
  }
  
  interface Frequency {
      type:     null | string;
      interval: null | string;
  }

  export default class cronparserWrapper {
    constructor(options: cronparserOptions);

    execute(callback: (error: any, data: cronparserResponse | null) => void): Promise<cronparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: cronparserResponse | null) => void): Promise<cronparserResponse>;
    execute(query?: Record<string, any>): Promise<cronparserResponse>;
  }
}
