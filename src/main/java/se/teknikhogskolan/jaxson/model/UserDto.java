package se.teknikhogskolan.jaxson.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import se.teknikhogskolan.springcasemanagement.model.User;

public final class UserDto extends AbstractDto {

    private Long userNumber;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Long teamId;
    private Collection<Long> workItemsId;

    protected UserDto() {
    }

    public UserDto(User user) {
        setId(user.getId());
        if (null != user.getCreated()) {
            setCreated(user.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        if (null != user.getLastModified()) {
            setLastModified(user.getLastModified().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        this.userNumber = user.getUserNumber();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.active = user.isActive();
        setWorkItemsId(getWorkItemsIdsFromUser(user));

        if (user.getTeam() != null) {
            this.teamId = user.getTeam().getId();
        }
    }

    private Collection<Long> getWorkItemsIdsFromUser(User user) {
        Collection<Long> result = new ArrayList<>();
        if (null != user.getWorkItems()) {
            user.getWorkItems().forEach(workItem -> result.add(workItem.getId()));
        }
        return result;
    }

    private void setWorkItemsId(Collection<Long> workItemsId) {
        this.workItemsId = workItemsId;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Collection<Long> getWorkItemsId() {
        return workItemsId;
    }

    public Boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserDto) {
            UserDto otherUser = (UserDto) obj;
            return userNumber.equals(otherUser.getUserNumber()) && username.equals(otherUser.getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += result * userNumber.hashCode();
        result += result * username.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDto [id=");
        builder.append(getId());
        builder.append(", userNumber=");
        builder.append(userNumber);
        builder.append(", username=");
        builder.append(username);
        builder.append(", firstName=");
        builder.append(firstName == null ? "null" : firstName);
        builder.append(", lastName=");
        builder.append(lastName == null ? "null" : lastName);
        builder.append(", teamId=");
        builder.append(teamId);
        builder.append(", workItemsSize=");
        builder.append(workItemsId == null ? "0" : workItemsId.size());
        builder.append(", active=");
        builder.append(active);
        builder.append(", created=");
        builder.append(getCreated());
        builder.append(", lastModified=");
        builder.append(getLastModified());
        builder.append("]");
        return builder.toString();
    }
}