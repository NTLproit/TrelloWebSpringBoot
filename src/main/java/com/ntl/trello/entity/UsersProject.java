package com.ntl.trello.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_project")
public class UsersProject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "users_id", nullable = false)
  private Users users;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id", nullable = false)
  private Project project;

  @Column(name = "isManage", nullable = false)
  private boolean isManage;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean getIsManage() {
    return isManage;
  }

  public void setIsManage(boolean isManage) {
    this.isManage = isManage;
  }

}
