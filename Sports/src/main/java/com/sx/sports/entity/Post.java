package com.sx.sports.entity;
import java.util.Date;
public class Post {
    private Integer PostId;
    private String title;
    private String content;
    private String userName;
    private Integer Likes;
    public Integer getPostID(){return PostId;}
    public void setPostID(Integer PostId){
        this.PostId=PostId;
    }
    public String getTitle(){return title;}
    public void setTitle(String title){
        this.title=title;
    }
    public String getContent(){return content;}
    public void setContent(String content){
        this.content=content;
    }
    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public Integer getLikest(){return Likes;}
    public void setLikes(Integer Likes ){
        this.Likes= Likes;
    }
    @Override
    public String toString() {
        return "Post{" +
                "PostId=" + PostId +'\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName +'\'' +
                ", Likes='" + Likes+
                '}';
    }
}
