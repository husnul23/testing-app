package com.example.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*
import java.time.temporal.ChronoUnit
import java.util.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.circumference
        assertEquals(dummyCircumference, volume, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.surfaceArea
        assertEquals(dummySurfaceArea, volume, 0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.volume
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.volume).thenReturn(dummyVolume)
        val volume = mainViewModel.volume
        verify(cuboidModel).volume
        assertEquals(dummyVolume, volume, 0.0001)
    }


    @Test
    fun testMockCircumference() {
        `when`(mainViewModel.circumference).thenReturn(dummyCircumference)
        val volume = mainViewModel.circumference
        verify(cuboidModel).circumference
        assertEquals(dummyCircumference, volume, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.surfaceArea).thenReturn(dummySurfaceArea)
        val volume = mainViewModel.surfaceArea
        verify(cuboidModel).surfaceArea
        assertEquals(dummySurfaceArea, volume, 0.0001)
    }

    @Test
    fun save() {
    }
}