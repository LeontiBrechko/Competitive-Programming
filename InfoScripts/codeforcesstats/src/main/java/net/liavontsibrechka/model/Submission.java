package net.liavontsibrechka.model;

public class Submission {
    private Long id;
    private Long contestId;
    private Long creationTimeSeconds;
    private Long relativeTimeSeconds;
    private Problem problem;
    private Party author;
    private String programmingLanguage;
    private Verdict verdict;
    private Testset testset;
    private Integer passedTestCount;
    private Long timeConsumedMillis;
    private Long memoryConsumedBytes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public void setCreationTimeSeconds(Long creationTimeSeconds) {
        this.creationTimeSeconds = creationTimeSeconds;
    }

    public Long getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public void setRelativeTimeSeconds(Long relativeTimeSeconds) {
        this.relativeTimeSeconds = relativeTimeSeconds;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Party getAuthor() {
        return author;
    }

    public void setAuthor(Party author) {
        this.author = author;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    public void setVerdict(Verdict verdict) {
        this.verdict = verdict;
    }

    public Testset getTestset() {
        return testset;
    }

    public void setTestset(Testset testset) {
        this.testset = testset;
    }

    public Integer getPassedTestCount() {
        return passedTestCount;
    }

    public void setPassedTestCount(Integer passedTestCount) {
        this.passedTestCount = passedTestCount;
    }

    public Long getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public void setTimeConsumedMillis(Long timeConsumedMillis) {
        this.timeConsumedMillis = timeConsumedMillis;
    }

    public Long getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }

    public void setMemoryConsumedBytes(Long memoryConsumedBytes) {
        this.memoryConsumedBytes = memoryConsumedBytes;
    }

    public enum Verdict {
        FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED
    }

    public enum Testset {
        SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, TESTS2, TESTS3, TESTS4, TESTS5, TESTS6, TESTS7, TESTS8, TESTS9, TESTS10
    }
}
