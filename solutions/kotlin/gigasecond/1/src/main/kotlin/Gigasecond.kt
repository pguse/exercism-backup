import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Duration

class Gigasecond {

    val date: LocalDateTime

    constructor(date: LocalDateTime) {
        this.date = date.plus(Duration.ofSeconds(1_000_000_000))
    }

    constructor(date: LocalDate) {
        this.date = date.atStartOfDay().plus(Duration.ofSeconds(1_000_000_000))
    }

}