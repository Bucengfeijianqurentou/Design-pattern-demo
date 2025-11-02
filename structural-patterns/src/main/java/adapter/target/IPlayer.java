package adapter.target;

// 1. 目标接口 (Target)
// 这是客户端期望的接口
public interface IPlayer {
    /**
     * 客户端统一的播放方法
     * @param audioType 音频类型 (e.g., "mp3", "vlc", "mp4")
     * @param fileName 文件名
     */
    void play(String audioType, String fileName);
}