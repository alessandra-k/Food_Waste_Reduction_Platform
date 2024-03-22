
package Model;

/**
 *
 * @author aless
 */
public enum Neighbourhood {
    
    HINTONBURG(1),
    TUNNEYS_PASTURE(2),
    WESTBORO(3),
    THE_GLEBE(4),
    HUNT_CLUB(5),
    STITTSVILLE_KANATA(6),
    CARLETON_PLACE(7),
    BARRHAVEN(8),
    ORLEANS(9),
    RIVERSIDE_SOUTH(10),
    SANDY_HILL(11),
    ALTA_VISTA(12);
    
    private final int neighbourhood_id;
    
    private Neighbourhood(int id) {
        this.neighbourhood_id = id;
    }
    
    public int getNeighbourhood_id() {
        return neighbourhood_id;
    }
}