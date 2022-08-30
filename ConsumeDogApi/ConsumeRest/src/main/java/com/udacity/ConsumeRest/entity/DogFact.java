package com.udacity.ConsumeRest.entity;

import java.util.Arrays;

public class DogFact {
    private String[] facts;
    private boolean success;

    public DogFact(String[] facts, boolean success) {
        this.facts = facts;
        this.success = success;
    }

    public DogFact() {}

    public String[] getFacts() {
        return facts;
    }

    public void setFacts(String[] facts) {
        this.facts = facts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "DogFact{" +
                "facts=" + Arrays.toString(facts) +
                ", success=" + success +
                '}';
    }
}
