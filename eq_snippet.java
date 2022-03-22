package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.EarthquakeUSGS;

import java.util.List;

public class eq_snippet {
    public static void main(String[] args) throws Exception {

        // create Bridges object
        Bridges bridges = new Bridges(0,"haseebz","1092119066883");
        // read the earth quake  data and build the BST
        bridges.setTitle("Accessing USGIS Earthquake Data (USGS Data)");

        DataSource ds = bridges.getDataSource();

        // get 100 most recent earthquake records
        List<EarthquakeUSGS> eq_list = ds.getEarthquakeUSGSData(100);

        // print the first record
        System.out.println("Earthquake 0:");
        System.out.println ("\tMagnitude:"  + eq_list.get(0).getMagnitude() + "\n"
                + "\tDate:" + eq_list.get(0).getTime() + "\n"
                + "\tLocation: " +  eq_list.get(0).getLocation() + "\n"
                + "\tLat/Long:"  + eq_list.get(0).getLatit() + "," +
                eq_list.get(0).getLongit());
    }
}
