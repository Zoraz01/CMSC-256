package cmsc256;

import bridges.base.GraphAdjListSimple;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.EarthquakeUSGS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class GraphEarthquakeData {


  public static double calcDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		final int radius = 6371; // Radius of the earth in km

		// Haversine formula to calculate a value between 0 and 1 between 2 points on a sphere,
		//  1 being the opposite side of the sphere
		double laDistance = Math.toRadians(latitude2 - latitude1);
		double loDistance = Math.toRadians(longitude2 - longitude1);

		double a = Math.sin(laDistance / 2) * Math.sin(laDistance / 2)
				+ Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
				* Math.sin(loDistance / 2) * Math.sin(loDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distance = radius * c;    //convert to km
		return distance;
	}


  public static void main(String[] args) throws Exception {
	// Create a Bridges object
	  Bridges bridges = new Bridges(0,"haseebz","1092119066883");
	// Get a DataSource object from Bridges
	  
    	// Set an assignment title 
	bridges.setTitle("Earthquake Data Graph Lab");
	bridges.setDescription("CMSC 256, Spring 2021");

	// Initialize a Graph 
	GraphAdjListSimple<String> graph = new GraphAdjListSimple<>();



    /* TODO:
    * Grab Earthquake data and store it in a List
    * Sort the list by magnitude
    * Retain only 100 earthquakes of highest magnitude
    */
	  DataSource ds = bridges.getDataSource();
	  List<EarthquakeUSGS> eq_list = ds.getEarthquakeUSGSData(5000);
	  List<Double> magnitudeList = new ArrayList<>();
	  for(int i =0; i < 5000;i++){
		  magnitudeList.add(eq_list.get(i).getMagnitude());
	  }

	  Collections.sort(eq_list, new Comparator<EarthquakeUSGS>() {
		  @Override
		  public int compare(EarthquakeUSGS o1, EarthquakeUSGS o2) {
			  return Double.compare(o1.getMagnitude(),o2.getMagnitude());
		  }
	  });
	  Collections.reverse(eq_list);
	  //System.out.println(eq_list.get(0).getMagnitude() + eq_list.get(0).getLocation());






    /* TODO:
    * Add the Earthquakes to the graph
    * Set each earthquake's location based on its latitude and longitude
    * ex: graph.getVisualizer(key).setLocation(earthquake.getLongit(), earthquake.getLatit());
    * Tweak the colors or other visual elements if you wish; For example, if the magnitude is higher than 6, set the color to red
    */
	  for(int i =0; i < 100; i++){
		  graph.addVertex(eq_list.get(i).getTitle(), eq_list.get(i).getTitle());
		  graph.getVisualizer(eq_list.get(i).getTitle()).setLocation(eq_list.get(i).getLongit(),eq_list.get(i).getLatit());
		  if(eq_list.get(i).getMagnitude()> 5.6){
			  graph.getVertex(eq_list.get(i).getTitle()).setColor("Red");
		  }
	  }



    bridges.setCoordSystemType("equirectangular");
    bridges.setDataStructure(graph);
    bridges.setMapOverlay(true);
    bridges.setTitle("Earthquake Map");

    bridges.visualize();


    /* TODO:
    * Compare the distances between all vertexes in the graph, drawing an edge
    * if they are within 500km. A method is provided to give a rough
    * estimate between 2 lat,long points.
    *
    * example usage: calcDistance(eq1.getLatit(), eq1.getLongit(),
    *                eq2.getLatit(), eq2.getLongit());
    * which returns a double representing the distance of two points in km
    */
	  for(int i = 0; i < 100; i++){
		  for(int j = 0; j < 100; j++){
			  if(calcDistance(eq_list.get(i).getLatit(),eq_list.get(i).getLongit(),eq_list.get(j).getLatit(),eq_list.get(j).getLongit()) <= 500){
				  graph.addEdge(eq_list.get(i).getTitle(),eq_list.get(j).getTitle());
			  }
		  }
	  }

    bridges.visualize();

    /* TODO:
    * Reset the locations of the vertices by setting their location to
    * Double.POSITIVE_INFINITY
    *
    * ex: graph.getVisualizer(key).setLocation(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
    */
	  for(int i = 0; i < 100;i++) {
		  graph.getVisualizer(eq_list.get(i).getTitle()).setLocation(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
	  }
    bridges.setMapOverlay(false);
    bridges.visualize();
  }
}
