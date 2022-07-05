package com.example.scerri.graphqljava.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class Users_DetailsProjection extends BaseSubProjectionNode<UsersProjectionRoot, UsersProjectionRoot> {
  public Users_DetailsProjection(UsersProjectionRoot parent, UsersProjectionRoot root) {
    super(parent, root, java.util.Optional.of("HRInfo"));
  }

  public Users_DetailsProjection salary() {
    getFields().put("salary", null);
    return this;
  }
}
