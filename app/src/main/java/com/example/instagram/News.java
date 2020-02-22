package com.example.instagram;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class News implements Parcelable {
    private int logo;
    private String author;
    private int image;
    private String data;
    private int likes;
    private int comment;

    public News(int logo, String author, int image, String data, int likes, int comment) {
        this.logo = logo;
        this.author = author;
        this.image = image;
        this.data = data;
        this.likes = likes;
        this.comment = comment;
    }

    protected News(Parcel in) {
        logo = in.readInt();
        author = in.readString();
        image = in.readInt();
        data = in.readString();
        likes = in.readInt();
        comment = in.readInt();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getLogo() {
        return logo;
    }

    public String getAuthor() {
        return author;
    }

    public int getImage() {
        return image;
    }

    public String getData() {
        return data;
    }

    public int getLikes() {
        return likes;
    }

    public int getComment() {
        return comment;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "News{" +
                "logo='" + logo + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", data='" + data + '\'' +
                ", likes=" + likes +
                ", comment=" + comment +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(logo);
        dest.writeString(author);
        dest.writeInt(image);
        dest.writeString(data);
        dest.writeInt(likes);
        dest.writeInt(comment);
    }


}
