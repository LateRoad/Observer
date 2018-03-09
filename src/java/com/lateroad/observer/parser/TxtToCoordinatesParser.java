package com.lateroad.observer.parser;

import com.lateroad.observer.action.TetragonAction;
import com.lateroad.observer.validation.TxtReaderValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TxtToCoordinatesParser {
    private static final Logger logger = Logger.getLogger(TetragonAction.class);

    private static final String delimeter = "\\s";
    
    public List<int[]> parse(List<String> lines) {
        TxtReaderValidator validator = new TxtReaderValidator();
        List<int[]> coordinatesList = new ArrayList<>();
        int[] coordinates;
        String[] characters;
        for (String line : lines) {
            if (validator.validateLine(line)) {
                characters = line.split(delimeter);
                coordinates = new int[characters.length];
                for (int i = 0; i < characters.length; ++i) {
                    coordinates[i] = Integer.parseInt(characters[i]);
                }
                coordinatesList.add(coordinates);
                logger.info("Line was successfully parsed to coordinates.");
            } else {
                logger.info("Wrong line format. Tetragon hasn't been created.");
            }
        }
        return coordinatesList;
    }
}
