package Devices;

public class Screen {

    int height;
    int width;

    public Screen(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void Define() {
        System.out.println("Screen size is: " + this.height + " by " + this.width);
    }

}
