package com.alec.test;

import java.util.List;

public class ClientUtil {

    private static final String SEPARATOR = "/";

    public static int partitionByKey(String key, int partitionNum) {
        if (key == null) {
            throw new RuntimeException("Partition key can not be null");
        }
        if (partitionNum <= 0) {
            throw new RuntimeException("Partition number should be positive");
        }
        return Math.abs(hash(key)) % partitionNum;
    }

    public static Pair<String, String> convertToMapKeyValue(String key, String fieldName, String fieldValue) {
        if (key == null || fieldName == null) {
            throw new RuntimeException("Key and fieldName can not be null");
        }
        return new Pair<>(key + SEPARATOR + fieldName, fieldValue);
    }

    public static int hash(String key) {
        return key.hashCode();
    }

    static class Pair<F, S> {
        private F first;
        private S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return this.first;
        }

        public S getSecond() {
            return this.second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }
    }
}
