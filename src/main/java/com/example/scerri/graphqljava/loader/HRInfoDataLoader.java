package com.example.scerri.graphqljava.loader;

import com.example.scerri.graphqljava.generated.types.HRInfo;
import com.example.scerri.graphqljava.service.HrInfoService;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.MappedBatchLoader;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


@Slf4j
@DgsDataLoader(name = "hrInfoLoader")
public class HRInfoDataLoader implements MappedBatchLoader<Integer, HRInfo> {

    private final HrInfoService hrInfoService;

    public HRInfoDataLoader(HrInfoService hrInfoService) {
        this.hrInfoService = hrInfoService;
    }

    @Override
    public CompletionStage<Map<Integer, HRInfo>> load(Set<Integer> keys) {
        LOGGER.info("Loading reviews for shows {}", keys.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        return CompletableFuture.supplyAsync(() -> hrInfoService.detailsForIDs(new ArrayList<>(keys)));
    }
}
