package futureskill.cowcount;

public interface APICaller {

    public int getFieldSize();
    public int getNumberOfCows();

    public int getXCoordinateForCow(int x);

    public int getYCoordinateForCow(int y);

    public void printMatrix();
}
