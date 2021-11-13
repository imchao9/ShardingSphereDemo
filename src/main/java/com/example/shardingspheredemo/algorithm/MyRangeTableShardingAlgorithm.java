package com.example.shardingspheredemo.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

public class MyRangeTableShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        Long upperVal = shardingValue.getValueRange().upperEndpoint();
        Long lowerVal = shardingValue.getValueRange().lowerEndpoint();

        String logicTableName = shardingValue.getLogicTableName();
        return Arrays.asList(logicTableName+"_1", logicTableName + "_2");
    }
}
