package com.wincom.dbsyncagent.tasks.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wincom.dbsyncagent.tasks.data.RdAlbumInfoDto;
import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IptvBuyCncldRootDto {

    private Long id;

    private VodCancelDto test;

    private List<VodCancelDto> tests = new ArrayList<>();

    public IptvBuyCncldRootDto() {
    }

    public IptvBuyCncldRootDto(Long id, VodCancelDto test, List<VodCancelDto> tests) {
        this.id = id;
        this.test = test;
        this.tests = tests;
    }

    public Long getId() {
        return id;
    }

    public VodCancelDto getTest() {
        return test;
    }

    public List<VodCancelDto> getTests() {
        return tests;
    }

    @Override
    public String toString() {
        return "IptvBuyCncldRootDto{" +
            "id='" + id + '\'' +
            ", test=" + test +
            ", tests=" + tests +
            '}';
    }
}
