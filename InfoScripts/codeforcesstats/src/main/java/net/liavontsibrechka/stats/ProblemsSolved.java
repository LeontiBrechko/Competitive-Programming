package net.liavontsibrechka.stats;

import net.liavontsibrechka.api.UserRequests;
import net.liavontsibrechka.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.time.*;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ProblemsSolved {
    private UserRequests userRequests;
    private ResourceBundle mainResources;

    @Autowired
    public ProblemsSolved(UserRequests userRequests, ResourceBundle mainResources) {
        this.userRequests = userRequests;
        this.mainResources = mainResources;
    }

    public void logStatisticsForPreiodByMonth(LocalDate startDate, Period period, PrintWriter printWriter) {

    }

    public long problemsSolvedByMonthCount(LocalDate localDate, ZoneOffset zoneOffset) {
        List<Submission> submissions = userRequests.status(mainResources.getString("handle"), null, null);
        long currentMonthEpochTime = LocalDateTime.of(localDate, LocalTime.MIDNIGHT).toEpochSecond(zoneOffset);
        long nextMonthEpochTime = LocalDateTime.of(localDate.plusMonths(1), LocalTime.MIDNIGHT).toEpochSecond(zoneOffset);
        return submissions.parallelStream()
                .filter(submission -> submission.getCreationTimeSeconds() >= currentMonthEpochTime &&
                        submission.getCreationTimeSeconds() < nextMonthEpochTime &&
                        submission.getVerdict() == Submission.Verdict.OK)
                .map(Submission::getProblem)
                .distinct()
                .count();
    }
}
