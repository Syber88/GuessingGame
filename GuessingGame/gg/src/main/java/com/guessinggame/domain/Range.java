package com.guessinggame.domain;

import java.util.Objects;

public class Range {
    private int start;
    private int end;

    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }

     public int start() {
        return this.start;
    }
    
    public int end() {
        return this.end;
    }
    
    @Override
    public boolean equals(Object obj) {
        // Auto-generated equality check
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Range other = (Range) obj;
        return start == other.start && end == other.end;
    }
    
    @Override
    public int hashCode() {
        // Auto-generated hash code
        return Objects.hash(start, end);
    }
    
    @Override
    public String toString() {
        return "Range[start=" + start + ", end=" + end + "]";
    }
}
