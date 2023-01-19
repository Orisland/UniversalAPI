package top.orisland;

import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.utils.MiraiLogger;

import java.io.IOException;

import static top.orisland.Util.LogUtil.MLOG;


public class Handler  extends SimpleListenerHost {
    @EventHandler
    public ListeningStatus friendListener(FriendMessageEvent event) throws IOException {

        return ListeningStatus.LISTENING;
    }

    @EventHandler
    public ListeningStatus groupListener(GroupMessageEvent event) throws IOException {


        return ListeningStatus.LISTENING;
    }

    public ListeningStatus bothListener(MessageEvent event){

        return ListeningStatus.LISTENING;
    }
}
