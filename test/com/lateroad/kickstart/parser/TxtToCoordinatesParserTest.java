package com.lateroad.kickstart.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TxtToCoordinatesParserTest {
    private TxtToCoordinatesParser parser = new TxtToCoordinatesParser();

    private String[] linesForParsing = {
            "0 0 3 0 3 2 0 2  ",
            "Hello tests!",
            "0 0 3 0 3 2 0 0"
    };
    private List<String> lines = new ArrayList<>();
    private int[] firstTetragonCoordinates = {0, 0, 3, 0, 3, 2, 0, 2};
    private int[] secondTetragonCoordinates = {0, 0, 3, 0, 3, 2, 0, 0};


    @Test
    public void parseTrue() {
        List<int[]> expected = new ArrayList<>();
        expected.add(firstTetragonCoordinates);
        expected.add(secondTetragonCoordinates);
        lines = Arrays.asList(linesForParsing);
        List<int[]> actual = parser.parse(lines);
        for(int i = 0; i < expected.size(); ++i){
            for( int j = 0; j < expected.get(i).length; ++j){
                Assert.assertTrue(expected.get(i)[j] == actual.get(i)[j]);
            }
        }
    }
}