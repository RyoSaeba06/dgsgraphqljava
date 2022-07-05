package com.example.scerri.graphqljava.service.impl;

import com.example.scerri.graphqljava.generated.types.HRInfo;
import com.example.scerri.graphqljava.service.HrInfoService;
import com.example.scerri.graphqljava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HrInfoServiceImpl implements HrInfoService {
    private final UserService userService;

    private final Map<Integer, HRInfo> details = new ConcurrentHashMap<>();

    public HrInfoServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void createDetails() {
        Faker faker = new Faker();
        userService.users().forEach(
                user -> {
                    details.put(user.getId(), HRInfo.newBuilder().salary(faker.number().numberBetween(40000, 200000)).build());
                }
        );
    }


    @Override
    public Map<Integer, HRInfo> detailsForIDs(@NonNull @NotNull List<Integer> ids) {
        LOGGER.info("Loading reviews for shows {}", ids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        return details.entrySet().stream().filter(entry -> ids.contains(entry.getKey())).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
