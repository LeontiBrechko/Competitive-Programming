package net.liavontsibrechka.model;

import java.util.List;

public class Party {
    private Long contestId;
    private List<Member> members;
    private ParticipantType participantType;
    private Long teamId;
    private String teamName;
    private Boolean ghost;
    private Integer room;
    private Long startTimeSeconds;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Boolean getGhost() {
        return ghost;
    }

    public void setGhost(Boolean ghost) {
        this.ghost = ghost;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Long getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds(Long startTimeSeconds) {
        this.startTimeSeconds = startTimeSeconds;
    }

    public enum ParticipantType {
        CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION
    }
}
