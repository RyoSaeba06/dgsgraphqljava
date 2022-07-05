package com.example.scerri.graphqljava.fetcher;

import com.example.scerri.graphqljava.generated.types.User;
import com.example.scerri.graphqljava.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class UserDataFetcher {
    final private UserService userService;

    public UserDataFetcher(UserService userService) {
        this.userService = userService;
    }


    @DgsQuery
    public List<User> users(@InputArgument(name = "userNameFilter") String nameFilter) {
        if (StringUtils.hasLength(nameFilter)) {
            return userService.users().stream().filter(user -> user.getFirstName().contains(nameFilter)
                    || user.getLastName().contains(nameFilter)).collect(Collectors.toList());
        }

        return userService.users();
    }
}
