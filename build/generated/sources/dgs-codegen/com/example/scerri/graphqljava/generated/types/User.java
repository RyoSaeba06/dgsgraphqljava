package com.example.scerri.graphqljava.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class User {
  private Integer id;

  private String firstName;

  private String lastName;

  private HRInfo details;

  public User() {
  }

  public User(Integer id, String firstName, String lastName, HRInfo details) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.details = details;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public HRInfo getDetails() {
    return details;
  }

  public void setDetails(HRInfo details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return "User{" + "id='" + id + "'," +"firstName='" + firstName + "'," +"lastName='" + lastName + "'," +"details='" + details + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(firstName, that.firstName) &&
                            java.util.Objects.equals(lastName, that.lastName) &&
                            java.util.Objects.equals(details, that.details);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, firstName, lastName, details);
  }

  public static com.example.scerri.graphqljava.generated.types.User.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer id;

    private String firstName;

    private String lastName;

    private HRInfo details;

    public User build() {
                  com.example.scerri.graphqljava.generated.types.User result = new com.example.scerri.graphqljava.generated.types.User();
                      result.id = this.id;
          result.firstName = this.firstName;
          result.lastName = this.lastName;
          result.details = this.details;
                      return result;
    }

    public com.example.scerri.graphqljava.generated.types.User.Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public com.example.scerri.graphqljava.generated.types.User.Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public com.example.scerri.graphqljava.generated.types.User.Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public com.example.scerri.graphqljava.generated.types.User.Builder details(HRInfo details) {
      this.details = details;
      return this;
    }
  }
}
