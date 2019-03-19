package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
/**
 * 音乐消息回复实体
 * 
 * */
public class MessageMusicResp extends MessageBase{
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
