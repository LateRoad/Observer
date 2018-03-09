package com.lateroad.observer.reader;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReaderTest {
    TxtReader reader = new TxtReader();
    File emptyFile;
    File file;
    String fileInsides = "1 2 3 4 5678 9";


    @BeforeClass
    public void initFiles() throws IOException {
        file = new File("file.txt");
        emptyFile = new File("emptyFile.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(fileInsides);
        writer.close();
        file.createNewFile();
        emptyFile.createNewFile();
    }

    @AfterClass
    public void removeFiles() {
        file.delete();
        emptyFile.delete();
    }

    @Test
    public void readTxtTrue() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(fileInsides);
        Assert.assertTrue(reader.readTxt("file.txt").equals(strings));
    }

    @Test
    public void readTxtEmptyFile() {
        ArrayList<String> strings = new ArrayList<>();
        Assert.assertNotNull(reader.readTxt("emptyFile"));
    }

    @Test
    public void readTxtNoSuchFile() throws IOException {
        reader.readTxt("noSuchFile.txt");
    }

}