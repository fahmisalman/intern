package ebdesk.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

/**
 * Created by asuss on 5/27/2017.
 */
@Entity
@Table(name = "user")
@Component
@Scope("session")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    @NotNull
    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    @NotNull
    private String first_name;

    private String last_name;
    private String phone;

    private int totalproject;
    private int ongoingproject;
    private int status;
    private int totalstar;

    @NotNull
    private int role;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_skill", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id"))
    private Set<Skill> user_skills;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"))
//    private Set<Project> projects;


    @OneToMany(mappedBy = "primaryKey.user",cascade = CascadeType.ALL)
    private Set<UserProject> userProjects;

    public User() {
    }

    public User(String email, String password, String first_name, String last_name, String phone, int role) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.role = role;
    }

    public User(String email, String password, String first_name, String last_name, String phone, int totalproject, int ongoingproject, int status, int totalstar, int role, Division division, Set<Skill> user_skills, Set<UserProject> userProjects) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.totalproject = totalproject;
        this.ongoingproject = ongoingproject;
        this.status = status;
        this.totalstar = totalstar;
        this.role = role;
        this.division = division;
        this.user_skills = user_skills;
        this.userProjects = userProjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getTotalproject() {
        return totalproject;
    }

    public void setTotalproject(int totalproject) {
        this.totalproject = totalproject;
    }

    public int getOngoingproject() {
        return ongoingproject;
    }

    public void setOngoingproject(int ongoingproject) {
        this.ongoingproject = ongoingproject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalstar() {
        return totalstar;
    }

    public void setTotalstar(int totalstar) {
        this.totalstar = totalstar;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Skill> getUser_skills() {
        return user_skills;
    }

    public void setUser_skills(Set<Skill> user_skills) {
        this.user_skills = user_skills;
    }

    public Set<UserProject> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Set<UserProject> userProjects) {
        this.userProjects = userProjects;
    }
}
