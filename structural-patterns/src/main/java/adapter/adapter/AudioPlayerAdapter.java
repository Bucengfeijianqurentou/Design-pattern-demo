package adapter.adapter;

import adapter.adaptee.AdvancedAudioPlayer;
import adapter.adaptee.SuperAudioPlayer;
import adapter.target.IPlayer;

// 5. 适配器 (Adapter) - 对象适配器
// 这个适配器实现了目标接口 IPlayer
public class AudioPlayerAdapter implements IPlayer {

    // 适配器内部持有两个被适配者的实例（组合）
    private AdvancedAudioPlayer advancedPlayer;
    private SuperAudioPlayer superPlayer;

    public AudioPlayerAdapter(String audioType) {
        // 根据类型，初始化对应的被适配者
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedPlayer = new AdvancedAudioPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            superPlayer = new SuperAudioPlayer();
        }
    }

    /**
     * 这是核心的转换逻辑
     * 客户端调用的是 play(type, file)，适配器将其转换为
     * advancedPlayer.playVlc(file) 或 superPlayer.playMp4(file)
     */
    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            // 将 IPlayer.play() 的调用 委托/转换 为 AdvancedAudioPlayer.playVlc()
            System.out.print("[对象适配器]: ");
            advancedPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            // 将 IPlayer.play() 的调用 委托/转换 为 SuperAudioPlayer.playMp4()
            System.out.print("[对象适配器]: ");
            superPlayer.playMp4(fileName);
        } else {
            System.out.println("格式 " + audioType + " 无法被适配器处理。");
        }
    }
}
