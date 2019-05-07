package com.ntl.trello.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_project")
public class UsersProject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;

  @Column(name = "users_id", nullable = false)
  private long usersId;

  @Column(name = "project_id", nullable = false)
  private long projectId;

  @Column(name = "isManage", nullable = false)
  private long isManage;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUsersId() {
    return usersId;
  }

  public void setUsersId(long usersId) {
    this.usersId = usersId;
  }


  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }


  public long getIsManage() {
    return isManage;
  }

  public void setIsManage(long isManage) {
    this.isManage = isManage;
  }

}
