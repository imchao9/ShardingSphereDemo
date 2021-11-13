package com.example.shardingspheredemo.algorithm;

import com.example.shardingspheredemo.entity.Course;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyComplexDSShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        Range<Long> cidRange = shardingValue.getColumnNameAndRangeValuesMap().get(Course.COL_CID);
        Collection<Long> userIdCol =
                shardingValue.getColumnNameAndShardingValuesMap().get(Course.COL_USER_ID);

        Number upperVal = cidRange.upperEndpoint();
        Number lowerVal = cidRange.lowerEndpoint();

        List<String> res = new ArrayList<>();

        for(Long userId: userIdCol) {
            BigInteger userIdB = BigInteger.valueOf(userId);
            BigInteger target = userIdB.mod(new BigInteger("2")).add(new BigInteger("1"));

            res.add("m"+ target);
        }

        return res;
    }
}
