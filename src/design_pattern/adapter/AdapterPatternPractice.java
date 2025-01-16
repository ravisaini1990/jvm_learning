package design_pattern.adapter;

public class AdapterPatternPractice {

    public static void main(String[] args) {
        new MusicPlayerAdapter(new VideoAdapter()).play(".mp4");
        new MusicPlayerAdapter(new VideoAdapter()).play(".mp3");
    }
}


interface IMediaPlayer {

    void play(String fileType);
}

class MusicPlayerAdapter implements  IMediaPlayer {
    IVLCMusicPlayer vlcMusicPlayer;

    MusicPlayerAdapter(IVLCMusicPlayer vlcMusicPlayer) {
        this.vlcMusicPlayer = vlcMusicPlayer;
    }

    @Override
    public void play(String fileType) {
       if (fileType.equals(".mp4")) {
           vlcMusicPlayer.playVideo();
       } else {
           System.out.println("Playing with In-built player");
       }
    }
}

interface IVLCMusicPlayer {

    void playVideo();
}


class VideoAdapter implements  IVLCMusicPlayer{

    @Override
    public void playVideo() {
        System.out.println("Playing Video file with Video Player");
    }
}