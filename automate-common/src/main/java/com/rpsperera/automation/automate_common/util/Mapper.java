package com.rpsperera.automation.automate_common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {

    private final ObjectMapper objectMapper;

    private Mapper() {
        this.objectMapper = new ObjectMapper();
    }

    public static Mapper getInstance() {
        return Holder.Instance;
    }

    public ObjectMapper getObjectMapper() {
        return Holder.Instance.objectMapper;
    }

    private static final class Holder {
        private static final Mapper Instance = new Mapper();
    }

}
