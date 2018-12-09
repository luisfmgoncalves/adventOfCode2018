package com.advent2018.day8;

import java.util.ArrayList;
import java.util.List;

public final class Node {

    public List<Node> childNodes;
    public List<Integer> metadata;

    public Node() {
        childNodes = new ArrayList<>();
        metadata = new ArrayList<>();
    }

    public int getValue() {
        if(childNodes.size() == 0) {
            return getTotalMetadata();
        } else {
            int childrenValues = 0;
            for(int metaDataValue : metadata) {
                if(metaDataValue <= childNodes.size()) {
                    Node childNode = childNodes.get(metaDataValue - 1);
                    if(childNode != null) {
                        childrenValues += childNode.getValue();
                    }
                }
            }
            return childrenValues;
        }
    }

    private int getTotalMetadata() {
        return metadata.stream().mapToInt(value -> value).sum();
    }

//    public final class Header {
//        public Integer numberOfChildNodes;
//        public Integer numberOfMetaDataEntries;
//
//        public Header(Integer numberOfChildNodes, Integer numberOfMetaDataEntries) {
//            this.numberOfChildNodes = numberOfChildNodes;
//            this.numberOfMetaDataEntries = numberOfMetaDataEntries;
//        }
//    }
}
