package adapter.client;

import adapter.adapter.AudioPlayerAdapter;
import adapter.target.IPlayer;

// 2. 客户端 (Client)
// 客户端只依赖于 IPlayer 接口
// 6. 客户端 (Client) - 修改后
public class MediaPlayer implements IPlayer {

    // 引用一个适配器
    private IPlayer audioAdapter;

    @Override
    public void play(String audioType, String fileName) {

        // 1. MediaPlayer 自己能处理的 (mp3)
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("MediaPlayer 正在播放 MP3 文件: " + fileName);

            // 2. MediaPlayer 自己不能处理的 (vlc 或 mp4)，交给适配器
        } else if ("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            // 当需要播放 vlc 或 mp4 时，创建并使用适配器
            audioAdapter = new AudioPlayerAdapter(audioType);
            audioAdapter.play(audioType, fileName);

            // 3. 适配器也不能处理的
        } else {
            System.out.println("不支持的音频格式: " + audioType);
        }
    }
}
