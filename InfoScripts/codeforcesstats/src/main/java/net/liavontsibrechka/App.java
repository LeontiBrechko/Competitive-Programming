package net.liavontsibrechka;

import net.liavontsibrechka.stats.ProblemsSolved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneOffset;

@SpringBootApplication
public class App {
    private ProblemsSolved problemsSolved;

    @Autowired
    public App(ProblemsSolved problemsSolved) {
        this.problemsSolved = problemsSolved;
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            LocalDate monthStart = LocalDate.now().withDayOfMonth(1);
            for (int i = 6; i >= 0; i--)
                System.out.println(monthStart.minusMonths(i).getMonth().toString() + " " +
                        problemsSolved.problemsSolvedByMonthCount(monthStart.minusMonths(i), ZoneOffset.UTC));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
