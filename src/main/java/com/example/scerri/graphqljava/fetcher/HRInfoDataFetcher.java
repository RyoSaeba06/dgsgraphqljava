package com.example.scerri.graphqljava.fetcher;

import com.example.scerri.graphqljava.generated.DgsConstants;
import com.example.scerri.graphqljava.generated.types.HRInfo;
import com.example.scerri.graphqljava.generated.types.User;
import com.example.scerri.graphqljava.loader.HRInfoDataLoader;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.security.access.annotation.Secured;

import java.util.concurrent.CompletableFuture;

@Slf4j
@DgsComponent
public class HRInfoDataFetcher {

    @Secured("ROLE_USER_VIEWER")
    @DgsData(parentType = DgsConstants.USER.TYPE_NAME)
    public CompletableFuture<HRInfo> details(DgsDataFetchingEnvironment dfe) {

        DataLoader<Integer, HRInfo> detailsDataLoader = dfe.getDataLoader(HRInfoDataLoader.class);

        User user = dfe.getSource();

        LOGGER.info("DataFetcher for user id: {}", user.getId());
        return detailsDataLoader.load(user.getId());
    }
}
