package cmsc256;

import bridges.data_src_dependent.Song;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        int isEqual = o1.getAlbumTitle().compareTo(o2.getAlbumTitle());
            if(isEqual == 0){
                isEqual = o1.getSongTitle().compareTo(o2.getSongTitle());
            }
        return isEqual;
    }
}
