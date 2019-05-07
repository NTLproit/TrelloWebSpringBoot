package com.ntl.trello.entity;

import javax.persistence.*;

@Entity
@Table(name = "columns_project")
public class ColumnsProject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;

  @Column(name = "columns_id", nullable = false)
  private long columnsId;

  @Column(name = "users_project_id", nullable = false)
  private long usersProjectId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getColumnsId() {
    return columnsId;
  }

  public void setColumnsId(long columnsId) {
    this.columnsId = columnsId;
  }


  public long getUsersProjectId() {
    return usersProjectId;
  }

  public void setUsersProjectId(long usersProjectId) {
    this.usersProjectId = usersProjectId;
  }

}
