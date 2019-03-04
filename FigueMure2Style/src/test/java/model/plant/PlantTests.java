package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class PlantTests {
    private Carotte car;
    private Figue fig;
    private Mure mur;
    private Pattate pat;
    private Pomme pom;
    private Tomate tom;
    
    @Before
    public void setUp() {
       car = new Carotte();
       fig = new Figue();
       mur = new Mure();
       pat = new Pattate();
       pom = new Pomme();
       tom = new Tomate();
    }
    
    @Test
    public void testCarotteCreation() {
        assertEquals(car.getName(), PlantVarietyEnum.CAROTTE);
        assertEquals(car.getPrice(), 1);
        assertEquals(car.getStyDevEat(), StylisticDeviceEnum.COMPARAISON);
    }
    
    @Test
    public void testFigueCreation() {
        assertEquals(fig.getName(), PlantVarietyEnum.FIGUE);
        assertEquals(fig.getPrice(), 1);
        assertEquals(fig.getStyDevEat(), StylisticDeviceEnum.PERIPHRASE);
    }
    
    @Test
    public void testMureCreation() {
        assertEquals(mur.getName(), PlantVarietyEnum.MURE);
        assertEquals(mur.getPrice(), 1);
        assertEquals(mur.getStyDevEat(), StylisticDeviceEnum.PERSONNIFICATION);
    }
    
    @Test
    public void testPattateCreation() {
        assertEquals(pat.getName(), PlantVarietyEnum.PATATTE);
        assertEquals(pat.getPrice(), 1);
        assertEquals(pat.getStyDevEat(), StylisticDeviceEnum.HYPERBOLE);
    }
    
    @Test
    public void testPommeCreation() {
        assertEquals(pom.getName(), PlantVarietyEnum.POMME);
        assertEquals(pom.getPrice(), 3);
        assertEquals(pom.getStyDevEat(), StylisticDeviceEnum.CHIASME);
    }
    
    @Test
    public void testTomateCreation() {
        assertEquals(tom.getName(), PlantVarietyEnum.TOMATE);
        assertEquals(tom.getPrice(), 3);
        assertEquals(tom.getStyDevEat(), StylisticDeviceEnum.OXYMORE);
    }
}
