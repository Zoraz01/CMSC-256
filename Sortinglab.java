import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sortinglab{
    public static void main(String[] args){
        Bridges bridges = new Bridges(3,"haseebz","1092119066883");
        DataSource ds = bridges.getDataSource();
        List<ActorMovieIMDB> movieData = null;
        try {
            movieData= ds.getActorMovieIMDBData(Integer.MAX_VALUE);
        }
        catch (Exception e){
            System.out.println("Unable to connect to Bridges.");

        }
        for(int i = 0;i<5;i++){
            ActorMovieIMDB entry = movieData.get(i);

                System.out.println("" + i + ". " + entry.getActor() + "was in " + entry.getMovie());
        }
        System.out.println("\n");
        ArrayList<ActorMovieIMDB> filteredMovieList = new ArrayList<>();
        for(ActorMovieIMDB actor:movieData ){
            if(actor.getMovie().equals("Being_John_Malkovich_(1999)")) {
                System.out.println(actor.getActor());
                filteredMovieList.add(actor);
            }
        }
        System.out.println("\n");
        Collections.sort(filteredMovieList,new ActorComparator());
        System.out.println("Sorted Actors: ");
      for(ActorMovieIMDB sortedActor :filteredMovieList){
          System.out.println(sortedActor.getActor());
        }
    }
}
