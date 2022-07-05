package com.example.scerri.graphqljava.service;

import com.example.scerri.graphqljava.generated.types.HRInfo;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

public interface HrInfoService {
    Map<Integer, HRInfo> detailsForIDs(@NonNull List<Integer> id);
}
