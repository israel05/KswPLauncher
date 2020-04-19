package com.wits.pms.statuscontrol;

import android.os.RemoteException;
import com.google.gson.Gson;

public class WitsCommand {
    public static final int BT_TYPE = 3;
    public static final int MCU_TYPE = 5;
    public static final int MEDIA_TYPE = 2;
    public static final int SYSTEM_TYPE = 1;
    private int command;
    private String jsonArg;
    private int subCommand;

    public static final class BtSubCommand {
        public static final int AUTO_CONN = 106;
        public static final int CLOSE_BT = 105;
        public static final int MUSIC_NEXT = 101;
        public static final int MUSIC_PAUSE = 104;
        public static final int MUSIC_PLAY = 103;
        public static final int MUSIC_PLAYPAUSE = 102;
        public static final int MUSIC_PREVIOUS = 100;
        public static final int MUSIC_RELEASE = 113;
        public static final int MUSIC_UNRELEASE = 114;
        public static final int OPEN_BT = 107;
        public static final int PHONE_ACCEPT = 112;
        public static final int PHONE_CALL = 108;
        public static final int PHONE_HANDUP = 109;
        public static final int VOICE_TO_PHONE = 110;
        public static final int VOICE_TO_SYSTEM = 111;
    }

    public static final class MediaSubCommand {
        public static final int CLOSE_MUSIC = 106;
        public static final int CLOSE_PIP = 118;
        public static final int CLOSE_VIDEO = 112;
    }

    public static final class SystemCommand {
        public static final int ACCEPT_PHONE = 116;
        public static final int ANDROID_MODE = 602;
        public static final int BACK = 115;
        public static final int BENZ_CONTROL = 801;
        public static final int CALL_BUTTON = 123;
        public static final int CAR_MODE = 601;
        public static final int DORMANT = 118;
        public static final int HANDUP_PHONE = 117;
        public static final int HOME = 114;
        public static final int MCU_UPDATE = 700;
        public static final int MEDIA_NEXT = 104;
        public static final int MEDIA_PAUSE = 106;
        public static final int MEDIA_PLAY = 105;
        public static final int MEDIA_PLAY_PAUSE = 121;
        public static final int MEDIA_PREVIOUS = 103;
        public static final int MUTE = 100;
        public static final int NEXT_FM = 120;
        public static final int OPEN_AUX = 605;
        public static final int OPEN_BT = 607;
        public static final int OPEN_CVBSDVR = 609;
        public static final int OPEN_DTV = 606;
        public static final int OPEN_FM = 110;
        public static final int OPEN_MODE = 604;
        public static final int OPEN_NAVI = 108;
        public static final int OPEN_SETTINGS = 111;
        public static final int OPEN_SPEECH = 109;
        public static final int OUT_MODE = 603;
        public static final int PREV_FM = 119;
        public static final int SCREEN_OFF = 113;
        public static final int SCREEN_ON = 112;
        public static final int SOURCE_CHANGE = 107;
        public static final int UPDATE_CONFIG = 200;
        public static final int USB_HOST = 122;
        public static final int USING_NAVI = 608;
        public static final int VOLUME_DOWN = 102;
        public static final int VOLUME_UP = 101;
    }

    public int getCommand() {
        return this.command;
    }

    public void setCommand(int command2) {
        this.command = command2;
    }

    public int getSubCommand() {
        return this.subCommand;
    }

    public void setSubCommand(int subCommand2) {
        this.subCommand = subCommand2;
    }

    public String getJsonArg() {
        return this.jsonArg;
    }

    public void setJsonArg(String jsonArg2) {
        this.jsonArg = jsonArg2;
    }

    public static WitsCommand getWitsCommandFormJson(String jsonArg2) {
        return (WitsCommand) new Gson().fromJson(jsonArg2, WitsCommand.class);
    }

    public WitsCommand(int command2, int subCommand2, String jsonArg2) {
        this.command = command2;
        this.subCommand = subCommand2;
        this.jsonArg = jsonArg2;
    }

    public WitsCommand(int command2, int subCommand2) {
        this.command = command2;
        this.subCommand = subCommand2;
    }

    public static void sendCommand(int command2, int subCommand2, String arg) {
        try {
            PowerManagerApp.getManager().sendCommand(new Gson().toJson((Object) new WitsCommand(command2, subCommand2, arg)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
