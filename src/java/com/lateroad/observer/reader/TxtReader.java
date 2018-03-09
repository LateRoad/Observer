package com.lateroad.observer.reader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {
    static {
        new DOMConfigurator().doConfigure("log4j2.xml", LogManager.getLoggerRepository());
    }

    private static final Logger logger = Logger.getLogger(TxtReader.class);


    public List readTxt(String filename) {
        List<String> list = new ArrayList<>();
        try {
            logger.info("Reading from " + filename + " was started.");
            List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            list.addAll(lines);
            logger.info("Reading from " + filename + " was finished.");
        } catch (IOException e) {
            logger.error("Wrong file name. File " + filename + " can not be open.", e);
        }
        return list;
    }
}
