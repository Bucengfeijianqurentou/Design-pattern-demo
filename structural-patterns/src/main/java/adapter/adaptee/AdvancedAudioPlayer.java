package adapter.adaptee;

// 3. 被适配者 (Adaptee) - 1
// 这是一个已存在的、接口不兼容的类
public class AdvancedAudioPlayer {
    public void playVlc(String fileName) {
        System.out.println("AdvancedPlayer 正在播放 VLC 文件: " + fileName);
    }
}
