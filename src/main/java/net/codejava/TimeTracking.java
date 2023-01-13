package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@CrossOrigin
public class TimeTracking{

    @GetMapping("/timetracking/{id}")
    public long getHoursForEmployee(
            @PathVariable("id") int id,
            @RequestParam("from" ) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from,
            @RequestParam("to")  @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to){

        return ChronoUnit.DAYS.between(from, to);
    }
}
