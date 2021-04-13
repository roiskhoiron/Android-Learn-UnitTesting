package com.example.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {
    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private final double dummyLength = 12.0;
    private final double dummyWidth = 7.0;
    private final double dummyHeight = 6.0;

    private final double dummyVolume = 504.0;
    private final double dummyCircumference = 100.0;
    private final double dummySurfaceArea = 396.0;

    @Before
    public void before() {
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    @Test
    public void testVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume = mainViewModel.getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testCircumference() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume = mainViewModel.getCircumeference();
        assertEquals(dummyCircumference, volume, 0.0001);
    }

    @Test
    public void testSurfaceArea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume = mainViewModel.getSurfaceArea();
        assertEquals(dummySurfaceArea, volume, 0.0001);
    }

    @Test
    public void testMockVolume() {
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testMockCircumference() {
        when(mainViewModel.getCircumeference()).thenReturn(dummyCircumference);
        double volume = mainViewModel.getCircumeference();
        verify(cuboidModel).getCircumeference();
        assertEquals(dummyCircumference, volume, 0.0001);
    }

    @Test
    public void testMockSurfaceArea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea);
        double volume = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dummySurfaceArea, volume, 0.0001);
    }



    @Test
    public void save() {
    }

    @Test
    public void getCircumeference() {
    }

    @Test
    public void getVolume() {
    }

    @Test
    public void getSurfaceArea() {
    }
}