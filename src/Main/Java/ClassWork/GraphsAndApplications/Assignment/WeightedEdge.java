package Main.Java.ClassWork.GraphsAndApplications.Assignment;

public class WeightedEdge extends Edge
        implements Comparable<WeightedEdge> {
    public int weight; // The weight on edge (u, v) (I changed weight to int to match assignment example)

    /** Create a weighted edge on (u, v) */
    public WeightedEdge(int u, int v, int weight) {
        super(u, v);
        this.weight = weight;
    }

    /** Compare two edges on weights */
    public int compareTo(WeightedEdge edge) {
        if (weight > edge.weight) {
            return 1;
        }
        else if (weight == edge.weight) {
            return 0;
        }
        else {
            return -1;
        }
    }
}