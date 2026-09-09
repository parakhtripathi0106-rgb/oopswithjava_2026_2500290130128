// /Abstract class
abstract class Device {
    // /variable
    String brand="Samsung";
    // abstract method
    abstract void turnOn();
    
    // Concrete method
    void showBrand(){
        System.out.println("Brand: "+brand);
    }

}
// Interfacee 1
interface Camera{
    int MAX_ZOOM=10;   
    void takePhoto();
    default void cameraInfo(){
        System.out.println("Camera is ready");
    }

}
// interface 2
interface MusicPlayer{
    String TYPE ="Digital";
    // public static fina
    void playMusic();
    // abstract and public method
    default void musicInfo(){
        System.out.println("Music player is ready");
    }
}
// child class
class Smartphone extends Device implements Camera, MusicPlayer{
    // inmplementing abstract method of device
    void turnOn(){
        System.out.println("Smartphone is turned ON");
    }
    // implement abstract method of camera
    public void takePhoto(){
        System.out.println("Taking photo...");
    }
    // implementing abstract method of MusicPLAYER
    public void playMusic(){
        System.out.println("Playing Music...");
    }
}

// Main class
public class Abstract_Interface{
    public static void main(String[] args){
        Smartphone s=new Smartphone();
        s.turnOn();
        s.showBrand();
        s.takePhoto();
        s.playMusic();
        s.cameraInfo();
        s.musicInfo();
        System.out.println("Maximum Zoom: " + Camera.MAX_ZOOM);
        System.out.println("Music Type: " + MusicPlayer.TYPE);
    }

}