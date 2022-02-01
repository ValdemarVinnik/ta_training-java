package com.epam.tests.clean_code_tests;


import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Airport;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Planes.ExperimentalPlane;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Planes.MilitaryPlane;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Planes.PassengerPlane;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Planes.Plane;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.models.ClassificationLevel;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.models.ExperimentalTypes;
import com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.models.MilitaryType;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        log.info("Test in progress: testGetTransportMilitaryPlanes()");
        Airport airport = new Airport(planes);

        List<MilitaryPlane> actualTransportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        List<MilitaryPlane> expectedMilitaryPlanes = Arrays.asList(new MilitaryPlane("C-130 Hercules",
                650, 5000, 110000, MilitaryType.TRANSPORT));

        assertEquals(expectedMilitaryPlanes,actualTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        log.info("Test in progress: testGetPassengerPlaneWithMaxCapacity()");
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortingByMaxLoadCapacity() {
        log.info("Test in progress: testSortingByMaxLoadCapacity()");
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        log.info("Test in progress: testHasAtLeastOneBomberInMilitaryPlanes()");
        Airport airport = new Airport(planes);
        List<MilitaryPlane> actualBomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        List<MilitaryPlane> expectedBomberMilitaryPlanes = Arrays.asList(new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER));

        assertEquals( expectedBomberMilitaryPlanes,actualBomberMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        log.info("Test in progress: testExperimentalPlanesHasClassificationLevelHigherThanUnclassified()");

        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = true;
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = false;
                break;
            }
        }
        assertTrue(hasUnclassifiedPlanes);
    }
}
