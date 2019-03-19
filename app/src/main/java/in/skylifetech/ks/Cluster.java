package in.skylifetech.ks;

public class Cluster {

    int clusterIcon;
    String clusterName;

    Cluster(int mClusterIcon, String mClusterName) {
        clusterIcon = mClusterIcon;
        clusterName = mClusterName;
    }

    public int getClusterIcon() {
        return clusterIcon;
    }

    public void setClusterIcon(int clusterIcon) {
        this.clusterIcon = clusterIcon;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
}
