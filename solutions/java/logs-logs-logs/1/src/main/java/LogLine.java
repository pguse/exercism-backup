public class LogLine {

    private LogLevel level;
    private String message;
    
    public LogLine(String logLine) {
        message = logLine.split(":")[1].substring(1);
        String level = logLine.substring(1,4);
        switch (level) {
            case "TRC":
                    this.level = LogLevel.TRACE;
                    break;
            case "DBG":
                    this.level = LogLevel.DEBUG;
                    break;
            case "INF":
                    this.level = LogLevel.INFO;
                    break;
            case "WRN":
                    this.level = LogLevel.WARNING;
                    break;
            case "ERR":
                    this.level = LogLevel.ERROR;
                    break;
            case "FTL":
                    this.level =  LogLevel.FATAL;
                    break;
            default:
                    this.level = LogLevel.UNKNOWN;
        }
    }

    public LogLevel getLogLevel() {
        return level;
    }

    public String getOutputForShortLog() {
        return level.getLevel() + ":" + message;
    }
}