package com.example.scerri.graphqljava.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class HRInfo {
  private Integer salary;

  public HRInfo() {
  }

  public HRInfo(Integer salary) {
    this.salary = salary;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "HRInfo{" + "salary='" + salary + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HRInfo that = (HRInfo) o;
        return java.util.Objects.equals(salary, that.salary);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(salary);
  }

  public static com.example.scerri.graphqljava.generated.types.HRInfo.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer salary;

    public HRInfo build() {
      com.example.scerri.graphqljava.generated.types.HRInfo result = new com.example.scerri.graphqljava.generated.types.HRInfo();
          result.salary = this.salary;
          return result;
    }

    public com.example.scerri.graphqljava.generated.types.HRInfo.Builder salary(Integer salary) {
      this.salary = salary;
      return this;
    }
  }
}
