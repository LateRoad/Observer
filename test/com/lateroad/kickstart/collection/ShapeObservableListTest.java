package com.lateroad.kickstart.collection;

import com.lateroad.kickstart.action.TetragonAction;
import com.lateroad.kickstart.entity.shape.subject.Tetragon;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShapeObservableListTest {
    ShapeObservableList<Tetragon> list;
    List<Tetragon> listChanged;
    Collection<Tetragon> collection;
    Tetragon tetragon0;
    Tetragon tetragon1;
    Tetragon tetragon0changed;
    Tetragon tetragon1changed;

    TetragonAction action;

    @BeforeClass
    public void setUpClass() throws Exception {
        list = ShapeObservableList.getInstance();
        listChanged = new ArrayList<>();
        collection = new ArrayList<>();

        tetragon0 = new Tetragon(9, 8, 6, 8, 8, 8, 8, 5);
        tetragon1 = new Tetragon(4, 5, 5, 6, 7, 4, 3, 4);

        tetragon0changed = new Tetragon(0, 0, 6, 8, 8, 8, 8, 5);
        tetragon1changed = new Tetragon(0, 0, 5, 6, 7, 4, 3, 4);

        action = new TetragonAction();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        listChanged.add(tetragon0changed);
        listChanged.add(tetragon1changed);

        collection.add(tetragon0);
        collection.add(tetragon1);
    }

    @AfterMethod
    public void dropDown() throws Exception {
        list.clear();
        listChanged.clear();
        collection.clear();
    }

    @Test
    public void testAdd() throws Exception {
        list.add(tetragon0);
        list.add(tetragon1);
        list.get(0).setDot(0, 0, 0);
        list.get(1).setDot(0, 0, 0);
        for (int i = 0; i < list.size(); ++i) {
            Assert.assertEquals(action.calculateSquare(list.get(i)), action.calculateSquare(listChanged.get(i)));
            Assert.assertEquals(action.calculatePerimeter(list.get(i)), action.calculatePerimeter(listChanged.get(i)));
        }
    }

    @Test
    public void testAddAll() throws Exception {
        list.addAll(collection);
        list.get(0).setDot(0, 0, 0);
        list.get(1).setDot(0, 0, 0);
        for (int i = 0; i < list.size(); ++i) {
            Assert.assertEquals(action.calculateSquare(list.get(i)), action.calculateSquare(listChanged.get(i)));
            Assert.assertEquals(action.calculatePerimeter(list.get(i)), action.calculatePerimeter(listChanged.get(i)));
        }
    }

    @Test
    public void testAddAllById() throws Exception {
        list.addAll(0, collection);
        list.get(0).setDot(0, 0, 0);
        list.get(1).setDot(0, 0, 0);
        System.out.println(list);
        for (int i = 0; i < list.size(); ++i) {
            Assert.assertEquals(action.calculateSquare(list.get(i)), action.calculateSquare(listChanged.get(i)));
            Assert.assertEquals(action.calculatePerimeter(list.get(i)), action.calculatePerimeter(listChanged.get(i)));
        }
    }

    @Test
    public void testSet() throws Exception {
        list.add(tetragon0);
        list.add(tetragon0);
        list.set(1, tetragon1);
        list.get(0).setDot(0, 0, 0);
        list.get(1).setDot(0, 0, 0);
        for (int i = 0; i < list.size(); ++i) {
            Assert.assertEquals(action.calculateSquare(list.get(i)), action.calculateSquare(listChanged.get(i)));
            Assert.assertEquals(action.calculatePerimeter(list.get(i)), action.calculatePerimeter(listChanged.get(i)));
        }
    }

    @Test
    public void testAddById() throws Exception {
        list.add(tetragon0);
        list.add(tetragon1);
        list.get(0).setDot(0, 0, 0);
        list.get(1).setDot(0, 0, 0);
        for (int i = 0; i < list.size(); ++i) {
            Assert.assertEquals(action.calculateSquare(list.get(i)), action.calculateSquare(listChanged.get(i)));
            Assert.assertEquals(action.calculatePerimeter(list.get(i)), action.calculatePerimeter(listChanged.get(i)));
        }
    }
}