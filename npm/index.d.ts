declare module '@apiverve/cronparser' {
  export interface cronparserOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface cronparserResponse {
    status: string;
    error: string | null;
    data: CronExpressionParserData;
    code?: number;
  }


  interface CronExpressionParserData {
      expression:  string;
      isValid:     boolean;
      format:      string;
      fields:      Fields;
      description: string;
      frequency:   Frequency;
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
      expression:  string;
      description: string;
      values:      number[];
  }
  
  interface Frequency {
      type:     string;
      interval: string;
  }

  export default class cronparserWrapper {
    constructor(options: cronparserOptions);

    execute(callback: (error: any, data: cronparserResponse | null) => void): Promise<cronparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: cronparserResponse | null) => void): Promise<cronparserResponse>;
    execute(query?: Record<string, any>): Promise<cronparserResponse>;
  }
}
