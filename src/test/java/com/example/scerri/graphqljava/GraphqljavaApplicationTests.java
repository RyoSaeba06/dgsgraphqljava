package com.example.scerri.graphqljava;

import com.example.scerri.graphqljava.fetcher.UserDataFetcher;
import com.example.scerri.graphqljava.generated.client.UsersGraphQLQuery;
import com.example.scerri.graphqljava.generated.client.UsersProjectionRoot;
import com.example.scerri.graphqljava.generated.types.User;
import com.example.scerri.graphqljava.service.impl.UserServiceImpl;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.intellij.lang.annotations.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest(classes = {DgsAutoConfiguration.class, UserDataFetcher.class, UserServiceImpl.class})
class GraphqljavaApplicationTests {

	@Autowired
	DgsQueryExecutor dgsQueryExecutor;

	@Test
	void users() {
		GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(UsersGraphQLQuery.newRequest().build(), new UsersProjectionRoot().id().firstName());
		String query = graphQLQueryRequest.serialize();
		List<User> users = dgsQueryExecutor.executeAndExtractJsonPath(query,"data.users[*]");
		Assertions.assertFalse(CollectionUtils.isEmpty(users));
		Assertions.assertEquals(7, users.size());
	}

	@Test
	void users2() {

		String query = "{\n" +
				"  users {\n" +
				"    id\n" +
				"  }\n" +
				"}";
		List<User> users = dgsQueryExecutor.executeAndExtractJsonPath(query,"data.users[*]");
		Assertions.assertFalse(CollectionUtils.isEmpty(users));
		Assertions.assertEquals(7, users.size());
	}

}
