package LmsLLD.models;

public class Member extends Account {
    int totalBookCheckedOut;

    public int getTotalBookCheckedOut() {
        return totalBookCheckedOut;
    }

    public void setTotalBookCheckedOut(int totalBookCheckedOut) {
        this.totalBookCheckedOut = totalBookCheckedOut;
    }
}
