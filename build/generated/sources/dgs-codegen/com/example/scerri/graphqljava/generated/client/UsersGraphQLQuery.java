package com.example.scerri.graphqljava.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class UsersGraphQLQuery extends GraphQLQuery {
  public UsersGraphQLQuery(String userNameFilter, Set<String> fieldsSet) {
    super("query");
    if (userNameFilter != null || fieldsSet.contains("userNameFilter")) {
        getInput().put("userNameFilter", userNameFilter);
    }
  }

  public UsersGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "users";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String userNameFilter;

    public UsersGraphQLQuery build() {
      return new UsersGraphQLQuery(userNameFilter, fieldsSet);
               
    }

    public Builder userNameFilter(String userNameFilter) {
      this.userNameFilter = userNameFilter;
      this.fieldsSet.add("userNameFilter");
      return this;
    }
  }
}
