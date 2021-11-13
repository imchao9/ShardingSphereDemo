package com.example.shardingspheredemo.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

public class MyPreciseDSShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String logicTableName = shardingValue.getLogicTableName();
        String cid = shardingValue.getColumnName();
        Long cidValue = shardingValue.getValue();
        // 实现 m1$->{cid%2+1}
        BigInteger shardingValueB = BigInteger.valueOf(cidValue);
        BigInteger resB = shardingValueB.mod(new BigInteger("2")).add(new BigInteger("1"));
        String key = "m" + resB;
        if (availableTargetNames.contains(key)) {
            return key;
        }
        throw new UnsupportedOperationException("route "+ key + " is not supported, please check your config");
    }
}
