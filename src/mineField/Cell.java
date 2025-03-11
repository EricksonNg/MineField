package mineField;

public class Cell {
    private boolean mined;
    private boolean visible;
    private int x;
    private int y;
    private int adjacentCount;

    public Cell(int y, int x, boolean mined) {
        this.mined = mined;
        this.visible = false;
        this.x = x;
        this.y = y;
    }

    public boolean isMined() {
        return mined;
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setAdjacent(int count) {
        this.adjacentCount = count;
    }
    public int getAdjacent() {
        return adjacentCount;
    }
}
