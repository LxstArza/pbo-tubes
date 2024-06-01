package com.gotpb.tubespbokelompok7.model;

public class Like {
    private String id;
    private String idVideo;
    private String idUser;

    public Like(String idVideo, String idUser) {
        this.idVideo = idVideo;
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
