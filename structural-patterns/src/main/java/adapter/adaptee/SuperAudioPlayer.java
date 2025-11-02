package adapter.adaptee;

// 4. 被适配者 (Adaptee) - 2
public class SuperAudioPlayer {
    public void playMp4(String fileName) {
        System.out.println("SuperPlayer 正在播放 MP4 文件: " + fileName);
    }
}
