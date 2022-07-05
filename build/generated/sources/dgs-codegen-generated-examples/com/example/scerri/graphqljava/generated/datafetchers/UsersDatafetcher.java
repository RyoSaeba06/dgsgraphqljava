package com.example.scerri.graphqljava.generated.datafetchers;

import com.example.scerri.graphqljava.generated.types.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class UsersDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "users"
  )
  public List<User> getUsers(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
