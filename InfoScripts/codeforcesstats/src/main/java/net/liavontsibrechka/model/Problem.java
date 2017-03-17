package net.liavontsibrechka.model;

import java.util.List;

public class Problem {
    private Long contestId;
    private String index;
    private String name;
    private Type type;
    private Double points;
    private List<String> tags;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Problem problem = (Problem) o;

        return contestId.equals(problem.contestId) && index.equals(problem.index);
    }

    @Override
    public int hashCode() {
        int result = contestId.hashCode();
        result = 31 * result + index.hashCode();
        return result;
    }

    public enum Type {
        PROGRAMMING, QUESTION
    }
}
