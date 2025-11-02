package adapter;

import adapter.client.MediaPlayer;
import adapter.target.IPlayer;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // 客户端 MediaPlayer 实例
        IPlayer player = new MediaPlayer();

        // 客户端调用它自己的 play 方法
        System.out.println("--- 客户端播放 MP3 ---");
        player.play("mp3", "beyond_horizons.mp3");

        System.out.println("\n--- 客户端播放 VLC (通过适配器) ---");
        player.play("vlc", "far_away.vlc");

        System.out.println("\n--- 客户端播放 MP4 (通过适配器) ---");
        player.play("mp4", "mind_over_matter.mp4");

        System.out.println("\n--- 客户端播放 AVI (不支持) ---");
        player.play("avi", "some_movie.avi");
    }
}
