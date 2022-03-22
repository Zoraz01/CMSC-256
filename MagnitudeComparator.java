package cmsc256;

import bridges.data_src_dependent.EarthquakeUSGS;

import java.util.Comparator;

public class MagnitudeComparator implements Comparator<EarthquakeUSGS> {
    @Override
    public int compare(EarthquakeUSGS o1, EarthquakeUSGS o2) {

        return Double.compare(o1.getMagnitude(),o2.getMagnitude());
    }
}
