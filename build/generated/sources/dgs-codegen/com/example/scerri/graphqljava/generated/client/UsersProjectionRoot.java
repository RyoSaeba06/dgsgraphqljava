package com.example.scerri.graphqljava.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class UsersProjectionRoot extends BaseProjectionNode {
  public Users_DetailsProjection details() {
    Users_DetailsProjection projection = new Users_DetailsProjection(this, this);    
    getFields().put("details", projection);
    return projection;
  }

  public UsersProjectionRoot id() {
    getFields().put("id", null);
    return this;
  }

  public UsersProjectionRoot firstName() {
    getFields().put("firstName", null);
    return this;
  }

  public UsersProjectionRoot lastName() {
    getFields().put("lastName", null);
    return this;
  }
}
